package com.camelot.common;

import com.camelot.pojo.UserInfoVO;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description: [米盾模拟类]</p>
 * Created on 2022/1/4
 *
 * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
 * @version 1.0
 */
public class AegisFacade {
    public static UserInfoVO getUserInfo(HttpServletRequest request) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUser("zhangsan");
        userInfoVO.setName("张三");
        userInfoVO.setDisplayName("san zhang 张三");
        userInfoVO.setDepartmentName("米盾部");
        userInfoVO.setEmail("zhangsan@xiaomi.com");
        userInfoVO.setMiID("Ims7%as9Ei%T6l12");
        userInfoVO.setAvatar("https://img1.baidu.com/it/u=818940727,1723281244&fm=26&fmt=auto");
        return userInfoVO;
    }
}
