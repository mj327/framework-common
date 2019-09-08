package com.mj.common.utils;


import com.mj.common.exception.ExceptionThrow;
import com.mj.common.model.base.response.BaseResponse;
import com.mj.common.model.base.response.CommonResult;
import com.mj.common.model.base.response.DataResponse;
import com.mj.common.model.base.response.PageResult;
import com.mj.common.model.order.OrderResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: MaJun
 * @Description:
 * @Date: 2019/9/3
 */
public class ResponseDemo {


    /**
     * 返回基本信息类型
     */
    public BaseResponse demo1() {

        if (Math.random() > Math.random()) {
            return BaseResponse.success();
        }

        return BaseResponse.fail();
    }


    /**
     * 查看详情类型
     */
    public DataResponse demo2() {

        Integer i = 1;

        if (Math.random() > i) {
            ExceptionThrow.throwException(CommonResult.INVALID_PARAMS_ERROR);
        }

        return new DataResponse<>(CommonResult.SUCCESS, i);
    }


    /**
     * 查看页面列表类型
     */
    public DataResponse demo3() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        if (list.size() == 0) {
            ExceptionThrow.throwException(OrderResult.ORDER_NOT_EXISTS_ERROR);
        }

        PageResult<Integer> pageResult = new PageResult<>();
        pageResult.setContent(list);
        pageResult.setTotalElements(3);
        pageResult.setTotalPages(1);
        return new DataResponse<>(CommonResult.SUCCESS, pageResult);
    }
}
