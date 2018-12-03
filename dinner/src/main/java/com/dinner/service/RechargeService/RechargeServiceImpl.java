package com.dinner.service.RechargeService;

import com.dinner.dao.RechargeDao.RechargeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:RechargeServiceImpl
 * discription:
 * author:panjing
 * createTime:2018-12-03 14:03
 */
@Service
public class RechargeServiceImpl implements RechargeSerive {
    @Autowired
    private RechargeDao rechargeDao;

    @Override
    public List<Map> RechargeQuery(Map map) {
        int pageNo = map.get("page") == null ? 1 : Integer.valueOf(map.get("page") + "");
        int pageSize =  map.get("limit") == null ? 10 : Integer.valueOf(map.get("limit") + "");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return rechargeDao.RechargeQuery(map);
    }

    @Override
    public int RechargeGetPageCount() {
        return rechargeDao.RechargeGetPageCount();
    }

    @Override
    public int RechargeAdd(Map map) {
        System.out.println(map);
        return rechargeDao.RechargeAdd(map);
    }


}
