package com.dinner.service.reserve;

import antlr.StringUtils;
import com.dinner.dao.reserve.ReserveDao;
import com.github.pagehelper.util.StringUtil;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * className:ReserveServiceImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-12-17 14:06
 */
@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveDao reserveDao;

    @Override
    public List<Map> reserveList(String selectDate) {
        if(StringUtil.isEmpty(selectDate)){
            selectDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return reserveDao.reserveList(selectDate);
    }

    @Override
    public int addReserve(Map map) {
        //reserveDao.updateState(map);
        return reserveDao.addReserve(map);
    }

    @Override
    public List<Map> reList() {
        return reserveDao.reList();
    }
}
