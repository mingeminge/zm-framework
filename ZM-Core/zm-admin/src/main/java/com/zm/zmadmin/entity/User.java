package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 用户
 * @date 2020/4/26 13:32
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_user")
public class User implements Serializable {

    private static final long serialVersionUID = -1668938869866701475L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Integer sex;

    private String avatar;

    @Column(name = "real_name")
    private String realName;

    private String signature;

    private Long deptId;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private String updateUser;

    @OneToMany
    @JoinTable(name = "zm_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;
}
