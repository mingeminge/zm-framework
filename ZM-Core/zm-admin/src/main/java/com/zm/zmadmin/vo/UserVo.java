package com.zm.zmadmin.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * ==========================
 *
 * @author : yizuomin
 * @date : Created in 20:54 2020/4/26
 * ===========================
 */
@Data
public class UserVo implements Serializable {

    private Long id;

    private String username;

    private String phone;

    private String email;

    private Integer sex;

    private String avatar;

    private String realName;

    private String signature;

    private Long deptId;

    private Integer status;

}
