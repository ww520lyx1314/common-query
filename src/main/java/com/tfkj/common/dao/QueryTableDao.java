/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.dao;


import com.tfkj.common.domain.QueryTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 单表生成DAO接口
 * @author gaowei
 * @version 2018-07-13
 */
@Mapper
public interface QueryTableDao {

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public QueryTable get(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public QueryTable get(QueryTable entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<QueryCustomTpl>());
     *
     *
     * @return
     */
    public List<QueryTable> findList();

    /**
     * 查询所有数据列表
     *
     * @param entity
     * @return
     */
    public List<QueryTable> findAllList(QueryTable entity);

    /**
     * 查询所有数据列表
     *
     * @see public List<QueryCustomTpl> findAllList(QueryCustomTpl entity)
     * @return
     */
    @Deprecated
    public List<QueryTable> findAllList();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    public int insert(QueryTable entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(QueryTable entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param id
     * @see public int delete(QueryCustomTpl entity)
     * @return
     */
    public int delete(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param entity
     * @return
     */
    public int delete(QueryTable entity);

    public int deleteAll();
}