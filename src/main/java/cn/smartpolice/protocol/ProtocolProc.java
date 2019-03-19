package cn.smartpolice.protocol;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import cn.smartpolice.entity.Device_Info;
import cn.smartpolice.entity.User_Info;
import cn.smartpolice.tools.JsonAnalysis;
import cn.smartpolice.workbean.AppNode;
import cn.smartpolice.workbean.DevNode;
import cn.smartpolice.workbean.PacketInfo;
import cn.smartpolice.workbean.SysInfo;
import cn.smartpolice.workbean.UserNode;

public class ProtocolProc {


	long count = 0;//统计系统???到的报文数
	PacketInfo packetInfo = new PacketInfo();
	UserNode userNode = null;
public void RecvPktProc(IoSession ios, byte[] message) throws IOException {
		//todo
//		SysInfo.getSysStatInfo().setReceicvenum(++count);
		packetInfo.setIoSession(ios);
		
		if (ParsePktHead(message) == true) {
			System.out.println(packetInfo.toString());
			if (CheckPktValid() == true) {
				// 进入具体协议处理
				SysInfo.getPrtocolBases()[packetInfo.getCmd()].ParsePktProto(packetInfo);				
			}
		}
	}
public Boolean ParsePktHead(byte[] message) throws IOException {
	ByteArrayInputStream ips  = new ByteArrayInputStream(message);
	DataInputStream dis = new DataInputStream(ips);
	System.out.println("解包?????");
	if (message.length >= ConstParam.MASSAGE_LEN) {
		packetInfo.setMessage(message); // 为报文信息赋??
		packetInfo.setDate(new Date());
		packetInfo.setLength(message.length);// 报文长度
		
		byte[] znafBytes = new byte[4];
		for (int i = 0; i < 4; i++)
			znafBytes[i] = dis.readByte();
		JsonAnalysis jsonAnalysis = new JsonAnalysis();
		String znaf = new String(znafBytes);

		if (znaf.equals("ZNAF")) {// 包含“ZNAF”时解????
			packetInfo.setCmd(dis.readByte());
			packetInfo.setType(dis.readByte());
			packetInfo.setOpt(dis.readByte());
			packetInfo.setSort(dis.readByte());

			if (packetInfo.getCmd() <= ConstParam.MAX_CMD) {// 小???13时解???
				
				packetInfo.setSid(dis.readInt());
				packetInfo.setSeq(dis.readInt());
				packetInfo.setAck(dis.readInt());

				// 非注册报文是否sid>0
				if ((packetInfo.getCmd() == ConstParam.CMD_2 && packetInfo.getType() == ConstParam.TYPE_1) || packetInfo.getSid()>0) {
					// 根据opt，解析首?????????
					StringBuffer buffer = new StringBuffer();
					for (int i = 20; i < message.length; i++) {
						buffer.append((char) message[i]);
					}
					String datas = buffer.toString();
					int datapos = datas.indexOf("{\"DATA\"", 20) + (ConstParam.MASSAGE_LEN + 1);
					packetInfo.setDatapos(datapos);// 数据域的起始位置
					byte opt = packetInfo.getOpt();
					if ((opt & 0x01) != 0) { // ???0位，??1时，表示此报文在服务器进行转发处???
						String hopt1 = jsonAnalysis.getValue(datas, "HOPT");
						if (hopt1 != null) {
							String did = jsonAnalysis.getValue(hopt1, "DID");
							packetInfo.setDid(Integer.parseInt(did));
						}
					}
					if ((opt & 0x02) != 0) { // ???1位，??2时，表示此报文加密处理过
						String hopt2 = jsonAnalysis.getValue(datas, "HOPT");
						if (hopt2 != null) {
							String keyseq = jsonAnalysis.getValue(hopt2, "KEYSEQ");
							packetInfo.setKeyseq(Integer.parseInt(keyseq));
						}
					}
					if ((opt & 0x04) != 0) { // ???2位，??4时，表示此报文携带源地址，便于NAT穿???处???
						String hopt3 = jsonAnalysis.getValue(datas, "HOPT");
						if (hopt3 != null) {
							String sip = jsonAnalysis.getValue(hopt3, "SIP");
							String sport = jsonAnalysis.getValue(hopt3, "SPORT");
							packetInfo.setSip(sip);
							packetInfo.setSport(Integer.parseInt(sport));
						}
					}
					if ((opt & 0x08) != 0) { // ???3位，??8时，表示此报文是请求报文或???需要确认的报???

					}
					if ((opt & 0x16) != 0) { // ???4位，??16时，表示此报文是应答报文，确认号有???

					}
					if ((opt & 0x32) != 0) { // ???5位，??32时，表示此报文后面有非json格式，主要用于传输有二进制格式数据，不能完全使用json解析器进行解???

					}
					int len = message.length - packetInfo.getDatapos();
					byte[] copy = new byte[len];
					System.arraycopy(message, packetInfo.getDatapos(), copy, 0, len);
					String datass;
					//将收到的DATA域内????进行UTF-8编???
					datass = new String(copy, StandardCharsets.UTF_8);
					String data = jsonAnalysis.getValue(datass, "DATA");
					packetInfo.setData(data);
					return true;
				} else
					System.out.println("非注册报文sid<0");
				return false;
			} else
				System.out.println("cmd>12");
			return false;
		} else
			System.out.println("报文头部不包含ZNAF");
		return false;
	} else
		System.out.println("报文长度小???20字???");
	return false;
}

