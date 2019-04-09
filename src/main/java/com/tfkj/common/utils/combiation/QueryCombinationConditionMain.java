package com.tfkj.common.utils.combiation;

import java.util.ArrayList;
import java.util.List;

/***
*@Description:固定条件查询的主表
*@param:
*@return:
*@author:xu.aichen
*@Date:2018/7/16
*/
public class QueryCombinationConditionMain {
    private String mainCode;
    private String name;
    private String delFlag;
    private List<QueryCombinationConditionChildren> queryCombinationConditionChildrenList = new ArrayList<>();


    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<QueryCombinationConditionChildren> getQueryCombinationConditionChildrenList() {
        return queryCombinationConditionChildrenList;
    }

    public void setQueryCombinationConditionChildrenList(List<QueryCombinationConditionChildren> queryCombinationConditionChildrenList) {
        this.queryCombinationConditionChildrenList = queryCombinationConditionChildrenList;
    }
}
