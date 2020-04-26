package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 头像
 * @date 2020/4/26 14:01
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_avatar")
public class Avatar implements Serializable {

    private static final long serialVersionUID = 9074517280919068496L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private String updateUser;
}
