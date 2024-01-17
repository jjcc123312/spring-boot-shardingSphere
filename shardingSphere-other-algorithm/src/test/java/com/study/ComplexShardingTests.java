package com.study;

import com.study.orm.entity.Shoping;
import com.study.orm.service.IShopingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 复合分片 test
 */
public class ComplexShardingTests extends BaseTests {

    @Autowired
    private IShopingService iShopingService;

    /**
     * 复合分片 test
     */
    @Test
    public void simpleTest() {
        Shoping shoping = new Shoping();
        shoping.setShopingId(122L);
        shoping.setShopingName("1");
        shoping.setShopingPrice(123);
        iShopingService.save(shoping);
    }

}
