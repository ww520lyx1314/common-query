/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.domain;

import java.util.List;

/**
 * 单表生成Entity
 * @author gaowei
 * @version 2018-07-13
 */
public class SelectOption extends DataEntity<SelectOption> {

	private static final long serialVersionUID = 1L;
	private String tableName;		// 表名
	private String tableColumn;	//表列
	private Boolean isSelect;		// 是否选中
	private Boolean isGroupStart;		// 是否分组
	private List<SelectOption> listSelect;

	public SelectOption(SelectOption se) {
		this.tableName = se.tableName;
		this.tableColumn = se.tableColumn;
		this.isSelect = se.isSelect;
		this.isGroupStart = se.isGroupStart;
		this.listSelect = se.listSelect;
	}
	public SelectOption() {
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}

	public Boolean getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Boolean select) {
		isSelect = select;
	}

	public Boolean getGroupStart() {
		return isGroupStart;
	}

	public void setIsGroupStart(Boolean groupStart) {
		isGroupStart = groupStart;
	}

	public List<SelectOption> getListSelect() {
		return listSelect;
	}

	public void setListSelect(List<SelectOption> listSelect) {
		this.listSelect = listSelect;
	}
}