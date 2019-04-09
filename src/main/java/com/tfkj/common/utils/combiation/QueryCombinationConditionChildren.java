package com.tfkj.common.utils.combiation;

/***
*@Description:固定条件查询的子表
*@param:
*@return:
*@author:xu.aichen
*@Date:2018/7/16
*/
public class QueryCombinationConditionChildren {
    private String enname;
    private String chname;
    private String type;
    private String value1;
    private String value2;
    private String logicalJoin;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getLogicalJoin() {
        return logicalJoin;
    }

    public void setLogicalJoin(String logicalJoin) {
        this.logicalJoin = logicalJoin;
    }
}
