package com.dinner.controller.reserveController;

import com.dinner.service.reserve.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:reserveController
 * describe:
 * author:邢芳彬
 * createTime:2018-12-17 10:01
 */
@Controller
public class reserveController {

    @Autowired
    private ReserveService reserveService;

    /**
     * 前台预定方法
     * @return
     */
    @ResponseBody
    @RequestMapping("/reserve")
    public int reserve(@RequestParam Map map) {
        return reserveService.addReserve(map);
    }
}
