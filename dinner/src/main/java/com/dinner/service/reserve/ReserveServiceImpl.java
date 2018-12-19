package com.dinner.service.reserve;

import com.dinner.dao.reserve.ReserveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Map> reserveList() {
        return reserveDao.reserveList();
    }

    @Override
    public int addReserve(Map map) {
        reserveDao.updateState(map);
        return reserveDao.addReserve(map);
    }

}
