/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.service;


import com.tfkj.common.dao.DetailDao;
import com.tfkj.common.dao.QueryCustomConditionDao;
import com.tfkj.common.dao.QueryTableDao;
import com.tfkj.common.dao.TableDBDao;
import com.tfkj.common.domain.QueryCustomCondition;
import com.tfkj.common.domain.QueryTable;
import com.tfkj.common.domain.SelectOption;
import com.tfkj.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 单表生成Service
 * @version 2018-07-13
 */
@Service
@Transactional(readOnly = true)
public class DetailService {

	@Autowired
	private DetailDao detailDao;

	public List<Map> findList(Map map){
		return detailDao.searchList(map);
	}

	public int countFindList(Map map){
		return detailDao.countSearchList(map);
	}
}