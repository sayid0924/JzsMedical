package com.jzs.netty.protocol;


import com.jzs.netty.base.BaseMsg;
import com.jzs.netty.base.MsgType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class CancelVoiceRequest extends BaseMsg {

    private String nurseCeardIp;
    private  String bedInfo;
    public CancelVoiceRequest() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }
}