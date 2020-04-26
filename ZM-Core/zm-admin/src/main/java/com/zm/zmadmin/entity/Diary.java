package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 日记
 * @date 2020/4/26 14:13
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_diary")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String title;

    private String text;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
