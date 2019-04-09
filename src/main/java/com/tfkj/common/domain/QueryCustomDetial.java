/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.domain;

import java.util.List;
import java.util.Map;


/**
 * 单表生成Entity
 * @author gaowei
 * @version 2018-07-12
 */
public class QueryCustomDetial extends DataEntity<QueryCustomDetial> {
	
	private static final long serialVersionUID = 1L;
	private String tmplid;		// 模板表的id
	private String coidid;		// 自定义条件中的id
	private String fieldName;		// 数据库字段名
	private String startFlag;		// 是否存在左括号
	private String fieldText;		// 字段对应中文
	private String dataref;		// 所选查询条件 与程序中Condition类中枚举相关
	private String firstValue;		// 值1的值
	private String firstValueDataType;
	private String secondValueDataType;
	private String secondValue;		// 值2的值
	private String endFlag;		// 是否存在右括号
	private String dmm;		// 如果有值 则对应码表中的数据
	private String relation;  //所有的关系
	private List<DictDO> selectValueData;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<DictDO> getSelectValueData() {
		//由于数据字典结构不清楚,出来那些也不清晰,所以此处可能会做处理
		return selectValueData;
	}

	public void setSelectValueData(List<DictDO> selectValueData) {
		this.selectValueData = selectValueData;
	}

	private String dataRefs;//所有的相关联的下拉框


	private List<Map> DataRefArray; //对应选择时候的下拉框


	public List<Map> getDataRefArray() {
		return DataRefArray;
	}

	public void setDataRefArray(List<Map> dataRefArray) {
		DataRefArray = dataRefArray;
	}

	public String getDataRefs() {
		return dataRefs;
	}

	public void setDataRefs(String dataRefs) {
		this.dataRefs = dataRefs;
	}

	public QueryCustomDetial() {
		super();
	}

	public QueryCustomDetial(String id){
		super(id);
	}

	public String getTmplid() {
		return tmplid;
	}

	public void setTmplid(String tmplid) {
		this.tmplid = tmplid;
	}

	public String getCoidid() {
		return coidid;
	}

	public void setCoidid(String coidid) {
		this.coidid = coidid;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getStartFlag() {
		return startFlag;
	}

	public void setStartFlag(String startFlag) {
		this.startFlag = startFlag;
	}

	public String getFieldText() {
		return fieldText;
	}

	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}

	public String getDataref() {
		return dataref;
	}

	public void setDataref(String dataref) {
		this.dataref = dataref;
	}

	public String getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}

	public String getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}

	public String getEndFlag() {
		return endFlag;
	}

	public void setEndFlag(String endFlag) {
		this.endFlag = endFlag;
	}

	public String getDmm() {
		return dmm;
	}

	public void setDmm(String dmm) {
		this.dmm = dmm;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getFirstValueDataType() {
		return firstValueDataType;
	}

	public void setFirstValueDataType(String firstValueDataType) {
		this.firstValueDataType = firstValueDataType;
	}

	public String getSecondValueDataType() {
		return secondValueDataType;
	}

	public void setSecondValueDataType(String secondValueDataType) {
		this.secondValueDataType = secondValueDataType;
	}
}