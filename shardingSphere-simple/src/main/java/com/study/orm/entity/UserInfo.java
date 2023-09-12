package com.study.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.ZSLong
 * @since 2023-08-29
 */
@TableName("user_info")
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用戶id
     */
    @TableId(type = IdType.AUTO)
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

}
