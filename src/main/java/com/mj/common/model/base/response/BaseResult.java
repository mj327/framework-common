package com.mj.common.model.base.response;


public interface BaseResult {

    //操作是否成功,true为成功，false操作失败
    boolean isSuccess();

    //提示代号
    int getCode();

    //提示信息
    String getMessage();
}
