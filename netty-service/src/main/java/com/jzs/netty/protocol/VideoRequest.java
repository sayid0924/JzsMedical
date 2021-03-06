package com.jzs.netty.protocol;


import com.jzs.netty.base.BaseMsg;
import com.jzs.netty.base.MsgType;

public class VideoRequest extends BaseMsg {
    private Object video;

    public VideoRequest() {
        super();
        setType(MsgType.VIDEO);
    }

    public Object getVideo() {
        return video;
    }

    public void setVideo(Object video) {
        this.video = video;
    }
}