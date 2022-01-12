package com.zyh.sentineltest.Util;


import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * <h3>SentinelDemo</h3>
 *
 * @author : zyh
 **/
public class SentinelBlockHandler {


    /**
     * @return
     */
    public static ResultUtil handlerException(BlockException exception) {
        return ResultUtil.error("限流了");
    }


    /**
     *
     * @param exception
     * @return
     */
    public static ResultUtil handlerPayCashException(int money,BlockException exception) {
        return ResultUtil.error("限流了");
    }


}
