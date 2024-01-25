package com.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.orm.entity.Shoping;
import com.study.orm.service.AutoIntervalService;
import com.study.orm.service.IShopingService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义分片算法 test
 */
public class ClassBasedTest extends BaseTests {

    @Autowired
    private IShopingService shopingService;

    @Autowired
    private AutoIntervalService autoIntervalService;


    /**
     * 标准分片算法 test
     */
    @Test
    public void standardPreciseTest() {
        // 精准分片
        Shoping shoping = shopingService.getById(123L);
        // 范围分片
        List<Shoping> list = shopingService.list(new LambdaQueryWrapper<Shoping>()
            .ge(Shoping::getShopingId, 124L)
            .le(Shoping::getShopingId, 1251L));
    }


}
