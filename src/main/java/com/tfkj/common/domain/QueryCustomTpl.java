/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.domain;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * 单表生成Entity
 * @author gaowei
 * @version 2018-07-13
 */
public class QueryCustomTpl extends DataEntity<QueryCustomTpl> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String value;		// 条件
	private String sqltxt;		// sql语句
	private String tables;     //表关系
	private UserDO user;		// 用户id
	private String sortId;		// sort_id
	private String type="0"; //类型 默认是0:在自定义条件树中 1:市管干部数下面的数据  2:县官干部下数据

	private List<QueryCustomDetial> queryCustomDetialList = new ArrayList<>();


	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}

	public QueryCustomTpl() {
		super();
	}

	public QueryCustomTpl(String id){
		super(id);
	}

	@Length(min=1, max=300, message="名称长度必须介于 1 和 300 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getSqltxt() {
		return sqltxt;
	}

	public void setSqltxt(String sqltxt) {
		this.sqltxt = sqltxt;
	}
	
	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}
	
	@Length(min=0, max=8, message="sort_id长度必须介于 0 和 8 之间")
	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<QueryCustomDetial> getQueryCustomDetialList() {
		return queryCustomDetialList;
	}

	public void setQueryCustomDetialList(List<QueryCustomDetial> queryCustomDetialList) {
		this.queryCustomDetialList = queryCustomDetialList;
	}
}