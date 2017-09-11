/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : dungeon

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-11 17:04:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dungeon_rule
-- ----------------------------
DROP TABLE IF EXISTS `dungeon_rule`;
CREATE TABLE `dungeon_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `rule_param` varchar(1024) DEFAULT NULL,
  `rule_type` tinyint(2) DEFAULT NULL,
  `is_active` tinyint(2) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
