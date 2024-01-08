package com.study.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-12-26
 */
@Data
@TableName("auto_interval")
public class AutoInterval implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId(type = IdType.AUTO)
    private Long orderId;

    /**
     * 订单总金额
     */
    private Integer orderPrice;

    /**
     * 用戶id
     */
    private Long userId;


    private LocalDateTime createGmt;

}
