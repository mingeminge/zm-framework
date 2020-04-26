package com.zm.zmadmin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 消费记录
 * @date 2020/4/26 14:17
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_record")
public class Record implements Serializable {

    private static final long serialVersionUID = 1578713072443700260L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer type;

    private Date time;

    private BigDecimal expend;

    private BigDecimal income;

    private String remark;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "user_id")
    private Long userId;
}
