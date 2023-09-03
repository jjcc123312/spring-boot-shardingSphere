package com.study.orm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.orm.entity.OrderInfo;
import com.study.orm.mapper.OrderInfoMapper;
import com.study.orm.service.IOrderInfoService;
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
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

}
