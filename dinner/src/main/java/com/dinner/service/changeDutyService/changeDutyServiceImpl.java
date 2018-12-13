package com.dinner.service.changeDutyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dinner.dao.changeDutyDao.changeDutyDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * className:changeDutyServiceImpl
 * discription:
 * author:panjing
 * createTime:2018-12-08 13:58
 */
@Service
public class changeDutyServiceImpl implements changeDutyService {

    @Autowired
    private changeDutyDao changeDutyDao;
    @Override
    public Map queryChangeDuty() {
        Map maps = changeDutyDao.queryChangeDuty();

        String queryMoney = changeDutyDao.queryMoney();

        maps.put("Money",queryMoney);
        return maps;
    }

    @Override
    public  List<Map> queryJemp() {
        List<Map> maps = changeDutyDao.queryJemp();

        return  maps;
    }

    @Override
    public int insert(Map map) {
        String stime = (String) map.get("stime");

        String etime = (String)  map.get("etime");
        stime = stime.replace("Z", " UTC");//注意是空格+UTC
        etime = etime.replace("Z", " UTC");//注意是空格+UTC
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
        try {
            Date stime1 = format.parse(stime);
            Date etime1= format.parse(etime);
            map.put("stime1",stime1);
            map.put("etime1",etime1);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return changeDutyDao.insert(map);
    }

    @Override
    public List<Map> queryRecord() {
        return changeDutyDao.queryRecord();
    }
}
