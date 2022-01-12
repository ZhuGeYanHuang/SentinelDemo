package com.zyh.sentineltest.controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
public class TestController {

    private final static String RESOURCE_NAME = "Test";

    @RequestMapping("/helloTest")
    public String firstSentinel() {
        Entry entry = null;
        try {
            //开启保护  传入唯一表示字符串
            entry = SphU.entry(RESOURCE_NAME);
            //被保护的逻辑
            log.info("开始业务");
            return "业务完成";
        } catch (BlockException e1) {
            //出发降级限流规则，被阻止访问了
            log.info("服务管控");
            return "被管控了";
        } catch (Exception e2) {
            log.info("兜底报错---");
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(e2, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }

    /**
     * 初始化规则
     */
    @PostConstruct
    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置受保护的资源
        rule.setResource(RESOURCE_NAME);
        //默认QPs限制
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //每秒访问1
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
