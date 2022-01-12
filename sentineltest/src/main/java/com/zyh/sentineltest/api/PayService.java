package com.zyh.sentineltest.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>支付接口</p>
 *
 * @author : zyh
 **/
@FeignClient(value = "super-market-pay",path = "pay")
public interface PayService {

    @RequestMapping(value = "payByCash/{money}")
    JSONObject payByCash(@PathVariable("money") int money);

}
