package com.zyh.sentineltest.api;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "super-market-order", path = "order")
public interface OrderApi {

    @RequestMapping(value = "getList/byMemberId/{memberId}")
    JSONObject getList(@PathVariable("memberId") String memberId);
}
