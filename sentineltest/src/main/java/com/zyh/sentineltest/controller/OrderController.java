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
public class OrderController {

    private static final String ORDER_LIST = "ORDER_GET_LIST";


    @RequestMapping("/order/AllList")
    public ResultUtil getList() {
        JSONObject result = new JSONObject();
        result.put("as5", 1);
        result.put("as4", 2);
        result.put("as3", 3);
        result.put("as2", 4);
        result.put("as1", 5);
        return ResultUtil.ok(result);
    }



}
