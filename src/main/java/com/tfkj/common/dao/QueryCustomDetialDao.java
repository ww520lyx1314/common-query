/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.dao;


import com.tfkj.common.domain.QueryCustomDetial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 单表生成DAO接口
 * @author gaowei
 * @version 2018-07-12
 */
@Mapper
public interface QueryCustomDetialDao  {
    public void deleteByTmpId(@Param(value = "delflag") String delflag, @Param(value = "tmpId") String tmpId);
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public QueryCustomDetial get(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public QueryCustomDetial get(QueryCustomDetial entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<QueryCustomDetial>());
     *
     * @param entity
     * @return
     */
    public List<QueryCustomDetial> findList(QueryCustomDetial entity);

    /**
     * 查询所有数据列表
     *
     * @param entity
     * @return
     */
    public List<QueryCustomDetial> findAllList(QueryCustomDetial entity);

    /**
     * 查询所有数据列表
     *
     * @see public List<QueryCustomDetial> findAllList(QueryCustomDetial entity)
     * @return
     */
    @Deprecated
    public List<QueryCustomDetial> findAllList();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    public int insert(QueryCustomDetial entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(QueryCustomDetial entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param id
     * @see public int delete(QueryCustomDetial entity)
     * @return
     */
    public int delete(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param entity
     * @return
     */
    public int delete(QueryCustomDetial entity);

    public int deleteAll();

    /**
     * 批量操作
     *
     * @param
     * @return
     */
    public int updateByIds(Map<String, Object> params);
}