package com.miao.car.cms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xsing on 2017/8/16.
 */
@RestController
@RefreshScope
public class HelloController {
    @Value("${weixin.wx.key}")
    String  appId;
    @RequestMapping("/appid")
    public  String  getMyAppId(){
        return  appId;
    }
}
