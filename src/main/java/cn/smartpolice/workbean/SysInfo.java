package cn.smartpolice.workbean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import cn.smartpolice.action.AlawaysRun;
import cn.smartpolice.hibernate.SoftInfo;
import cn.smartpolice.protocol.MsgTaskCheckThread;
import cn.smartpolice.protocol.ProtocolAccount;
import cn.smartpolice.protocol.ProtocolBase;
import cn.smartpolice.protocol.ProtocolControl;
import cn.smartpolice.protocol.ProtocolDiscoverLAN;
import cn.smartpolice.protocol.ProtocolEncryption;
import cn.smartpolice.protocol.ProtocolFile;
import cn.smartpolice.protocol.ProtocolLogin;
import cn.smartpolice.protocol.ProtocolMessage;
import cn.smartpolice.protocol.ProtocolQuery;
import cn.smartpolice.protocol.ProtocolRelate;
import cn.smartpolice.protocol.ProtocolTest;
import cn.smartpolice.protocol.ProtocolUpgrade;
import cn.smartpolice.webservice.ManagerInfoService;


/**
 * ϵͳ��Ϣ ʹ��synchronizedSet����ʹHashSet����ͬ����������Set s =
 * Collections.synchronizedSet(new HashSet(...));
 * 
 * @author ����
 *
 */
public class SysInfo {
//    private static int 
	private static SysInfo instance;
	private static UIUserInfo uIUserInfo; // �����û���¼��Ϣ
	public static UIUserInfo getuIUserInfo() {
		return uIUserInfo;
	}

	public static void setuIUserInfo(UIUserInfo uIUserInfo) {
		SysInfo.uIUserInfo = uIUserInfo;
	}


	private static Set<UserNode> userNodeQueue = Collections.synchronizedSet(new HashSet<UserNode>()); // dev����
	// private static HashSet<AppNode> appNodeQueue = new HashSet<AppNode>();

	private static ArrayList<FileNodeInfo> fileDataInfoQueue = new ArrayList<FileNodeInfo>(); // �ļ�����	
//	private static ArrayList<SoftInfo> SoftInfQueue = new ArrayList<SoftInfo>(); //�������
	private static SysStatInfo sysStatInfo = new SysStatInfo(); // ϵͳͳ����Ϣ


	private static SysCfgInfo sysCfgInfo; // ϵͳ������Ϣ
	private static  List<MsgTask> msgTaskQueue = Collections.synchronizedList(new ArrayList<MsgTask>());
	private static Thread msgTaskCheckThread;
	private static Thread startThread;

	// Э�鴦��������
	private static ProtocolBase[] prtocolBases = { new ProtocolTest(), new ProtocolLogin(), new ProtocolAccount(),
			new ProtocolControl(), new ProtocolQuery(), new ProtocolMessage(), new ProtocolDiscoverLAN(),
			new ProtocolFile(),new ProtocolEncryption(),new ProtocolRelate(),new ProtocolFile(),new ProtocolUpgrade()};
	
	public static SysStatInfo getSysStatInfo() {
		sysStatInfo.setOpenFileNum(fileDataInfoQueue.size());//�����ļ�����
		return sysStatInfo;
	}

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
	public Thread createStartThread(ManagerInfoService managerInfoService){	
		msgTaskCheckThread=new Thread((new AlawaysRun(managerInfoService)));
		return msgTaskCheckThread;                                                  
	}
	public static ProtocolBase[] getPrtocolBases() {
		return prtocolBases;
	}

	public static ArrayList<FileNodeInfo> getFileDataInfoQueue() {
		return fileDataInfoQueue;
	}
	


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

	// ��������˽��
	private SysInfo() {
	}

	// �õ�SysInfo����
	public static SysInfo getInstance() {
		instance = new SysInfo();
		return instance;
	}

	// ����id�ҵ�app��Ϣ�ڵ�
	public AppNode getAppNodeById(int id) {
		for (UserNode userNode : userNodeQueue) {
			// id��Ȳ��ж��Ƿ���appnode
			if (userNode.getId() == id && userNode instanceof AppNode) {
				AppNode appNode = (AppNode) userNode; // ��������ת��
				return appNode;
			}
		}
		return null;
	}
	/**
	 * �����û��˻����ҽڵ�
	 * @param string �û��˻�
	 * @return
	 */
	public AppNode getAppNodeByAccount(String account) {
		for (UserNode userNode : userNodeQueue) {
			// id��Ȳ��ж��Ƿ���appnode
			if (userNode.getAccount().equals(account) && userNode instanceof AppNode) {
				AppNode appNode = (AppNode) userNode; // ��������ת��
				return appNode;
			}
		}
		return null;
	}
	/**
	 * �����û��˻����ҽڵ�
	 * @param string �û��˻�
	 * @return
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
	// ����id�ҵ�dev��Ϣ�ڵ�
	public DevNode getDevNodeById(int id) {
		for (UserNode userNode : userNodeQueue) {
			if (userNode.getId() == id && userNode instanceof DevNode) {
				DevNode devNode = (DevNode) userNode;
				return devNode;
			}
		}
		return null;
	}

	// ���һ��userNode�ڵ㵽������
	public synchronized void addUserNode(UserNode userNode) {

		this.userNodeQueue.add(userNode);
	}

	// ɾ��userNode�����е�һ���ڵ�
	public synchronized void removeUserNode(UserNode userNode) {

		this.userNodeQueue.remove(userNode);
	}

	public void addMsgTask(MsgTask msgTask) {

		this.msgTaskQueue.add(msgTask);
	}
	public boolean removeMsgTask(MsgTask msgTask) {

		return this.msgTaskQueue.remove(msgTask);
		
	}
	
	
	/**
	 * ��Ϣ�����̴߳���
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
	public static void startThread(ManagerInfoService managerInfoService) {
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
	}
}
