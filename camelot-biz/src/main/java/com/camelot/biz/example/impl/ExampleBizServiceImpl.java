package com.camelot.biz.example.impl;

import com.camelot.biz.base.BaseBizServiceImpl;
import com.camelot.biz.example.ExampleBizService;
import com.camelot.core.example.vo.ExampleVo;
import com.camelot.core.example.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: [这是一个业务，是一个完整的功能]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@Service
@Slf4j
public class ExampleBizServiceImpl extends BaseBizServiceImpl implements ExampleBizService {

    @Autowired
    private ExampleService exampleService;

    @Override
    public Integer count() {
        Integer count = exampleService.count();
        log.info("[这是一个例子][查询条数]param:{},count:{}", "null", count);
        return count;
    }

    @Override
    public List<ExampleVo> list() {
        return exampleService.list();
    }
}
