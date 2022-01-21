package com.camelot.controller.example;

import com.camelot.biz.example.ExampleBizService;
import com.camelot.common.constant.Result;
import com.camelot.common.exception.AutomaticAccrualException;
import com.camelot.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [这是一个视图层]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@Api(tags = "这是一个例子")
@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController {

    @Autowired
    private ExampleBizService exampleBizService;

    /**
     * 查询列表总数
     *
     * @return
     */
    @ApiOperation(value = "例子-查询列表总数", notes = "例子-查询列表总数")
    @GetMapping(value = "/count")
    public Result<?> queryCount() {
        throw new AutomaticAccrualException("123123");
//        return Result.OK(exampleBizService.count());
    }


    /**
     * 查询列表总数
     *
     * @return
     */
    @ApiOperation(value = "例子-查询列表总数", notes = "例子-查询列表总数")
    @GetMapping(value = "/lust")
    public Result<?> queryPageList() {
        return Result.OK(exampleBizService.list());
    }
}
