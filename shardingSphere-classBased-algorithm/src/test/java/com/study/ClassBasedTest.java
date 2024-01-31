package com.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.orm.entity.BoundaryRange;
import com.study.orm.entity.Shoping;
import com.study.orm.entity.VolumeRange;
import com.study.orm.service.BoundaryRangeService;
import com.study.orm.service.IShopingService;
import com.study.orm.service.VolumeRangeService;
import java.util.List;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义分片算法 test
 */
public class ClassBasedTest extends BaseTests {

    @Autowired
    private IShopingService shopingService;

    @Autowired
    private VolumeRangeService volumeRangeService;

    @Autowired
    private BoundaryRangeService boundaryRangeService;

    /**
     * 标准分片算法 test
     */
    @Test
    public void standardTest() {
        // 精准分片
        Shoping shoping = shopingService.getById(123L);
        // 范围分片
        List<Shoping> list = shopingService.list(new LambdaQueryWrapper<Shoping>()
            .ge(Shoping::getShopingId, 124L)
            .le(Shoping::getShopingId, 1251L));
    }

    /**
     * 复合分片 test
     */
    @Test
    public void complexTest() {
        // 精准查询
        VolumeRange volumeRange = new VolumeRange();
        volumeRange.setUserId(123L);
        volumeRange.setOrderPrice(22);
        volumeRangeService.save(volumeRange);
        LambdaQueryWrapper<VolumeRange> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(VolumeRange::getOrderId, 123L, 12444L);
        queryWrapper.in(VolumeRange::getUserId, 123L, 12444L, 512L);
        volumeRangeService.list(queryWrapper);

        // 范围查询
        LambdaQueryWrapper<VolumeRange> queryRangeWrapper = new LambdaQueryWrapper<>();
        queryRangeWrapper.ge(VolumeRange::getOrderId, 124L);
        queryRangeWrapper.le(VolumeRange::getUserId, 1251L);
    }


    @Test
    public void hintTest() {
        try (HintManager instance = HintManager.getInstance()) {
            instance.addDatabaseShardingValue("ds","1");
            instance.addTableShardingValue("boundary_range","1");
            instance.setDatabaseShardingValue("1");
            boundaryRangeService.list(new LambdaQueryWrapper<BoundaryRange>()
                .eq(BoundaryRange::getOrderId, 123123L));
        }
    }

}
