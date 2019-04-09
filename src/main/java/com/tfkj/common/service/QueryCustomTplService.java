/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tfkj.common.dao.QueryCustomTplDao;
import com.tfkj.common.domain.CarderPersonSearhParam;
import com.tfkj.common.domain.CardrePersonSearch;
import com.tfkj.common.domain.QueryCustomDetial;
import com.tfkj.common.domain.QueryCustomTpl;
import com.tfkj.common.utils.StringUtils;
import com.tfkj.common.utils.SymmetricEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 单表生成Service
 * @author gaowei
 * @version 2018-07-13
 */
@Service
@Transactional(readOnly = true)
public class QueryCustomTplService  {
	@Autowired
	private QueryCustomTplDao dao;
	@Autowired
	private QueryCustomDetialService detialService;
	@Autowired
	private QueryTableService queryTableService;

	public QueryCustomTpl get(String id) {
		return dao.get(id);
	}
	
	public List<QueryCustomTpl> findList(QueryCustomTpl queryCustomTpl) {
		return dao.findList(queryCustomTpl);
	}

	@Transactional(readOnly = false)
	public void save(QueryCustomTpl queryCustomTpl) {
		if(StringUtils.isEmpty(queryCustomTpl.getId())){
			queryCustomTpl.preInsert();
			dao.insert(queryCustomTpl);
		}else{
			queryCustomTpl.preUpdate();
			dao.update(queryCustomTpl);
		}

	}
	
	@Transactional(readOnly = false)
	public void delete(QueryCustomTpl queryCustomTpl) {
		dao.delete(queryCustomTpl);
	}


	/**
	 * 保存模板 并且根据模板生成相应的sql语句
	 * @param tplName
	 * @param queryCustomDetials
	 */
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public String saveTplAndDetial(String tplName, List<QueryCustomDetial> queryCustomDetials){
		QueryCustomTpl queryCustomTpl = new QueryCustomTpl();
		//模板名称
		queryCustomTpl.setName(tplName);
		//设置用户id
		/*UserDO user = ShiroUtils.getUser();*/
		queryCustomTpl.setUser(null);
		//循环sql语句
		CarderPersonSearhParam<Map> mapCarderPersonSearhParam = CardrePersonSearch.customQuery2Sql(queryCustomDetials);

		//设置表关系
		queryCustomTpl.setTables(queryTableService.tablesCondition());

		//设置sql语句
		queryCustomTpl.setSqltxt(mapCarderPersonSearhParam.getSql());
		//设置sql语句对应的参数
		Map params = mapCarderPersonSearhParam.getParam();
		String paramsJSON = JSON.toJSONString(params);
		queryCustomTpl.setValue(paramsJSON);
		save(queryCustomTpl);
		//循环插入 模板对应的查询条件
		for(QueryCustomDetial queryCustomDetial : queryCustomDetials){
			if((!StringUtils.isEmpty(queryCustomDetial.getFirstValue()))||(!StringUtils.isEmpty(queryCustomDetial.getSecondValue()))){
				queryCustomDetial.setTmplid(queryCustomTpl.getId());
				queryCustomDetial.setId(null);
				queryCustomDetial.preInsert();
				detialService.save(queryCustomDetial);
			}
		}
		return queryCustomTpl.getId();
	}


	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public void updateTplAndDetial(String tplName, List<QueryCustomDetial> queryCustomDetials, String tplId){
		QueryCustomTpl queryCustomTpl = new QueryCustomTpl();
		//模板名称
		queryCustomTpl.setName(tplName);
		//设置用户id
		/*UserDO user = ShiroUtils.getUser();*/
		queryCustomTpl.setUser(null);
		queryCustomTpl.setId(tplId);
		//设置表关系
		queryCustomTpl.setTables(queryTableService.tablesCondition());
		//循环sql语句
		CarderPersonSearhParam<Map> mapCarderPersonSearhParam = CardrePersonSearch.customQuery2Sql(queryCustomDetials);
		//设置sql语句
		queryCustomTpl.setSqltxt(mapCarderPersonSearhParam.getSql());
		//设置sql语句对应的参数
		Map params = mapCarderPersonSearhParam.getParam();
		String paramsJSON = JSON.toJSONString(params);
		queryCustomTpl.setValue(paramsJSON);
		save(queryCustomTpl);
		//删除相应模板的之前的数据
		detialService.deleteByTmpId("1",tplId);
		//循环插入 模板对应的查询条件
		for(QueryCustomDetial queryCustomDetial : queryCustomDetials){
			if((!StringUtils.isEmpty(queryCustomDetial.getFirstValue()))||(!StringUtils.isEmpty(queryCustomDetial.getSecondValue()))){
				queryCustomDetial.setTmplid(queryCustomTpl.getId());
				queryCustomDetial.setId(null);
				queryCustomDetial.preInsert();
				detialService.save(queryCustomDetial);
			}
		}
	}


	/**
	 * 根据传入的ids查出所有的对应的模板数据
	 * @param ids
	 * @return
	 */
	public String getTpl2JsonStr(String ids){
		String[] idsSplit = ids.split(",");
		List<String> idList = Arrays.asList(idsSplit);
		Map param = new HashMap();
		param.put("ids",idList);
		List<QueryCustomTpl> queryCustomTpls = dao.getQueryCustomTpls(param);
        return SymmetricEncoder.AESEncode(JSONArray.toJSONString(queryCustomTpls));
	}


    /**
     * 保存主表数据和字表数据
     */
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public void saveCustomTpl(List<QueryCustomTpl> queryCustomTplList){
       /* UserDO user = ShiroUtils.getUser();*/
        for(QueryCustomTpl queryCustomTpl : queryCustomTplList){
            queryCustomTpl.setId(null);
            save(queryCustomTpl);
            for(QueryCustomDetial queryCustomDetial : queryCustomTpl.getQueryCustomDetialList()){
                queryCustomDetial.setTmplid(queryCustomTpl.getId());
                queryCustomDetial.setId(null);
                detialService.save(queryCustomDetial);
            }
        }
    }
}