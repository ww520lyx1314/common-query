/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.controller;
import com.tfkj.common.domain.QueryCustomDetial;
import com.tfkj.common.service.QueryCustomDetialService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 单表生成Controller
 * @author gaowei
 * @version 2018-07-12
 */
@Controller
@RequestMapping(value = "role/table/queryCustomDetial")
public class QueryCustomDetialController  {

	@Autowired
	private QueryCustomDetialService queryCustomDetialService;
	
	@ModelAttribute
	public QueryCustomDetial get(@RequestParam(required=false) String id) {
		QueryCustomDetial entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = queryCustomDetialService.get(id);
		}
		if (entity == null){
			entity = new QueryCustomDetial();
		}
		return entity;
	}
	


	@RequestMapping(value = "form")
	public String form(QueryCustomDetial queryCustomDetial, Model model) {
		model.addAttribute("queryCustomDetial", queryCustomDetial);
		return "business/role/table/queryCustomDetialForm";
	}


	@RequestMapping(value = "save")
	public String save(QueryCustomDetial queryCustomDetial, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, queryCustomDetial)){
//			return form(queryCustomDetial, model);
//		}
		queryCustomDetialService.save(queryCustomDetial);
//		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:role/table/queryCustomDetial/?repage";
	}
	

	@RequestMapping(value = "delete")
	public String delete(QueryCustomDetial queryCustomDetial, RedirectAttributes redirectAttributes) {
		queryCustomDetialService.delete(queryCustomDetial);
		/*addMessage(redirectAttributes, "删除单表成功");*/
		return "redirect:role/table/queryCustomDetial/?repage";
	}

}