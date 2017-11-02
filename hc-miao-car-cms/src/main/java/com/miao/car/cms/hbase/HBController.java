package com.miao.car.cms.hbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xsing on 2017/10/19.
 */
@RestController
public class HBController {

    @Autowired
    HBService hbService;

    @RequestMapping("/cms/hbase")
    public  String  hbaseTest(){
        System.out.println("开始==============");
        try {
            Map<String, Object> map = hbService.get("test", "row1");
            System.out.println(map.toString()+"==============");
        }catch (Throwable e){
           e.printStackTrace();
        }
      return "成功";
    }
}
