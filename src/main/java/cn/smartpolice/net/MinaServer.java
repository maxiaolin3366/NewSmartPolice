package cn.smartpolice.net;


import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;


public class MinaServer {

	public static void initMinaServer() {
		NioDatagramAcceptor acceptor = new NioDatagramAcceptor();
		acceptor.setHandler((IoHandler) new NetHandler()); 
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 180);
		int bindPort = 5678;
		try {
			acceptor.unbind();
			acceptor.bind(new InetSocketAddress(bindPort));
			
	        
		} catch (IOException e) {
			System.out.println("Mina Server start for error!"+bindPort);
			e.printStackTrace();
		}
		System.out.println("Mina Server run done!!! on port:"+bindPort); 
	}
}
