package cn.smartpolice.net;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NetServerListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		MinaServer.initMinaServer();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		//释放定时器
		//释放mina网络通信
		System.out.println("初始化信息销毁");
	}

}
