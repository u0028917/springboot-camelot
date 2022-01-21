package com.camelot.core.http;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.camelot.common.util.http.HttpClient;
import com.camelot.common.util.http.HttpHeader;
import com.camelot.common.util.http.HttpParamers;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>Description: []</p>
 * Created on 2022/1/21
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@Service
public class HttpServiceImpl implements HttpService {

    private int connectTimeout = 15000;
    private int readTimeout = 30000;

    public Map<String, Object> httpService(String serviceUrl, HttpParamers paramers) throws Exception{
        return httpService(serviceUrl, paramers, null);
    }

    public Map<String, Object> httpService(String serviceUrl, HttpParamers paramers, HttpHeader header) throws Exception{
        String response = service(serviceUrl, paramers, header);
        try {
            Map<String, Object> result = JSONObject.parseObject(response, new TypeReference<Map<String, Object>>() {});
            if ((result == null) || (result.isEmpty())) {
                throw new Exception("远程服务返回的数据无法解析");
            }
            Integer code = (Integer) result.get("code");
            if ((code == null) || (code.intValue() != 0)) {
                throw new Exception((String) result.get("message"));
            }
            return result;
        } catch (Exception e) {
            throw new Exception("返回结果异常,response:" + response, e);
        }
    }
    public String service(String serviceUrl, HttpParamers paramers) throws Exception {
        return service(serviceUrl, paramers, null);
    }
    public String service(String serviceUrl, HttpParamers paramers, HttpHeader header) throws Exception {
        String responseData = "";
        try {
            responseData = HttpClient.doService(serviceUrl, paramers, header, this.connectTimeout, this.readTimeout);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
        return responseData;
    }

}
