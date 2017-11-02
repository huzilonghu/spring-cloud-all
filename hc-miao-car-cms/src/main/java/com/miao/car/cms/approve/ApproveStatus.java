package com.miao.car.cms.approve;

/**
 * Created by xsing on 2017/8/22.
 *
 * 审核的基本状态
 *  -1 不通过   和  1 通过
 *
 */
public interface ApproveStatus {

    public static final int  PASS=1 ;        //审核通过

    public static final  int  NO_PASS=-1  ;   // 不通过

    public static final  int  RESET=0  ;      // 原始状态
}
