package com.dinner.controller.foodController;

import com.dinner.service.orderService.OrderService;
import com.dinner.service.food.foodService;
import com.dinner.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * className:FoodController
 * describe:
 * author:邢芳彬
 * createTime:2018-12-11 09:38
 */
@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private foodService foodService;
    @Autowired
    private FtpUtil ftpUtil;
    private ResourceLoader resourceLoader;

    @Value("${ftp.remoteIp}")
    private String remoteIp;
    @Value("${ftp.ftpUserName}")
    private String ftpUserName;
    @Value("${ftp.ftpPassWord}")
    private String ftpPassWord;
    @Value("${ftp.remotePath}")
    private String remotePath;
    @Value("${ftp.uploadPort}")
    private String uploadPort;

    @Value("${ftp.localPath}")
    private String filePath; // D:/images/

    @Autowired
    public FoodController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 菜单列表
     * @return
     */
    @RequestMapping("foodList")
    public String foodList(Model model) {
        model.addAttribute("data",orderService.goodList());
        return "after/foodManager";
    }

    /**
     * 菜单添加和更新
     * @return
     */
    @ResponseBody
    @RequestMapping("addORupdate")
    public Integer addORupdate(@RequestBody Map map){
        int state = 0;
        if (map.get("FOOD_ID") != null) {
            state = foodService.updateFood(map);
        } else {
            state = foodService.addFood(map);
        }
        return state;
    }

    /**
     * 菜品删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("delete")
    public Integer delete(@RequestParam Map map) {
        return foodService.delFood(map);
    }

/*    *//**
     * 图片显示
     * @param fileName
     * @return
     *//*
    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("file:" + filePath + fileName);
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }*/
    /**
     * 图片显示方法
     * @param fileName
     * @return
     */
    @RequestMapping("/showFtp")
    public ResponseEntity showFtp(String fileName){
        try {
            Resource resource = resourceLoader.getResource("ftp://"+ftpUserName+":"+ftpPassWord+"@"+remoteIp+remotePath+fileName);
            return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpUserName+":"+ftpPassWord+"@"+remoteIp+remotePath+fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * 图片上传
     * @param file
     * @return
     */
    @RequestMapping("/uploadPic")
    @ResponseBody
    public Object uploadPic(@RequestParam MultipartFile file){

        /*if (file!=null&&!file.isEmpty()){*/
            final String s = ftpUtil.upLoad(file);
            /*map.put("filePath",s);
            map.put("fileName",file.getOriginalFilename());
        }
        System.out.println("上传了原图名字 "+file.getOriginalFilename());
        foodService.addFood(map);
        System.out.println(foodService.addFood(map));
        return foodService.addFood(map);*/
            return s;
    }




}
