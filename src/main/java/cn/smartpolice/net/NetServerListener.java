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

		//�ͷŶ�ʱ��
		//�ͷ�mina����ͨ��
		System.out.println("��ʼ����Ϣ����");
	}

}
