package com.tfkj.common.domain;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/***
*@Description: sql表达式工具
*@param:
*@return:
*@author:xu.aichen
*@Date:2018/7/12
*/
public class Condition {

    //前端显示用的 name
    private String name;

    //前端显示 value
    private String value;

    private static final String REGEXPARAM = "#\\{[a-zA-Z0-9\\[.*\\]_]*\\}";
    private List<Object> valuesArrays	= new LinkedList<Object>();
    private List<Where> wheres	= new LinkedList<Where>();
    private Map<String, Object> values			= new HashMap<String, Object>();
    private List<Object> conds			= new LinkedList<Object>();
    private List<String> condStrings		= new LinkedList<String>();

    public static enum Codemun{
        EQ("=","EQ","等于"),LIKE("like","LIKE","包含"),LLIKE("like","LLIKE","左包含"),RLIKE("like","RLIKE","右包含"),NLIKE("not like","NOTLIKE","不包含"),NEQ("!=","NEQ","不等于"),GT(">","GT","大于"),LT("<","LT","小于"),GTE(">=","GTE","大于等于"),LTE("<=","LTE","小于等于"),
        BETWEEN_AND("between","BETWEEN","区间"),NOT_BETWEEN_AND("not between","NOT BETWEEN","不在区间"),IN("in","IN","在"),NOTIN("not in","NOT IN","不在"),
//        EXISTS("exists","EXISTS","是否存在"),
        AND("and","AND","and"), OR("or","OR","or");
        private String sqle;
        private String en;
        private String showEn;

        Codemun(String sqle, String en, String showEn) {
            this.sqle = sqle;
            this.en = en;
            this.showEn = showEn;
        }

        public String getShowEn() {
            return showEn;
        }

        public void setShowEn(String showEn) {
            this.showEn = showEn;
        }

        public String getSqle() {
            return sqle;
        }

        public void setSqle(String sqle) {
            this.sqle = sqle;
        }

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        @Override
		public String toString() {
			return this.sqle;
		}
    }

