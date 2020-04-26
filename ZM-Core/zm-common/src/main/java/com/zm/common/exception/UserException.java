package com.zm.common.exception;

import com.zm.common.enums.UserEnums;
import lombok.Data;

/**
 * ==========================
 *
 * @author : yizuomin
 * @date : Created in 20:47 2020/4/26
 * ===========================
 */
@Data
public class UserException extends RuntimeException {

    private String message;

    private Integer code;

    public UserException(UserEnums enums){
        this.message=enums.getMessage();
        this.code=enums.getCode();
    }
}
