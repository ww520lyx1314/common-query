package com.tfkj.common.domain;

import com.tfkj.common.utils.StringUtils;

import java.util.List;
import java.util.Map;

/***
 *@Description: 用于固定条件和自定义查询模块使用工具
 *@param:
 *@return:
 *@author:xu.aichen
 *@Date:2018/7/11
 */
public class CardrePersonSearch {
    /**
     * 根据用户自定义的数据进行sql的拼接
     * @return
     */
    public static CarderPersonSearhParam<Map> customQuery2Sql(List<QueryCustomDetial> queryCustomDetials){
        CarderPersonSearhParam carderPersonSearhParam = new CarderPersonSearhParam();
        if(queryCustomDetials!=null&&queryCustomDetials.size()>0){
            Condition condition = new Condition();
            int i = 0 ;
            //循环所有的查询条件
            for(QueryCustomDetial queryCustomDetial : queryCustomDetials){
                i++;
                if((!StringUtils.isEmpty(queryCustomDetial.getFirstValue()))||(!StringUtils.isEmpty(queryCustomDetial.getSecondValue()))){
                    //判断当前条件是否存在左侧括号
                    if("1".equals(queryCustomDetial.getStartFlag())){
                        condition.leftKuo();
                    }
                    //处理中间数据
                    conditionByValue(queryCustomDetial.getDataref(),condition,queryCustomDetial.getFieldName(),i,
                            queryCustomDetial.getFirstValue(),queryCustomDetial.getSecondValue());

                    if("1".equals(queryCustomDetial.getEndFlag())){
                        condition.rightKuo();
                    }
                    if(i<queryCustomDetials.size()){
                        //逻辑向后
                        if("0".equals(queryCustomDetial.getRelation())){//为0 则是与
                            condition.and();
                        }else if("1".equals(queryCustomDetial.getRelation())){ //为1 则是或
                            condition.or();
                        }
                    }
                }
            }
            carderPersonSearhParam.setSql(condition.toWhereSql());
            carderPersonSearhParam.setParam(condition.getValues());
        }
        return carderPersonSearhParam;
    }


    //将值拼接成sql
    private static void conditionByValue(String dataref, Condition condition, String field, int index, Object... values){
        if(field.indexOf(",")>0){
            condition.leftKuo();
            String[] split = field.split(",");
            for(int i = 0 ; i < split.length ; i++){
                conditionByValue(dataref,condition,split[i],5000,values);
                if(i!=split.length-1){
                    condition.or();
                }
            }
            condition.rightKuo();
        }else{
            if(Condition.Codemun.EQ.getEn().equalsIgnoreCase(dataref)){
                condition.eq(field,values[0],index);
            }if(Condition.Codemun.NEQ.getEn().equalsIgnoreCase(dataref)){
                condition.neq(field,values[0],index);
                condition.and();
                condition.neq(field,"",5000+index);
            }else if(Condition.Codemun.LIKE.getEn().equalsIgnoreCase(dataref)){
                condition.like(field,"%"+values[0]+"%",index);
            }else if(Condition.Codemun.LLIKE.getEn().equalsIgnoreCase(dataref)){
                condition.like(field,values[0]+"%",index);
            }else if(Condition.Codemun.RLIKE.getEn().equalsIgnoreCase(dataref)){
                condition.like(field,"%"+values[0],index);
            }else if(Condition.Codemun.NLIKE.getEn().equalsIgnoreCase(dataref)){
                condition.notLike(field,"%"+values[0]+"%",index);
            }else if(Condition.Codemun.GT.getEn().equalsIgnoreCase(dataref)){
                condition.gt(field,values[0],index);
            }else if(Condition.Codemun.LT.getEn().equalsIgnoreCase(dataref)){
                condition.lt(field,values[0],index);
            }else if(Condition.Codemun.LTE.getEn().equalsIgnoreCase(dataref)){
                condition.le(field,values[0],index);
            }else if(Condition.Codemun.GTE.getEn().equalsIgnoreCase(dataref)){
                condition.ge(field,values[0],index);
            }else if(Condition.Codemun.BETWEEN_AND.getEn().equalsIgnoreCase(dataref)){
                condition.between(field,index,values[0],values[1]);
            }else if(Condition.Codemun.NOT_BETWEEN_AND.getEn().equalsIgnoreCase(dataref)){
                condition.notBetween(field,index,values[0],values[1]);
                condition.and();
                condition.neq(field,"",5000+index);
            }else if(Condition.Codemun.IN.getEn().equalsIgnoreCase(dataref)){
                condition.in(field,index,values);
            }else if(Condition.Codemun.NOTIN.getEn().equalsIgnoreCase(dataref)){
                condition.notIn(field,index,values);
                condition.and();
                condition.neq(field,"",5000+index);
            }
        }
    }
}
