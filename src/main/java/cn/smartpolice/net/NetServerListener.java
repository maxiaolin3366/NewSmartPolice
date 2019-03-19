package cn.smartpolice.net;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NetServerListener implements ServletContextListener{


    public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		MinaServer.initMinaServer();
	}


    public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
