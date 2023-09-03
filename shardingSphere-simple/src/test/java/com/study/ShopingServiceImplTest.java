package com.study;

import com.study.orm.entity.Shoping;
import com.study.orm.service.IOrderInfoService;
import com.study.orm.service.IShopingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shoping商品表的测试类
 * @author Leo 
 */
@Slf4j
public class ShopingServiceImplTest extends ShardingSphereSimpleApplicationTests {

    @Autowired
    private IShopingService shopingService;

    @Autowired
    private IOrderInfoService orderInfoService;

    // 测试数据插入的方法
    @Test
    public void insertSelective() {
        Shoping shoping = new Shoping();
        shoping.setShopingId(15L);
        shoping.setShopingName("黄金零号竹子");
        shoping.setShopingPrice(8888);
        shopingService.save(shoping);

    }
}