package com.miao.car.cms.approve.apptestservice;

import com.miao.car.cms.approve.ApproveEvent;
import com.miao.car.cms.approve.ApproveListenerAdapter;

/**
 * Created by xsing on 2017/8/22.
 * 测试处理业务 事件监听业务 2
 */
public class TestAdapter extends ApproveListenerAdapter {
    @Override
    public void passHandled(ApproveEvent event) {
              OtherService otherService= (OtherService)event.getSource();
              System.out.println("审批文字通过"+otherService.getOrderId()+"====="+otherService.getUserId());
    }

    @Override
    public void noPassHandled(ApproveEvent event) {
        System.out.println("审批文字未通过");
    }
}
