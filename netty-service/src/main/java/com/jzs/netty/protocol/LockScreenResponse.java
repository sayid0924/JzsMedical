package com.jzs.netty.protocol;


import com.jzs.netty.base.BaseMsg;
import com.jzs.netty.base.MsgType;

public class LockScreenResponse extends BaseMsg {
    private Integer status;

    public LockScreenResponse() {
        super();
        setType(MsgType.LOCK_SCREEN);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}