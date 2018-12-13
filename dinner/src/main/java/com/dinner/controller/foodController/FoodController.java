package com.dinner.controller.foodController;

import com.dinner.service.orderService.OrderService;
import com.dinner.service.food.foodService;
import com.dinner.util.FileUtil;
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

    private ResourceLoader resourceLoader;

    @Value("${upload.path}")
    private String filePath; // E:/images/

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
            foodService.updateFood(map);
            state = 1;
        } else {
            foodService.addFood(map);
            state = 0;
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

    /**
     * 图片显示
     * @param fileName
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("file:" + filePath + fileName);
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
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
        System.out.println("上传了 "+file.getOriginalFilename());
        String s = FileUtil.uploadFile("E:/images/", file);
        return s;
    }




}