    //返回一组 包含 等于相关的 集合  目前是写在了程序里 以后可能是去数据库中取
    public List<Condition> getConditionByEq(){
        List<Condition> conditionList = new ArrayList<>();
        Condition condition = new Condition();
        condition.setName("等于");
        condition.setValue(Codemun.EQ.getEn());
        conditionList.add(condition);
        condition = new Condition();
        condition.setName("不等于");
        condition.setValue(Codemun.NEQ.getEn());
        conditionList.add(condition);
        condition = new Condition();
        condition.setName("大于");
        condition.setValue(Codemun.GT.getEn());
        conditionList.add(condition);
        condition = new Condition();
        condition.setName("小于");
        condition.setValue(Codemun.LT.getEn());
        conditionList.add(condition);
        condition = new Condition();
        condition.setName("大等于");
        condition.setValue(Codemun.GTE.getEn());
        conditionList.add(condition);
        condition = new Condition();
        condition.setName("小等于");
        condition.setValue(Codemun.LTE.getEn());
        conditionList.add(condition);
        return conditionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Condition exists(String existsSql, Map<String,Object> value) {
        if (!StringUtils.isEmpty(existsSql) && value != null) {
//            Where where = new Where();
//            where.setColumnName(column);
//            where.setOperation(Condition.Codemun.EQ);
//            where.addVals(value);
//            this.wheres.add(where);
            StringBuilder sb = new StringBuilder();
            sb.append(existsSql);
//            this.valuesArrays.add(value);
            this.values.putAll(value);
            this.conds.add(sb.toString());
//            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, value.toString()));
        }
        return this;
    }


    //拼接sql的工具
    public Condition eq(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.EQ);
            where.addVals(value);
            this.wheres.add(where);
            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.EQ);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i).replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column+i).replace("$",""), value);
            this.conds.add(sb.toString());
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, value.toString()));
        }
        return this;
    }
    public Condition neq(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.NEQ);
            where.addVals(value);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.NEQ);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i).replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column+i).replace("$",""), value);
            this.conds.add(sb.toString());
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, value.toString()));
        }
        return this;
    }


    public Condition gt(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.GT);
            where.addVals(value);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.GT);
            sb.append(" ");
            sb.append("#");
            sb.append("{");
            sb.append((column+i+"gt").replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column+i+"gt").replace("$",""), value);
            this.conds.add(sb.toString());
            String valueStr = "";
            if (value instanceof String) {
                valueStr = "'" + value.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, valueStr));
        }
        return this;
    }

    public Condition lt(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.LT);
            where.addVals(value);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.LT);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i+"lt").replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column+i+"lt").replace("$",""), value);
            this.conds.add(sb.toString());
            String valueStr = "";
            if (value instanceof String) {
                valueStr = "'" + value.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, valueStr));
        }
        return this;
    }

    public Condition ge(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.GTE);
            where.addVals(value);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.GTE);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i+"gte").replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column+i+"gte").replace("$",""), value);
            this.conds.add(sb.toString());
            String valueStr = "";
            if (value instanceof String) {
                valueStr = "'" + value.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, valueStr));
        }
        return this;
    }

    public Condition le(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.LTE);
            where.addVals(value);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.LTE);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i+"lte").replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column+i+"lte").replace("$",""), value);
            this.conds.add(sb.toString());
            String valueStr = "";
            if (value instanceof String) {
                valueStr = "'" + value.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, valueStr));
        }
        return this;
    }

    public Condition like(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.LIKE);
            where.addVals(value);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.LIKE);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column.replace(".","")+i).replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column.replace(".","")+i).replace("$",""), value);
            this.conds.add(sb.toString());
            String valueStr = "";
            if (value instanceof String) {
                valueStr = "'" + value.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, valueStr));
        }
        return this;
    }

    public Condition notLike(String column, Object value, int i) {
        if (!StringUtils.isEmpty(column) && value != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.NLIKE);
            where.addVals(value);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.NLIKE);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i).replace("$",""));
            sb.append("}");
            this.valuesArrays.add(value);
            this.values.put((column+i).replace("$",""), value);
            this.conds.add(sb.toString());
            String valueStr = "";
            if (value instanceof String) {
                valueStr = "'" + value.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceAll(REGEXPARAM, valueStr));
        }
        return this;
    }

    public Condition in(String column, int b, Object... values) {
        if (!StringUtils.isEmpty(column) && values != null && values.length > 0) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.IN);
            where.addVals(values);
            this.wheres.add(where);

            StringBuilder sbs = new StringBuilder();
            sbs.append(column);
            sbs.append(" ");
            sbs.append(Codemun.IN);
            sbs.append(" ");
            sbs.append("(");
            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.IN);
            sb.append(" ");
            sb.append("(");
            int i = 0;
            for (Object value : values) {
                sbs.append(value.toString());
                sbs.append(",");
//				sb.append("?");
                sb.append("#");
                sb.append("{");
                sb.append((column+b+"_"+i).replace("$",""));
                sb.append("}");
                sb.append(",");
                this.valuesArrays.add(value);
                this.values.put((column+b+"_"+i).replace("$",""), value);
                i++;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            sbs.deleteCharAt(sbs.length() - 1);
            sbs.append(")");
            this.conds.add(sb.toString());
            this.condStrings.add(sbs.toString());
        }
        return this;
    }

    public Condition notIn(String column, int b, Object... values) {
        if (!StringUtils.isEmpty(column) && values != null && values.length > 0) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.NOTIN);
            where.addVals(values);
            this.wheres.add(where);

            StringBuilder sbs = new StringBuilder();
            sbs.append(column);
            sbs.append(" ");
            sbs.append(Codemun.NOTIN);
            sbs.append(" ");
            sbs.append("(");
            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.NOTIN);
            sb.append(" ");
            sb.append("(");
            int i = 0;
            for (Object value : values) {
                sbs.append(value.toString());
                sbs.append(",");
//				sb.append("?");
                sb.append("#");
                sb.append("{");
                sb.append((column+b+"_"+i).replace("$",""));
                sb.append("}");
                sb.append(",");
                this.valuesArrays.add(value);
                this.values.put((column+b+"_"+i).replace("$",""), value);
                i++;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
//			this.values.put(column, values);
            this.conds.add(sb.toString());
            this.condStrings.add(sbs.toString());
        }
        return this;
    }

    public Condition between(String column, int i, Object value1, Object value2) {
        if (!StringUtils.isEmpty(column) && value1 != null && value2 != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.BETWEEN_AND);
            where.addVals(value1, value2);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.BETWEEN_AND);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i+"_1").replace("$",""));
            sb.append("}");
            sb.append(" AND ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i+"_2").replace("$",""));
            sb.append("}");

            this.valuesArrays.add(value1);
            this.valuesArrays.add(value2);
            this.values.put((column+i +"_1").replace("$",""), value1);
            this.values.put((column+i+"_2").replace("$",""), value2);
            this.conds.add(sb.toString());
            String value1Str = "";
            String value2Str = "";
            if (value1 instanceof String) {
                value1Str = "'" + value1.toString() + "'";
            }
            if (value2 instanceof String) {
                value2Str = "'" + value2.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceFirst(REGEXPARAM, value1Str));
            this.condStrings.add(sb.toString().replaceFirst(REGEXPARAM, value2Str));
        }
        return this;
    }

    public Condition notBetween(String column, int i, Object value1, Object value2) {
        if (!StringUtils.isEmpty(column) && value1 != null && value2 != null) {
            Where where = new Where();
            where.setColumnName(column);
            where.setOperation(Codemun.NOT_BETWEEN_AND);
            where.addVals(value1, value2);
            this.wheres.add(where);

            StringBuilder sb = new StringBuilder();
            sb.append(column);
            sb.append(" ");
            sb.append(Codemun.NOT_BETWEEN_AND);
            sb.append(" ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i).replace("$",""));
            sb.append("}");
            sb.append(" AND ");
//			sb.append("?");
            sb.append("#");
            sb.append("{");
            sb.append((column+i).replace("$",""));
            sb.append("}");

            this.valuesArrays.add(value1);
            this.valuesArrays.add(value2);
            this.values.put((column+i).replace("$",""), new Object[] { value1, value2 });
            this.conds.add(sb.toString());
            String value1Str = "";
            String value2Str = "";
            if (value1 instanceof String) {
                value1Str = "'" + value1.toString() + "'";
            }
            if (value2 instanceof String) {
                value2Str = "'" + value2.toString() + "'";
            }
            this.condStrings.add(sb.toString().replaceFirst(REGEXPARAM, value1Str));
            this.condStrings.add(sb.toString().replaceFirst(REGEXPARAM, value2Str));
        }
        return this;
    }

    public Condition and() {
        Where where = new Where();
        where.setOperation(Codemun.AND);
        this.wheres.add(where);

        this.conds.add(" AND ");
        this.condStrings.add(" AND ");
        return this;
    }

    public Condition or() {
        Where where = new Where();
        where.setOperation(Codemun.OR);
        this.wheres.add(where);

        this.conds.add(" OR ");
        this.condStrings.add(" OR ");
        return this;
    }

    public String toWhereSql() {
        if (CollectionUtils.isEmpty(conds)) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            if (!CollectionUtils.isEmpty(conds)) {
                for (Object cond : conds) {
                    sb.append(cond);
                    sb.append(" ");
                }
            }

            return sb.toString();
        }
    }

    public String toWhereString() {
        if (CollectionUtils.isEmpty(condStrings)) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            if (!CollectionUtils.isEmpty(condStrings)) {
                for (Object cond : condStrings) {
                    sb.append(cond);
                    sb.append(" ");
                }
            }

            return sb.toString();
        }
    }

    public Map<String, Object> getValues() {
		return this.values;
	}

    public List<Object> getValuesArray() {
		return this.valuesArrays;
	}

    public Condition leftKuo() {
        /*Where where = new Where();
        where.setOperation(Codemun.AND);
        this.wheres.add(where);*/

        this.conds.add(" ( ");
        this.condStrings.add(" ( ");
        return this;
    }

    public Condition rightKuo() {
        /*Where where = new Where();
        where.setOperation(Codemun.AND);
        this.wheres.add(where);*/

        this.conds.add(" ) ");
        this.condStrings.add(" ) ");
        return this;
    }


    public Condition preAppend(String sql){
        this.conds.add(sql);
        this.condStrings.add(sql);
        return this;
    }
}
