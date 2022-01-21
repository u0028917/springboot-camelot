package com.camelot.core.http;

import com.camelot.common.util.http.HttpHeader;
import com.camelot.common.util.http.HttpParamers;

import java.util.Map;

/**
 * <p>Description: []</p>
 * Created on 2022/1/21
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
public interface HttpService {

    Map<String, Object> httpService(String serviceUrl, HttpParamers paramers) throws Exception;

    Map<String, Object> httpService(String serviceUrl, HttpParamers paramers, HttpHeader header) throws Exception;

}
