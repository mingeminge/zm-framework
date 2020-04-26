package com.zm.zmadmin.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * ==========================
 *
 * @author : yizuomin
 * @date : Created in 22:52 2020/4/26
 * ===========================
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecordQuery extends BaseQuery{

    private Long userId;

    private Date startTime;

    private Date endTime;

    private Integer type;
}
