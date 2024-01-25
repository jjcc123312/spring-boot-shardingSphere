package com.study.config.classbased;

import java.util.Collection;
import java.util.Properties;
import lombok.SneakyThrows;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;

/**
 * 自定义标准类型分片算法
 */
public class CustomStandardShardingAlgorithm implements
    org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm<Long> {

    /**
     * 精准分片；用于处理=和in
     *
     * @param availableTargetNames 目标分片的集合（数据源名称或表名）
     * @param shardingValue 分片键等相关信息
     * @return 节点name
     */
    @Override
    @SneakyThrows
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        Long value = shardingValue.getValue();
        long l = value % 2;
        for (String availableTargetName : availableTargetNames) {
            if (availableTargetName.endsWith(String.valueOf(l))) {
                return availableTargetName;
            }
        }
        throw new Exception("error");
    }

    /**
     * 范围分片；用于between and 分片，如果不配置RangeShardingAlgorithm，sql钟的between and将按照全库路由处理
     *
     * @param availableTargetNames 目标分片的集合（数据源名称或表名）
     * @param shardingValue 分片键等相关信息
     * @return 节点names
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        return availableTargetNames;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties props) {

    }
}
