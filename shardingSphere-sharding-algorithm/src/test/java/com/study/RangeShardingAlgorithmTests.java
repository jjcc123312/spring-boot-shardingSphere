package com.study;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.study.orm.entity.AutoInterval;
import com.study.orm.entity.BoundaryRange;
import com.study.orm.entity.VolumeRange;
import com.study.orm.service.AutoIntervalService;
import com.study.orm.service.BoundaryRangeService;
import com.study.orm.service.VolumeRangeService;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 范围分片算法 tests
 *
 * @author Leo
 * @version 1.0 2023/9/17
 */
@Slf4j
public class RangeShardingAlgorithmTests extends BaseTests {

    @Autowired
    private VolumeRangeService volumeRangeService;

    @Autowired
    private BoundaryRangeService boundaryRangeService;

    @Autowired
    private AutoIntervalService autoIntervalService;


    /**
     * 基于分片容量的范围分片
     */
    @Test
    public void volumeRangeAlgorithm() {
        // 这一数据将插入volume_range0表中
        VolumeRange volumeRange0 = new VolumeRange();
        volumeRange0.setOrderPrice(-777);
        volumeRange0.setUserId(1L);
        volumeRangeService.save(volumeRange0);

        // 这一数据将插入volume_range1表中
        VolumeRange volumeRange1 = new VolumeRange();
        volumeRange1.setOrderPrice(0);
        volumeRange1.setUserId(1L);
        volumeRangeService.save(volumeRange1);

        // 这一数据将插入volume_range2表中
        VolumeRange volumeRange2 = new VolumeRange();
        volumeRange2.setOrderPrice(40);
        volumeRange2.setUserId(1L);
        volumeRangeService.save(volumeRange2);

        // 这一数据将插入volume_range3表中
        VolumeRange volumeRange3 = new VolumeRange();
        volumeRange3.setOrderPrice(80);
        volumeRange3.setUserId(1L);
        volumeRangeService.save(volumeRange3);
        for (int i = 0; i < 81; i++) {
            VolumeRange volumeRange = new VolumeRange();
            volumeRange.setOrderPrice(i);
            volumeRange.setUserId(1L);
            volumeRangeService.save(volumeRange);
        }
    }

    /**
     * 基于分片边界的范围分片
     */
    @Test
    public void boundaryRangeAlgorithm() {
        BoundaryRange boundaryRange0 = new BoundaryRange();
        boundaryRange0.setOrderPrice(-1);
        boundaryRange0.setUserId(1L);
        boundaryRangeService.save(boundaryRange0);

        BoundaryRange boundaryRange1 = new BoundaryRange();
        boundaryRange1.setOrderPrice(0);
        boundaryRange1.setUserId(1L);
        boundaryRangeService.save(boundaryRange1);

        BoundaryRange boundaryRange2 = new BoundaryRange();
        boundaryRange2.setOrderPrice(10);
        boundaryRange2.setUserId(1L);
        boundaryRangeService.save(boundaryRange2);

        BoundaryRange boundaryRange3 = new BoundaryRange();
        boundaryRange3.setOrderPrice(20);
        boundaryRange3.setUserId(1L);
        boundaryRangeService.save(boundaryRange3);

    }

    /**
     * 基于可变时间范围的分片算法
     */
    @Test
    public void autoInterval() {

        /*
        * datetime-lower: '2024-01-03 00:00:00'
        * datetime-upper: '2024-01-03 03:00:00'
        * sharding-seconds: 3600
        * */
        // 通过3600 * 0.005计算出溢出值：18
        // 即分片0的时间范围是：(∞..2024-01-03 00:00:18)
        AutoInterval autoInterval0 = new AutoInterval();
        autoInterval0.setOrderPrice(-1);
        autoInterval0.setUserId(1L);
        LocalDateTime createGmt0 = LocalDateTimeUtil.parse("2024-01-03 00:00:17", "yyyy-MM-dd HH:mm:ss");
        autoInterval0.setCreateGmt(createGmt0);
        autoIntervalService.save(autoInterval0);

        // 2024-01-03 00:00:18 + 3600得到右开时间，即分片1的时间范围是：[2024-01-03 00:00:18..2024-01-03 01:00:18]
        AutoInterval autoInterval1 = new AutoInterval();
        autoInterval1.setOrderPrice(-1);
        autoInterval1.setUserId(1L);
        LocalDateTime createGmt1 = LocalDateTimeUtil.parse("2024-01-03 01:00:17", "yyyy-MM-dd HH:mm:ss");
        autoInterval1.setCreateGmt(createGmt1);
        autoIntervalService.save(autoInterval1);

        // 2024-01-03 00:00:18 + 3600 * 2得到右开时间，即分片2的时间范围是：(2024-01-03 01:00:18..2024-01-03 02:00:18]
        AutoInterval autoInterval2 = new AutoInterval();
        autoInterval2.setOrderPrice(-1);
        autoInterval2.setUserId(1L);
        LocalDateTime createGmt2 = LocalDateTimeUtil.parse("2024-01-03 02:00:19", "yyyy-MM-dd HH:mm:ss");
        autoInterval2.setCreateGmt(createGmt2);
        autoIntervalService.save(autoInterval2);

        // 2024-01-03 00:00:18 + 3600 * 3得到右开时间，即分片3的时间范围是：(2024-01-03 02:00:18..2024-01-03 03:00:18]
        AutoInterval autoInterval3 = new AutoInterval();
        autoInterval3.setOrderPrice(-1);
        autoInterval3.setUserId(1L);
        LocalDateTime createGmt3 = LocalDateTimeUtil.parse("2024-01-03 03:00:18", "yyyy-MM-dd HH:mm:ss");
        autoInterval3.setCreateGmt(createGmt3);
        autoIntervalService.save(autoInterval3);

        // 2024-01-03 00:00:18 + 3600 * 3得到右开时间，即分片4的时间范围是：(2024-01-03 03:00:18..∞]
        AutoInterval autoInterval4 = new AutoInterval();
        autoInterval4.setOrderPrice(-1);
        autoInterval4.setUserId(1L);
        LocalDateTime createGmt4 = LocalDateTimeUtil.parse("2024-01-03 03:00:19", "yyyy-MM-dd HH:mm:ss");
        autoInterval4.setCreateGmt(createGmt4);
        autoIntervalService.save(autoInterval4);

    }

    public static void main(String[] args){
        double ceil = Math.ceil(1.001);
        System.out.println(ceil);
    }

}
