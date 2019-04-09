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
public class QueryTable extends DataEntity<QueryTable> {

	private static final long serialVersionUID = 1L;
	private String tableName;		// 表名
	private String tableKeyColumn;		// 表关键字段
	private String tableOtherKeyColumn;		// 其他表外键
	private UserDO user;		// 用户id
	private String sortId;		// sort_id
	private String TableNameText; //表名注解
	private List<SelectOption> singleSelectOption; //单表下拉选
	private List<SelectOption> mulSelectOption; //多表下拉选


	public List<SelectOption> getSingleSelectOption() {
		return singleSelectOption;
	}

	public void setSingleSelectOption(List<SelectOption> singleSelectOption) {
		this.singleSelectOption = singleSelectOption;
	}

	public List<SelectOption> getMulSelectOption() {
		return mulSelectOption;
	}

	public void setMulSelectOption(List<SelectOption> mulSelectOption) {
		this.mulSelectOption = mulSelectOption;
	}

	public String getTableNameText() {
		return TableNameText;
	}

	public void setTableNameText(String tableNameText) {
		TableNameText = tableNameText;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableKeyColumn() {
		return tableKeyColumn;
	}

	public void setTableKeyColumn(String tableKeyColumn) {
		this.tableKeyColumn = tableKeyColumn;
	}

	public String getTableOtherKeyColumn() {
		return tableOtherKeyColumn;
	}

	public void setTableOtherKeyColumn(String tableOtherKeyColumn) {
		this.tableOtherKeyColumn = tableOtherKeyColumn;
	}

	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
}