package com.mj.common.model.base.response;


public enum CommonResult implements BaseResult {

    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 11111, "操作失败！"),
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 10002, "权限不足，无权操作！"),
    INVALID_PARAMS_ERROR(false, 10003, "非法参数！"),
    NULL_POINTER_EXCEPTION(false, 90001, "抱歉，系统繁忙，请稍后重试！"),
    INDEX_OUT_OF_BOUNDS_EXCEPTION(false, 90002, "抱歉，系统繁忙，请稍后重试！"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");

    //操作是否成功
    boolean success;
    //提示代号
    int code;
    //提示信息
    String message;

    CommonResult(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
