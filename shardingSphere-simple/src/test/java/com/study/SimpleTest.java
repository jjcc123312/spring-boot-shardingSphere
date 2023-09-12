package com.study;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * simple test class
 *
 * @author Leo
 * @version 1.0 2023/9/12
 */
@Slf4j
public class SimpleTest {


    /**
     * 通过雪花算法生成的数值获取对应设置的datacenterId、workerId、时间戳 (原理解析) <br/>
     * 本示例雪花算法源码使用的是hutool，与特推开源的代码有所差别;差别如下：
     * <pre>
     *     hutool时间纪元是从2010-11-04 09:42:54开始
     *     10BIT工作进程位具体为5BIT的数据中心id（0 ~ 31的10进制数字），5BIT的进程id（0 ~ 31的10进制数字）
     * </pre>
     */
    @Test
    public void snowflakeTest() {
        Snowflake snowflake = IdUtil.getSnowflake(31,5);
        // long l = snowflake.nextId();
        long l = 1701596422900281344L;
        log.info("snowflake id:{}", l);
        long workerId = snowflake.getWorkerId(l);
        long dataCenterId = snowflake.getDataCenterId(l);
        long snowflakeGenerateDateTime = snowflake.getGenerateDateTime(l);
        /*
        * snowflakeId二进制：1011110011101010010001110111001100010000010111111000000000000
        * 这里snowflakeId转换成二进制后没有64BIT只有61BIT,缺少的三个BIT分别是表示正数的0,以及时间戳的2位 00
        *   这里时间戳是从2010-11-04 09:42:54开始计时，至2023年9月12日相差的时间39BIT即可承载
        * 完整的snowflakeId二进制应该是 000 1011110011101010010001110111001100010 000010111111 000000000000
        * */

        /*
         * 获取workerId
         * id = 1701596422900281344（10进制）
         *
         * 1011110011101010010001110111001100010000010111111 = id >> 12 (:10进制id转换成二进制后右移12位；即减去12位序列化位)
         * & (:前后两个进制从最右开始比对，有1得1，有0得0)
         * 11111 = ~(-1L << 5L) (:二进制-1左移5位得到-100000，~符号转换成正数得到11111)
         * ≈
         * 11111 & 11111 = 11111 = 31（10进制的workerId）
         * */
        long l1 = l >> 12 & ~(-1L << 5L);

        /*
         * 获取生成时间戳；默认的起始时间: 1288834974657L = 2010-11-04 09:42:54
         * id = 1701596422900281344（10进制）
         *
         *   101111001110101001000111011100110001000 = id >> 22 (:10进制id转换成二进制后右移2位；即减去12位序列化位、5位数据中心、5位工作进程)
         * &
         * 11111111111111111111111111111111111111111 = ~(-1L << 41L) (:二进制-1左移41位得到-100000000000000000000000000000000000000000，~符号转换成正数得到11111111111111111111111111111111111111111)
         * ≈
         * 101111001110101001000111011100110001000 & 11111111111111111111111111111111111111111 = 101111001110101001000111011100110001000 = 405692201352 （10进制的时间戳）
         *
         * 405692201352 + 1288834974657 = 1694527176009 = 2023-09-12 21:59:36.009 (id生成时间)
         * */
        long time = l >> 22 & ~(-1L << 41L) + 1288834974657L;

        log.info("snowflake workerId:{}", workerId);
        log.info("snowflake dataCenterId:{}", dataCenterId);
        log.info("snowflake snowflakeGenerateDateTime:{}", snowflakeGenerateDateTime);
    }

}
