package com.dinner.service.goodsService;

import com.dinner.dao.goodsDao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:GoodsServiceImpl
 * discriptoin:
 * author:王朝军
 * createTime:2018-11-22 20:51
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private  GoodsDao goodsDao;

    @Override
    public List<Map> goodsList(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return goodsDao.goodsList(map);
    }
    @Override
    public int countFoodsList() {
        return goodsDao.countFoodsList();
    }

    @Override
    public int updateInventory(Map map) {
/*        String userName = session.getAttribute("userName");
        map.put("userName",userName);*/
        //System.out.println(map.get("Account")+"前面处来的账号");
        Map userName = goodsDao.selectUser(map);
        map.put("userName",String.valueOf(userName.get("EMP_NAME")));

        int result = goodsDao.addInventory(map);
        int result1 = goodsDao.updateGoods(map);
        if (result!=-1&&result1!=-1){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Map> inventoryList(Map map) {
        return goodsDao.inventoryList(map);
    }

    @Override
    public List<Map> inventoryDetails(Map map) {
        return goodsDao.inventoryDetails(map);
    }

    @Override
    public int addPutGoods(Map map) {
        Map userName = goodsDao.selectUser(map);
        map.put("userName",String.valueOf(userName.get("EMP_NAME")));
        return goodsDao.addPutGoods(map);
    }

    @Override
    public List<Map> putGoodsList(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return goodsDao.putGoodsList(map);
    }

    @Override
    public int countPutList() {
        return goodsDao.countPutList();
    }

    @Override
    public int addPutRecord(Map map) {
        Map userName = goodsDao.selectUser(map);
        map.put("userName",String.valueOf(userName.get("EMP_NAME")));
        int result = goodsDao.addPutRecord(map);
        int result1= goodsDao.updateGoods2(map);
        int result2= goodsDao.deletePut(map);
        if (result1!=-1&&result!=-1&&result2!=-1) {
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int addPutRecord2(Map map) {
        Map userName = goodsDao.selectUser(map);
        map.put("userName",String.valueOf(userName.get("EMP_NAME")));
        int result = goodsDao.addPutRecord2(map);
        int result1= goodsDao.deletePut(map);
        if (result1!=-1&&result!=-1) {
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Map> putRecord(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize")+"");
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return goodsDao.putRecord(map);
    }

    @Override
    public int countPutRecordList() {
        return goodsDao.countPutRecordList();
    }

}
