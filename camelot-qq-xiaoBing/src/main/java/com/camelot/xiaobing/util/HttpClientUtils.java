/**
 * Copyright (c) 2018 EA
 */
package com.camelot.xiaobing.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * http连接工具类
 * Created by didi on 2017/5/3.
 */
@Slf4j
public class HttpClientUtils {

    public static final String ERROEONE = "发起HTTP请求，请求URL：";
    public static final String ERROETWO = "; 发送请求异常：";
    public static final String CONTENTTYPE = "Content-type";

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url    发送请求的URL
     * @param param  请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param header 请求头
     * @return URL 所代表远程资源的响应结果
     */
    public static Map sendGet(String url, Map<String, Object> param, Map<String, String> header) {
        try {
            RestTemplate restTemplate = new RestTemplateBuilder().build();
            HttpHeaders requestHeaders = new HttpHeaders();
            header.forEach((key, value) -> {
                requestHeaders.add(key, value);
            });
            HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
            ResponseEntity<Map> rss = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Map.class, param);
            if (rss.getStatusCode().equals(HttpStatus.OK)) {
                return rss.getBody();
            } else {
                log.error(ERROEONE + url + ERROETWO);
                return null;
            }
        } catch (Exception ex) {
            log.error(ERROEONE + url + ERROETWO, ex);
            return null;
        }
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param map   请求头
     * @return 所代表远程资源的响应结果
     */
    public static Map sendPost(String url, String param, Map<String, String> map) {

        try {
            RestTemplate restTemplate = new RestTemplateBuilder().build();

            HttpHeaders headers = new HttpHeaders();
            if (map != null && !map.isEmpty()) {
                map.forEach(headers::add);
            } else {
                headers.add(CONTENTTYPE, "application/json; charset=utf-8");
            }

            HttpEntity<String> entity = new HttpEntity<>(param, headers);

            ResponseEntity<Map> ret = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

            if (ret.getStatusCode().equals(HttpStatus.OK)) {
                return ret.getBody();
            } else {
                log.error(ERROEONE + url + ERROETWO);
                return null;
            }
        } catch (Exception ex) {
            log.error(ERROEONE + url + ERROETWO, ex);
            return null;
        }
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数
     * @param body  请求体
     * @param head  请求头
     * @return 所代表远程资源的响应结果
     */
    public static Map sendPost(String url, Map<String, String> head, Map<String, Object> body, Map<String, String> param) {

        try {
            RestTemplate restTemplate = new RestTemplateBuilder().build();

            HttpHeaders headers = new HttpHeaders();
            if (head != null && !head.isEmpty()) {
                head.forEach(headers::add);
            } else {
                headers.add(CONTENTTYPE, "application/json; charset=utf-8");
            }
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
            MultiValueMap<String, String> mapParam = new LinkedMultiValueMap<>();
            param.forEach((key, value) -> {
                mapParam.add(key, value);
            });
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(mapParam);
            ResponseEntity<Map> ret = restTemplate.postForEntity(builder.toUriString(), entity, Map.class);
            if (ret.getStatusCode().equals(HttpStatus.OK)) {
                return ret.getBody();
            } else {
                log.error(ERROEONE + url + ERROETWO);
                return null;
            }
        } catch (Exception ex) {
            log.error(ERROEONE + url + ERROETWO, ex);
            return null;
        }
    }

}
