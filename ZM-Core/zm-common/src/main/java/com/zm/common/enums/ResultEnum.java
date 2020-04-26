package com.zm.common.enums;

import lombok.Getter;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 09:52
 * ==================================
 **/
@Getter
public enum ResultEnum {
    OK(200, "操作成功"),
    SYSTEM_ERROR(500, "出错啦，请联系管理员!");

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
