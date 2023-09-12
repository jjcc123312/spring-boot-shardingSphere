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
 * @since 2023-08-29
 */
@TableName("order_info")
@Data
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单详情号
     */
    @TableId(type = IdType.AUTO)
    private Long orderInfoId;

    /**
     * 订单号
     */
    private Long orderId;

    /**
     * 商品名称
     */
    private String shopingName;

    /**
     * 商品价格
     */
    private Integer shopingPrice;

}
