package com.dinner.service.VipService;

import com.dinner.dao.VipDao.VipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:VipServiceLmpl
 * discription:
 * author:panjing
 * createTime:2018-11-23 15:15
 */
@Service
public class VipServiceLmpl implements VipService {
    @Autowired
    private VipDao vipDao;
    @Override
    public List<Map> VipQuery(Map map) {
        int pageNo=Integer.valueOf(map.get("page")==null?"2":map.get("page")+"");
        int pageSize=Integer.valueOf(map.get("limit")==null?"10":map.get("limit")+"");
        return null;
    }
}
