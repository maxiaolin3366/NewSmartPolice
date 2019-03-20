package cn.smartpolice.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartpolice.dao.AdminLogMapper;
import cn.smartpolice.entity.AdminLog;
import cn.smartpolice.service.AdminLogServiceI;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminLogService implements AdminLogServiceI {


    private AdminLogMapper adminLogDao;

    @Autowired
    public void setAdminLogDao(AdminLogMapper adminLogDao) {
        this.adminLogDao = adminLogDao;
    }

    public void addAdminLog(AdminLog adminlog) throws Exception {
        // TODO Auto-generated method stub
        adminLogDao.insert(adminlog);
    }

}
