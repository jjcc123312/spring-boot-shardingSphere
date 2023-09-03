package com.study.orm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单详情号
     */
    @TableId
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

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getShopingName() {
        return shopingName;
    }

    public void setShopingName(String shopingName) {
        this.shopingName = shopingName;
    }

    public Integer getShopingPrice() {
        return shopingPrice;
    }

    public void setShopingPrice(Integer shopingPrice) {
        this.shopingPrice = shopingPrice;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
            "orderInfoId = " + orderInfoId +
            ", orderId = " + orderId +
            ", shopingName = " + shopingName +
            ", shopingPrice = " + shopingPrice +
        "}";
    }
}
