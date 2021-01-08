package com.official.nvclouds.dto;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/9 12:00
 * @Description: 图形验证码
 */
@Data
public class VerifyCode {
    private String code;
    private byte[] imgBytes;
    private long expireTime;
}
