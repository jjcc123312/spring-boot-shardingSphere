package com.study.orm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.study.orm.entity.Order;
import com.study.orm.entity.OrderInfo;
import com.study.orm.mapper.OrderMapper;
import com.study.orm.service.IOrderService;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public int insertSelective(Order record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> selectJOinOrderInfo(Long orderId) {
        MPJLambdaWrapper<Order> eq = new MPJLambdaWrapper<Order>()
            .selectAll(Order.class).selectAll(OrderInfo.class)
            .leftJoin(OrderInfo.class, OrderInfo::getOrderId, Order::getOrderId)
            .eq(Order::getOrderId, orderId);

        return baseMapper.selectJoinMaps(eq);
    }
}
