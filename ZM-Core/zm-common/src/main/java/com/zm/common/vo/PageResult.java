package com.zm.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 10:19
 * ==================================
 **/
@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 2129600208818927470L;

    private Integer code;

    private Long count;

    private T data;

    public static <T> PageResult build(Long count, T data) {
        PageResult pageResultVO = new PageResult();
        pageResultVO.setData(data);
        pageResultVO.setCount(count);
        pageResultVO.setCode(200);
        return pageResultVO;
    }
}
