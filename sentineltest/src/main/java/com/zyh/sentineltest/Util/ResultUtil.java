package com.zyh.sentineltest.Util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;

public class ResultUtil extends JSONObject {

    public ResultUtil() {
        put("code", "00000");
        put("msg", "success");
    }


    public static ResultUtil ok() {
        ResultUtil resultUtil = new ResultUtil();
        return resultUtil;
    }

    public static ResultUtil ok(JSONObject object) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.putAll(object);
        return resultUtil;
    }

    public static ResultUtil ok(String msg) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("msg", msg);
        return resultUtil;
    }

    public static ResultUtil error() {
        return error("未知错误");
    }

    public static ResultUtil error(String msg) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        resultUtil.put("msg", msg);
        return resultUtil;
    }

    public static ResultUtil error(String code, String msg) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", code);
        resultUtil.put("msg", msg);
        return resultUtil;
    }


}
