/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : dungeon

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-12-13 14:36:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_99_001_35E4
-- ----------------------------
DROP TABLE IF EXISTS `T_99_001_35E4`;
CREATE TABLE `T_99_001_35E4` (
  `C001` varchar(4) NOT NULL,
  `C002` varchar(128) DEFAULT NULL,
  `C003` char(1) DEFAULT NULL,
  PRIMARY KEY (`C001`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
