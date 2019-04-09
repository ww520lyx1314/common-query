package com.tfkj.common.utils.combiation;
import com.tfkj.common.domain.Condition;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/***
*@Description: 用户常用组合查询的注解 此注解用于字段上
*@param:
*@return:
*@author:xu.aichen
*@Date:2018/7/16
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Component
public @interface MyCondition {

   String endKuo() default ""; //用于封口使用
   String preKuo() default ""; //是否包含前置括号
   String afterKuo() default ""; //是否包含后置括号
   //一下两个属性没有实现
   String orRely() default ""; //是否依赖其他属性组成or逻辑关系
   String andRely() default "";//是否依赖其他属性组成and逻辑关系

   String column() default ""; //默认的列名
   boolean logicByObject() default false; //是否只是使用对象中的属性作为逻辑拼接
   String logicName()  default "";//如果logicByObject 是 true的话 取此字符串对应的字段的数据
   String preAppend() default ""; //如果标记此注解的属性存在值，此致为此条sql拼接是的前置条件 写死的sql
   Condition.Codemun preAppendCode() default Condition.Codemun.AND;//前置条件的拼接 与 传入的条件之间的拼接方式
   Condition.Codemun searchCode() default Condition.Codemun.EQ;//查询方式
   String transitionCode() default "";//传入值是否是需要查询对应条件表


}
