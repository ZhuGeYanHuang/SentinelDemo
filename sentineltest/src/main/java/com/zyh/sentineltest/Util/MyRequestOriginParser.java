package com.zyh.sentineltest.Util;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>授权</p>
 *
 * @author : zyh
 **/
@Component
public class MyRequestOriginParser implements RequestOriginParser {
    /**
     * 通过request获取来源标识，交给授权规则进行匹配
     *
     * @param request
     * @return
     */
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String code = request.getParameter("code");
        return code;
    }
}
