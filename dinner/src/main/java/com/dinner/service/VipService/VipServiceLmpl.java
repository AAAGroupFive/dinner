package com.dinner.service.VipService;

import com.dinner.dao.VipDao.VipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
        int pageNo = map.get("page") == null ? 1 : Integer.valueOf(map.get("page") + "");
        int pageSize =  map.get("limit") == null ? 10 : Integer.valueOf(map.get("limit") + "");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        List<Map> maps = vipDao.VipQuery(map);

        for (Map map1 : maps) {
            String STATE= String.valueOf(map1.get("VIP_STATE")+"");
            if(STATE.equals("0")){
                map1.put("STATE","启用");

            }else {
                map1.put("STATE","禁用");
            }

            String SEX= String.valueOf(map1.get("VIP_SEX")+"");
            if(SEX.equals("0")){
                map1.put("sex","男");
            }else {
                map1.put("sex","女");
            }
        }

        System.out.println(maps);

        return maps;
    }

    @Override
    public int VipGetPageCount() {
        return vipDao.VipGetPageCount();
    }

    @Override
    public int VipAdd(Map map) {
        if(map.get("VIPname")!=""&&map.get("VIPnumber")!=""&&map.get("sex")!=""&&map.get("VIPbalance")!=""&&map.get("VIPaddress")!="")
        {
            return vipDao.VipAdd(map);
        }else { return -1;}



    }

    @Override
    public int VipUpdate(Map map) {
        Object vip_state = map.get("VIP_STATE");
        if(vip_state.equals("禁用")){
            map.put("state",1);
        }else if(vip_state.equals("启用")){
            map.put("state",0);
        }

        int i = vipDao.VipUpdate(map);
        return i;
    }

    @Override
    public int VipDelete(Map map) {
        Map temp = new HashMap();
        List <Integer> splitDelete = new ArrayList<Integer>();
        String VIP_ID =map.get("VIP_ID").toString();
        String[] split = VIP_ID.split(",");
        List<Map> maps = vipDao.CheckDelete(split);
        System.out.println(maps.get(0).get("VIP_BALANCE"));
        for (Map Check:maps) {
            System.out.println(Check);
            if(Check.get("VIP_BALANCE")!=null&&Integer.valueOf(Check.get("VIP_BALANCE")+"")>0){
                splitDelete.clear();
            }else {
               splitDelete.add(Integer.valueOf(Check.get("VIP_ID")+""));
            }
        }
        System.out.println(splitDelete);
        if(splitDelete.isEmpty()){

            return -1;
        }else {
            return vipDao.VipDelete(splitDelete) ;
        }











    }
}
