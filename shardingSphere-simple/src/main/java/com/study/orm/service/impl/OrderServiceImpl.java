package com.study.orm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.orm.entity.Order;
import com.study.orm.mapper.OrderMapper;
import com.study.orm.service.IOrderService;
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

}
