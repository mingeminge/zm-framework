package com.zm.common.query;

import lombok.Data;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 09:58
 * ==================================
 **/
@Data
public class BaseQuery {

    private Integer size = 10;

    private Integer current = 1;
}
