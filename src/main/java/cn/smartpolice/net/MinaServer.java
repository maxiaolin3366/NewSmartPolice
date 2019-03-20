package cn.smartpolice.net;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MinaServer {
    final static Logger logger = LoggerFactory.getLogger(MinaServer.class);

	/*public static void initMinaServer() {
		NioDatagramAcceptor acceptor = new NioDatagramAcceptor();
		acceptor.setHandler((IoHandler) new NetHandler()); 
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 180);
		int bindPort = 5678;
		try {
			acceptor.unbind();
			acceptor.bind(new InetSocketAddress(bindPort));
			
	        
		} catch (IOException e) {
			logger.debug("Mina Server start for error ! on port-->"+bindPort);
			e.printStackTrace();
		}
		logger.debug("Mina Server run done ! on port-->"+bindPort);
	}*/

}