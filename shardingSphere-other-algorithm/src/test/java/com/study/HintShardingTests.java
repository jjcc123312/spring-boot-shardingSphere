package com.study;

import com.study.orm.entity.VolumeRange;
import com.study.orm.service.VolumeRangeService;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * hint强制路由
 */
public class HintShardingTests extends BaseTests {


    @Autowired
    private VolumeRangeService volumeRangeService;

    @Test
    public void simpleTest() {
        try (HintManager instance = HintManager.getInstance()) {
            instance.addTableShardingValue("volume_range", 2);
            instance.addDatabaseShardingValue("ds", 1);
            VolumeRange volumeRange0 = new VolumeRange();
            volumeRange0.setOrderPrice(-777);
            volumeRange0.setUserId(1L);
            volumeRangeService.save(volumeRange0);
        }
    }
}
