package com.study;

import com.study.orm.entity.Shoping;
import com.study.orm.service.IShopingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 标准分片 test
 */
public class StandardShardingTests extends BaseTests {

    @Autowired
    private IShopingService iShopingService;

    /**
     * 标准分片算法
     */
    @Test
    public void simpleTest() {
        Shoping shoping = new Shoping();
        shoping.setShopingId(1L);
        shoping.setShopingName("1123是");
        shoping.setShopingPrice(123);
        iShopingService.save(shoping);
    }

}
