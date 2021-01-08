package com.official.nvclouds.enums;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/8 17:27
 * @Description:
 */
public enum  SysEnum {

    PARAMS_ERRO(403,"参数错误"),
    CODE_ERRO(1000,"验证码发送异常");

    private int code;
    private String msg;

    SysEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
