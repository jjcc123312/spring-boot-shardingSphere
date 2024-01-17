package com.study.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
@TableName("shoping")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shoping implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Long shopingId;

    /**
     * 商品名称
     */
    private String shopingName;

    /**
     * 商品价格
     */
    private Integer shopingPrice;

}
