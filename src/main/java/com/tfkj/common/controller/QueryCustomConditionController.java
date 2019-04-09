/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tfkj.common.domain.*;
import com.tfkj.common.service.DetailService;
import com.tfkj.common.service.QueryCustomConditionService;
import com.tfkj.common.service.QueryCustomTplService;
import com.tfkj.common.service.QueryTableService;
import com.tfkj.common.utils.BuildTree;
import com.tfkj.common.utils.PageUtils;
import com.tfkj.common.utils.Query;
import com.tfkj.common.utils.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2018-07-12
 */
@Controller
@RequestMapping(value = "cardreperson/queryCustomCondition")
public class QueryCustomConditionController  {

	@Autowired
	private QueryCustomConditionService queryCustomConditionService;

	@Autowired
	private SqlSearchUtils sqlSearchUtils;

	@Autowired
	private QueryCustomTplService queryCustomTplService;

	@Autowired
	private QueryTableService queryTableService;

	@Autowired
	private DetailService detailService;


	/**
	 * 生成图表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toBingtu")
	@ResponseBody
	public Map<String,Object> toBingtu( String[] ids,Model model) {
		Map<String,Object> map=new HashMap<>();
		List<Object> name=new ArrayList<Object>();
		List<Object> value=new ArrayList<Object>();
		for (String id:ids) {
			QueryCustomTpl entity = queryCustomTplService.get(id);
			Map query = new HashMap();
			query.put("sqlParams",entity.getSqltxt());
			query.putAll((Map)JSON.parse(entity.getValue()));
			query.put("zhcx","zhcx");
			query.put("tables",entity.getTables());
			int total =  detailService.countFindList(query);
			JSONObject objectValue=new JSONObject();
			JSONObject objectName=new JSONObject();
			objectValue.put("value",total);
			objectValue.put("name",entity.getName()+"："+total+"个");
			value.add(objectValue);
			objectName.put("name",entity.getName()+"："+total+"个");
			objectName.put("icon","bar");
			name.add(objectName);

		}
		map.put("name",name);
		map.put("value",value);
		return map;
	}

	/**
	 * 生成柱状图
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toZhutu")
	@ResponseBody
	public Map<String,Object> toZhutu( String[] ids,Model model) {
		Map<String,Object> map=new HashMap<>();
		List<Object> name=new ArrayList<Object>();
		List<Object> value=new ArrayList<Object>();
		for (String id:ids) {
			QueryCustomTpl entity = queryCustomTplService.get(id);
			Map query = new HashMap();
			query.put("sqlParams",entity.getSqltxt());
			query.putAll((Map)JSON.parse(entity.getValue()));
			query.put("zhcx","zhcx");
			query.put("tables",entity.getTables());
			int total =  detailService.countFindList(query);
			value.add(total);
			name.add(entity.getName());

		}
		map.put("name",name);
		map.put("value",value);
		return map;
	}
	/**
	 * 按树形结构查询出相应数据
	 * @return
	 */
	@RequestMapping(value="treeData")
	@ResponseBody
	public Tree<QueryCustomCondition> treeData(QueryCustomCondition queryCustomCondition){
		List<Tree<QueryCustomCondition>> trees = new ArrayList<Tree<QueryCustomCondition>>();
		List<QueryCustomCondition> list = queryCustomConditionService.findList(queryCustomCondition);
		dataRefList(list);
		for (QueryCustomCondition query:list) {
			Tree<QueryCustomCondition> tree = new Tree<QueryCustomCondition>();
			tree.setId(query.getId());
			tree.setParentId(query.getParentkey());
			tree.setText(query.getName());
			tree.setT(query);
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		Tree<QueryCustomCondition> t = BuildTree.build(trees);
		return t;
	}

	/**
	 * 按树形结构查询出相应数据
	 * @return
	 */
	@RequestMapping(value="treeDataMb")
	@ResponseBody
	public Tree<QueryCustomTpl> treeDataMb(QueryCustomCondition queryCustomCondition){
		List<Tree<QueryCustomTpl>> trees = new ArrayList<Tree<QueryCustomTpl>>();
		QueryCustomTpl queryCustomTpl = new QueryCustomTpl();
		queryCustomTpl.setCreateBy(null);
		List<QueryCustomTpl> list = queryCustomTplService.findList(queryCustomTpl);
		for (QueryCustomTpl query:list) {
			Tree<QueryCustomTpl> tree = new Tree<QueryCustomTpl>();
			tree.setId(query.getId());
			tree.setParentId("0");
			tree.setText(query.getName());
			tree.setT(query);
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		Tree<QueryCustomTpl> t = BuildTree.buildTitle(trees,"模板列表(点击新增模板)");
		return t;
	}



	/**
	 * 处理数字运算符的转换
	 */
	private void dataRefList(List<QueryCustomCondition> queryCustomConditionList){
		Map<String, String> sqlSearch = sqlSearchUtils.getSqlSearch();
		for(QueryCustomCondition queryCustomCondition : queryCustomConditionList){
			String dataref = queryCustomCondition.getDataref();
			if(!StringUtils.isEmpty(dataref)){
				String[] split = dataref.split(",");
				//创建 查询条件集合 有前台显示使用
				List<Map> codi = new ArrayList<>();
				for(String s : split){
					Map map = new HashMap();
					//根据值去出对应的显示值
					String s1 = sqlSearch.get(s);
					map.put("enname",s);
					map.put("chname",s1);
					codi.add(map);
				}
				queryCustomCondition.setDataRefArray(codi);
			}
		}
	}


	/**
	 * 根据数据字典获取数据
	 * @return
	 */
	@RequestMapping(value="getDict")
	@ResponseBody
	/*public Object getDict(String code){
		return DictUtils.getDictList(code);
	}*/


	@ModelAttribute
	public QueryCustomCondition get(@RequestParam(required=false) String id) {
		QueryCustomCondition entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = queryCustomConditionService.get(id);
		}
		if (entity == null){
			entity = new QueryCustomCondition();
		}
		return entity;
	}

	/**
	 * 返回自定义查询画面
	 * @return
	 */
	@RequestMapping(value = "toCustomsearch")
	public String toCustomsearch(Model model){
		//查找出此人定义的模板画面
		QueryCustomTpl queryCustomTpl = new QueryCustomTpl();
		queryCustomTpl.setCreateBy(null);
		List<QueryCustomTpl> list = queryCustomTplService.findList(queryCustomTpl);
		model.addAttribute("customTpl",list);
		model.addAttribute("tables",queryTableService.tablesCondition());
		return "common/query/searchList";
	}


	@GetMapping("toListSearch")
	String ToListSearch(){
		return "common/query/searchListDetil";
	}

	@ResponseBody
	@GetMapping("/listSearch")
	public PageUtils listSearch(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		String sqlParams = StringEscapeUtils.unescapeHtml4(query.get("strData").toString());
		List<QueryCustomDetial> queryCustomDetials = JSONArray.parseArray(sqlParams, QueryCustomDetial.class);
		CarderPersonSearhParam<Map> mapCarderPersonSearhParam = CardrePersonSearch.customQuery2Sql(queryCustomDetials);
		query.put("sqlParams",mapCarderPersonSearhParam.getSql());
		query.putAll(mapCarderPersonSearhParam.getParam());
		query.put("zhcx","zhcx");
		query.put("tableListItem",query.get("tableListItem"));

		if (queryCustomDetials!=null&&queryCustomDetials.size()>0&&queryCustomDetials.get(0).getTmplid()!=null&&queryCustomDetials.get(0).getTmplid()!=""){
			QueryCustomTpl queryCustomTpl=queryCustomTplService.get(queryCustomDetials.get(0).getTmplid());
			query.put("tables",queryCustomTpl.getTables());
		}else {
			query.put("tables",queryTableService.tablesCondition());
		}
		List<Map> list = detailService.findList(query);
		int total = detailService.countFindList(query);
		PageUtils pageUtils = new PageUtils(list, total);
		return pageUtils;
	}

	/**
	 * 生成图表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toEchart")
	public String toEchart( Model model) {
		List<Tree<QueryCustomTpl>> trees = new ArrayList<Tree<QueryCustomTpl>>();
		QueryCustomTpl queryCustomTpl = new QueryCustomTpl();
		queryCustomTpl.setCreateBy(null);
		List<QueryCustomTpl> list = queryCustomTplService.findList(queryCustomTpl);
		model.addAttribute("tplList",list);
		return "common/query/echart";
	}

	/**
	 * 跳到选择表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toTableDB")
	public String toTableDB( Model model) {
		List<Map> list=queryCustomConditionService.getTableList();
        List<QueryTable> listQuery=queryTableService.findList();
        model.addAttribute("queryList",listQuery);
		model.addAttribute("tableList",list);
		return "common/query/tableDB";
	}

	/**
	 *
	 * 获取表字段
	 * @param model
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTableColumn")
	public List getTableColumn( Model model,String ids) {
		List listTable=new ArrayList();
		String[] strs=ids.split(",");
		for (String str: strs ) {
			List<Map> list=queryCustomConditionService.getTableColumn(str);
			listTable.add(list);
		}
		return listTable;
	}

	@ResponseBody
	@RequestMapping(value = "saveTablePz")
	public String saveTablePz( Model model,String tableName,String keys,String tableNameText) {
		/*try{*/
			List listTable=new ArrayList();
			//表名字段
			String[] tableNameList=tableName.split(",");
			//表名注解
			String[] tableNameTextList=tableNameText.split(",");
			//关键字段
			String[] keyList=null;
			if(StringUtils.isNotEmpty(keys)){
				 keyList=keys.split(",");
			}
			List<QueryTable> queryTableList=new ArrayList<QueryTable>();
			for (int i=0;i<tableNameList.length;i++){
				QueryTable queryTable=new QueryTable();
				queryTable.setTableName(tableNameList[i]);
				if(tableNameList.length==tableNameTextList.length){
					queryTable.setTableNameText("016b2c81bdf54b91a41d9d87d7bbe6e9".equals(tableNameTextList[i])?"":tableNameTextList[i]);
				}
                if(keyList!=null && !"!".equals(keyList[i]) && StringUtils.isNotEmpty(keyList[i])){
					queryTable.setTableKeyColumn(keyList[i].split("!")[0]);
					queryTable.setTableOtherKeyColumn(keyList[i].split("!")[1]);
				}
				queryTableList.add(queryTable);
			}
		    queryTableService.save(queryTableList);
			return "success";
		/*}catch (Exception e){
			return "false";
		}*/

	}

	@RequestMapping(value = "form")
	public String form(QueryCustomCondition queryCustomCondition, Model model) {
		model.addAttribute("queryCustomCondition", queryCustomCondition);
		return "business/cardreperson/queryCustomConditionForm";
	}


	@RequestMapping(value = "save")
	public String save(QueryCustomCondition queryCustomCondition, Model model, RedirectAttributes redirectAttributes) {
		/*if (!beanValidator(model, queryCustomCondition)){
			return form(queryCustomCondition, model);
		}*/
		queryCustomConditionService.save(queryCustomCondition);
		/*addMessage(redirectAttributes, "保存单表成功");*/
		return "redirect:cardreperson/queryCustomCondition/?repage";
	}
	

	@RequestMapping(value = "delete")
	public String delete(QueryCustomCondition queryCustomCondition, RedirectAttributes redirectAttributes) {
		queryCustomConditionService.delete(queryCustomCondition);
		/*addMessage(redirectAttributes, "删除单表成功");*/
		return "redirect:cardreperson/queryCustomCondition/?repage";
	}



}