package com.study;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class SimpleTest {

    private static final int DB_CNT = 10;

    private static final int TBL_CNT = 100;

    @Test
    public void shard1() {
        String userId = "100";
        int userIdInt = 201;
        int hash = userId.hashCode();
        // 对库数量取余结果为库序号
        int dbIdx = Math.abs(userIdInt % DB_CNT);
        // 对表数量取余结果为表序号
        int tblIdx = Math.abs(userIdInt % TBL_CNT);
        log.info("dbIdx:{},tabIdx:{}", dbIdx, tblIdx);
    }

    @Test
    public void shard2() {
        // ① 算Hash
        int userId = 1986;
        int hash = userId;
        // ② 总分片数
        int sumSlot = DB_CNT * TBL_CNT;
        // ③ 分片序号
        int slot = Math.abs(hash % sumSlot);
        // ④ 计算库序号和表序号的错误案例
        int dbIdx = slot % DB_CNT ;
        int tblIdx = slot / DB_CNT ;
        log.info("dbIdx:{},tabIdx:{}", dbIdx, tblIdx);

    }


    @Test
    public void shard3() {
        // ① 算Hash
        int userId = 1986;
        int hash = userId;
        // ② 总分片数
        int sumSlot = DB_CNT * TBL_CNT;
        // ③ 分片序号
        int slot = Math.abs(hash % sumSlot);
        // ④ 重新修改二次求值方案
        int dbIdx = slot / TBL_CNT;
        int tblIdx = slot % TBL_CNT;
        log.info("dbIdx:{},tabIdx:{}", dbIdx, tblIdx);
    }


    @Test
    public void tetete() {
        // String fileInfo = "order/export/xxx.xml";
        String fileInfo = "123123123.xaaa";
        String fileName = fileInfo;
        String fileDir = "";
        int i = fileInfo.lastIndexOf("/");
        if (-1 != i) {
            fileDir = fileInfo.substring(0, i);
            fileName = fileInfo.substring(i + 1);
        }
        log.info("fileName:{}, fileDir:{}", fileName, fileDir);
    }



}
