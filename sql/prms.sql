/*
Navicat MySQL Data Transfer

Source Server         : zb
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : prms

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2016-08-22 17:41:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pms_menu`
-- ----------------------------
DROP TABLE IF EXISTS `pms_menu`;
CREATE TABLE `pms_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `creater` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `is_leaf` varchar(20) DEFAULT NULL,
  `level` smallint(6) DEFAULT NULL,
  `parent_id` bigint(20) NOT NULL,
  `target_name` varchar(100) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of pms_menu
-- ----------------------------
INSERT INTO `pms_menu` VALUES ('1', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'NO', '1', '0', '#', '001', '权限管理', '##');
INSERT INTO `pms_menu` VALUES ('2', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '1', 'cdgl', '00101', '菜单管理', 'pms/menu/list');
INSERT INTO `pms_menu` VALUES ('3', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '1', 'qxgl', '00102', '权限管理', 'pms/permission/list');
INSERT INTO `pms_menu` VALUES ('4', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '1', 'jsgl', '00103', '角色管理', 'pms/role/list');
INSERT INTO `pms_menu` VALUES ('5', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '1', 'czygl', '00104', '操作员管理', 'pms/operator/list');
INSERT INTO `pms_menu` VALUES ('10', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'NO', '1', '0', '#', '002', '账户管理', '##');
INSERT INTO `pms_menu` VALUES ('12', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '10', 'zhxx', '00201', '账户信息', 'account/list');
INSERT INTO `pms_menu` VALUES ('13', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '10', 'zhlsxx', '00202', '账户历史信息', 'account/historyList');
INSERT INTO `pms_menu` VALUES ('20', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'NO', '1', '0', '#', '003', '用户管理', '##');
INSERT INTO `pms_menu` VALUES ('22', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '20', 'yhxx', '00301', '用户信息', 'user/info/list');
INSERT INTO `pms_menu` VALUES ('30', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'NO', '1', '0', '#', '004', '支付管理', '##');
INSERT INTO `pms_menu` VALUES ('32', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '30', 'zfcpgl', '00401', '支付产品信息', 'pay/product/list');
INSERT INTO `pms_menu` VALUES ('33', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '30', 'yhzfpz', '00402', '用户支付配置', 'pay/config/list');
INSERT INTO `pms_menu` VALUES ('40', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'NO', '1', '0', '#', '005', '交易管理', '##');
INSERT INTO `pms_menu` VALUES ('42', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '40', 'zfddgl', '00501', '支付订单管理', 'trade/listPaymentOrder');
INSERT INTO `pms_menu` VALUES ('43', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '40', 'zfjjgl', '00502', '支付记录管理', 'trade/listPaymentRecord');
INSERT INTO `pms_menu` VALUES ('50', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'NO', '1', '0', '#', '006', '结算管理', '##');
INSERT INTO `pms_menu` VALUES ('52', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '50', 'jsjlgl', '00601', '结算记录管理', 'sett/list');
INSERT INTO `pms_menu` VALUES ('60', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'NO', '1', '0', '#', '007', '对账管理', '##');
INSERT INTO `pms_menu` VALUES ('62', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '60', 'dzcclb', '00701', '对账差错列表', 'reconciliation/list/mistake');
INSERT INTO `pms_menu` VALUES ('63', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '60', 'dzpclb', '00702', '对账批次列表', 'reconciliation/list/checkbatch');
INSERT INTO `pms_menu` VALUES ('64', '0', 'edgar', '2016-08-22 11:07:43', 'admin', '2016-08-22 11:07:43', 'ACTIVE', '', 'YES', '2', '60', 'dzhcclb', '00703', '对账缓冲池列表', 'reconciliation/list/scratchPool');

-- ----------------------------
-- Table structure for `pms_menu_role`
-- ----------------------------
DROP TABLE IF EXISTS `pms_menu_role`;
CREATE TABLE `pms_menu_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `version` bigint(20) DEFAULT NULL,
  `creater` varchar(50) NOT NULL COMMENT '创建人',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_KEY_2` (`role_id`,`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8 COMMENT='权限（菜单）与角色关联表';

-- ----------------------------
-- Records of pms_menu_role
-- ----------------------------
INSERT INTO `pms_menu_role` VALUES ('94', null, '', null, null, null, null, null, '1', '1');
INSERT INTO `pms_menu_role` VALUES ('95', null, '', null, null, null, null, null, '1', '2');
INSERT INTO `pms_menu_role` VALUES ('96', null, '', null, null, null, null, null, '1', '3');
INSERT INTO `pms_menu_role` VALUES ('97', null, '', null, null, null, null, null, '1', '4');
INSERT INTO `pms_menu_role` VALUES ('98', null, '', null, null, null, null, null, '1', '5');
INSERT INTO `pms_menu_role` VALUES ('99', null, '', null, null, null, null, null, '1', '10');
INSERT INTO `pms_menu_role` VALUES ('100', null, '', null, null, null, null, null, '1', '12');
INSERT INTO `pms_menu_role` VALUES ('101', null, '', null, null, null, null, null, '1', '13');
INSERT INTO `pms_menu_role` VALUES ('102', null, '', null, null, null, null, null, '1', '20');
INSERT INTO `pms_menu_role` VALUES ('103', null, '', null, null, null, null, null, '1', '22');
INSERT INTO `pms_menu_role` VALUES ('104', null, '', null, null, null, null, null, '1', '30');
INSERT INTO `pms_menu_role` VALUES ('105', null, '', null, null, null, null, null, '1', '32');
INSERT INTO `pms_menu_role` VALUES ('106', null, '', null, null, null, null, null, '1', '33');
INSERT INTO `pms_menu_role` VALUES ('107', null, '', null, null, null, null, null, '1', '40');
INSERT INTO `pms_menu_role` VALUES ('108', null, '', null, null, null, null, null, '1', '42');
INSERT INTO `pms_menu_role` VALUES ('109', null, '', null, null, null, null, null, '1', '43');
INSERT INTO `pms_menu_role` VALUES ('110', null, '', null, null, null, null, null, '1', '50');
INSERT INTO `pms_menu_role` VALUES ('111', null, '', null, null, null, null, null, '1', '52');
INSERT INTO `pms_menu_role` VALUES ('112', null, '', null, null, null, null, null, '1', '60');
INSERT INTO `pms_menu_role` VALUES ('113', null, '', null, null, null, null, null, '1', '62');
INSERT INTO `pms_menu_role` VALUES ('114', null, '', null, null, null, null, null, '1', '63');
INSERT INTO `pms_menu_role` VALUES ('115', null, '', null, null, null, null, null, '1', '64');
INSERT INTO `pms_menu_role` VALUES ('125', null, '', null, null, null, null, null, '2', '1');
INSERT INTO `pms_menu_role` VALUES ('126', null, '', null, null, null, null, null, '2', '2');
INSERT INTO `pms_menu_role` VALUES ('127', null, '', null, null, null, null, null, '2', '3');
INSERT INTO `pms_menu_role` VALUES ('128', null, '', null, null, null, null, null, '2', '4');
INSERT INTO `pms_menu_role` VALUES ('129', null, '', null, null, null, null, null, '2', '5');
INSERT INTO `pms_menu_role` VALUES ('130', null, '', null, null, null, null, null, '2', '10');
INSERT INTO `pms_menu_role` VALUES ('131', null, '', null, null, null, null, null, '2', '12');
INSERT INTO `pms_menu_role` VALUES ('132', null, '', null, null, null, null, null, '2', '13');
INSERT INTO `pms_menu_role` VALUES ('133', null, '', null, null, null, null, null, '2', '20');
INSERT INTO `pms_menu_role` VALUES ('134', null, '', null, null, null, null, null, '2', '22');
INSERT INTO `pms_menu_role` VALUES ('135', null, '', null, null, null, null, null, '2', '30');
INSERT INTO `pms_menu_role` VALUES ('136', null, '', null, null, null, null, null, '2', '32');
INSERT INTO `pms_menu_role` VALUES ('137', null, '', null, null, null, null, null, '2', '33');
INSERT INTO `pms_menu_role` VALUES ('138', null, '', null, null, null, null, null, '2', '40');
INSERT INTO `pms_menu_role` VALUES ('139', null, '', null, null, null, null, null, '2', '42');
INSERT INTO `pms_menu_role` VALUES ('140', null, '', null, null, null, null, null, '2', '43');
INSERT INTO `pms_menu_role` VALUES ('141', null, '', null, null, null, null, null, '2', '50');
INSERT INTO `pms_menu_role` VALUES ('142', null, '', null, null, null, null, null, '2', '52');
INSERT INTO `pms_menu_role` VALUES ('143', null, '', null, null, null, null, null, '2', '60');
INSERT INTO `pms_menu_role` VALUES ('144', null, '', null, null, null, null, null, '2', '62');
INSERT INTO `pms_menu_role` VALUES ('145', null, '', null, null, null, null, null, '2', '63');
INSERT INTO `pms_menu_role` VALUES ('146', null, '', null, null, null, null, null, '2', '64');

-- ----------------------------
-- Table structure for `pms_operator`
-- ----------------------------
DROP TABLE IF EXISTS `pms_operator`;
CREATE TABLE `pms_operator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` bigint(20) NOT NULL,
  `creater` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `real_name` varchar(50) NOT NULL,
  `mobile_no` varchar(15) NOT NULL,
  `login_name` varchar(50) NOT NULL,
  `login_pwd` varchar(256) NOT NULL,
  `type` varchar(20) NOT NULL,
  `salt` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_KEY_2` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='操作员表';

-- ----------------------------
-- Records of pms_operator
-- ----------------------------
INSERT INTO `pms_operator` VALUES ('1', '0', 'edgar', '2016-08-17 11:07:43', 'admin', '2016-08-17 11:07:43', 'ACTIVE', '超级管理员', '超级管理员', '18620936193', 'admin', 'd3c59d25033dbf980d29554025c23a75', 'ADMIN', '8d78869f470951332959580424d4bf4f');
INSERT INTO `pms_operator` VALUES ('2', '0', 'edgar', '2016-08-17 11:07:43', 'guest', '2016-08-17 11:07:43', 'ACTIVE', '游客', '游客', '18926215592', 'guest', '3f0dbf580ee39ec03b632cb33935a363', 'USER', '183d9f2f0f2ce760e98427a5603d1c73');

-- ----------------------------
-- Table structure for `pms_operator_log`
-- ----------------------------
DROP TABLE IF EXISTS `pms_operator_log`;
CREATE TABLE `pms_operator_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` bigint(20) NOT NULL,
  `creater` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `operator_id` bigint(20) NOT NULL,
  `operator_name` varchar(50) NOT NULL,
  `operate_type` varchar(50) NOT NULL COMMENT '操作类型（1:增加，2:修改，3:删除，4:查询）',
  `ip` varchar(100) NOT NULL,
  `content` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='权限_操作员操作日志表';

-- ----------------------------
-- Records of pms_operator_log
-- ----------------------------

-- ----------------------------
-- Table structure for `pms_permission`
-- ----------------------------
DROP TABLE IF EXISTS `pms_permission`;
CREATE TABLE `pms_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` bigint(20) NOT NULL,
  `creater` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `permission_name` varchar(100) NOT NULL,
  `permission` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_KEY_2` (`permission`),
  KEY `AK_KEY_3` (`permission_name`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of pms_permission
-- ----------------------------
INSERT INTO `pms_permission` VALUES ('1', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-菜单-查看', '权限管理-菜单-查看', 'pms:menu:view');
INSERT INTO `pms_permission` VALUES ('2', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-菜单-添加', '权限管理-菜单-添加', 'pms:menu:add');
INSERT INTO `pms_permission` VALUES ('3', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-菜单-查看', '权限管理-菜单-修改', 'pms:menu:edit');
INSERT INTO `pms_permission` VALUES ('4', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-菜单-删除', '权限管理-菜单-删除', 'pms:menu:delete');
INSERT INTO `pms_permission` VALUES ('11', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-权限-查看', '权限管理-权限-查看', 'pms:permission:view');
INSERT INTO `pms_permission` VALUES ('12', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-权限-添加', '权限管理-权限-添加', 'pms:permission:add');
INSERT INTO `pms_permission` VALUES ('13', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-权限-修改', '权限管理-权限-修改', 'pms:permission:edit');
INSERT INTO `pms_permission` VALUES ('14', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-权限-删除', '权限管理-权限-删除', 'pms:permission:delete');
INSERT INTO `pms_permission` VALUES ('21', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-角色-查看', '权限管理-角色-查看', 'pms:role:view');
INSERT INTO `pms_permission` VALUES ('22', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-角色-添加', '权限管理-角色-添加', 'pms:role:add');
INSERT INTO `pms_permission` VALUES ('23', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-角色-修改', '权限管理-角色-修改', 'pms:role:edit');
INSERT INTO `pms_permission` VALUES ('24', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-角色-删除', '权限管理-角色-删除', 'pms:role:delete');
INSERT INTO `pms_permission` VALUES ('25', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-角色-分配权限', '权限管理-角色-分配权限', 'pms:role:assignpermission');
INSERT INTO `pms_permission` VALUES ('31', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-操作员-查看', '权限管理-操作员-查看', 'pms:operator:view');
INSERT INTO `pms_permission` VALUES ('32', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-操作员-添加', '权限管理-操作员-添加', 'pms:operator:add');
INSERT INTO `pms_permission` VALUES ('33', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-操作员-查看', '权限管理-操作员-修改', 'pms:operator:edit');
INSERT INTO `pms_permission` VALUES ('34', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-操作员-冻结与解冻', '权限管理-操作员-冻结与解冻', 'pms:operator:changestatus');
INSERT INTO `pms_permission` VALUES ('35', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '权限管理-操作员-重置密码', '权限管理-操作员-重置密码', 'pms:operator:resetpwd');
INSERT INTO `pms_permission` VALUES ('51', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '账户管理-账户-查看', '账户管理-账户-查看', 'account:accountInfo:view');
INSERT INTO `pms_permission` VALUES ('52', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '账户管理-账户-添加', '账户管理-账户-添加', 'account:accountInfo:add');
INSERT INTO `pms_permission` VALUES ('53', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '账户管理-账户-查看', '账户管理-账户-修改', 'account:accountInfo:edit');
INSERT INTO `pms_permission` VALUES ('54', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '账户管理-账户-删除', '账户管理-账户-删除', 'account:accountInfo:delete');
INSERT INTO `pms_permission` VALUES ('61', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '账户管理-账户历史-查看', '账户管理-账户历史-查看', 'account:accountHistory:view');
INSERT INTO `pms_permission` VALUES ('71', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '用户管理-用户信息-查看', '用户管理-用户信息-查看', 'user:userInfo:view');
INSERT INTO `pms_permission` VALUES ('72', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '用户管理-用户信息-添加', '用户管理-用户信息-添加', 'user:userInfo:add');
INSERT INTO `pms_permission` VALUES ('73', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '用户管理-用户信息-查看', '用户管理-用户信息-修改', 'user:userInfo:edit');
INSERT INTO `pms_permission` VALUES ('74', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '用户管理-用户信息-删除', '用户管理-用户信息-删除', 'user:userInfo:delete');
INSERT INTO `pms_permission` VALUES ('81', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付产品-查看', '支付管理-支付产品-查看', 'pay:product:view');
INSERT INTO `pms_permission` VALUES ('82', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付产品-添加', '支付管理-支付产品-添加', 'pay:product:add');
INSERT INTO `pms_permission` VALUES ('83', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付产品-查看', '支付管理-支付产品-修改', 'pay:product:edit');
INSERT INTO `pms_permission` VALUES ('84', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付产品-删除', '支付管理-支付产品-删除', 'pay:product:delete');
INSERT INTO `pms_permission` VALUES ('85', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付方式-查看', '支付管理-支付方式-查看', 'pay:way:view');
INSERT INTO `pms_permission` VALUES ('86', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付方式-添加', '支付管理-支付方式-添加', 'pay:way:add');
INSERT INTO `pms_permission` VALUES ('87', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付方式-查看', '支付管理-支付方式-修改', 'pay:way:edit');
INSERT INTO `pms_permission` VALUES ('88', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付方式-删除', '支付管理-支付方式-删除', 'pay:way:delete');
INSERT INTO `pms_permission` VALUES ('91', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付配置-查看', '支付管理-支付配置-查看', 'pay:config:view');
INSERT INTO `pms_permission` VALUES ('92', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付配置-添加', '支付管理-支付配置-添加', 'pay:config:add');
INSERT INTO `pms_permission` VALUES ('93', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付配置-查看', '支付管理-支付配置-修改', 'pay:config:edit');
INSERT INTO `pms_permission` VALUES ('94', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '支付管理-支付配置-删除', '支付管理-支付配置-删除', 'pay:config:delete');
INSERT INTO `pms_permission` VALUES ('101', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-订单-查看', '交易管理-订单-查看', 'trade:order:view');
INSERT INTO `pms_permission` VALUES ('102', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-订单-添加', '交易管理-订单-添加', 'trade:order:add');
INSERT INTO `pms_permission` VALUES ('103', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-订单-查看', '交易管理-订单-修改', 'trade:order:edit');
INSERT INTO `pms_permission` VALUES ('104', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-订单-删除', '交易管理-订单-删除', 'trade:order:delete');
INSERT INTO `pms_permission` VALUES ('111', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-记录-查看', '交易管理-记录-查看', 'trade:record:view');
INSERT INTO `pms_permission` VALUES ('112', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-记录-添加', '交易管理-记录-添加', 'trade:record:add');
INSERT INTO `pms_permission` VALUES ('113', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-记录-查看', '交易管理-记录-修改', 'trade:record:edit');
INSERT INTO `pms_permission` VALUES ('114', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '交易管理-记录-删除', '交易管理-记录-删除', 'trade:record:delete');
INSERT INTO `pms_permission` VALUES ('121', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '结算管理-记录-查看', '结算管理-记录-查看', 'sett:record:view');
INSERT INTO `pms_permission` VALUES ('122', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '结算管理-记录-添加', '结算管理-记录-添加', 'sett:record:add');
INSERT INTO `pms_permission` VALUES ('123', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '结算管理-记录-查看', '结算管理-记录-修改', 'sett:record:edit');
INSERT INTO `pms_permission` VALUES ('124', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '结算管理-记录-删除', '结算管理-记录-删除', 'sett:record:delete');
INSERT INTO `pms_permission` VALUES ('131', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-差错-查看', '对账管理-差错-查看', 'recon:mistake:view');
INSERT INTO `pms_permission` VALUES ('132', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-差错-添加', '对账管理-差错-添加', 'recon:mistake:add');
INSERT INTO `pms_permission` VALUES ('133', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-差错-查看', '对账管理-差错-修改', 'recon:mistake:edit');
INSERT INTO `pms_permission` VALUES ('134', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-差错-删除', '对账管理-差错-删除', 'recon:mistake:delete');
INSERT INTO `pms_permission` VALUES ('141', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-批次-查看', '对账管理-批次-查看', 'recon:batch:view');
INSERT INTO `pms_permission` VALUES ('142', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-批次-添加', '对账管理-批次-添加', 'recon:batch:add');
INSERT INTO `pms_permission` VALUES ('143', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-批次-查看', '对账管理-批次-修改', 'recon:batch:edit');
INSERT INTO `pms_permission` VALUES ('144', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-批次-删除', '对账管理-批次-删除', 'recon:batch:delete');
INSERT INTO `pms_permission` VALUES ('151', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-缓冲池-查看', '对账管理-缓冲池-查看', 'recon:scratchPool:view');
INSERT INTO `pms_permission` VALUES ('152', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-缓冲池-添加', '对账管理-缓冲池-添加', 'recon:scratchPool:add');
INSERT INTO `pms_permission` VALUES ('153', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-缓冲池-查看', '对账管理-缓冲池-修改', 'recon:scratchPool:edit');
INSERT INTO `pms_permission` VALUES ('154', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '对账管理-缓冲池-删除', '对账管理-缓冲池-删除', 'recon:scratchPool:delete');

-- ----------------------------
-- Table structure for `pms_role`
-- ----------------------------
DROP TABLE IF EXISTS `pms_role`;
CREATE TABLE `pms_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` bigint(20) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `role_code` varchar(20) NOT NULL COMMENT '角色类型（1:超级管理员角色，0:普通操作员角色）',
  `role_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_KEY_2` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of pms_role
-- ----------------------------
INSERT INTO `pms_role` VALUES ('1', '0', 'edgar', '2016-08-17 11:07:43', 'admin', '2016-08-17 11:07:43', 'ACTIVE', '超级管理员角色', 'admin', '超级管理员角色');
INSERT INTO `pms_role` VALUES ('2', '0', 'edgar', '2016-08-17 11:07:43', 'guest', '2016-08-17 11:07:43', 'ACTIVE', '游客角色', 'guest', '游客角色');

-- ----------------------------
-- Table structure for `pms_role_operator`
-- ----------------------------
DROP TABLE IF EXISTS `pms_role_operator`;
CREATE TABLE `pms_role_operator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` bigint(20) NOT NULL,
  `creater` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `operator_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_KEY_2` (`role_id`,`operator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='操作员与角色关联表';

-- ----------------------------
-- Records of pms_role_operator
-- ----------------------------
INSERT INTO `pms_role_operator` VALUES ('1', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '1', '1');
INSERT INTO `pms_role_operator` VALUES ('2', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '1');
INSERT INTO `pms_role_operator` VALUES ('3', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '2');

-- ----------------------------
-- Table structure for `pms_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `pms_role_permission`;
CREATE TABLE `pms_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` bigint(20) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(20) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_KEY_2` (`role_id`,`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1080 DEFAULT CHARSET=utf8 COMMENT='权限与角色关联表';

-- ----------------------------
-- Records of pms_role_permission
-- ----------------------------
INSERT INTO `pms_role_permission` VALUES ('1063', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '1');
INSERT INTO `pms_role_permission` VALUES ('1064', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '11');
INSERT INTO `pms_role_permission` VALUES ('1065', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '21');
INSERT INTO `pms_role_permission` VALUES ('1066', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '31');
INSERT INTO `pms_role_permission` VALUES ('1067', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '41');
INSERT INTO `pms_role_permission` VALUES ('1068', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '51');
INSERT INTO `pms_role_permission` VALUES ('1069', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '61');
INSERT INTO `pms_role_permission` VALUES ('1070', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '71');
INSERT INTO `pms_role_permission` VALUES ('1071', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '81');
INSERT INTO `pms_role_permission` VALUES ('1072', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '85');
INSERT INTO `pms_role_permission` VALUES ('1073', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '91');
INSERT INTO `pms_role_permission` VALUES ('1074', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '101');
INSERT INTO `pms_role_permission` VALUES ('1075', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '111');
INSERT INTO `pms_role_permission` VALUES ('1076', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '121');
INSERT INTO `pms_role_permission` VALUES ('1077', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '131');
INSERT INTO `pms_role_permission` VALUES ('1078', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '141');
INSERT INTO `pms_role_permission` VALUES ('1079', '0', 'edgar', '2016-08-17 11:07:43', 'test', '2016-08-17 11:07:43', 'ACTIVE', '', '2', '151');
