package com.zyh.sentineltest.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.zyh.sentineltest.Util.ResultUtil;
import com.zyh.sentineltest.Util.SentinelBlockHandler;
import com.zyh.sentineltest.Util.SentinelFallback;
import com.zyh.sentineltest.api.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class MemberController {

    private static final String RESOURCE_MONEY = "MEMBER_GET_MONEY";
    private static final String RESOURCE_LIST = "MEMBER_GET_LIST";
    private static final String RESOURCE_NAME1 = "MEMBER_GET_LIST1";

    @Resource
    private PayService payService;


    @SentinelResource(value = RESOURCE_MONEY,
            fallbackClass = SentinelFallback.class,
            fallback = "fallbackPayCashTest",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handlerPayCashException"
    )
    @RequestMapping("/payCash/{money}")
    public ResultUtil payCash(@PathVariable("money") int money) {
        JSONObject result = payService.payByCash(money);
        return ResultUtil.ok(result);
    }

    @SentinelResource(value = RESOURCE_LIST,
            fallbackClass = SentinelFallback.class,
            fallback = "fallbackTest",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handlerException"
    )
    @RequestMapping("/order/List")
    public ResultUtil payCash() {
        JSONObject result = new JSONObject();
        result.put("as5", 1);
        result.put("as4", 2);
        result.put("as3", 3);
        result.put("as2", 4);
        result.put("as1", 5);
        return ResultUtil.ok(result);
    }


    @RequestMapping("/order/List1")
    @SentinelResource(value = RESOURCE_NAME1,
            fallbackClass = SentinelFallback.class,
            fallback = "fallbackTest",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "handlerException"
    )
    public ResultUtil getList() {
        JSONObject result = new JSONObject();
        try {
            Thread.sleep(101);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResultUtil.ok(result);
    }




}
