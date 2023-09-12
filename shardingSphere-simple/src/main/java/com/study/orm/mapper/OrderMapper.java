package com.study.orm.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.study.orm.entity.Order;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
public interface OrderMapper extends MPJBaseMapper<Order> {

    int insertSelective(Order record);
}
