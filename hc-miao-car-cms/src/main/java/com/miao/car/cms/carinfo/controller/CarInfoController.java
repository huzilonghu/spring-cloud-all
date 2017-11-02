package com.miao.car.cms.carinfo.controller;

import com.miao.car.cms.carinfo.service.CarInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xsing on 2017/8/17.
 */
@RestController
public class CarInfoController {
    @Autowired
    CarInfoService carInfoService;

    @RequestMapping("/carInfo")
    public  String  getCar(){
        return  carInfoService.getCarInfo();
    }
}
