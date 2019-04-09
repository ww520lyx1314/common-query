
默认访问路径http://localhost:8080/cardreperson/queryCustomCondition/toCustomsearch

综合查询的功能：
1、实现多表左连接查询，可以自己灵活配置
2、实现多种条件复杂的组合查询
3、实现了灵活配置查询结果列
4、实现了查询结果统计图表的功能

采用的技术：
springboot+spring+mybatis

数据库：
mysql

备注：
1、多表连接采用左连接
2、默认查询条件格式为text文本格式、如果需要使用下拉选、时间请自行配置、配置逻辑如下
	query_custom_condition
	dataType 可以实现的类型有：select，date_month，text
	select： 	 code        下拉选dict表里面的type字段
				 dataType     select
				 dataRef      EQ,NEQ
	text：       dataType     text
				 dataRef      LIKE,NOTLIKE
date_month：     dataType     date_month
				 dataRef      EQ,GT,LT,GTE,LTE,BETWEEN
3、表字段设计最好不要出现重复的字段
   如 表1  id
      表2  id
	查询结果只能显示一个id值结果
	可以设计成
	  表1  表1_id
      表2  表2_id
