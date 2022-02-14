package com.camelot.core.example.impl;

import com.camelot.common.util.BeanMapperUtils;
import com.camelot.core.example.ExampleService;
import com.camelot.core.example.vo.ExampleVo;
import com.camelot.atom.example.ExampleAtomService;
import com.camelot.atom.example.dto.ExampleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: []</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleAtomService exampleAtomService;

    @Override
    public Integer count() {
        return exampleAtomService.count();
    }

    @Override
    public List<ExampleVo> list() {
        List<ExampleDto> exampleDtoList = exampleAtomService.list();
        return BeanMapperUtils.mapList(exampleDtoList, ExampleVo.class);
    }


}
