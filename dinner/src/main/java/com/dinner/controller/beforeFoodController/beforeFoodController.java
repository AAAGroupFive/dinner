package com.dinner.controller.beforeFoodController;

import com.dinner.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:beforeFoodController
 * describe:
 * author:邢芳彬
 * createTime:2018-12-11 16:06
 */
@Controller
@RequestMapping("/before")
public class beforeFoodController {

    @Autowired
    private OrderService orderService;

    private ResourceLoader resourceLoader;

    @Value("${upload.path}")
    private String filePath; // D:/images/

    @Autowired
    public beforeFoodController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 跳转前台特色美食页面
     * @return
     */
    @RequestMapping("/food")
    public String food(Model model) {
        model.addAttribute("data",orderService.goodList());
        return "before/food";
    }


    /**
     * 图片显示方法
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

}
