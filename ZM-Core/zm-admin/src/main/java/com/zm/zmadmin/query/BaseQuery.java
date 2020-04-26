package com.zm.zmadmin.query;

import lombok.Data;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:34
 * ==================================
 **/
@Data
public class BaseQuery {

    private Integer page = 0;

    private Integer limit = 10;

}
