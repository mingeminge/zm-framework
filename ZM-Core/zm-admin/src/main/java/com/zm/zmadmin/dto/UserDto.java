package com.zm.zmadmin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:51
 * ==================================
 **/
@Data
public class UserDto implements Serializable {


    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Integer sex;

    private String avatar;

    private String realName;

    private String signature;

    private Long deptId;

    private Integer status;

    private List<Long> roleIds;

}
