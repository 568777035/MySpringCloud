/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test_user

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-08 13:13:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demand
-- ----------------------------
DROP TABLE IF EXISTS `demand`;
CREATE TABLE `demand` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATEBY_NAME` varchar(255) DEFAULT NULL COMMENT '创建人名称',
  `CREATEBY_ID` varchar(255) DEFAULT NULL COMMENT '创建人ID',
  `DEMAND_NAME` varchar(255) DEFAULT NULL COMMENT '需求单名称',
  `DEMAND_DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '需求描述',
  `DEMAND_STATUS` varchar(255) DEFAULT NULL COMMENT '需求单状态',
  `AUDITOR_ID` varchar(255) DEFAULT NULL COMMENT '审核人ID',
  `ORG_ID` varchar(255) DEFAULT NULL COMMENT '组织ID',
  `STARTTIME` datetime DEFAULT NULL COMMENT '开始时间',
  `ENDTIME` datetime DEFAULT NULL COMMENT '结束时间',
  `TASK_ID` varchar(255) DEFAULT NULL COMMENT '流程实例ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of demand
-- ----------------------------
