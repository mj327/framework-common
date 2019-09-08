package com.mj.common.model.order;


import com.mj.common.model.base.response.BaseResult;

public enum OrderResult implements BaseResult {

    ORDER_EXISTS_ERROR(false, 24001, "订单已存在！"),
    ORDER_NOT_EXISTS_ERROR(false, 24002, "订单不存在！"),
    DUPLICATE_ORDER_ERROR(false, 24003, "订单重复！");

    boolean success;
    int code;
    String message;

    OrderResult(boolean success, int code, String message) {
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
