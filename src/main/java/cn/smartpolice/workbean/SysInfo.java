package cn.smartpolice.workbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


import cn.smartpolice.protocol.MsgTaskCheckThread;
import cn.smartpolice.protocol.ProtocolBase;


/*
 * 系统信息 使用synchronizedSet方法使HashSet具有同步的能力：Set s =
 * Collections.synchronizedSet(new HashSet(...));
 *
 * @author 刘???
 *
 */
public class SysInfo {
//    private static int 
	private static SysInfo instance;
	/*private static UIUserInfo uIUserInfo; // 界面用户登录信息
	public static UIUserInfo getuIUserInfo() {
		return uIUserInfo;
	}*/

	/*public static void setuIUserInfo(UIUserInfo uIUserInfo) {
		SysInfo.uIUserInfo = uIUserInfo;
	}*/


	private static Set<UserNode> userNodeQueue = Collections.synchronizedSet(new HashSet<UserNode>()); // dev队???
	// private static HashSet<AppNode> appNodeQueue = new HashSet<AppNode>();

	//	private static ArrayList<FileNodeInfo> fileDataInfoQueue = new ArrayList<FileNodeInfo>(); // 文件队列
//	private static ArrayList<SoftInfo> SoftInfQueue = new ArrayList<SoftInfo>(); //软件队列
	private static SysStatInfo sysStatInfo = new SysStatInfo(); // 系统统计信???


	private static SysCfgInfo sysCfgInfo; // 系统配置信息
	private static  List<MsgTask> msgTaskQueue = Collections.synchronizedList(new ArrayList<MsgTask>());
	private static Thread msgTaskCheckThread;
	private static Thread startThread;

	// 协议处理类数??
	private static ProtocolBase[] prtocolBases = { /*new ProtocolTest(), new ProtocolLogin(), new ProtocolAccount(),
			new ProtocolControl(), new ProtocolQuery(), new ProtocolMessage(), new ProtocolDiscoverLAN(),
			new ProtocolFile(),new ProtocolEncryption(),new ProtocolRelate(),new ProtocolFile(),new ProtocolUpgrade()*/};
	
/*	public static SysStatInfo getSysStatInfo() {
		sysStatInfo.setOpenFileNum(fileDataInfoQueue.size());//设置文件打开??
		return sysStatInfo;
	}*/

	public static Thread getMsgTaskCheckThread() {
		return msgTaskCheckThread;
	}
	public Thread createNewThread(){	
		msgTaskCheckThread=new Thread((new MsgTaskCheckThread()));
		return msgTaskCheckThread;                                                  
	}
	public static Thread getStartThread() {
		return startThread;
	}

	// 将构造器私???
	private SysInfo() {
	}

/*	public static ArrayList<FileNodeInfo> getFileDataInfoQueue() {
		return fileDataInfoQueue;
	}*/
	


	public static Set<UserNode> getUserNodeQueue() {
		return userNodeQueue;
	}

	public static synchronized List<MsgTask> getMsgTaskQueue() {
		return  msgTaskQueue;
	}

	public static void setSysCfgInfo(SysCfgInfo sysCfgInfo) {
		SysInfo.sysCfgInfo = sysCfgInfo;
	}
	public static SysCfgInfo getSysCfgInfo() {
		return sysCfgInfo;
	}

	public static ProtocolBase[] getPrtocolBases() {
		return prtocolBases;
	}

	// 得到SysInfo单???
	public static SysInfo getInstance() {
		instance = new SysInfo();
		return instance;
	}

	// 根据id找到app信息节点
	public AppNode getAppNodeById(int id) {
		for (UserNode userNode : userNodeQueue) {
			// id相等并判断是否是appnode
			if (userNode.getId() == id && userNode instanceof AppNode) {
				AppNode appNode = (AppNode) userNode; // 向下类????转换
				return appNode;
			}
		}
		return null;
	}
	/**
	 * 根据用户账户查找节点
	 * @return
	 */
	public AppNode getAppNodeByAccount(String account) {
		for (UserNode userNode : userNodeQueue) {
			// id相等并判断是否是appnode
			if (userNode.getAccount().equals(account) && userNode instanceof AppNode) {
				AppNode appNode = (AppNode) userNode; // 向下类????转换
				return appNode;
			}
		}
		return null;
	}

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

	// 添加??个userNode节点到队列???
	public synchronized void addUserNode(UserNode userNode) {

		userNodeQueue.add(userNode);
	}

	// 删除userNode队列中的???个节??
	public synchronized void removeUserNode(UserNode userNode) {

		userNodeQueue.remove(userNode);
	}

	public void addMsgTask(MsgTask msgTask) {

		msgTaskQueue.add(msgTask);
	}
	public boolean removeMsgTask(MsgTask msgTask) {

		return msgTaskQueue.remove(msgTask);
		
	}
	
	
	/**
	 * 消息处理线程创建
	 */
	public void msgTaskThreadCheck(){
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
	/*public static void startThread(ManagerInfoService managerInfoService) {
		Thread msgTaskCheckThread = null;
		if (SysInfo.getStartThread() == null) {
			msgTaskCheckThread = SysInfo.getInstance().createStartThread( managerInfoService);
			msgTaskCheckThread.start();
		} else {
			if (!SysInfo.getMsgTaskCheckThread().isAlive()) {
				msgTaskCheckThread = SysInfo.getInstance().createStartThread(managerInfoService);
				msgTaskCheckThread.start();
			}
		}
	}*/
}
