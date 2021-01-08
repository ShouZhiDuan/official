package com.official.nvclouds.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/8 17:59
 * @Description: 数据操作基类
 */
public interface TkMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, InsertListMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {
}
