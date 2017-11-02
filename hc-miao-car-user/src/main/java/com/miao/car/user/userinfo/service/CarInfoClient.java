package com.miao.car.user.userinfo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xsing on 2017/8/17.
 */
@FeignClient("cms")
public interface CarInfoClient {

    @RequestMapping("/carInfo")
    String  getCar();
}
