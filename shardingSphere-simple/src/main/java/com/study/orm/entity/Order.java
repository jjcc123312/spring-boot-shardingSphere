package com.study.orm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId
    private Long orderId;

    /**
     * 订单总金额
     */
    private Integer orderPrice;

    /**
     * 用戶id
     */
    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId = " + orderId +
            ", orderPrice = " + orderPrice +
            ", userId = " + userId +
        "}";
    }
}
