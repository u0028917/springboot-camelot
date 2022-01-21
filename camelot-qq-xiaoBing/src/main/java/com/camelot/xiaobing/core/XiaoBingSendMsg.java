package com.camelot.xiaobing.core;

import com.alibaba.fastjson.JSONObject;
import com.camelot.xiaobing.props.XiaoBingProperties;
import com.camelot.xiaobing.util.HttpClientUtils;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.*;
import java.util.stream.Collectors;

public class XiaoBingSendMsg {


    private XiaoBingProperties xiaoBingProperties;

    public XiaoBingSendMsg() {
    }


    public XiaoBingSendMsg(XiaoBingProperties xiaoBingProperties) {
        this.xiaoBingProperties = xiaoBingProperties;
    }

    @Async
    @EventListener(XiaoBingEvent.class)
    public void sendError(XiaoBingEvent event) throws Exception {
        RuntimeException runtimeException = (RuntimeException) event.getSource();
        String accessToken = Objects.requireNonNull(getAccessToken(xiaoBingProperties));
        String chartId = xiaoBingProperties.getChartId() != null ? xiaoBingProperties.getChartId() : Objects.requireNonNull(getChartId(xiaoBingProperties, accessToken));
        sendMsg(xiaoBingProperties.getMessageUrl(), accessToken, chartId, runtimeException);
    }

    private void sendMsg(String messageUrl, String accessToken, String chartId, RuntimeException runtimeException) throws Exception {
        Map<String, String> head = getHead();
        head.put("Authorization", "Bearer " + accessToken);
        Map<String, Object> postBody = new HashMap<>();
        postBody.put("receive_id", chartId);
        postBody.put("msg_type", "interactive");
        String content = getMsg(runtimeException);
        String msg = "{\"config\":{\"wide_screen_mode\":true},\"elements\":[{\"tag\":\"markdown\",\"content\":\"%s\\n\"}]}";
        postBody.put("content", String.format(msg, content));
        Map map = HttpClientUtils.sendPost(messageUrl, head, postBody, Collections.singletonMap("receive_id_type", "chat_id"));
        System.out.println(map);
    }

    private String getMsg(RuntimeException runtimeException) {
        StringBuilder builder = new StringBuilder();
        builder.append(runtimeException.getClass().getName()).append("： ").append(runtimeException.getMessage()).append("\\n");
        for (int i = 0, length = runtimeException.getStackTrace().length; i < length; i++) {
            if (i < 6) {
                builder.append("at ").append(runtimeException.getStackTrace()[i].getClassName()).append(".")
                        .append(runtimeException.getStackTrace()[i].getMethodName()).append("： ")
                        .append(runtimeException.getStackTrace()[i].getLineNumber()).append("\\n");
            } else {
                break;
            }
        }
        return builder.toString();
    }

    private String getChartId(XiaoBingProperties properties, String accessToken) throws Exception {
        Map<String, String> head = new HashMap<>();
        head.put("Authorization", "Bearer " + accessToken);
        Map<String, Object> param = new HashMap<>();
        param.put("page_size", 10);
        param.put("user_id_type", "open_id");
        Map<String, Object> chartsBody = HttpClientUtils.sendGet(properties.getChartUrl(), param, head);
        if ("0".equals(String.valueOf(chartsBody.get("code")))) {
            Map<String, Object> dataMap = (Map<String, Object>) chartsBody.get("data");
            List<Map<String, Object>> list = (List<Map<String, Object>>) dataMap.get("items");
            //todo 分页循环
            Map<String, Object> map = list.stream().filter(ma -> properties.getGroupName().equals(String.valueOf(ma.get("name")))).collect(Collectors.toList()).get(0);
            return map.get("chat_id").toString();
        }
        return null;
    }

    private String getAccessToken(XiaoBingProperties properties) throws Exception {
        Map<String, String> head = getHead();
        Map<String, Object> param = new HashMap<>();
        param.put("app_id", properties.getAppId());
        param.put("app_secret", properties.getAppSecret());
        JSONObject jsonParam = new JSONObject(param);
        Map<String, Object> tokenBody = HttpClientUtils.sendPost(properties.getTenantUrl(), jsonParam.toJSONString(), head);
        if ("0".equals(String.valueOf(tokenBody.get("code")))) {
            return String.valueOf(tokenBody.get("tenant_access_token"));
        }
        return null;
    }

    private Map<String, String> getHead() {
        Map<String, String> head = new HashMap<>();
        head.put("Content-Type", "application/json; charset=utf-8");
        return head;
    }


}
