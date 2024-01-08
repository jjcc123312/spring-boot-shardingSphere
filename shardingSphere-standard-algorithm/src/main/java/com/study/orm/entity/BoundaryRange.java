package com.study.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-09-20
 */
@TableName("boundary_range")
@Data
public class BoundaryRange implements Serializable {

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

}
