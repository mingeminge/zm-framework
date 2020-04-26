package com.zm.common.vo;

import com.zm.common.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 09:51
 * ==================================
 **/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1670001209362707402L;
    
    private Integer code;
    
    private String message;
    
    private T data;

    public static <T>Result ok(T data) {
        Result result = new Result();
        result.setCode(ResultEnum.OK.getCode());
        result.setMessage(ResultEnum.OK.getMessage());
        result.setData(data);
        return result;
    }

    public static Result ok() {
        Result Result = new Result();
        Result.setCode(ResultEnum.OK.getCode());
        Result.setMessage(ResultEnum.OK.getMessage());
        return Result;
    }
    public static Result error() {
        Result result = new Result();
        result.setCode(ResultEnum.SYSTEM_ERROR.getCode());
        result.setMessage(ResultEnum.SYSTEM_ERROR.getMessage());
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.setCode(ResultEnum.SYSTEM_ERROR.getCode());
        result.setMessage(message);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }
}
