package cn.smartpolice.protocol;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
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

	
	long count = 0;//ͳ��ϵͳ�յ��ı�����
	PacketInfo packetInfo = new PacketInfo();
	UserNode userNode = null;
public void RecvPktProc(IoSession ios, byte[] message) throws IOException {
		//todo
//		SysInfo.getSysStatInfo().setReceicvenum(++count);
		packetInfo.setIoSession(ios);
		
		if (ParsePktHead(message) == true) {
			System.out.println(packetInfo.toString());
			if (CheckPktValid() == true) {
				// �������Э�鴦��	
				SysInfo.getPrtocolBases()[packetInfo.getCmd()].ParsePktProto(packetInfo);				
			}
		}
	}
public Boolean ParsePktHead(byte[] message) throws IOException {
	ByteArrayInputStream ips  = new ByteArrayInputStream(message);
	DataInputStream dis = new DataInputStream(ips);
	System.out.println("�����ʼ");
	if (message.length >= ConstParam.MASSAGE_LEN) {
		packetInfo.setMessage(message); // Ϊ������Ϣ��ֵ
		packetInfo.setDate(new Date());
		packetInfo.setLength(message.length);// ���ĳ���
		
		byte[] znafBytes = new byte[4];
		for (int i = 0; i < 4; i++)
			znafBytes[i] = dis.readByte();
		JsonAnalysis jsonAnalysis = new JsonAnalysis();
		String znaf = new String(znafBytes);

		if (znaf.equals("ZNAF")) {// ������ZNAF��ʱ����
			packetInfo.setCmd(dis.readByte());
			packetInfo.setType(dis.readByte());
			packetInfo.setOpt(dis.readByte());
			packetInfo.setSort(dis.readByte());

			if (packetInfo.getCmd() <= ConstParam.MAX_CMD) {// С��13ʱ����
				
				packetInfo.setSid(dis.readInt());
				packetInfo.setSeq(dis.readInt());
				packetInfo.setAck(dis.readInt());

				// ��ע�ᱨ���Ƿ�sid>0
				if ((packetInfo.getCmd() == ConstParam.CMD_2 && packetInfo.getType() == ConstParam.TYPE_1) || packetInfo.getSid()>0) {
					// ����opt�������ײ�ѡ��						
					StringBuffer buffer = new StringBuffer();
					for (int i = 20; i < message.length; i++) {
						buffer.append((char) message[i]);
					}
					String datas = buffer.toString();
					int datapos = datas.indexOf("{\"DATA\"", 20) + (ConstParam.MASSAGE_LEN + 1);
					packetInfo.setDatapos(datapos);// ���������ʼλ��
					byte opt = packetInfo.getOpt();
					if ((opt & 0x01) != 0) { // ��0λ����1ʱ����ʾ�˱����ڷ���������ת������
						String hopt1 = jsonAnalysis.getValue(datas, "HOPT");
						if (hopt1 != null) {
							String did = jsonAnalysis.getValue(hopt1, "DID");
							packetInfo.setDid(Integer.parseInt(did));
						}
					}
					if ((opt & 0x02) != 0) { // ��1λ����2ʱ����ʾ�˱��ļ��ܴ����
						String hopt2 = jsonAnalysis.getValue(datas, "HOPT");
						if (hopt2 != null) {
							String keyseq = jsonAnalysis.getValue(hopt2, "KEYSEQ");
							packetInfo.setKeyseq(Integer.parseInt(keyseq));
						}
					}
					if ((opt & 0x04) != 0) { // ��2λ����4ʱ����ʾ�˱���Я��Դ��ַ������NAT��͸����
						String hopt3 = jsonAnalysis.getValue(datas, "HOPT");
						if (hopt3 != null) {
							String sip = jsonAnalysis.getValue(hopt3, "SIP");
							String sport = jsonAnalysis.getValue(hopt3, "SPORT");
							packetInfo.setSip(sip);
							packetInfo.setSport(Integer.parseInt(sport));
						}
					}
					if ((opt & 0x08) != 0) { // ��3λ����8ʱ����ʾ�˱����������Ļ�����Ҫȷ�ϵı���

					}
					if ((opt & 0x16) != 0) { // ��4λ����16ʱ����ʾ�˱�����Ӧ���ģ�ȷ�Ϻ���Ч

					}
					if ((opt & 0x32) != 0) { // ��5λ����32ʱ����ʾ�˱��ĺ����з�json��ʽ����Ҫ���ڴ����ж����Ƹ�ʽ���ݣ�������ȫʹ��json���������н���

					}
					int len = message.length - packetInfo.getDatapos();
					byte[] copy = new byte[len];
					System.arraycopy(message, packetInfo.getDatapos(), copy, 0, len);
					String datass;
					//���յ���DATA�����ݽ���UTF-8����
					try {
						datass = new String(copy, "UTF-8");
						String data = jsonAnalysis.getValue(datass, "DATA");
						packetInfo.setData(data);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					return true;
				} else
					System.out.println("��ע�ᱨ��sid<0");
				return false;
			} else
				System.out.println("cmd>12");
			return false;
		} else
			System.out.println("����ͷ��������ZNAF");
		return false;
	} else
		System.out.println("���ĳ���С��20�ֽ�");
	return false;
}

// ��鱨����Ч�ԣ�����Э�鶼��Ҫ��һ���Դ���������ʵʩ��
public Boolean CheckPktValid() {

	// ע������
	if (packetInfo.getCmd() == ConstParam.CMD_2 && packetInfo.getType() == ConstParam.TYPE_1) {
		return true;
	}
	// ��ͨ���Ա���
	if (packetInfo.getCmd() == ConstParam.CMD_0 && packetInfo.getType() == ConstParam.TYPE_1
			&& packetInfo.getOpt() == ConstParam.OPT_8) {
		System.out.println("��ͨ����");
		return true;
	}
	if (packetInfo.getCmd() == ConstParam.CMD_11 && packetInfo.getType() == ConstParam.TYPE_1
			&& packetInfo.getOpt() == ConstParam.OPT_8) {
		System.out.println("������ѯ");
		return true;
	}
//	if (packetInfo.getCmd() == ConstParam.CMD_5 && packetInfo.getType() == ConstParam.TYPE_3
//			&& packetInfo.getOpt() == ConstParam.OPT_8) {
//		System.out.println("��Ϣ��ѯ");
//		return true;
//	}
	if (packetInfo.getCmd() == ConstParam.CMD_5) {
		//System.out.println("��Ϣ��ѯ");
		return true;
	}
	// ����SID�ҵ��û���Ϣ�ڵ�
	// dev��app�Ĵ���

	// ͨ������sort�ж���dev����app
	if (packetInfo.getSort() == ConstParam.SORT_2) {
		userNode = SysInfo.getInstance().getDevNodeById(packetInfo.getSid());
		System.out.println("ǰ���豸");
	}
	if (packetInfo.getSort() == ConstParam.SORT_0) {
		userNode = SysInfo.getInstance().getAppNodeById(packetInfo.getSid());
		System.out.println("app�û�");
	}

	// cmd=1ʱ�����ڽڵ㶼�����������һ�ε�½ȫ�ֶ����л������ڸýڵ㣩
	if (userNode == null) {
		System.out.println("û�нڵ�");
		if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_1) {
			// �����dev��½�򴴽��µ�dev�ڵ�

			if (packetInfo.getSort() == ConstParam.SORT_2) {
				DeviceInfo devinf = deviceDao.findDevByID(packetInfo.getSid());
				if (devinf != null) {
					// ip��port��Ҫ�Ǿֲ��������õ�Ӧ��ı��Ļ�仯�����ߵ������
					String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
							.getHostAddress();
					int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
					DevNode devNode = new DevNode(); // �����ڵ�
					Random rando = new Random();
					int random = rando.nextInt(999999) % 900000 + 100000; // ����һ��6λ�����
					devNode.setLink(random);
					devNode.setIp(ip);
					devNode.setPort(port);
					devNode.setAccount(devinf.getUsername());
					devNode.setId(devinf.getDeviceid());
					devNode.setRevPktDate(new Date());

					devNode.setIoSession(packetInfo.getIoSession());
					devNode.setRevPktId(packetInfo.getSeq());
					// �մ����Ľڵ�ĵ�¼״̬��Ϊ0����ʾ��δ��֤
					devNode.setState(ConstParam.LOGIN_STATE_0);
					// ���ڵ���Ϣ��ӵ������� ����Ϊ����ProtocolLogin��ȡ��ȡ�ڵ�id (���Ż�) ��ͬ
					packetInfo.setDevNode(devNode);
					// ���ڵ���ӵ����� �ڵ�¼�����д�ȫ�ֶ�����ȡ ��ͬ
					SysInfo.getInstance().addUserNode(devNode);
					System.out.println("�����ڵ�:");
					System.out.println(devNode);
					return true;
				} else
					return false;
			}
			// ������app��½ �򴴽�app�ڵ�
			else if (packetInfo.getSort() == ConstParam.SORT_0) {

				User_Info appInf = userDao.findAppuserByID(packetInfo.getSid());
				if (appInf != null) {
					String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
							.getHostAddress();
					int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
					AppNode appNode = new AppNode(); // �����ڵ�
					Random rando = new Random();
					int random = rando.nextInt(99999) % 90000 + 10000; // ����һ��5λ�����
					appNode.setLink(random);
					appNode.setIp(ip);
					appNode.setPort(port);
					// �û��˺� ProtocolLogin��ȡ�����Աȣ����û�����������ʵ������
					appNode.setAccount(appInf.getUsername());
					appNode.setId(appInf.getId());
					appNode.setRevPktDate(new Date());
					appNode.setRevPktId(packetInfo.getSeq());
					appNode.setIoSession(packetInfo.getIoSession());
					appNode.setState(ConstParam.LOGIN_STATE_0);
					packetInfo.setAppNode(appNode);
					SysInfo.getInstance().addUserNode(appNode); // ���ڵ���ӵ�����
					System.out.println("�����ڵ�:");
					System.out.println(appNode);
					return true;
				} else {
					return false;
				}
			} else {
				System.out.print("��֧��");
				return false;
			}
		} else {
			System.out.print("δ��¼ʱ�޽ڵ㣬���������޷����У�");
			return false;
		}
	}

	// 1.������֤����¼����󷵻�������֤�ı��ģ���2.��¼���󣨵��� ��û���ü�ɾ��ȫ�ֶ����еĽڵ㣩��3.����Ĵ���������ڵ����ʱ��
	else {
		System.out.println("���ڽڵ�");
		// �жϽڵ�״̬�����Ϊ�ѵ�¼�ڵ㣬����TRUE�����Ϊδ��֤�ڵ㣬ֻ����������¼Э��
		if (userNode.getState() == ConstParam.LOGIN_STATE_2) {
			System.out.println("�ڵ��ѵ�¼��" + userNode.getId());

			JsonAnalysis jsonAnalysis = new JsonAnalysis();
			if (jsonAnalysis.getValue(packetInfo.getData(), "LINK") != null) {// ������õ���LINK������ڵ��е�LINK�Աȣ��Ƿ���ͬ������ñ�����Ч
				System.out.println("link��Ϊ��");
				int link = Integer.parseInt(jsonAnalysis.getValue(packetInfo.getData(), "LINK"));
				if (userNode.getLink() == link) {
					System.out.println("LINK��ȷ");
					if (!updateUserNode()) {
						return false;
					}
				} else {
					System.out.println("link����ȷ��ɾ���ڵ�");
					// SysInfo.getInstance().removeUserNode(userNode);
					return false;
				}

			} else {
				if (!updateUserNode()) {
					return false;
				} // ���½ڵ���Ϣ
			}
		} else { // δ��¼�ڵ�
			System.out.println("�ڵ�δ��¼");
			if (!updateUserNode()) {
				return false;
			} // ���½ڵ���Ϣ
			if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_1) {
				System.out.println("�ǵ�¼����");
				return true;
			} else if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_3) {
				System.out.println("�ǵ�¼��֤����");
				return true;
			} else {
				return false;
			}
		}
	}
	return true;
}

public boolean updateUserNode() {
	// ���ԴIP�Ͷ˿ڣ����Ƿ�仯
	String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
								.getHostAddress();
	int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
	if (!userNode.getIp().equals(ip) || userNode.getPort() != port) {
		System.out.println("IP�Ͷ˿ںŸı�");
		userNode.setIp(ip);
		userNode.setPort(port);
		userNode.setIoSession(packetInfo.getIoSession());
	}
    userNode.setRevPktDate(new Date()); // ��¼������ձ���ʱ��
	if (userNode instanceof DevNode) { // Ҳ����ͨ������sort�ж������ֽڵ�
		DevNode devNode = (DevNode) userNode;
		packetInfo.setDevNode(devNode);
	} else {
		AppNode appNode = (AppNode) userNode;
		packetInfo.setAppNode(appNode);
	}
	if (userNode.getRevPktId() == packetInfo.getSeq()) {//�����ظ���������һ�η��ͱ���
		packetInfo.getIoSession().write(IoBuffer.wrap(userNode.getLastPacketInfo()));
		return false;
	}
	userNode.setRevPktId(packetInfo.getSeq());
	return true;

}
}
