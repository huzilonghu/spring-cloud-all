package com.miao.car.cms.approve;

import org.springframework.core.annotation.Order;

import java.util.EventListener;

/**
 * Created by xsing on 2017/8/22.
 */
public interface ApproveListener extends EventListener {


    public void passHandled(ApproveEvent event);

    public void noPassHandled(ApproveEvent event);

}
