/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.service;
import com.tfkj.common.dao.QueryCustomConditionDao;
import com.tfkj.common.dao.QueryTableDao;
import com.tfkj.common.dao.TableDBDao;
import com.tfkj.common.domain.QueryCustomCondition;
import com.tfkj.common.domain.QueryTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2018-07-12
 */
@Service
@Transactional(readOnly = true)
public class QueryCustomConditionService  {
	@Autowired
	private QueryCustomConditionDao dao;
	@Resource
	private TableDBDao tableDao;
    @Autowired
	private QueryTableDao queryTableDao;

	/**
	 * 获取库表
	 * @return
	 */
	public  List<Map> getTableList(){
		List<Map> listMap=tableDao.listTable();
		List<Map> newMap= new ArrayList<Map>();
		List<QueryTable> queryTableList=queryTableDao.findList();
		for (QueryTable queryTable:queryTableList) {
			for (Map map:listMap) {
				if(!queryTable.getTableName().equals(map.get("TABLE_NAME"))){
					newMap.add(map);
				}
			}
			listMap=newMap;
			newMap=new ArrayList<Map>();
		}
		return listMap;
	}

	/**
	 * 获取表列字段
	 * @param tableName
	 * @return
	 */
	public List<Map> getTableColumn(String tableName){
		return tableDao.listTableColumn(tableName);
	}

	public QueryCustomCondition get(String id) {
		return dao.get(id);
	}
	
	public List<QueryCustomCondition> findList(QueryCustomCondition queryCustomCondition) {
		return dao.findList(queryCustomCondition);
	}
	

	@Transactional(readOnly = false)
	public void save(QueryCustomCondition queryCustomCondition) {
		dao.insert(queryCustomCondition);
	}
	
	@Transactional(readOnly = false)
	public void delete(QueryCustomCondition queryCustomCondition) {
		dao.delete(queryCustomCondition);
	}

	@Transactional(readOnly = false)
	public void deleteAll() {
		dao.deleteAll();
	}
	
}