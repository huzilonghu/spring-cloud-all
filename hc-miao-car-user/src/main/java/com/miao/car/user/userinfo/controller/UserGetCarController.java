package com.miao.car.user.userinfo.controller;

import com.miao.car.user.userinfo.service.CarInfoClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xsing on 2017/8/17.
 */
@RestController
public class UserGetCarController {

    @Autowired
    CarInfoClient  carInfoClient;

    @RequestMapping("/userCarInfo")
    String  userGetCarInfo(){
        return  carInfoClient.getCar();
    }
}
