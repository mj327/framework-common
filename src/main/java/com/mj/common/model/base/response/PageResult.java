package com.mj.common.model.base.response;

import lombok.Data;

import java.util.Collection;


@Data
public class PageResult<T> {
    //数据列表
    private Collection<T> content;
    //数据总数
    private long totalElements;
    //总页数
    private int totalPages;
}
