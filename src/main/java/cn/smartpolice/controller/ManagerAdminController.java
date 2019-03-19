package cn.smartpolice.controller;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smartpolice.entity.Admin_Log;
import cn.smartpolice.service.serviceImpl.AdminLogService;

@Controller
public class ManagerAdminController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AdminLogService adminLogService;

	@RequestMapping("/admin")
	public String addAdminLog(String s) {

		logger.info("路径配置成???");
		System.out.println(s);
		Admin_Log adminlog = new Admin_Log();
		adminlog.setAdmin_id(2);
		adminlog.setLogin_time(new Date(System.currentTimeMillis()));
		adminlog.setOprate("登???");
		try {
			adminLogService.addAdminLog(adminlog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "insert adminlog failed!";
		}
		return "NewFile";
	}

}
