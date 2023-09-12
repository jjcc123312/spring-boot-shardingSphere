package com.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.orm.entity.Shoping;
import com.study.orm.service.IShopingService;
import java.util.List;
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

    /**
     * 测试数据插入的方法
     */
    @Test
    public void insertSelective() {
        Shoping shoping = new Shoping();
        shoping.setShopingId(15L);
        shoping.setShopingName("黄金零号竹子");
        shoping.setShopingPrice(8888);
        shopingService.save(shoping);
    }

    /**
     * 测试分库策略是否有效
     */
    @Test
    public void databaseStrategyInsert() {
        for (int i = 1; i <= 10; i++){
            Shoping shoping = new Shoping();
            shoping.setShopingId((long) i);
            shoping.setShopingName("黄金"+ i +"号竹子");
            shoping.setShopingPrice(1111 * i);
            shopingService.save(shoping);
        }
    }

    /**
     * 测试按商品名称的分表策略是否有效
     */
    @Test
    public void tableStrategyInsert() {
        for (int i = 1; i <= 20; i++){
            Shoping shoping =
                new Shoping((long) i, "白玉"+ i +"号竹子", i * 888);
            shopingService.save(shoping);
        }
    }


    /**
     * 分库分表查询 by 根据分库路由key查询
     */
    @Test
    public void findByShopingID() {
        Shoping shoping = shopingService.getById(1L);
        log.info("shoping:{}", shoping);
    }

    /**
     * 分库分表查询 by 既有分库路由key查询又有分表路由key查询
     */
    @Test
    public void find() {
        List<Shoping> list = shopingService.list(new LambdaQueryWrapper<Shoping>()
            .eq(Shoping::getShopingId, 1L)
            .eq(Shoping::getShopingName, "白玉1号竹子"));
        log.info("shoping：{}", list);
    }

    /**
     *  分库分表查询 by 分表路由key查询
     */
    @Test
    public void findByNotId() {
        List<Shoping> list = shopingService.list(new LambdaQueryWrapper<Shoping>()
            .eq(Shoping::getShopingName, "白玉1号竹子"));
        log.info("shoping：{}", list);
    }

    /**
     * 分库分表查询 by 没有使用分库键查询、分表键查询
     */
    @Test
    public void findByNot() {
        List<Shoping> list = shopingService.list(new LambdaQueryWrapper<Shoping>()
            .likeRight(Shoping::getShopingName, "白玉"));
        log.info("shoping：{}", list);
    }

    /**
     * 全局唯一id生成 by 雪花算法
     */
    @Test
    public void  distributedSnowflake() {
        for (int i = 21; i <= 30; i++) {
            Shoping shoping = new Shoping();
            shoping.setShopingName("黄金"+ i +"号竹子");
            shoping.setShopingPrice(8888);
            shopingService.save(shoping);
        }
    }
}



