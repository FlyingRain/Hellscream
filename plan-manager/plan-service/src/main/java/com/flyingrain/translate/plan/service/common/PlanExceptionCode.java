package com.flyingrain.translate.plan.service.common;

/**
 * Created by wally on 6/16/17.
 */
public enum PlanExceptionCode {

    PARAM_INVALID("P0001","参数不合法"),
    MAKE_PLAN_FALURE("P1001","制定计划失败"),
    MAKE_PLAN_DUPLICAT("P1002","重复制定计划"),
    MODIFY_PLAN_FALURE("P2001","修改计划失败"),
    SYCHRONIZE_PLAN_FAIL("P3001","同步任务失败"),
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
