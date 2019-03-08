/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test_user

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-08 13:13:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEMAND_ID` int(11) DEFAULT NULL COMMENT '需求单ID',
  `AUDITOR_ID` varchar(255) DEFAULT NULL COMMENT '审核人ID',
  `AUDITOR_OPINION` varchar(255) DEFAULT NULL COMMENT '审核意见',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of record
-- ----------------------------
