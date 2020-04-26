package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 留言
 * @date 2020/4/26 14:07
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 6173921300384860625L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "user_id")
    private Long userId;

}
