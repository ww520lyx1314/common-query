/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.service;


import com.tfkj.common.dao.*;
import com.tfkj.common.domain.*;
import com.tfkj.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 单表生成Service
 * @author gaowei
 * @version 2018-07-13
 */
@Service
@Transactional(readOnly = true)
public class QueryTableService {
	@Autowired
	private QueryTableDao queryTableDao;

	@Autowired
	private TableDBDao tableDBDao;

    @Autowired
	private QueryCustomConditionDao conditionDao;

	@Autowired
    private QueryCustomTplDao queryCustomTplDao;

    @Autowired
    private QueryCustomDetialDao queryCustomDetialDao;

	@Transactional(readOnly = false)
	public void save(List<QueryTable> queryTableList) {
		//清空原始模板以及详细信息
		queryCustomTplDao.deleteAll();
		queryCustomDetialDao.deleteAll();
		//清空条件表
		conditionDao.deleteAll();
		//清空配置表
		queryTableDao.deleteAll();
		int i=0;
		for (QueryTable queryTable:queryTableList) {
			queryTableDao.insert(queryTable);
			List<Map> list=tableDBDao.listTableColumn(queryTable.getTableName());
			List<QueryCustomCondition> listQuery=new ArrayList<QueryCustomCondition>();
			QueryCustomCondition query1=new QueryCustomCondition();
			query1.preInsert();
			//表注解作为父节点文字
			query1.setName(StringUtils.isNotEmpty(queryTable.getTableNameText())?queryTable.getTableNameText():queryTable.getTableName());
			query1.setKey("parent");
			query1.setParentkey("0");
			query1.setSortId(String.valueOf(i++));
			conditionDao.insert(query1);
			for (Map listColumn:list) {
				QueryCustomCondition query=new QueryCustomCondition();
				query.preInsert();
				query.setKey(listColumn.get("TABLE_NAME").toString()+"."+listColumn.get("COLUMN_NAME").toString());
				if (StringUtils.isNotEmpty(listColumn.get("COLUMN_COMMENT").toString())){
					query.setName(listColumn.get("COLUMN_COMMENT").toString());
				}else{
					query.setName(listColumn.get("COLUMN_NAME").toString());
				}
				query.setParentkey(query1.getId());
				//默认配置Text文本格式，需要修改select的或时间格式请手动修改数据库，code配置select编码
				query.setDatatype("text");
				query.setDataref("LIKE,NOTLIKE");
				query.setSortId(String.valueOf(i++));
				conditionDao.insert(query);

			}
		}
	}

	public List<QueryTable> findList(){
		List<QueryTable> list=queryTableDao.findList();
		List<SelectOption> selectMulGroup=new ArrayList<SelectOption>();
		//分组
		List<SelectOption> selectMulOptionList=new ArrayList<SelectOption>();
		for (QueryTable qt:list) {
			List<Map> option= tableDBDao.listTableColumn(qt.getTableName());

			SelectOption selMulOption=new SelectOption();
			List<SelectOption> selectMulOptionListIn=new ArrayList<SelectOption>();
			//单个下拉选
			List<SelectOption> selectSigOptionList=new ArrayList<SelectOption>();
			for (Map map:option) {
				SelectOption selectOptionSig=new SelectOption();
				selectOptionSig.setTableName(map.get("TABLE_NAME").toString());
				selectOptionSig.setTableColumn(map.get("COLUMN_NAME").toString());
				//判断单个下拉选
				String key=map.get("TABLE_NAME").toString()+"-"+map.get("COLUMN_NAME").toString();
				if(key.equals(qt.getTableKeyColumn())){
					selectOptionSig.setIsSelect(true);
				}else{
					selectOptionSig.setIsSelect(false);
				}
				selectSigOptionList.add(selectOptionSig);
				//多项下拉选
				SelectOption selectOptionSig1=new SelectOption();
				selectOptionSig1.setTableName(map.get("TABLE_NAME").toString());
				selectOptionSig1.setTableColumn(map.get("COLUMN_NAME").toString());
				selectMulOptionListIn.add(selectOptionSig1);
				selMulOption.setListSelect(selectMulOptionListIn);
				

			}
			selMulOption.setTableName(qt.getTableName());
			selectMulOptionList.add(selMulOption);
			//分组下拉选结束
			qt.setSingleSelectOption(selectSigOptionList);
		}
		for (QueryTable qt:list) {
			List<SelectOption> selectMulOptionListNew =new ArrayList<SelectOption>();
			for (SelectOption sq:selectMulOptionList) {
				List<SelectOption> selectIn =new ArrayList<SelectOption>();
				SelectOption seOut=new SelectOption();
				for (SelectOption sqIn:sq.getListSelect()){
					SelectOption seIn=new SelectOption(sqIn);
					String key1=seIn.getTableName()+"-"+seIn.getTableColumn();
					if(key1.equals(qt.getTableOtherKeyColumn())){
						seIn.setIsSelect(true);
					}else{
						seIn.setIsSelect(false);
					}
					selectIn.add(seIn);
				}
				seOut.setTableName(sq.getTableName());
				seOut.setListSelect(selectIn);
				selectMulOptionListNew.add(seOut);
			}
			qt.setMulSelectOption(selectMulOptionListNew);
		}

		return list;
	}

   //拼接表数据
	public  String  tablesCondition(){
		StringBuffer stringBuffer=new StringBuffer();
		List<QueryTable> queryTableList=queryTableDao.findList();
		if (queryTableList!=null&&queryTableList.size()>0){
			stringBuffer.append(queryTableList.get(0).getTableName());
		}
		if (queryTableList!=null&&queryTableList.size()>1){
			for (int i=1;i<queryTableList.size();i++){
				stringBuffer.append(" LEFT JOIN ");
				stringBuffer.append(queryTableList.get(i).getTableName());
				stringBuffer.append(" on ");
				stringBuffer.append(queryTableList.get(i).getTableKeyColumn().replace("-","."));
				stringBuffer.append(" = ");
				stringBuffer.append(queryTableList.get(i).getTableOtherKeyColumn().replace("-","."));
			}
		}
		return stringBuffer.toString();
	}
}