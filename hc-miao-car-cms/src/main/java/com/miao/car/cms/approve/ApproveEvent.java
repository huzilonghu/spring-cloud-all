package com.miao.car.cms.approve;

import java.util.EventObject;

/**
 * Created by xsing on 2017/8/22.
 */
public class ApproveEvent extends EventObject {

    public int checkStatus=0;                            //事件节点 检查的状态(一般是状态修改前的状态)
    public int currentStuats=0;                          //事件处理状态类型 当前的值
    /**
     * Constructs a prototypical Event.
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApproveEvent(Object source) {
        super(source);
    }

    /**
     * 只需要业务参数  和 当前操作的状态
     * @param source
     * @param mark
     */
    public ApproveEvent(Object source, int mark) {
            super(source);
            if(checkStatusValue(mark)) {
                this.currentStuats = mark;
            }
            else {
                currentStuats = ApproveStatus.RESET;
            }
    }

    /**
     * 需要处理  验证上一个节点的状态
     * @param source
     * @param mark
     * @param checkStatus
     */
    public ApproveEvent(Object source, int mark, int checkStatus) {
        super(source);
        if(checkStatusValue(mark)) {
            this.currentStuats = mark;
        }
        else {
            currentStuats = ApproveStatus.RESET;
        }
        this.checkStatus=checkStatus;
    }

    /**
     * 参数判断
     * @return
     */

    public  boolean  isPassStatus(){
        if(this.currentStuats==ApproveStatus.PASS) return true;

        else return false;
    }

    public  boolean  isNoPassStatus(){
        if(this.currentStuats==ApproveStatus.NO_PASS) return true;

        else return false;
    }

    /**
     * 检查状态的值是否合法, 如果状态参数有添加, 需要扩展
     * @return
     */
    public boolean  checkStatusValue(int mark){
        if(mark==ApproveStatus.NO_PASS || mark==ApproveStatus.PASS ) {
            return  true;
        }
        else {
            return false;
        }
    }
}
