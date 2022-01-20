package com.camelot.biz.example;

import com.camelot.core.example.vo.ExampleVo;

import java.util.List;

/**
 * <p>Description: []</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
public interface ExampleBizService {

    Integer count();

    List<ExampleVo> list();
}
