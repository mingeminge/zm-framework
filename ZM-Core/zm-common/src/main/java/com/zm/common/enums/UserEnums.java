package com.zm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ==========================
 *
 * @author : yizuomin
 * @date : Created in 20:48 2020/4/26
 * ===========================
 */
@Getter
@AllArgsConstructor
public enum UserEnums {

    USER_NOT_FOUND(1001,"用户不存在"),

    USER_EXISTS(1002,"用户已存在"),

    PHONE_NUMBER_IS_REGISTERED(1003,"手机号已被注册"),

    PASSWORD_ERROR(1004,"密码错误")
    ;


    private Integer code;

    private String message;


}
