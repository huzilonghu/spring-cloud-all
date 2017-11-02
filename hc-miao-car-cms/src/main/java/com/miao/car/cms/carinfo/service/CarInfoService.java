package com.miao.car.cms.carinfo.service;

import org.springframework.stereotype.Service;

/**
 * Created by xsing on 2017/8/17.
 */
@Service
public class CarInfoService {

    public  String  getCarInfo(){
        return "{carName:\"宝马\",carColor:\"red\"}";
    }
}
