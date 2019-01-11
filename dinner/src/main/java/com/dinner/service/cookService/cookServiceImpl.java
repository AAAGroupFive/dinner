package com.dinner.service.cookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dinner.dao.cookDao.cookDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:cookServiceImpl
 * discriptoin:
 * author:王朝军
 * createTime:2019-01-11 21:17
 */
@Service
public class cookServiceImpl implements cookService{
    @Autowired
    private cookDao cookDao;
    /**
     * 待做
     * @param map
     * @return
     */
    @Override
    public List<Map> cookList(Map map) {
        List<Map> map1 = new ArrayList<>();
        map1=cookDao.cookList(map);
        for (Map map2 : map1) {
            String state = String.valueOf(map2.get("CON_STATE"));
            if (state.equals("0")) {
                map2.put("STATE", "未做");
            }
        }
        return map1;
    }

    /**
     * 已做
     * @param map
     * @return
     */
    @Override
    public List<Map> cookedList(Map map) {
        List<Map> map1 = new ArrayList<>();
        map1=cookDao.cookedList(map);
        for (Map map2 : map1) {
            String state = String.valueOf(map2.get("CON_STATE"));
            if (state.equals("1")) {
                map2.put("STATE", "已做");
            }
        }
        return map1;
    }

    @Override
    public int updateCook(Map map) {
        return cookDao.updateCook(map);
    }
}
