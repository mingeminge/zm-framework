package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 登录背景动画设置
 * @date 2020/4/26 14:22
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_login_settings")
public class LoginSettings implements Serializable {

    private static final long serialVersionUID = -6413159817715531052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private Integer type;

    private Long time;

    @Column(name = "is_on")
    private Boolean on;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private Date createUser;
}
