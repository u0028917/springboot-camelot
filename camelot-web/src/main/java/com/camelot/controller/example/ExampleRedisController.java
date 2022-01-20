package com.camelot.controller.example;

import com.camelot.common.constant.Result;
import com.camelot.controller.base.BaseController;
import com.camelot.redis.core.RedisService;
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
@Api(tags = "这是一个redis例子")
@RestController
@RequestMapping("/reids/example")
public class ExampleRedisController extends BaseController {

    @Autowired
    private RedisService redisService;

    /**
     * 查询列表总数
     *
     * @return
     */
    @ApiOperation(value = "例子-查询列表总数", notes = "例子-查询列表总数")
    @GetMapping(value = "/get")
    public Result<?> getRedis() {
        redisService.set("aa", "aa", 10000L);
        return Result.OK(redisService.get("aa"));
    }


}
