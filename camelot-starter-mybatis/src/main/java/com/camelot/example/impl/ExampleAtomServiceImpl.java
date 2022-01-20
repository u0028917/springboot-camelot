package com.camelot.example.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.camelot.example.ExampleAtomService;
import com.camelot.example.dto.ExampleDto;
import com.camelot.example.mapper.ExampleMapper;
import org.springframework.stereotype.Service;

/**
 * <p>Description: []</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@Service
public class ExampleAtomServiceImpl extends ServiceImpl<ExampleMapper, ExampleDto> implements ExampleAtomService {
}
