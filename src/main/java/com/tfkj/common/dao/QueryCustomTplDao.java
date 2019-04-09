/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.dao;

import com.tfkj.common.domain.QueryCustomTpl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 单表生成DAO接口
 * @author gaowei
 * @version 2018-07-13
 */
@Mapper
public interface QueryCustomTplDao  {

    public List<QueryCustomTpl> getQueryCustomTpls(Map param);

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public QueryCustomTpl get(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public QueryCustomTpl get(QueryCustomTpl entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<QueryCustomTpl>());
     *
     * @param entity
     * @return
     */
    public List<QueryCustomTpl> findList(QueryCustomTpl entity);

    /**
     * 查询所有数据列表
     *
     * @param entity
     * @return
     */
    public List<QueryCustomTpl> findAllList(QueryCustomTpl entity);

    /**
     * 查询所有数据列表
     *
     * @see public List<QueryCustomTpl> findAllList(QueryCustomTpl entity)
     * @return
     */
    @Deprecated
    public List<QueryCustomTpl> findAllList();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    public int insert(QueryCustomTpl entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(QueryCustomTpl entity);

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
    public int delete(QueryCustomTpl entity);

    public int deleteAll();

    /**
     * 批量操作
     *
     * @param
     * @return
     */
    public int updateByIds(Map<String, Object> params);
}