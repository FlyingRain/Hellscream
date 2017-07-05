package com.flyingrain.translate.plan.service.common;

/**
 * Created by wally on 6/16/17.
 */
public enum PlanExceptionCode {

    PARAM_INVALID("P0001","参数不合法"),
    MAKE_PLAN_FAILURE("P1001","制定计划失败"),
    MAKE_PLAN_DUPLICATE("P1002","重复制定计划"),
    MODIFY_PLAN_FAILURE("P2001","修改计划失败"),
    SYNCHRONIZE_PLAN_FAIL("P3001","同步任务失败,任务不存在或已同步完成"),
    PLAN_NOT_EXIT("P1002","查询计划不存在")
    ;

    private String code;

    private String msg;

    PlanExceptionCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
