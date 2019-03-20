package cn.smartpolice.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smartpolice.entity.AdminLog;
import cn.smartpolice.service.serviceImpl.AdminLogService;

@Controller
public class ManagerAdminController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private AdminLogService adminLogService;

    @Autowired
    public void setAdminLogService(AdminLogService adminLogService) {
        this.adminLogService = adminLogService;
    }

	@RequestMapping("/admin")
	public String addAdminLog(String s) {

        logger.info("路径配置成功");
		System.out.println(s);
        AdminLog adminlog = new AdminLog();
		try {
			adminLogService.addAdminLog(adminlog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            logger.debug("insert adminlog failed!");
        }
        return "index";
	}

}
