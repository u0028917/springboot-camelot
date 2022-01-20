package com.camelot.common;

import com.camelot.pojo.UserInfoVO;

/**
 * <p>Description: [用户工具类]</p>
 * Created on 2022/1/4
 *
 * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
 * @version 1.0
 */
public class UserContextHolder {

    private UserContextHolder() {
    }

    private static ThreadLocal<UserInfoVO> userContext = new ThreadLocal<>();

    public static void setUser(UserInfoVO user) {
        userContext.set(user);
    }

    public static UserInfoVO getUser() {
        if (userContext != null) {
            return userContext.get();
        } else {
            return null;
        }
    }

}
