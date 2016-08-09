/*
Navicat MySQL Data Transfer

Source Server         : zb
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : prms

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2016-08-09 17:55:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `p_account`
-- ----------------------------
DROP TABLE IF EXISTS `p_account`;
CREATE TABLE `p_account` (
  `id` varchar(50) NOT NULL,
  `edit_time` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `account_no` varchar(50) NOT NULL,
  `balance` decimal(20,6) NOT NULL,
  `unbalance` decimal(20,6) NOT NULL,
  `security_money` decimal(20,6) NOT NULL,
  `status` varchar(36) NOT NULL,
  `total_income` decimal(20,6) NOT NULL,
  `total_expend` decimal(20,6) NOT NULL,
  `today_income` decimal(20,6) NOT NULL,
  `today_expend` decimal(20,6) NOT NULL,
  `account_type` varchar(50) NOT NULL,
  `sett_amount` decimal(20,6) NOT NULL,
  `user_no` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户表';

-- ----------------------------
-- Records of p_account
-- ----------------------------
