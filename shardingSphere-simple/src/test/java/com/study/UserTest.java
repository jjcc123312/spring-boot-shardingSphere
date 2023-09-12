/*
 * Copyright(c) 2022 长沙市希尚网络科技有限公司
 * 注意：本内容仅限于长沙市希尚网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

package com.study;

import com.study.orm.entity.UserInfo;
import com.study.orm.service.IUserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * user test
 *
 * @author Leo
 * @version 1.0 2023/9/11
 */
public class UserTest extends ShardingSphereSimpleApplicationTests {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 广播表功能测试
     */
    @Test
    public void broadcastTable() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAge(26);
        userInfo.setUserName("Jjcc");
        userInfo.setUserSex("man");

        userInfoService.save(userInfo);
    }
}
