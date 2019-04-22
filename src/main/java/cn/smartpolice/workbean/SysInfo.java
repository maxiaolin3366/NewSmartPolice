package cn.smartpolice.workbean;

import cn.smartpolice.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/*
 * 系统信息 使用synchronizedSet方法使HashSet具有同步的能力：Set s =
 * Collections.synchronizedSet(new HashSet(...));
 */
@Component
public class SysInfo {
    private static UIUserNode uiUserNode;
    private static SysStatInfo sysStatInfo;
    private static ProtocolBase[] protocolBases = {new ProtocolTest(), new ProtocolLogin(), new ProtocolAccount(), new ProtocolControl(), new ProtocolQuery(), new ProtocolMessage()};
    private static Set<UserNode> userNodeQueue = Collections.synchronizedSet(new HashSet<UserNode>());  //节点队列
    private FileUsing fileUsing;
    private static SysCfgInfo sysCfgInfo;
    private static Thread msgTaskCheckThread;
    private static List<MsgTask> msgTaskQueue = Collections.synchronizedList(new ArrayList<MsgTask>());

    public static List<MsgTask> getMsgTaskQueue() {
        return msgTaskQueue;
    }

    public static Set<UserNode> getUserNodeQueue() {
        return userNodeQueue;
    }

    private SysInfo() {
    }

    public static UIUserNode getUiUserNode() {
        return uiUserNode;
    }

    public static void setUiUserNode(UIUserNode uiUserNode) {
        SysInfo.uiUserNode = uiUserNode;
    }

    public static Thread getMsgTaskCheckThread() {
        return msgTaskCheckThread;
    }

    private Thread createNewThread() {
        msgTaskCheckThread = new Thread((new MsgTaskCheckThread()));
        return msgTaskCheckThread;
    }

    public void msgTaskThreadCheck() {
        Thread msgTaskCheckThread = null;
        if (SysInfo.getMsgTaskCheckThread() == null) {
            msgTaskCheckThread = SysInfo.getInstance().createNewThread();
            msgTaskCheckThread.start();
        } else {
            if (!SysInfo.getMsgTaskCheckThread().isAlive()) {
                msgTaskCheckThread = SysInfo.getInstance().createNewThread();
                msgTaskCheckThread.start();
            }
        }
    }

    public void addMsgTask(MsgTask msgTask) {

        msgTaskQueue.add(msgTask);
    }

    public boolean removeMsgTask(MsgTask msgTask) {

        return msgTaskQueue.remove(msgTask);

    }
    public static SysInfo getInstance() {

        return InnerSysInfo.instance;
    }

    private static class InnerSysInfo {//使用内部类的方式实现单例
        private static SysInfo instance = new SysInfo();
    }

    public static SysStatInfo getSysStatInfo() {
        sysStatInfo = new SysStatInfo();
        return sysStatInfo;
    }

    @Autowired
    public static ProtocolBase[] getProtocolBases() {
        return protocolBases;
    }

    public static SysCfgInfo getSysCfgInfo() {
        return sysCfgInfo;
    }

    // 根据sid找到app信息节点
    public AppNode getAppNodeById(int id) {
        for (UserNode userNode : userNodeQueue) {
            // id相等并判断是否是appnode
            if (userNode.getId() == id && userNode instanceof AppNode) {
                AppNode appNode = (AppNode) userNode; // 向下类型转换
                return appNode;
            }
        }
        return null;
    }

    /**
     * 根据用户账户查找节点
     */
    public AppNode getAppNodeByAccount(String account) {
        for (UserNode userNode : userNodeQueue) {
            // id相等并判断是否是appnode
            if (userNode.getAccount().equals(account) && userNode instanceof AppNode) {
                AppNode appNode = (AppNode) userNode; // 向下类型转换
                return appNode;
            }
        }
        return null;
    }

    /**
     * 根据用户账户查找节点
     */
    public DevNode getDevNodeByAccount(String account) {
        for (UserNode userNode : userNodeQueue) {
            if (userNode.getAccount().equals(account) && userNode instanceof DevNode) {
                DevNode devNode = (DevNode) userNode;
                return devNode;
            }
        }
        return null;
    }

    // 根据id找到dev信息节点
    public DevNode getDevNodeById(int id) {
        for (UserNode userNode : userNodeQueue) {
            if (userNode.getId() == id && userNode instanceof DevNode) {
                DevNode devNode = (DevNode) userNode;
                return devNode;
            }
        }
        return null;
    }

    // 添加一个userNode节点到队列中
    public synchronized void addUserNode(UserNode userNode) {
        userNodeQueue.add(userNode);
    }

    // 删除userNode队列中的一个节点
    public synchronized void removeUserNode(UserNode userNode) {
        userNodeQueue.remove(userNode);
    }


}
