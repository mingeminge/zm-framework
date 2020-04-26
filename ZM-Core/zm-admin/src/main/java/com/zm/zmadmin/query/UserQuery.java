package com.zm.zmadmin.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:35
 * ==================================
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends BaseQuery {

    private String phone;

}
