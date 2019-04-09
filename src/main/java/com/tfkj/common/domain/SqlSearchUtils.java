package com.tfkj.common.domain;


import com.tfkj.common.utils.combiation.QueryCombinationConditionChildren;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
*@Description: 处理查询方式的 转换
*@param:
*@return:
*@author:xu.aichen
*@Date:2018/7/12
*/
@Component
public class SqlSearchUtils {
    private Map<String,String> sqlSearch= new HashMap<>();

    /**
     * 为画面显示使用
     */
    private Map<String,List<QueryCombinationConditionChildren>> queryChildrenList = new HashMap<>();

    /**
     * 为后台处理拼接sql时使用
     */
    private Map<String,QueryCombinationConditionChildren> queryChild = new HashMap<>();


    public Map<String, List<QueryCombinationConditionChildren>> getQueryChildrenList() {
        return queryChildrenList;
    }

    public void setQueryChildrenList(Map<String, List<QueryCombinationConditionChildren>> queryChildrenList) {
        this.queryChildrenList = queryChildrenList;
    }

    public Map<String, QueryCombinationConditionChildren> getQueryChild() {
        return queryChild;
    }

    public void setQueryChild(Map<String, QueryCombinationConditionChildren> queryChild) {
        this.queryChild = queryChild;
    }

    public Map<String, String> getSqlSearch() {
        return sqlSearch;
    }

    public void setSqlSearch(Map<String, String> sqlSearch) {
        this.sqlSearch = sqlSearch;
    }

    @PostConstruct
    public void initSearchDatas(){
        Condition.Codemun[] values = Condition.Codemun.values();
        for(Condition.Codemun v : values){
            sqlSearch.put(v.getEn(),v.getShowEn());
        }
    }






}
