package com.study;

import com.study.orm.entity.VolumeRange;
import com.study.orm.service.VolumeRangeService;
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

}
