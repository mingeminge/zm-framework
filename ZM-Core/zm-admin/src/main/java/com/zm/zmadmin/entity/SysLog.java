package com.zm.zmadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ==================================
 *
 * @author yizuomin
 * @description: 日志
 * @date 2020/4/26 14:04
 * ==================================
 **/
@Data
@Entity
@Table(name = "zm_sys_log")
public class SysLog implements Serializable {

    private static final long serialVersionUID = -2288822145569266855L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;

    private String username;

    private String uri;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Column(name = "execution_time")
    private Long executionTime;

    @Column(name = "error_flag")
    private Boolean errorFlag;

    @Column(name = "info", columnDefinition = "text comment '详情'")
    private String info;
}
