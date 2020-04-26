package com.zm.zmadmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 菜单
 * @date 2020/4/26 13:44
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 2468653614690751692L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String path;

    private String component;

    private Integer type;

    private String permission;

    @Column(name = "component_name")
    private String componentName;

    private String icon;

    private Boolean cache;

    private Boolean hidden;

    private Long sort;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "i_frame")
    private Boolean iFrame;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private String updateUser;
}
