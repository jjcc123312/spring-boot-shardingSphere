package com.study.orm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用戶id
     */
    @TableId
    private Long userId;

    /**
     * 用戶姓名
     */
    private String userName;

    /**
     * 用戶性別
     */
    private String userSex;

    /**
     * 用戶年齡
     */
    private Integer userAge;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "userId = " + userId +
            ", userName = " + userName +
            ", userSex = " + userSex +
            ", userAge = " + userAge +
        "}";
    }
}
