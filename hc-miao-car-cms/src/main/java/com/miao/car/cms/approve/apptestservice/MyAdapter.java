package com.miao.car.cms.approve.apptestservice;

import com.miao.car.cms.approve.ApproveEvent;
import com.miao.car.cms.approve.ApproveListenerAdapter;

/**
 * Created by xsing on 2017/8/22.
 * 测试处理业务 事件监听业务 1
 */
public class MyAdapter  extends ApproveListenerAdapter {
    @Override
    public void passHandled(ApproveEvent event) {
        System.out.println("审核通过,发送信息==");
    }

    @Override
    public void noPassHandled(ApproveEvent event) {
        System.out.println("审核失败,发送信息==");
    }
}
