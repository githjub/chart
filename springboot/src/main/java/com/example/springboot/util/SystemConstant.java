package com.example.springboot.util;

import java.util.UUID;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/30 15:42
 */
public class SystemConstant {
    public static final String JWT_ERRCODE_EXPIRE = "JWT错误1";
    public static final String JWT_ERRCODE_FAIL = "JWT错误2,3";
    public static final long JWT_TTL = 1123200000;//设置token过期时间:ms//设为一天过期
    public static final String JWT_SECERT = "123156464135L";//密钥,只有服务端才知道,用于解密JWT
}
