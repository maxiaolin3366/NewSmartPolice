package cn.smartpolice.net;

import cn.smartpolice.protocol.ConstParam;
import cn.smartpolice.workbean.AppNode;
import cn.smartpolice.workbean.DevNode;
import cn.smartpolice.workbean.SysInfo;
import cn.smartpolice.workbean.UserNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProtocolTimer {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void timerTasks() {
        int intervalTime = 10 * 1000;//单位：毫秒 检查间隔时间
        int overTime = 60 * 1000; //单位：毫秒  节点超时时间
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                logger.debug("定时检查线程启动-->");
                int devNum = 0;
                int userNum = 0;
                Date CurrentTime = new Date();
                for (UserNode userNode : SysInfo.getInstance().getUserNodeQueue()) {
                    if (userNode instanceof DevNode && userNode.getState() == ConstParam.LOGIN_STATE_2) {
                        ++devNum;
                    }
                    if (userNode instanceof AppNode && userNode.getState() == ConstParam.LOGIN_STATE_2) {
                        ++userNum;
                    }
                    long interval = (CurrentTime.getTime() - userNode.getRevPktDate().getTime());

                    if (interval > overTime) {
                        SysInfo.getInstance().removeUserNode(userNode); //删除节点
                        logger.debug("节点超时被删除-->" + userNode);
                    }
                }
                SysInfo.getSysStatInfo().setLogindevnum(devNum);//统计登陆设备
                SysInfo.getSysStatInfo().setLoginusernum(userNum);//统计登陆用户
            }
        }, 0, intervalTime, TimeUnit.MILLISECONDS);
    }
}
