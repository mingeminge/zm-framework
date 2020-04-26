package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 照片
 * @date 2020/4/26 14:10
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_photo")
public class Photo implements Serializable {

    private static final long serialVersionUID = -7268606954280892865L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "album_id")
    private Long albumId;
}
