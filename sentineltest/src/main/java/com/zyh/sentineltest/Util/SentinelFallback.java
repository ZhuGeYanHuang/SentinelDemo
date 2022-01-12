package com.zyh.sentineltest.Util;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelFallback {

    /**
     * 方法必须是静态的 否则sentinel无法识别
     * @return
     */
    public static ResultUtil fallbackTest(BlockException e) {
        return ResultUtil.error("服务降级。。返回");
    }

    /**
     * 方法必须是静态的 否则sentinel无法识别
     * @return
     */
    public static ResultUtil fallbackPayCashTest(int money,BlockException e) {
        return ResultUtil.error("服务降级。。返回");
    }
}