	// ???查报文有效???，??有协???????要的??般???处理在这里????施??
public Boolean CheckPktValid() {

	// 注册请求
	if (packetInfo.getCmd() == ConstParam.CMD_2 && packetInfo.getType() == ConstParam.TYPE_1) {
		return true;
	}
	// 连???测试报??
	if (packetInfo.getCmd() == ConstParam.CMD_0 && packetInfo.getType() == ConstParam.TYPE_1
			&& packetInfo.getOpt() == ConstParam.OPT_8) {
		System.out.println("连???测???");
		return true;
	}
	if (packetInfo.getCmd() == ConstParam.CMD_11 && packetInfo.getType() == ConstParam.TYPE_1
			&& packetInfo.getOpt() == ConstParam.OPT_8) {
		System.out.println("升级查询");
		return true;
	}
//	if (packetInfo.getCmd() == ConstParam.CMD_5 && packetInfo.getType() == ConstParam.TYPE_3
//			&& packetInfo.getOpt() == ConstParam.OPT_8) {
//		System.out.println("消息查询");
//		return true;
//	}
	if (packetInfo.getCmd() == ConstParam.CMD_5) {
		//System.out.println("消息查询");
		return true;
	}
	// 根据SID找到用户信息节点
	// dev和app的处??

	// 通过报文sort判断是dev还是app
	if (packetInfo.getSort() == ConstParam.SORT_2) {
		userNode = SysInfo.getInstance().getDevNodeById(packetInfo.getSid());
		System.out.println("前端设备");
	}
	if (packetInfo.getSort() == ConstParam.SORT_0) {
		userNode = SysInfo.getInstance().getAppNodeById(packetInfo.getSid());
		System.out.println("app用???");
	}

	// cmd=1时不????在节点都从这儿进（第一次登陆全???队列中还不存在该节点??
	if (userNode == null) {/*
		System.out.println("没有节点");
		if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_1) {
			// 如果是dev登陆则创建新的dev节???

			if (packetInfo.getSort() == ConstParam.SORT_2) {
				Device_Info devinf = deviceDao.findDevByID(packetInfo.getSid());
				if (devinf != null) {
					// ip和port???要是??部变量，得到应答的报文会变化（掉线的情况???
					String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
							.getHostAddress();
					int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
					DevNode devNode = new DevNode(); // 创建节点
					Random rando = new Random();
					int random = rando.nextInt(999999) % 900000 + 100000; // 产生??????6位随机数
					devNode.setLink(random);
					devNode.setIp(ip);
					devNode.setPort(port);
					devNode.setAccount(devinf.getUsername());
					devNode.setId(devinf.getDeviceid());
					devNode.setRevPktDate(new Date());

					devNode.setIoSession(packetInfo.getIoSession());
					devNode.setRevPktId(packetInfo.getSeq());
					// 刚创建的节点的登录状态置???0，表示还未验??
					devNode.setState(ConstParam.LOGIN_STATE_0);
					// 将节点信息添加到报文?? 仅仅为了在ProtocolLogin中取获取节点id (可优??) 下???
					packetInfo.setDevNode(devNode);
					// 将节点添加到队列 在登录处理中从全???队列中取 下???
					SysInfo.getInstance().addUserNode(devNode);
					System.out.println("创建节点:");
					System.out.println(devNode);
					return true;
				} else
					return false;
			}
			// 若果是app登??? 则创建app节???
			else if (packetInfo.getSort() == ConstParam.SORT_0) {

				User_Info appInf = userDao.findAppuserByID(packetInfo.getSid());
				if (appInf != null) {
					String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
							.getHostAddress();
					int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
					AppNode appNode = new AppNode(); // 创建节点
					Random rando = new Random();
					int random = rando.nextInt(99999) % 90000 + 10000; // 产生??????5位随机数
					appNode.setLink(random);
					appNode.setIp(ip);
					appNode.setPort(port);
					// 用户????? ProtocolLogin会取出来对比（是用户?????不是真????姓名）
					appNode.setAccount(appInf.getUsername());
					appNode.setId(appInf.getId());
					appNode.setRevPktDate(new Date());
					appNode.setRevPktId(packetInfo.getSeq());
					appNode.setIoSession(packetInfo.getIoSession());
					appNode.setState(ConstParam.LOGIN_STATE_0);
					packetInfo.setAppNode(appNode);
					SysInfo.getInstance().addUserNode(appNode); // 将节点添加到队列
					System.out.println("创建节点:");
					System.out.println(appNode);
					return true;
				} else {
					return false;
				}
			} else {
				System.out.print("不支??");
				return false;
			}
		} else {
			System.out.print("未登录时无节点，其他操作无法进行???");
			return false;
		}*/
	}

	// 1.请求验证（登录请求后返回请求验证的报文）???2.登录请求（?????? 还没来得及删除全???队列中的节点），3.保活报文从这儿进（节点存在时??
	else {
		System.out.println("存在节点");
		// 判断节点状???，如果为已登录节点，返回TRUE，如?????未验证节点，只能允许进入登录协???
		if (userNode.getState() == ConstParam.LOGIN_STATE_2) {
			System.out.println("节点已登录???" + userNode.getId());

			JsonAnalysis jsonAnalysis = new JsonAnalysis();
			if (jsonAnalysis.getValue(packetInfo.getData(), "LINK") != null) {// 如果配置的有LINK，则与节??????的LINK对比，是否相同，否则该报文无??
				System.out.println("link不为??");
				int link = Integer.parseInt(jsonAnalysis.getValue(packetInfo.getData(), "LINK"));
				if (userNode.getLink() == link) {
					System.out.println("LINK正???");
					return updateUserNode();
				} else {
					System.out.println("link不正确，删除节点");
					// SysInfo.getInstance().removeUserNode(userNode);
					return false;
				}

			} else {
				// 更新节点信???
				return updateUserNode();
			}
		} else { // 未登录节???
			System.out.println("节点未登???");
			if (!updateUserNode()) {
				return false;
			} // 更新节点信???
			if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_1) {
				System.out.println("是登录请???");
				return true;
			} else if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_3) {
				System.out.println("是登录验证请??");
				return true;
			} else {
				return false;
			}
		}
	}
	return true;
}

public boolean updateUserNode() {
	// ???查源IP和端口，看是???????
	String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
								.getHostAddress();
	int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
	if (!userNode.getIp().equals(ip) || userNode.getPort() != port) {
		System.out.println("IP和端口号???变");
		userNode.setIp(ip);
		userNode.setPort(port);
		userNode.setIoSession(packetInfo.getIoSession());
	}
	userNode.setRevPktDate(new Date()); // 记录??近接收报文时??
	if (userNode instanceof DevNode) { // 也可?????过报文sort判断是哪种节??
		DevNode devNode = (DevNode) userNode;
		packetInfo.setDevNode(devNode);
	} else {
		AppNode appNode = (AppNode) userNode;
		packetInfo.setAppNode(appNode);
	}
	if (userNode.getRevPktId() == packetInfo.getSeq()) {//报文重复，返回上?????????送报??
		packetInfo.getIoSession().write(IoBuffer.wrap(userNode.getLastPacketInfo()));
		return false;
	}
	userNode.setRevPktId(packetInfo.getSeq());
	return true;

}
}
