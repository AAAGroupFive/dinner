package com.dinner.controller.wxController;

import com.dinner.entity.MessageText;
import com.dinner.util.CheckCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @className:WXController
 * @discription:
 * @author:zz
 * @crateTime:2019-01-13 15:41
 */
@RestController
public class WXController {

    /**
     * 验证Token
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("/checkToken")
    public String checkWXToken(String signature,String timestamp,String nonce,String echostr){
        if(CheckCodeUtil.checkSignature(signature, timestamp, nonce)){
            return echostr;
        }
        return null;
    }


    /**
     * 自动回复
     * @param ms
     * @return
     */
    @PostMapping(value="/checkToken",produces = {"application/xml; charset=UTF-8"})//返回XML
    public MessageText getMsg(@RequestBody MessageText ms){
        System.out.println(ms.getContent());

        MessageText text = new MessageText(ms.getFromUserName(), ms.getToUserName(), new Date().getTime()+"", "text", "<a href='https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432'>开发手册</a>", null);
        return text;
    }
}
