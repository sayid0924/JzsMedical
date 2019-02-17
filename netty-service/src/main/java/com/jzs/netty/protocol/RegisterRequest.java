package com.jzs.netty.protocol;


import com.jzs.netty.base.BaseMsg;
import com.jzs.netty.base.MsgType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterRequest extends BaseMsg {

    public RegisterRequest() {
        super();
        setType(MsgType.REGISTER);
    }

}