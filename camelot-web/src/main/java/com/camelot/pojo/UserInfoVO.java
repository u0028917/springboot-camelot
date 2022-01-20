package com.camelot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户类
 * @Author: sunshaobo
 * @Date: 2021-12-15
 * @Version: V1.0
 */
@Data
public class UserInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名，如：zhangsan
     */
    private String user;
    /**
     * 用户名，如：张三
     */
    private String name;
    /**
     * 用户展示名：如sa zhang 张三
     */
    private String displayName;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * miID
     */
    private String miID;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 计提开关配置权限
     */
    private Boolean accrualSwitch;

    public Boolean getAccrualSwitch() {
        return accrualSwitch != null ? accrualSwitch : false;
    }
}
