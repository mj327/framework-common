package com.mj.common.model.base.response;


import lombok.Data;

@Data
public class BaseResponse {

    //操作是否成功
    boolean success;

    //提示代号
    int code;

    //提示信息
    String message;

    public BaseResponse(BaseResult baseResult) {
        this.success = baseResult.isSuccess();
        this.code = baseResult.getCode();
        this.message = baseResult.getMessage();
    }

    public static BaseResponse success() {
        return new BaseResponse(CommonResult.SUCCESS);
    }

    public static BaseResponse fail() {
        return new BaseResponse(CommonResult.FAIL);
    }
}
