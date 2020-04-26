package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 相册
 * @date 2020/4/26 14:12
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_album")
public class Album implements Serializable {

    private static final long serialVersionUID = -4955902760511697414L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "photo_num")
    private Integer photoNum;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "default_img")
    private String defaultImg;

    @Column(name = "user_id")
    private Long userId;
}
