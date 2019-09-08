package com.mj.common.exception;


import com.mj.common.model.base.response.BaseResult;

public class CustomException extends RuntimeException {

    private BaseResult baseResult;

    public CustomException(BaseResult baseResult) {
        super(baseResult.getMessage());
        this.baseResult = baseResult;
    }

    public BaseResult getBaseResult() {
        return baseResult;
    }
}
