package com.mj.common.model.base.response;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class DataResponse<T> extends BaseResponse {

    private T dataResult;

    public DataResponse(BaseResult baseResult, T dataResult) {
        super(baseResult);
        this.dataResult = dataResult;
    }
}
