package com.miao.car.cms.approve;

import java.util.Vector;

/**
 * Created by xsing on 2017/8/22.
 */
public class HandledService {

    protected Vector listeners;                       //监听者队列

    public HandledService(){
        listeners=new Vector();
    }

    public synchronized void addApproveListener(ApproveListener apl) { listeners.add(apl); }//添加监听者

    public synchronized void removeApproveListener(ApproveListener apl){listeners.remove(apl);}

    /**
     * 可以重载多个实现方法,或者使用spring自己的事件处理
     * @param mark
     * @return
     */

    public boolean notifyEvent(int mark) {            //事件通知函数重载版本1
        Vector  l=(Vector)listeners.clone();
        boolean rt=true;
        ApproveEvent ev=new ApproveEvent(this,mark);
        synchronized(this) {                           //多线程锁定
            for(int i=0; i<l.size(); i++) {            //查询监听者，并调用处理方法体
                if(ev.isPassStatus())  {
                    ((ApproveListener)l.elementAt(i)).passHandled(ev);
                }
                else if(ev.isNoPassStatus()) {
                    ((ApproveListener)l.elementAt(i)).noPassHandled(ev);
                }
                else {
                    rt=false;
                }
            }
        }
        return rt;
    }
}
