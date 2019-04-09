/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.dao;


import com.tfkj.common.domain.QueryCustomCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 单表生成DAO接口
 * @author ThinkGem
 * @version 2018-07-12
 */
@Mapper
public interface QueryCustomConditionDao  {
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public QueryCustomCondition get(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public QueryCustomCondition get(QueryCustomCondition entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<QueryCustomCondition>());
     *
     * @param entity
     * @return
     */
    public List<QueryCustomCondition> findList(QueryCustomCondition entity);

    /**
     * 查询所有数据列表
     *
     * @param entity
     * @return
     */
    public List<QueryCustomCondition> findAllList(QueryCustomCondition entity);

    /**
     * 查询所有数据列表
     *
     * @see public List<QueryCustomCondition> findAllList(QueryCustomCondition entity)
     * @return
     */
    @Deprecated
    public List<QueryCustomCondition> findAllList();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    public int insert(QueryCustomCondition entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(QueryCustomCondition entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param id
     * @see public int delete(QueryCustomCondition entity)
     * @return
     */
    public int delete(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param entity
     * @return
     */
    public int delete(QueryCustomCondition entity);

    /**
     * 清空条件表
     * @return
     */
    public int deleteAll();

    /**
     * 批量操作
     *
     * @param
     * @return
     */
    public int updateByIds(Map<String, Object> params);
}