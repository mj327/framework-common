package com.mj.common.exception;


import com.google.common.collect.ImmutableMap;
import com.mj.common.model.base.response.BaseResponse;
import com.mj.common.model.base.response.BaseResult;
import com.mj.common.model.base.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionCatch {

    private static ImmutableMap<Class<? extends Throwable>, BaseResult> EXCEPTION_MAP;
    private static ImmutableMap.Builder<Class<? extends Throwable>, BaseResult> exceptionMapBuilder = ImmutableMap.builder();

    static {
        exceptionMapBuilder.put(NullPointerException.class, CommonResult.NULL_POINTER_EXCEPTION);
        exceptionMapBuilder.put(IndexOutOfBoundsException.class, CommonResult.INDEX_OUT_OF_BOUNDS_EXCEPTION);
        exceptionMapBuilder.put(HttpMessageNotReadableException.class, CommonResult.INVALID_PARAMS_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public BaseResponse handleCustomException(CustomException customException) {
        log.error("A {} has been thrown:{}", customException.getClass().getName(), customException);
        BaseResult baseResult = customException.getBaseResult();
        return new BaseResponse(baseResult);
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception exception) {
        log.error("A {} has been thrown:{}", exception.getClass().getName(), exception);
        if (EXCEPTION_MAP == null) {
            EXCEPTION_MAP = exceptionMapBuilder.build();
        }
        BaseResult baseResult = EXCEPTION_MAP.get(exception.getClass());
        if (baseResult != null) {
            return new BaseResponse(baseResult);
        } else {
            return new BaseResponse(CommonResult.SERVER_ERROR);
        }
    }
}
