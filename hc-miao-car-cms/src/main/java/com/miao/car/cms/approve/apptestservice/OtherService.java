package com.miao.car.cms.approve.apptestservice;

import com.miao.car.cms.approve.HandledService;

/**
 * Created by xsing on 2017/8/22.
 * 主体业务测试
 */
public class OtherService  extends HandledService {

    String  userId;

    String  orderId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OtherService(String userId, String orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public void doOtherService(){
        System.out.println("自己的任务开始");

        notifyEvent(1);  //事件通知

        System.out.println("自己的任务结束");
    }

    /**
     * 测试方法
     * @param args
     */
    public  static  void  main(String args[]){

        OtherService  otherService= new OtherService("232323","23232'");
        TestAdapter ser= new TestAdapter();
        otherService.addApproveListener(ser);
        otherService.doOtherService();
    }
}
