package com.mj.common.exception;


import com.mj.common.model.base.response.BaseResult;

public class ExceptionThrow {

    public static void throwException(BaseResult baseResult) {
        throw new CustomException(baseResult);
    }
}
