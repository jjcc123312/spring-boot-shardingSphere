/*
 * Copyright(c) 2022 长沙市希尚网络科技有限公司
 * 注意：本内容仅限于长沙市希尚网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

package com.study;

import com.alibaba.fastjson.JSON;
import com.study.orm.entity.Order;
import com.study.orm.entity.OrderInfo;
import com.study.orm.service.IOrderInfoService;
import com.study.orm.service.IOrderService;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * order test
 *
 * @author Leo
 * @version 1.0 2023/9/10
 */
@Slf4j
public class OrderTest extends ShardingSphereSimpleApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderInfoService orderInfoService;


    /**
     * order insert
     */
    @Test
    public void orderInsert() {
        // 插入一条订单数据
        Order order = new Order();
        order.setUserId(111111L);
        order.setOrderPrice(100000);
        orderService.save(order);

        // 对同一笔订单插入三条订单详情数据
        for (int i = 1; i <= 3; i++) {
            OrderInfo orderInfo = new OrderInfo();
            // 前面插入订单的方法执行完成后会返回orderID
            orderInfo.setOrderId(order.getOrderId());
            orderInfo.setShopingName("黄金1号竹子");
            orderInfo.setShopingPrice(8888);

            orderInfoService.save(orderInfo);
        }
    }


    /**
     * 绑定表功能测试
     */
    @Test
    public void bindingTable() {
        List<Map<String, Object>> maps = orderService.selectJOinOrderInfo(907765695033376768L);
        log.info("binding table select result:{}", JSON.toJSONString(maps));
    }


}
