/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : dungeon

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-08-15 22:51:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dungeon_role
-- ----------------------------
DROP TABLE IF EXISTS `dungeon_role`;
CREATE TABLE `dungeon_role` (
  `id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `role_param` varchar(1024) DEFAULT NULL,
  `role_type` tinyint(2) DEFAULT NULL,
  `is_active` tinyint(2) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
