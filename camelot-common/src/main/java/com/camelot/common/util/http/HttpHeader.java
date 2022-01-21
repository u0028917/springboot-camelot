package com.camelot.common.util.http;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: [请求头]</p>
 * Created on 2022/1/21
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
public class HttpHeader {

    private Map<String, String> params = new HashMap<String, String>();

    public HttpHeader addParam(String name, String value) {
        this.params.put(name, value);
        return this;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

}
