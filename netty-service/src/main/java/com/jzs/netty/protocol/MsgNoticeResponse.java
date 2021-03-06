package com.jzs.netty.protocol;


import com.jzs.netty.base.BaseMsg;
import com.jzs.netty.base.MsgType;

public class MsgNoticeResponse extends BaseMsg {
    private Integer status;

    public MsgNoticeResponse() {
        super();
        setType(MsgType.MSG_NOTICE);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}