package com.study.config.classbased;

import com.google.common.collect.Range;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import lombok.SneakyThrows;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;

/**
 * 自定义复合分片
 */
public class CustomComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
        ComplexKeysShardingValue<Long> shardingValue) {
        Collection<Long> orderIdCollection = shardingValue.getColumnNameAndShardingValuesMap().get("order_id");
        Collection<Long> userIdCollection = shardingValue.getColumnNameAndShardingValuesMap().get("user_id");
        Map<String, Range<Long>> columnNameAndRangeValuesMap = shardingValue.getColumnNameAndRangeValuesMap();
        String logicTableName = shardingValue.getLogicTableName();
        Set<String> shardingNameCollection = new HashSet<>();
        // 通过定义的分片键，以笛卡尔积算法算出所有的目标sharding
        for (Long orderId : orderIdCollection) {
            for (Long userId : userIdCollection) {
                long value = orderId + userId;
                long slot = value % 4;
                String targetName = compute(availableTargetNames, slot);
                shardingNameCollection.add(targetName);
            }
        }
        return shardingNameCollection;
    }

    /**
     * 计算出分片位置
     *
     * @param availableTargetNames 所有的分片目标（库或表）
     * @param slot（分片槽）
     * @return 分片目标
     */
    @SneakyThrows
    public String compute(Collection<String> availableTargetNames, long slot) {
        for (String targetName : availableTargetNames) {
            if (targetName.endsWith("_" + slot)) {
                return targetName;
            }
        }
        throw new Exception("");
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties props) {

    }
}
