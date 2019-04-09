/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 查询库表，表列
 * @author rjwangwei
 * @version 2018-07-12
 */
@Mapper
public interface DetailDao {

    public List<Map> searchList(Map param);

    public int countSearchList(Map param);

}