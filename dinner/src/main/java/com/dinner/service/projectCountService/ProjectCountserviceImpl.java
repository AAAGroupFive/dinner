package com.dinner.service.projectCountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dinner.dao.projectCountDao.ProjoectCountDao;
import java.util.List;
import java.util.Map;

/**
 * className:projectCountserviceImpl
 * discription:
 * author:panjing
 * createTime:2018-11-29 18:41
 */
@Service
public class ProjectCountserviceImpl implements ProjectCountService {
    @Autowired
    private ProjoectCountDao projoectCountDao;

    @Override
    public List<Map> getMoneyCount() {
        // TODO Auto-generated method stub
        return projoectCountDao.getMoneyCount();
    }
    @Override
    public List<Map> getVipMoneyCount() {
        // TODO Auto-generated method stub
        return projoectCountDao.getVipMoneyCount();
    }
}
