package com.camelot.config.interceptor;


import com.alibaba.fastjson.JSON;
import com.camelot.common.AegisFacade;
import com.camelot.common.constant.CommonConstant;
import com.camelot.common.constant.CommonMsg;
import com.camelot.common.UserContextHolder;
import com.camelot.common.constant.Result;
import com.camelot.common.util.NetworkUtil;
import com.camelot.pojo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 签名拦截器
 *
 * @author qinfeng
 */
@Slf4j
public class InterceptorInterceptor implements HandlerInterceptor {
    /**
     * 5分钟有效期
     */
    private final static long MAX_EXPIRE = 5 * 60;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        log.info("current request uri:{}", request.getRequestURI());
        log.info("current request IP:{}", NetworkUtil.getIpAddress(request));
        UserInfoVO userInfoVO = AegisFacade.getUserInfo(request);
        if (userInfoVO == null) {
            Result result = new Result(CommonConstant.SC_JEECG_NO_AUTHZ, CommonMsg.SC_JEECG_NO_AUTHZ);
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(JSON.toJSONString(result));
            out.flush();
            out.close();
            return false;
        }
        UserContextHolder.setUser(userInfoVO);
        log.info("userEmail: {} ", UserContextHolder.getUser() != null ? UserContextHolder.getUser().getEmail() : "---");
        return true;
    }

}
