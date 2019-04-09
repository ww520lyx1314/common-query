package com.tfkj.common.domain;

import java.util.List;

/***
*@Description: 对模板条件生成的sql以及参数的封装
*@param:
*@return:
*@author:xu.aichen
*@Date:2018/7/11
*/
public class CarderPersonSearhParam<T> extends BaseEntity<T> {
    private T param;

    //截止时间 (不是查询条件，只是为计算年龄使用)
    private String untilEndDate;

    private String searchSql;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public String getSql() {
        return searchSql;
    }

    public void setSql(String searchSql) {
        this.searchSql = searchSql;
    }

    //需要一个 sql 站位符
    private String[] sqlPlaceholder;


    /*private String ageJsonStr="[{enname:1,chname:'35岁及以下'},{enname:2,chname:'36-40岁'},{enname:3,chname:'41-45岁'}" +
            ",{enname:4,chname:'46-50岁'},{enname:5,chname:'51-55岁'},{enname:6,chname:'56-59岁'},{enname:7,chname:'60岁以上'}]";*/


    //查询条件 (等于相关)
    public List<Condition> conditionEqList;

    /*public List<Dict> getAge() {
        List<Dict> ageList= JSONArray.parseArray(ageJsonStr, Dict.class);
        return ageList;
    }*/


    public List<Condition> getConditionEqList() {
        Condition condition = new Condition();
        return condition.getConditionByEq();
    }

    public void setConditionEqList(List<Condition> conditionEqList) {
        this.conditionEqList = conditionEqList;
    }

    @Override
    public void preInsert() {

    }

    @Override
    public void preUpdate() {

    }

    public String getUntilEndDate() {
        return untilEndDate;
    }

    public void setUntilEndDate(String untilEndDate) {
        this.untilEndDate = untilEndDate;
    }
}
