package com.dinner.service.emp;

import com.dinner.dao.emp.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discriptoin:
 * author:zz
 * createTime:2018-11-23-10:13
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    @Override
    public List<Map> getEmp(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize") + "");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return empDao.getEmp(map);
    }

    @Override
    public int getCountEmp(Map map) {
        return empDao.getCountEmp(map);
    }
}
