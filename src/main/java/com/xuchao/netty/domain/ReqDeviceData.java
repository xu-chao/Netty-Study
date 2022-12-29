package com.xuchao.netty.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReqDeviceData implements Serializable {
    private String tag;
    private String deviceNo;
    private String data;
}
