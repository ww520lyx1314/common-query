/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.service;
import com.tfkj.common.dao.QueryCustomDetialDao;
import com.tfkj.common.domain.QueryCustomDetial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 单表生成Service
 * @author gaowei
 * @version 2018-07-12
 */
@Service
@Transactional(readOnly = true)
public class QueryCustomDetialService  {
	@Autowired
	private QueryCustomDetialDao dao;

	public QueryCustomDetial get(String id) {
		return dao.get(id);
	}
	
	public List<QueryCustomDetial> findList(QueryCustomDetial queryCustomDetial) {
		return dao.findList(queryCustomDetial);
	}
	

	@Transactional(readOnly = false)
	public void save(QueryCustomDetial queryCustomDetial) {
		dao.insert(queryCustomDetial);
	}
	
	@Transactional(readOnly = false)
	public void delete(QueryCustomDetial queryCustomDetial) {
		dao.delete(queryCustomDetial);
	}

	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void deleteByTmpId(String delflag, String tplId) {
		dao.deleteByTmpId(delflag,tplId);
    }
}