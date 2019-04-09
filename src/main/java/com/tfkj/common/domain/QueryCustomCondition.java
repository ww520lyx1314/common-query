/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.domain;

import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Map;


/**
 * 单表生成Entity
 * @author ThinkGem
 * @version 2018-07-12
 */
public class QueryCustomCondition extends DataEntity<QueryCustomCondition> {
	
	private static final long serialVersionUID = 1L;
	private String key;		// 表名或者字段名
	private String name;		// 名称
	private String parentkey;		// 父级 表名
	private String code;		// 代码
	private String datatype;		// 数据类型：DATE、STRING、INT、SELECT
	private String dataref;		// 运算符:=、!=、&gt;=、									&lt;/td&gt;									&lt;td nowrap&gt;										&lt;input type=
	private String sortId;		// 排序

	private List<Map> dataRefArray;  //处理 语句运算符的转换


	public List<Map> getDataRefArray() {
		return dataRefArray;
	}

	public void setDataRefArray(List<Map> dataRefArray) {
		this.dataRefArray = dataRefArray;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public QueryCustomCondition() {
		super();
	}

	public QueryCustomCondition(String id){
		super(id);
	}

	@Length(min=1, max=255, message="表名或者字段名长度必须介于 1 和 255 之间")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Length(min=1, max=255, message="名称长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="父级 表名长度必须介于 0 和 255 之间")
	public String getParentkey() {
		return parentkey;
	}

	public void setParentkey(String parentkey) {
		this.parentkey = parentkey;
	}
	
	@Length(min=0, max=255, message="代码长度必须介于 0 和 255 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=20, message="数据类型：DATE、STRING、INT、SELECT长度必须介于 0 和 20 之间")
	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	
	public String getDataref() {
		return dataref;
	}

	public void setDataref(String dataref) {
		this.dataref = dataref;
	}
	
	@Length(min=0, max=8, message="排序长度必须介于 0 和 8 之间")
	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
	
}