

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for query_custom_condition
-- ----------------------------
DROP TABLE IF EXISTS `query_custom_condition`;
CREATE TABLE `query_custom_condition` (
  `id` varchar(255) NOT NULL,
  `key` varchar(255) NOT NULL COMMENT '表名或者字段名',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `parentKey` varchar(255) DEFAULT NULL COMMENT '父级 表名',
  `code` varchar(255) DEFAULT NULL COMMENT '代码',
  `dataType` varchar(20) DEFAULT NULL COMMENT '数据类型：DATE、STRING、INT、SELECT',
  `dataRef` varchar(255) DEFAULT NULL COMMENT '运算符:=、!=、>=、<=、LIKE、NOT_LIKE、BETWEEN_AND',
  `sort_id` int(8) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查询分析-自定义查询-条件组合';

-- ----------------------------
-- Records of query_custom_condition
-- ----------------------------
INSERT INTO `query_custom_condition` VALUES ('0259aaebc7e54eb68c5c9b079966c155', 'parent', '菜单管理', '0', null, null, null, '36', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('054e728002b04d4daec6ec3e9f1c9ef5', 'sys_menu.gmt_create', '创建时间', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '45', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('0a5a222edeef421a882349b544930660', 'sys_role.role_name', '角色名称', '29445fd2e06a45e9a7ea7ead9b825c4e', null, 'text', 'LIKE,NOTLIKE', '26', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('0b52b77901dd43acab8656edaf293791', 'sys_menu.type', '类型   0：目录   1：菜单   2：按钮', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '42', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('0cf9f3b363ea4238817673c564823982', 'sys_user.user_id', 'user_id', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '1', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('0e83c7ec12354b0db1e309178cb885d3', 'sys_user.hobby', '爱好', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '16', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('0fa29c546f78495aae3cfa71b046a61a', 'sys_user.password', '密码', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '4', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('17ad5ccf34e74c028ecfc4e56c838c48', 'sys_role.gmt_modified', '创建时间', '29445fd2e06a45e9a7ea7ead9b825c4e', null, 'text', 'LIKE,NOTLIKE', '31', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('19b5230d30204ad8b45e41eee0b8f347', 'parent', 'sys_user', '0', null, null, null, '0', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('1c717d8624d744dfaad3d45fc4cb64fe', 'sys_user.dept_id', 'dept_id', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '5', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('1c851cae77214427b7c83e365d0c1b31', 'sys_user_role.role_id', '角色ID', '91cf60b0a4f848f790fe50ceb8e539cc', null, 'text', 'LIKE,NOTLIKE', '23', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('1f7a50cb1bc446d39276a2cb4a04ed54', 'sys_user_role.user_id', '用户ID', '91cf60b0a4f848f790fe50ceb8e539cc', null, 'text', 'LIKE,NOTLIKE', '22', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('24218b4a52ae4b92b56d7c878ca0f74a', 'sys_user.email', '邮箱', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '6', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('29445fd2e06a45e9a7ea7ead9b825c4e', 'parent', '角色', '0', null, null, null, '24', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('2d54c051fa2b42c989d2084184632090', 'sys_user_role.id', 'id', '91cf60b0a4f848f790fe50ceb8e539cc', null, 'text', 'LIKE,NOTLIKE', '21', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('311cbcb477c748d3be3e6efc14087477', 'sys_menu.menu_id', 'menu_id', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '37', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('332569800c4745bca70f100f13bc1f84', 'sys_menu.order_num', '排序', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '44', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('344e4e5808164243a9bdf1e7a4075790', 'sys_user.mobile', '手机号', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '7', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('3709306c594d486ca702d24861510e9c', 'sys_role_menu.menu_id', '菜单ID', 'd35cf731dcc04f44a5286571e3e56dea', null, 'text', 'LIKE,NOTLIKE', '35', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('37fdaca5ada44ccaad058d0c837f7168', 'sys_menu.perms', '授权(多个用逗号分隔，如：user:list,user:create)', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '41', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('39d7b569a6e24eeb80c735ef155bb832', 'sys_menu.icon', '菜单图标', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '43', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('47c48b4d093a4fab9dd7804a22541184', 'sys_user.name', 'name', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '3', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('4f5b37a61d0b41abb867eb526ee6d9b8', 'sys_user.city', '所在城市', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '18', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('559a8240d4304cee84f8c7e1a743a86f', 'sys_user.province', '省份', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '17', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('5978735aa4c643cd90b6f5566e49017c', 'sys_role_menu.role_id', '角色ID', 'd35cf731dcc04f44a5286571e3e56dea', null, 'text', 'LIKE,NOTLIKE', '34', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('604f4d440c974015b3829da27fed01ca', 'sys_role.gmt_create', '创建时间', '29445fd2e06a45e9a7ea7ead9b825c4e', null, 'text', 'LIKE,NOTLIKE', '30', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('675cd2db99aa44dfa6036fcf5ea6e8f9', 'sys_user.gmt_modified', '修改时间', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '11', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('6fe686b2689b4f728b557efa1241580b', 'sys_user.sex', '性别', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '12', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('709fcd7a3c9d4f58b7e11a59d2e149b1', 'sys_role.remark', '备注', '29445fd2e06a45e9a7ea7ead9b825c4e', null, 'text', 'LIKE,NOTLIKE', '28', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('79cc06c1757f477481c25cf0bab69290', 'sys_menu.name', '菜单名称', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '39', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('7a7f5cc149c34aa99d5f5cea8ea63cb8', 'sys_user.live_address', '现居住地', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '15', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('7f1d2d7f7ce949a7a5f7149875d5e545', 'sys_user.status', '状态 0:禁用，1:正常', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '8', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('89bdece12d994975bfd48e96a597b265', 'sys_menu.parent_id', '父菜单ID，一级菜单为0', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '38', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('91cf60b0a4f848f790fe50ceb8e539cc', 'parent', '用户与角色对应关系', '0', null, null, null, '20', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('95f3fe864bfb408986580c214bc53067', 'sys_user.gmt_create', '创建时间', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '10', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('9da06f5f42b04506bcfd1f47405188fa', 'sys_role.user_id_create', '创建用户id', '29445fd2e06a45e9a7ea7ead9b825c4e', null, 'text', 'LIKE,NOTLIKE', '29', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('aa24386ef77a42dea44a24266380ae9e', 'sys_menu.url', '菜单URL', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '40', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('aaf09aca051847db8d7175c78a85e2b5', 'sys_role.role_id', 'role_id', '29445fd2e06a45e9a7ea7ead9b825c4e', null, 'text', 'LIKE,NOTLIKE', '25', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('b640447c64754889b6dd331e3299b8fb', 'sys_role.role_sign', '角色标识', '29445fd2e06a45e9a7ea7ead9b825c4e', null, 'text', 'LIKE,NOTLIKE', '27', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('cca9d81957e140398d8292097319e246', 'sys_user.username', '用户名', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '2', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('ce86ff689d614c4f9b675e03c4a90518', 'sys_user.birth', '出身日期', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '13', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('d1818938d7b24f83a25efcfd999d2bd2', 'sys_role_menu.id', 'id', 'd35cf731dcc04f44a5286571e3e56dea', null, 'text', 'LIKE,NOTLIKE', '33', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('d35cf731dcc04f44a5286571e3e56dea', 'parent', '角色与菜单对应关系', '0', null, null, null, '32', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('de8d1d91c7254420afed0c1b0dde0a65', 'sys_user.pic_id', 'pic_id', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '14', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('e44c99d146d949edb6e71a74e38b92d4', 'sys_user.user_id_create', '创建用户id', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '9', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('e61229e04f2744d6bd781812e662d7f0', 'sys_menu.gmt_modified', '修改时间', '0259aaebc7e54eb68c5c9b079966c155', null, 'text', 'LIKE,NOTLIKE', '46', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');
INSERT INTO `query_custom_condition` VALUES ('f87d5c4903ff4a4eaf18c232cc8f8117', 'sys_user.district', '所在地区', '19b5230d30204ad8b45e41eee0b8f347', null, 'text', 'LIKE,NOTLIKE', '19', null, '2019-04-09 13:53:01', null, '2019-04-09 13:53:01', null, '0');

-- ----------------------------
-- Table structure for query_custom_detial
-- ----------------------------
DROP TABLE IF EXISTS `query_custom_detial`;
CREATE TABLE `query_custom_detial` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `tmplId` varchar(64) NOT NULL DEFAULT '' COMMENT '模板表的id',
  `coidId` varchar(64) NOT NULL DEFAULT '' COMMENT '自定义条件中的id',
  `fieldName` varchar(50) DEFAULT NULL COMMENT '数据库字段名',
  `startFlag` varchar(10) DEFAULT NULL COMMENT '是否存在左括号',
  `fieldText` varchar(100) DEFAULT NULL COMMENT '字段对应中文',
  `dataRef` varchar(100) DEFAULT NULL COMMENT '所选查询条件 与程序中Condition类中枚举相关',
  `firstValue` varchar(100) DEFAULT NULL COMMENT '值1的值',
  `firstValue_dataType` varchar(45) DEFAULT NULL,
  `secondValue` varchar(100) DEFAULT NULL COMMENT '值2的值',
  `secondValue_dataType` varchar(45) DEFAULT NULL,
  `endflag` varchar(10) DEFAULT NULL COMMENT '是否存在右括号',
  `dmm` varchar(50) DEFAULT NULL COMMENT '如果有值 则对应码表中的数据',
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自定义查询-查询条件';

-- ----------------------------
-- Records of query_custom_detial
-- ----------------------------
INSERT INTO `query_custom_detial` VALUES ('ffc632965cbe4997a80b010463c17b1e', 'a790f786f4764d8487d7a0cf331818e9', 'cca9d81957e140398d8292097319e246', 'sys_user.username', '0', '用户名', 'LIKE', 'admin', 'text', null, 'text', '0', null, null, '2019-04-09 13:55:33', null, '2019-04-09 13:55:33', null, '0');

-- ----------------------------
-- Table structure for query_custom_tpl
-- ----------------------------
DROP TABLE IF EXISTS `query_custom_tpl`;
CREATE TABLE `query_custom_tpl` (
  `id` varchar(64) NOT NULL,
  `name` varchar(300) NOT NULL COMMENT '名称',
  `value` text COMMENT '条件',
  `sqlTxt` text COMMENT 'sql语句',
  `tables` text,
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `sort_id` int(8) DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  `type` char(1) DEFAULT '0' COMMENT '默认是0:在自定义条件树中 1:市管干部数下面的数据  2:县官干部下数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查询分析-自定义条件查询-模板';

-- ----------------------------
-- Records of query_custom_tpl
-- ----------------------------
INSERT INTO `query_custom_tpl` VALUES ('a790f786f4764d8487d7a0cf331818e9', '模板例子', '{\"sys_userusername1\":\"%admin%\"}', 'sys_user.username like #{sys_userusername1} ', 'sys_user LEFT JOIN sys_user_role on sys_user_role.user_id = sys_user.user_id LEFT JOIN sys_role on sys_role.role_id = sys_user_role.role_id LEFT JOIN sys_role_menu on sys_role_menu.role_id = sys_role.role_id LEFT JOIN sys_menu on sys_menu.menu_id = sys_role_menu.menu_id', null, null, null, '2019-04-09 13:55:33', null, '2019-04-09 13:55:33', null, '0', '0');

-- ----------------------------
-- Table structure for query_table
-- ----------------------------
DROP TABLE IF EXISTS `query_table`;
CREATE TABLE `query_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `table_name` varchar(255) DEFAULT NULL COMMENT '表名',
  `table_nameText` varchar(255) DEFAULT NULL,
  `table_keyColumn` varchar(255) DEFAULT NULL COMMENT '表关键字',
  `table_otherKeyColumn` varchar(255) DEFAULT NULL COMMENT '关联表外键',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `sort_id` int(8) DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=328 DEFAULT CHARSET=utf8 COMMENT='查询分析-待查询表';

-- ----------------------------
-- Records of query_table
-- ----------------------------
INSERT INTO `query_table` VALUES ('323', 'sys_user', '', null, null, null, null, null, null, null, null, null);
INSERT INTO `query_table` VALUES ('324', 'sys_user_role', '用户与角色对应关系', 'sys_user_role-user_id', 'sys_user-user_id', null, null, null, null, null, null, null);
INSERT INTO `query_table` VALUES ('325', 'sys_role', '角色', 'sys_role-role_id', 'sys_user_role-role_id', null, null, null, null, null, null, null);
INSERT INTO `query_table` VALUES ('326', 'sys_role_menu', '角色与菜单对应关系', 'sys_role_menu-role_id', 'sys_role-role_id', null, null, null, null, null, null, null);
INSERT INTO `query_table` VALUES ('327', 'sys_menu', '菜单管理', 'sys_menu-menu_id', 'sys_role_menu-menu_id', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '标签名',
  `value` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '数据值',
  `type` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `sort` decimal(10,0) DEFAULT NULL COMMENT '排序（升序）',
  `parent_id` bigint(64) DEFAULT '0' COMMENT '父级编号',
  `create_by` int(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`) USING BTREE,
  KEY `sys_dict_label` (`name`) USING BTREE,
  KEY `sys_dict_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=390 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '正常', '0', 'del_flag', '删除标记', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('3', '显示', '1', 'show_hide', '显示/隐藏', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('4', '隐藏', '0', 'show_hide', '显示/隐藏', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('5', '是', '1', 'yes_no', '是/否', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('6', '否', '0', 'yes_no', '是/否', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('7', '红色', 'red', 'color', '颜色值', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('8', '绿色', 'green', 'color', '颜色值', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('9', '蓝色', 'blue', 'color', '颜色值', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('10', '黄色', 'yellow', 'color', '颜色值', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('11', '橙色', 'orange', 'color', '颜色值', '50', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('12', '默认主题', 'default', 'theme', '主题方案', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('13', '天蓝主题', 'cerulean', 'theme', '主题方案', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('14', '橙色主题', 'readable', 'theme', '主题方案', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('15', '红色主题', 'united', 'theme', '主题方案', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('16', 'Flat主题', 'flat', 'theme', '主题方案', '60', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('17', '国家', '1', 'sys_area_type', '区域类型', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('18', '省份、直辖市', '2', 'sys_area_type', '区域类型', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('19', '地市', '3', 'sys_area_type', '区域类型', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('20', '区县', '4', 'sys_area_type', '区域类型', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('21', '公司', '1', 'sys_office_type', '机构类型', '60', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('22', '部门', '2', 'sys_office_type', '机构类型', '70', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('23', '小组', '3', 'sys_office_type', '机构类型', '80', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('24', '其它', '4', 'sys_office_type', '机构类型', '90', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('25', '综合部', '1', 'sys_office_common', '快捷通用部门', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('26', '开发部', '2', 'sys_office_common', '快捷通用部门', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('27', '人力部', '3', 'sys_office_common', '快捷通用部门', '50', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('28', '一级', '1', 'sys_office_grade', '机构等级', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('29', '二级', '2', 'sys_office_grade', '机构等级', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('30', '三级', '3', 'sys_office_grade', '机构等级', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('31', '四级', '4', 'sys_office_grade', '机构等级', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('32', '所有数据', '1', 'sys_data_scope', '数据范围', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('33', '所在公司及以下数据', '2', 'sys_data_scope', '数据范围', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('34', '所在公司数据', '3', 'sys_data_scope', '数据范围', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('35', '所在部门及以下数据', '4', 'sys_data_scope', '数据范围', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('36', '所在部门数据', '5', 'sys_data_scope', '数据范围', '50', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('37', '仅本人数据', '8', 'sys_data_scope', '数据范围', '90', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('38', '按明细设置', '9', 'sys_data_scope', '数据范围', '100', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('39', '系统管理', '1', 'sys_user_type', '用户类型', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('40', '部门经理', '2', 'sys_user_type', '用户类型', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('41', '普通用户', '3', 'sys_user_type', '用户类型', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('42', '基础主题', 'basic', 'cms_theme', '站点主题', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('43', '蓝色主题', 'blue', 'cms_theme', '站点主题', '20', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('44', '红色主题', 'red', 'cms_theme', '站点主题', '30', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('45', '文章模型', 'article', 'cms_module', '栏目模型', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('46', '图片模型', 'picture', 'cms_module', '栏目模型', '20', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('47', '下载模型', 'download', 'cms_module', '栏目模型', '30', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('48', '链接模型', 'link', 'cms_module', '栏目模型', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('49', '专题模型', 'special', 'cms_module', '栏目模型', '50', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('50', '默认展现方式', '0', 'cms_show_modes', '展现方式', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('51', '首栏目内容列表', '1', 'cms_show_modes', '展现方式', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('52', '栏目第一条内容', '2', 'cms_show_modes', '展现方式', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('53', '发布', '0', 'cms_del_flag', '内容状态', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('54', '删除', '1', 'cms_del_flag', '内容状态', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('55', '审核', '2', 'cms_del_flag', '内容状态', '15', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('56', '首页焦点图', '1', 'cms_posid', '推荐位', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('57', '栏目页文章推荐', '2', 'cms_posid', '推荐位', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('58', '咨询', '1', 'cms_guestbook', '留言板分类', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('59', '建议', '2', 'cms_guestbook', '留言板分类', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('60', '投诉', '3', 'cms_guestbook', '留言板分类', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('61', '其它', '4', 'cms_guestbook', '留言板分类', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('62', '公休', '1', 'oa_leave_type', '请假类型', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('63', '病假', '2', 'oa_leave_type', '请假类型', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('64', '事假', '3', 'oa_leave_type', '请假类型', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('65', '调休', '4', 'oa_leave_type', '请假类型', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('66', '婚假', '5', 'oa_leave_type', '请假类型', '60', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('67', '接入日志', '1', 'sys_log_type', '日志类型', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('68', '异常日志', '2', 'sys_log_type', '日志类型', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('69', '请假流程', 'leave', 'act_type', '流程类型', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('70', '审批测试流程', 'test_audit', 'act_type', '流程类型', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('71', '分类1', '1', 'act_category', '流程分类', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('72', '分类2', '2', 'act_category', '流程分类', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('73', '增删改查', 'crud', 'gen_category', '代码生成分类', '10', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('74', '增删改查（包含从表）', 'crud_many', 'gen_category', '代码生成分类', '20', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('75', '树结构', 'tree', 'gen_category', '代码生成分类', '30', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('76', '=', '=', 'gen_query_type', '查询方式', '10', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('77', '!=', '!=', 'gen_query_type', '查询方式', '20', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('78', '&gt;', '&gt;', 'gen_query_type', '查询方式', '30', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('79', '&lt;', '&lt;', 'gen_query_type', '查询方式', '40', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('80', 'Between', 'between', 'gen_query_type', '查询方式', '50', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('81', 'Like', 'like', 'gen_query_type', '查询方式', '60', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('82', 'Left Like', 'left_like', 'gen_query_type', '查询方式', '70', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('83', 'Right Like', 'right_like', 'gen_query_type', '查询方式', '80', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('84', '文本框', 'input', 'gen_show_type', '字段生成方案', '10', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('85', '文本域', 'textarea', 'gen_show_type', '字段生成方案', '20', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('86', '下拉框', 'select', 'gen_show_type', '字段生成方案', '30', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('87', '复选框', 'checkbox', 'gen_show_type', '字段生成方案', '40', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('88', '单选框', 'radiobox', 'gen_show_type', '字段生成方案', '50', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('89', '日期选择', 'dateselect', 'gen_show_type', '字段生成方案', '60', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('90', '人员选择', 'userselect', 'gen_show_type', '字段生成方案', '70', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('91', '部门选择', 'officeselect', 'gen_show_type', '字段生成方案', '80', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('92', '区域选择', 'areaselect', 'gen_show_type', '字段生成方案', '90', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('93', 'String', 'String', 'gen_java_type', 'Java类型', '10', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('94', 'Long', 'Long', 'gen_java_type', 'Java类型', '20', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('95', '仅持久层', 'dao', 'gen_category', '代码生成分类', '40', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('96', '男', '1', 'sex', '性别', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('97', '女', '2', 'sex', '性别', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('98', 'Integer', 'Integer', 'gen_java_type', 'Java类型', '30', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('99', 'Double', 'Double', 'gen_java_type', 'Java类型', '40', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('100', 'Date', 'java.util.Date', 'gen_java_type', 'Java类型', '50', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('104', 'Custom', 'Custom', 'gen_java_type', 'Java类型', '90', '0', '1', null, '1', null, '', '1');
INSERT INTO `sys_dict` VALUES ('105', '会议通告', '1', 'oa_notify_type', '通知通告类型', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('106', '奖惩通告', '2', 'oa_notify_type', '通知通告类型', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('107', '活动通告', '3', 'oa_notify_type', '通知通告类型', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('108', '草稿', '0', 'oa_notify_status', '通知通告状态', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('109', '发布', '1', 'oa_notify_status', '通知通告状态', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('110', '未读', '0', 'oa_notify_read', '通知通告状态', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('111', '已读', '1', 'oa_notify_read', '通知通告状态', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('112', '草稿', '0', 'oa_notify_status', '通知通告状态', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('113', '删除', '0', 'del_flag', '删除标记', null, null, null, null, null, null, '', '');
INSERT INTO `sys_dict` VALUES ('118', '关于', 'about', 'blog_type', '博客类型', null, null, null, null, null, null, '全url是:/blog/open/page/about', '');
INSERT INTO `sys_dict` VALUES ('119', '交流', 'communication', 'blog_type', '博客类型', null, null, null, null, null, null, '', '');
INSERT INTO `sys_dict` VALUES ('120', '文章', 'article', 'blog_type', '博客类型', null, null, null, null, null, null, '', '');
INSERT INTO `sys_dict` VALUES ('121', '编码', 'code', 'hobby', '爱好', null, null, null, null, null, null, '', '');
INSERT INTO `sys_dict` VALUES ('122', '绘画', 'painting', 'hobby', '爱好', null, null, null, null, null, null, '', '');
INSERT INTO `sys_dict` VALUES ('123', '中国农工民主党党员', '08', 'YW_ZZMM', '政治面貌', '46', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('124', '中国共产党预备党员', '02', 'YW_ZZMM', '政治面貌', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('125', '中国民主促进会会员', '07', 'YW_ZZMM', '政治面貌', '45', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('126', '中国共产党党员', '01', 'YW_ZZMM', '政治面貌', '39', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('127', '群众', '13', 'YW_ZZMM', '政治面貌', '51', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('128', '无党派民主人士', '12', 'YW_ZZMM', '政治面貌', '50', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('129', '中国共产主义青年团团员', '03', 'YW_ZZMM', '政治面貌', '41', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('130', '中国国民党革命委员会会员', '04', 'YW_ZZMM', '政治面貌', '42', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('131', '其他', '14', 'YW_ZZMM', '政治面貌', '52', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('132', '中国民主建国会会员', '06', 'YW_ZZMM', '政治面貌', '44', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('133', '台湾民主自治同盟盟员', '11', 'YW_ZZMM', '政治面貌', '49', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('134', '九三学社社员', '10', 'YW_ZZMM', '政治面貌', '48', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('135', '中国致公党党员', '09', 'YW_ZZMM', '政治面貌', '47', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('136', '中国民主同盟会会员', '05', 'YW_ZZMM', '政治面貌', '43', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('137', '喀麦隆', '120', 'GB2659', '国家', '26', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('138', '肯尼亚', '404', 'GB2659', '国家', '71', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('139', '圣多美和普林西比', '678', 'GB2659', '国家', '115', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('140', '加拿大', '124', 'GB2659', '国家', '27', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('141', '佛得角', '132', 'GB2659', '国家', '28', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('142', '中非', '140', 'GB2659', '国家', '29', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('143', '斯里兰卡', '144', 'GB2659', '国家', '30', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('144', '乍得', '148', 'GB2659', '国家', '31', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('145', '智利', '152', 'GB2659', '国家', '32', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('146', '中国', '156', 'GB2659', '国家', '0', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('147', '哥伦比亚', '170', 'GB2659', '国家', '34', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('148', '科摩罗', '174', 'GB2659', '国家', '35', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('149', '刚果', '178', 'GB2659', '国家', '36', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('150', '扎伊尔', '180', 'GB2659', '国家', '37', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('151', '古巴', '192', 'GB2659', '国家', '38', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('152', '塞浦路斯', '196', 'GB2659', '国家', '39', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('153', '贝宁', '204', 'GB2659', '国家', '40', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('154', '丹麦', '208', 'GB2659', '国家', '41', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('155', '厄瓜多尔', '218', 'GB2659', '国家', '42', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('156', '赤道几内亚', '226', 'GB2659', '国家', '43', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('157', '埃塞俄比亚', '230', 'GB2659', '国家', '44', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('158', '斐济', '242', 'GB2659', '国家', '45', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('159', '芬兰', '246', 'GB2659', '国家', '46', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('160', '法国', '250', 'GB2659', '国家', '47', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('161', '吉布提', '262', 'GB2659', '国家', '48', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('162', '加蓬', '266', 'GB2659', '国家', '49', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('163', '冈比亚', '270', 'GB2659', '国家', '50', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('164', '加纳', '288', 'GB2659', '国家', '51', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('165', '基里巴斯', '296', 'GB2659', '国家', '52', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('166', '希腊', '300', 'GB2659', '国家', '53', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('167', '格林纳达', '308', 'GB2659', '国家', '54', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('168', '几内亚', '324', 'GB2659', '国家', '55', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('169', '圭亚那', '328', 'GB2659', '国家', '56', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('170', '香港地区', '344', 'GB2659', '国家', '57', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('171', '匈牙利', '348', 'GB2659', '国家', '58', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('172', '冰岛', '352', 'GB2659', '国家', '59', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('173', '印度', '356', 'GB2659', '国家', '60', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('174', '印度尼西亚', '360', 'GB2659', '国家', '61', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('175', '伊朗', '364', 'GB2659', '国家', '62', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('176', '伊拉克', '368', 'GB2659', '国家', '63', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('177', '爱尔兰', '372', 'GB2659', '国家', '64', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('178', '巴勒斯坦', '374', 'GB2659', '国家', '65', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('179', '以色列', '376', 'GB2659', '国家', '66', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('180', '意大利', '380', 'GB2659', '国家', '67', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('181', '牙买加', '388', 'GB2659', '国家', '68', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('182', '日本', '392', 'GB2659', '国家', '69', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('183', '约旦', '400', 'GB2659', '国家', '70', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('184', '朝鲜', '408', 'GB2659', '国家', '72', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('185', '韩国', '410', 'GB2659', '国家', '73', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('186', '科威特', '414', 'GB2659', '国家', '74', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('187', '老挝', '418', 'GB2659', '国家', '75', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('188', '黎巴嫩', '422', 'GB2659', '国家', '76', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('189', '莱索托', '426', 'GB2659', '国家', '77', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('190', '利比里亚', '430', 'GB2659', '国家', '78', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('191', '利比亚', '434', 'GB2659', '国家', '79', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('192', '列支敦士登公国', '438', 'GB2659', '国家', '80', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('193', '卢森堡', '442', 'GB2659', '国家', '81', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('194', '澳门地区', '446', 'GB2659', '国家', '82', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('195', '马达加斯加', '450', 'GB2659', '国家', '83', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('196', '马来西亚', '458', 'GB2659', '国家', '84', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('197', '马尔代夫', '462', 'GB2659', '国家', '85', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('198', '马里', '466', 'GB2659', '国家', '86', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('199', '马耳他', '470', 'GB2659', '国家', '87', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('200', '毛里塔尼亚', '478', 'GB2659', '国家', '88', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('201', '毛里求斯', '480', 'GB2659', '国家', '89', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('202', '墨西哥', '484', 'GB2659', '国家', '90', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('203', '蒙古', '496', 'GB2659', '国家', '91', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('204', '摩洛哥', '504', 'GB2659', '国家', '92', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('205', '莫桑比克', '508', 'GB2659', '国家', '93', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('206', '阿曼', '512', 'GB2659', '国家', '94', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('207', '纳米比亚', '516', 'GB2659', '国家', '95', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('208', '尼泊尔', '524', 'GB2659', '国家', '96', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('209', '荷兰', '528', 'GB2659', '国家', '97', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('210', '瓦努阿图', '548', 'GB2659', '国家', '98', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('211', '新西兰', '554', 'GB2659', '国家', '99', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('212', '尼加拉瓜', '558', 'GB2659', '国家', '100', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('213', '尼日尔', '562', 'GB2659', '国家', '101', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('214', '尼日利亚', '566', 'GB2659', '国家', '102', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('215', '挪威', '578', 'GB2659', '国家', '103', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('216', '巴基斯坦', '586', 'GB2659', '国家', '104', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('217', '巴布亚新几内亚', '598', 'GB2659', '国家', '105', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('218', '秘鲁', '604', 'GB2659', '国家', '106', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('219', '菲律宾', '608', 'GB2659', '国家', '107', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('220', '波兰', '616', 'GB2659', '国家', '108', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('221', '葡萄牙', '620', 'GB2659', '国家', '109', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('222', '几内亚比绍', '624', 'GB2659', '国家', '110', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('223', '卡塔尔', '634', 'GB2659', '国家', '111', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('224', '罗马尼亚', '642', 'GB2659', '国家', '112', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('225', '卢旺达', '646', 'GB2659', '国家', '113', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('226', '圣马力诺', '674', 'GB2659', '国家', '114', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('227', '亚洲', '000', 'GB2659', '国家', '2', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('228', '阿富汗', '004', 'GB2659', '国家', '1', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('229', '阿尔巴尼亚', '008', 'GB2659', '国家', '3', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('230', '南极洲', '010', 'GB2659', '国家', '4', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('231', '阿尔及利亚', '012', 'GB2659', '国家', '5', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('232', '安道尔', '020', 'GB2659', '国家', '6', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('233', '安哥拉', '024', 'GB2659', '国家', '7', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('234', '安提瓜和巴布达', '028', 'GB2659', '国家', '8', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('235', '阿根廷', '032', 'GB2659', '国家', '9', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('236', '澳大利亚', '036', 'GB2659', '国家', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('237', '奥地利', '040', 'GB2659', '国家', '11', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('238', '巴林', '048', 'GB2659', '国家', '12', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('239', '孟加拉', '050', 'GB2659', '国家', '13', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('240', '巴巴多斯', '052', 'GB2659', '国家', '14', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('241', '比利时', '056', 'GB2659', '国家', '15', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('242', '玻利维亚', '068', 'GB2659', '国家', '16', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('243', '博茨瓦纳', '072', 'GB2659', '国家', '17', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('244', '巴西', '076', 'GB2659', '国家', '18', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('245', '伯利兹', '084', 'GB2659', '国家', '19', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('246', '文莱', '096', 'GB2659', '国家', '20', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('247', '保加利亚', '100', 'GB2659', '国家', '21', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('248', '缅甸', '104', 'GB2659', '国家', '22', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('249', '布隆迪', '108', 'GB2659', '国家', '23', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('250', '白俄罗斯', '112', 'GB2659', '国家', '24', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('251', '柬埔寨', '116', 'GB2659', '国家', '25', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('252', '沙特阿拉伯', '682', 'GB2659', '国家', '116', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('253', '塞内加尔', '686', 'GB2659', '国家', '117', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('254', '塞舌尔', '690', 'GB2659', '国家', '118', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('255', '塞拉利昂', '694', 'GB2659', '国家', '119', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('256', '新加坡', '702', 'GB2659', '国家', '120', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('257', '越南', '704', 'GB2659', '国家', '121', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('258', '索马里', '706', 'GB2659', '国家', '122', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('259', '津巴布韦', '716', 'GB2659', '国家', '123', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('260', '也门', '720', 'GB2659', '国家', '124', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('261', '西班牙', '724', 'GB2659', '国家', '125', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('262', '苏丹', '736', 'GB2659', '国家', '126', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('263', '苏里南', '740', 'GB2659', '国家', '127', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('264', '瑞典', '752', 'GB2659', '国家', '128', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('265', '瑞士', '756', 'GB2659', '国家', '129', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('266', '叙利亚', '760', 'GB2659', '国家', '130', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('267', '泰国', '764', 'GB2659', '国家', '131', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('268', '多哥', '768', 'GB2659', '国家', '132', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('269', '特立尼达和多巴哥', '780', 'GB2659', '国家', '133', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('270', '阿拉伯联合酋长国', '784', 'GB2659', '国家', '134', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('271', '突尼斯', '788', 'GB2659', '国家', '135', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('272', '土耳其', '792', 'GB2659', '国家', '136', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('273', '乌干达', '800', 'GB2659', '国家', '137', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('274', '乌克兰', '804', 'GB2659', '国家', '138', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('275', '埃及', '818', 'GB2659', '国家', '139', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('276', '英国', '826', 'GB2659', '国家', '140', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('277', '坦桑尼亚', '834', 'GB2659', '国家', '141', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('278', '美国', '840', 'GB2659', '国家', '142', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('279', '布基纳法索', '854', 'GB2659', '国家', '143', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('280', '乌拉圭东岸', '858', 'GB2659', '国家', '144', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('281', '委内瑞拉', '862', 'GB2659', '国家', '145', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('282', '西萨摩亚', '882', 'GB2659', '国家', '146', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('283', '南斯拉夫', '890', 'GB2659', '国家', '147', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('284', '赞比亚', '894', 'GB2659', '国家', '148', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('285', '俄罗斯', '896', 'GB2659', '国家', '149', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('286', '台湾地区', '898', 'GB2659', '国家', '150', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('287', '斯洛伐克', '902', 'GB2659', '国家', '151', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('288', '鄂温克族', '45', 'YW_MZ', '民族', '112', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('289', '哈尼族', '16', 'YW_MZ', '民族', '83', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('290', '侗族', '12', 'YW_MZ', '民族', '79', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('291', '哈萨克族', '17', 'YW_MZ', '民族', '84', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('292', '塔塔尔族', '50', 'YW_MZ', '民族', '117', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('293', '彝族', '07', 'YW_MZ', '民族', '74', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('294', '毛南族', '36', 'YW_MZ', '民族', '103', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('295', '塔吉克族', '41', 'YW_MZ', '民族', '108', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('296', '独龙族', '51', 'YW_MZ', '民族', '118', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('297', '仫佬族', '32', 'YW_MZ', '民族', '99', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('298', '赫哲族', '53', 'YW_MZ', '民族', '120', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('299', '汉族', '01', 'YW_MZ', '民族', '68', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('300', '纳西族', '27', 'YW_MZ', '民族', '94', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('301', '黎族', '19', 'YW_MZ', '民族', '86', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('302', '外国血统', '58', 'YW_MZ', '民族', '125', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('303', '白族', '14', 'YW_MZ', '民族', '81', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('304', '朝鲜族', '10', 'YW_MZ', '民族', '77', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('305', '门巴族', '54', 'YW_MZ', '民族', '121', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('306', '裕固族', '48', 'YW_MZ', '民族', '115', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('307', '高山族', '23', 'YW_MZ', '民族', '90', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('308', '俄罗斯族', '44', 'YW_MZ', '民族', '111', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('309', '苗族', '06', 'YW_MZ', '民族', '73', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('310', '羌族', '33', 'YW_MZ', '民族', '100', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('311', '珞巴族', '55', 'YW_MZ', '民族', '122', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('312', '乌孜别克族', '43', 'YW_MZ', '民族', '110', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('313', '维吾尔族', '05', 'YW_MZ', '民族', '72', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('314', '佤族', '21', 'YW_MZ', '民族', '88', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('315', '布依族', '09', 'YW_MZ', '民族', '76', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('316', '仡佬族', '37', 'YW_MZ', '民族', '104', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('317', '布朗族', '34', 'YW_MZ', '民族', '101', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('318', '回族', '03', 'YW_MZ', '民族', '70', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('319', '柯尔克孜族', '29', 'YW_MZ', '民族', '96', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('320', '土族', '30', 'YW_MZ', '民族', '97', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('321', '畲族', '22', 'YW_MZ', '民族', '89', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('322', '锡伯族', '38', 'YW_MZ', '民族', '105', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('323', '满族', '11', 'YW_MZ', '民族', '78', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('324', '傈僳族', '20', 'YW_MZ', '民族', '87', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('325', '拉祜族', '24', 'YW_MZ', '民族', '91', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('326', '傣族', '18', 'YW_MZ', '民族', '85', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('327', '其他族', '57', 'YW_MZ', '民族', '124', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('328', '藏族', '04', 'YW_MZ', '民族', '71', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('329', '阿昌族', '39', 'YW_MZ', '民族', '106', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('330', '基诺族', '56', 'YW_MZ', '民族', '123', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('331', '壮族', '08', 'YW_MZ', '民族', '75', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('332', '东乡族', '26', 'YW_MZ', '民族', '93', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('333', '保安族', '47', 'YW_MZ', '民族', '114', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('334', '水族', '25', 'YW_MZ', '民族', '92', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('335', '土家族', '15', 'YW_MZ', '民族', '82', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('336', '蒙古族', '02', 'YW_MZ', '民族', '69', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('337', '怒族', '42', 'YW_MZ', '民族', '109', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('338', '鄂伦春族', '52', 'YW_MZ', '民族', '119', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('339', '崩龙族', '46', 'YW_MZ', '民族', '113', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('340', '瑶族', '13', 'YW_MZ', '民族', '80', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('341', '景颇族', '28', 'YW_MZ', '民族', '95', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('342', '撒拉族', '35', 'YW_MZ', '民族', '102', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('343', '达斡尔族', '31', 'YW_MZ', '民族', '98', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('344', '外国民族', '59', 'YW_MZ', '民族', '126', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('345', '普米族', '40', 'YW_MZ', '民族', '107', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('346', '京族', '49', 'YW_MZ', '民族', '116', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('347', '核心', 'A', 'YW_SMDJ', '涉密等级', '1', null, null, null, null, null, '', null);
INSERT INTO `sys_dict` VALUES ('348', '重要', 'B', 'YW_SMDJ', '涉密等级', '2', null, null, null, null, null, '', null);
INSERT INTO `sys_dict` VALUES ('349', '一般', 'C', 'YW_SMDJ', '涉密等级', '3', null, null, null, null, null, '', null);
INSERT INTO `sys_dict` VALUES ('350', '因私护照', '1', 'YW_ZJLX', '证件类型', '1', null, null, null, null, null, null, '');
INSERT INTO `sys_dict` VALUES ('351', '港澳通行证', '2', 'YW_ZJLX', '证件类型', '1', null, null, null, null, null, null, '');
INSERT INTO `sys_dict` VALUES ('352', '台湾通行证', '3', 'YW_ZJLX', '证件类型', '1', null, null, null, null, null, null, '');
INSERT INTO `sys_dict` VALUES ('353', '组织机构保管', '1', 'YW_DQZT', '当前状态', '1', null, null, null, null, null, null, '');
INSERT INTO `sys_dict` VALUES ('354', '已作废', '2', 'YW_DQZT', '当前状态', '1', null, null, null, null, null, null, '');
INSERT INTO `sys_dict` VALUES ('355', '已借出', '3', 'YW_DQZT', '当前状态', '1', null, null, null, null, null, null, '');
INSERT INTO `sys_dict` VALUES ('356', '父亲', '1', 'YW_YBRGX', '与本人关系', '1', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('357', '母亲', '2', 'YW_YBRGX', '与本人关系', '2', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('358', '哥哥', '3', 'YW_YBRGX', '与本人关系', '3', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('359', '姐姐', '4', 'YW_YBRGX', '与本人关系', '4', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('360', '弟弟', '5', 'YW_YBRGX', '与本人关系', '5', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('361', '妹妹', '6', 'YW_YBRGX', '与本人关系', '6', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('362', '亲戚', '7', 'YW_YBRGX', '与本人关系', '7', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('363', '朋友', '8', 'YW_YBRGX', '与本人关系', '8', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('364', '是', '是', 'YW_SF', '是否', '1', null, null, null, null, null, '', null);
INSERT INTO `sys_dict` VALUES ('365', '否', '否', 'YW_SF', '是否', '2', null, null, null, null, null, '', null);
INSERT INTO `sys_dict` VALUES ('366', '核心', '1', 'YW_SMNX', '涉密年限', '1', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('367', '重要', '3', 'YW_SMNX', '涉密年限', '2', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('368', '一般', '5', 'YW_SMNX', '涉密年限', '3', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('371', '人民团体', 'A', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('372', '市委各工委保密办', 'B', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('373', '金融', 'C', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('374', '教育、卫生', 'D', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('375', '政法', 'E', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('376', '宣传', 'F', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('377', '部委、市直机关', 'G', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('378', '区县保密局', 'H', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('379', '国资', 'I', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('380', '规划建设交通', 'J', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('381', '商务', 'K', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('382', '科技', 'L', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('383', '统战', 'M', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('384', '农业', 'N', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('385', '军工单位名录-国有', 'O', 'sys_dept_type', '单位性质', '100', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('386', '孩子', '9', 'YW_YBRGX', '与本人关系', '6', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('387', '涉密期人员', '1', 'YW_SMZT', '涉密人员状态', '1', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('388', '脱密期人员', '2', 'YW_SMZT', '涉密人员状态', '2', '0', null, null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('389', '历史人员', '3', 'YW_SMZT', '涉密人员状态', '3', '0', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('3', '0', '系统设置', '', '', '0', 'fa fa-desktop', '3', '2017-08-09 23:06:55', '2017-08-14 14:13:43');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) DEFAULT NULL COMMENT '角色标识',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `user_id_create` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '填报员', 'admin', '拥有最高权限', '2', '2017-08-12 00:43:52', '2017-08-12 19:14:59');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4027 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('367', '1', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `dept_id` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(255) DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `user_id_create` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `sex` bigint(32) DEFAULT NULL COMMENT '性别',
  `birth` datetime DEFAULT NULL COMMENT '出身日期',
  `pic_id` bigint(32) DEFAULT NULL,
  `live_address` varchar(500) DEFAULT NULL COMMENT '现居住地',
  `hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  `province` varchar(255) DEFAULT NULL COMMENT '省份',
  `city` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `district` varchar(255) DEFAULT NULL COMMENT '所在地区',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '超级管理员', 'e4008ee7ccb631bf549ea7537b147172', '269e498f22e74e11a20929e5df5cf289', '', '', '1', null, '1900-01-01 00:00:00', '2019-02-20 16:54:11', null, '1900-01-01 00:00:00', null, '', '', '', '', '');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=653 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('73', '1', '1');

-- ----------------------------
-- Function structure for getAge
-- ----------------------------
DROP FUNCTION IF EXISTS `getAge`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `getAge`(startDate text,endDate text) RETURNS int(11)
begin
	DECLARE age INT(10);
	if startDate is null or startDate='' THEN SET age=0;END IF;
	IF endDate is null or endDate='' then SET endDate=NOW() ;END IF;
	IF LENGTH(startDate)<8 then SET startDate=CONCAT(startDate,'-1');END IF;
	IF LENGTH(endDate)<8 then SET endDate=CONCAT(endDate,'-1');END IF;
	SET age= YEAR(endDate)-(YEAR(startDate)+1) + ( DATE_FORMAT(startDate, '%m%d') <= DATE_FORMAT(endDate, '%m%d'));
	IF age<0 then set age=0;end IF;
	RETURN age;
end
;;
DELIMITER ;
