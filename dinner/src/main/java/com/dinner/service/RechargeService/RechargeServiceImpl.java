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
        List<Map> maps = rechargeDao.RechargeQuery(map);

        return maps ;
    }

    @Override
    public int RechargeGetPageCount() {
        return rechargeDao.RechargeGetPageCount();
    }

    @Override
    public int RechargeAdd(Map map) {
        System.out.println(map);
        int recharge =0;
        int re_before_money =0;
        if(map.get("RECHARGE")!=""){
            recharge = Integer.parseInt(map.get("RECHARGE").toString());
        }
        if(map.get("RE_BEFORE_MONEY")!=""){
            re_before_money  = Integer.parseInt(map.get("RE_BEFORE_MONEY").toString());
        }


        int re_give;
        if(map.get("RE_GIVE")!=null){
          re_give= Integer.parseInt(map.get("RE_GIVE").toString());
        }else {
            re_give=0;
        }

        int balance=recharge+re_before_money+re_give;

        map.put("balance",balance);
        int i = rechargeDao.RechargeUpdata(map);

        return rechargeDao.RechargeAdd(map);
    }


}
