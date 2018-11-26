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
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
        int pageSize =  map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize") + "");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        List<Map> maps = vipDao.VipQuery(map);

        for (Map map1 : maps) {

            Object vip_sex = map1.get("VIP_SEX");

            if(map1.get("VIP_SEX").toString().equals("0")){
                map1.put("sex","男");
            }else {
                map1.put("sex","女");
            }
        }

        return maps;
    }

    @Override
    public int VipGetPageCount() {
        return vipDao.VipGetPageCount();
    }

    @Override
    public int VipAdd(Map map) {

        return vipDao.VipAdd(map);
    }
}
