package cn.smartpolice.net;

import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import cn.smartpolice.protocol.ProtocolProc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NetHandler extends IoHandlerAdapter {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	ProtocolProc ProtocolProc = new ProtocolProc();
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		SocketAddress remoteAddress = session.getRemoteAddress(); //获取远程客户端地址信息
		Date date = new Date();
		logger.debug("连接成功-->" + remoteAddress);
	}

	public void messageReceived(IoSession session, Object message) throws Exception {
		long time1 = new Date().getTime();
		logger.debug("消息接入--> ");
		String messageStr = message.toString();
		byte[] b = messageStr.getBytes(StandardCharsets.UTF_8);
		ProtocolProc.RecvPktProc(session, b);
		long time2 = new Date().getTime();
		logger.debug("系统反应时间-->" + (time2 - time1) + "毫秒");
		logger.debug("----等待消息接入----");
	}
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("会话启动 -->");
	}

	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("消息已回传给客户端-->" + session.getRemoteAddress());
	}

	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("其他方法抛出异常-->" + cause);
		logger.debug("客户端-->" + session.getRemoteAddress() + " 关闭了连接");
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub

	}

	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		logger.debug("远程网络连接被关闭-->");
	}


	


	


	
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println("-->远程网络关闭时间：" + date.toString());
	}


}
