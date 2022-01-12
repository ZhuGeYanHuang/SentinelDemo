package com.zyh.sentineltest.Util;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zyh
 */
@Slf4j
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        log.info("=====限流异常================" + e.getRule());
        ResultUtil r = null;

        if (e instanceof FlowException) {
            r = ResultUtil.error("7000", "接口限流了");

        } else if (e instanceof DegradeException) {
            r = ResultUtil.error("7001", "服务降级了");

        } else if (e instanceof ParamFlowException) {
            r = ResultUtil.error("7002", "热点参数限流了");

        } else if (e instanceof SystemBlockException) {
            r = ResultUtil.error("7003", "触发系统保护规则了");

        } else if (e instanceof AuthorityException) {
            r = ResultUtil.error("7004", "授权规则不通过");
        }

        //返回json数据
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), r);

    }
}
