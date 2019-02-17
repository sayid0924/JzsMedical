package com.jzs.netty.protocol;


import com.jzs.netty.base.BaseMsg;
import com.jzs.netty.base.MsgType;

public class LockScreenRequest extends BaseMsg {

    public LockScreenRequest() {
        super();
        setType(MsgType.LOCK_SCREEN);
    }
}