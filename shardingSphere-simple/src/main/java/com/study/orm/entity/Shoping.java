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
@TableName("shoping")
public class Shoping implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId
    private Long shopingId;

    /**
     * 商品名称
     */
    private String shopingName;

    /**
     * 商品价格
     */
    private Integer shopingPrice;

    public Long getShopingId() {
        return shopingId;
    }

    public void setShopingId(Long shopingId) {
        this.shopingId = shopingId;
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
        return "Shoping{" +
            "shopingId = " + shopingId +
            ", shopingName = " + shopingName +
            ", shopingPrice = " + shopingPrice +
        "}";
    }
}
