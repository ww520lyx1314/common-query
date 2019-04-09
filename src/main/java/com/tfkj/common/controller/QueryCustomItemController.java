package com.tfkj.common.controller;

import com.tfkj.common.domain.QueryCustomCondition;
import com.tfkj.common.service.QueryCustomConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "item")
public class QueryCustomItemController {

	@Autowired
	private QueryCustomConditionService queryCustomConditionService;

	
	@RequestMapping(value="/toEchart")
	public String toEchart(String tmplId, Model model){
		QueryCustomCondition queryCustomCondition = new QueryCustomCondition();
		List<QueryCustomCondition> findList = queryCustomConditionService.findList(queryCustomCondition);
		model.addAttribute("tplList", findList);
		return "common/query/listIemEchart";
	}
}
