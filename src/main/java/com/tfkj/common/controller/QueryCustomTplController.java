/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.controller;


import com.alibaba.fastjson.JSONArray;
import com.tfkj.common.domain.*;
import com.tfkj.common.service.QueryCustomDetialService;
import com.tfkj.common.service.QueryCustomTplService;
import com.tfkj.common.utils.PageUtils;
import com.tfkj.common.utils.SymmetricEncoder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 单表生成Controller
 * @author gaowei
 * @version 2018-07-13
 */
@Controller
@RequestMapping(value = "cardre/queryCustomTpl")
public class QueryCustomTplController  {

	@Autowired
	private QueryCustomTplService queryCustomTplService;

	@Autowired
	private QueryCustomDetialService queryCustomDetialService;

	@Autowired
	private SqlSearchUtils sqlSearchUtils;

	@ModelAttribute
	public QueryCustomTpl get(@RequestParam(required=false) String id) {
		QueryCustomTpl entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = queryCustomTplService.get(id);
		}
		if (entity == null){
			entity = new QueryCustomTpl();
		}
		return entity;
	}


	/**
	 * 保存或更新模板方法
	 * @return
	 */
	@RequestMapping(value="saveOrUpdateTpl")
	@ResponseBody
	public Object saveOrUpdateTpl(String tplName, String datas, String tplId){
		Map<String,String> params = new HashMap<>();
		try {
			datas = StringEscapeUtils.unescapeHtml4(datas);
			List<QueryCustomDetial> queryCustomDetials = JSONArray.parseArray(datas, QueryCustomDetial.class);
			if(StringUtils.isEmpty(tplId)){
				String id = queryCustomTplService.saveTplAndDetial(tplName, queryCustomDetials);
				params.put("tmplId",id);
			}else{
				queryCustomTplService.updateTplAndDetial(tplName, queryCustomDetials,tplId);
			}
			params.put("result","1");
			params.put("msg","操作成功");
		} catch (Exception e) {
			/*logger.error(e.getMessage(),e);*/
			e.printStackTrace();
			params.put("result","0");
			params.put("msg",e.getMessage());
		}
		return params;
	}

	/**
	 * 删除制定模板
	 * @return
	 */
	@RequestMapping(value="deleteTpl")
	@ResponseBody
	public Object deleteTpl(String tplId){
		Map<String,String> params = new HashMap<>();
		try {
			QueryCustomTpl queryCustomTpl = new QueryCustomTpl();
			queryCustomTpl.setId(tplId);
			queryCustomTplService.delete(queryCustomTpl);
			params.put("result","1");
			params.put("msg","操作成功");
		} catch (Exception e) {
			/*logger.error(e.getMessage(),e);*/
			e.printStackTrace();
			params.put("result","0");
			params.put("msg",e.getMessage());
		}
		return params;
	}


	@RequestMapping(value="getTmpDetail")
	@ResponseBody
	public PageUtils getTmpDetail(String tplId){
		if(!StringUtils.isEmpty(tplId)&&!"-1".equals(tplId)){
			QueryCustomDetial queryCustomDetial = new QueryCustomDetial();
			queryCustomDetial.setTmplid(tplId);
			List<QueryCustomDetial> list = queryCustomDetialService.findList(queryCustomDetial);
			Map<String, String> sqlSearch = sqlSearchUtils.getSqlSearch();
			for(QueryCustomDetial queryCustomDetial1 : list){
			if(!StringUtils.isEmpty(queryCustomDetial1.getDmm())){
				Map<String, Object> map = new HashMap<>(16);
				/*map.put("type", queryCustomDetial1.getDmm());
				List<DictDO> dictList = dictService.list(map);
					queryCustomDetial1.setSelectValueData(dictList);*/
				}
				String dataRefs = queryCustomDetial1.getDataRefs();
				if(!StringUtils.isEmpty(dataRefs)){
					String dataref = dataRefs;
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
						queryCustomDetial1.setDataRefArray(codi);
					}
				}
			}

			PageUtils pageUtils = new PageUtils(list, 1);
			return pageUtils;
		}
		/*************************************/
		PageUtils queryCustomDetialPageResult = new PageUtils(new ArrayList<QueryCustomDetial>(),10);
		/*************************************/
		return queryCustomDetialPageResult;
	}


	@RequestMapping(value="queryCustomTpl")
	public ModelAndView toSearchList(String sqlParams){
		String decode = URLDecoder.decode(sqlParams);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sqlParams",decode);
		modelAndView.setViewName("business/carderPersonSearch/cardreSearchList");
		return modelAndView;
	}

	/**
	 * 根据当传入数据直接查询sql
	 * @return
	 */
	@RequestMapping(value="searchByDatas")
	@ResponseBody
	public Object searchByDatas(String datas){
		Map<String,String> params = new HashMap<>();
		try {
			datas = StringEscapeUtils.unescapeHtml4(datas);
			List<QueryCustomDetial> queryCustomDetials = JSONArray.parseArray(datas, QueryCustomDetial.class);
//			queryCustomTplService.saveTplAndDetial(tplName,queryCustomDetials);
			CarderPersonSearhParam<Map> mapCarderPersonSearhParam = CardrePersonSearch.customQuery2Sql(queryCustomDetials);
			params.put("result","1");
			params.put("msg","操作成功");
		} catch (Exception e) {
			/*logger.error(e.getMessage(),e);*/
			e.printStackTrace();
			params.put("result","0");
			params.put("msg",e.getMessage());
		}
		return params;
	}


	/**
	 * 自定义模板的树形结构画面跳转
	 * @param queryCustomTpl
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "customTplTree")
	public String customTplTree(QueryCustomTpl queryCustomTpl, Model model) {
		model.addAttribute("queryCustomTpl", queryCustomTpl);
		return "business/carderPersonSearch/exportCustomTplTree";
	}




	@RequestMapping("tplDownload")
	public ResponseEntity<byte[]> download(String ids) throws IOException {
//		String path="D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\springMVC\\WEB-INF\\upload\\图片10（定价后）.xlsx";
//		File file=new File(path);
        String tpl2JsonStr = queryCustomTplService.getTpl2JsonStr(ids);
        HttpHeaders headers = new HttpHeaders();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        String fileName=new String(("自定义模板"+format+".fh").getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(tpl2JsonStr.getBytes(),
				headers, HttpStatus.CREATED);
	}

    /**
     * @Title: showImport @Description: 导入Excel-跳转 @param @param
     *         model @param @return 参数 @return String 返回类型 @throws
     */
    @RequestMapping(value = { "showImportCustomTpl" })
    public String showImportExcel(Model model) {
        return "business/carderPersonSearch/importCustomTplForm";
    }



    @RequestMapping(value = "importCustomTpl")
    @ResponseBody
    public Map<String, Object> importExcel(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String originalFilename = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String readStr;
            while(!StringUtils.isEmpty(readStr = bufferedReader.readLine())){
                stringBuilder.append(readStr);
            }
            try {
                List<QueryCustomTpl> queryCustomTpls = JSONArray.parseArray(SymmetricEncoder.AESDncode(stringBuilder.toString()), QueryCustomTpl.class);
                if(queryCustomTpls!=null&&queryCustomTpls.size()>0){
                    queryCustomTplService.saveCustomTpl(queryCustomTpls);
                    result.put("success",true);
                    result.put("msg","导入成功");
                }else{
                    result.put("success",false);
                    result.put("msg","导入的文件中没有数据");
                }
            } catch (Exception e) {
                e.printStackTrace();
               /* logger.error(e.getMessage(),e);*/
                result.put("success",false);
                result.put("msg","导入的文件存在问题");
            }
//            List<String> names = cardrePersonService.importExcel(newFile);
//            if(names!=null&&names.size()>0){
//                String name = StringUtils.join(names.toArray(), ",");
//                result.put(name, name);
//                return result;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }








	@RequestMapping(value = "form")
	public String form(QueryCustomTpl queryCustomTpl, Model model) {
		model.addAttribute("queryCustomTpl", queryCustomTpl);
		return "business/role/queryCustomTplForm";
	}

	@RequestMapping(value = "save")
	public String save(QueryCustomTpl queryCustomTpl, Model model, RedirectAttributes redirectAttributes) {
	/*	if (!beanValidator(model, queryCustomTpl)){
			return form(queryCustomTpl, model);
		}*/
		queryCustomTplService.save(queryCustomTpl);
		/*addMessage(redirectAttributes, "保存单表成功");*/
		return "redirect:role/queryCustomTpl/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(QueryCustomTpl queryCustomTpl, RedirectAttributes redirectAttributes) {
		queryCustomTplService.delete(queryCustomTpl);
//		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:role/queryCustomTpl/?repage";
	}

}