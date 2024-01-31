package com.study.config.classbased;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;

/**
 * 自定义hint分片算法
 */
public class CustomHintShardingAlgorithm implements HintShardingAlgorithm<Long> {


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
        HintShardingValue<Long> shardingValue) {
        // HintManager传递的sharding values
        Collection<Long> values = shardingValue.getValues();

        Set<String> tableNameSet = new HashSet<>();
        for (String availableTargetName : availableTargetNames) {
            for (Comparable<Long> value : values) {
                if (availableTargetName.endsWith(value.toString())) {
                    tableNameSet.add(availableTargetName);
                }
            }
        }
        Assert.isFalse(ObjectUtil.isEmpty(tableNameSet), "table name is empty");

        return tableNameSet;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties props) {
        System.out.println("custom hint algorithm init");
    }
}
