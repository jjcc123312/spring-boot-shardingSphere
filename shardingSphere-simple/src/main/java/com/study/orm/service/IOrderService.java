package com.study.orm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.orm.entity.Order;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
public interface IOrderService extends IService<Order> {

    /**
     * insert
     * @param record entity
     * @return int
     */
    int insertSelective(Order record);

    /**
     * join select
     * @param orderId order id
     */
    List<Map<String, Object>> selectJOinOrderInfo(Long orderId);

}
