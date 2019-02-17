package com.jzs.netty.protocol;


import com.jzs.netty.base.BaseMsg;
import com.jzs.netty.base.MsgType;

public class CancelVideoRequest extends BaseMsg {
    public CancelVideoRequest() {
        super();
        setType(MsgType.CANCEL_VIDEO);
    }
}