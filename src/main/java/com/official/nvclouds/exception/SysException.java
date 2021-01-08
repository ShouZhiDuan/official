package com.official.nvclouds.exception;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/8 17:16
 * @Description:
 */
public class SysException extends RuntimeException {
    public SysException(String message) {
        super(message);
    }
    public String getMsg(){
        return this.getMessage();
    }
}
