/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : dungeon

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-08-15 22:50:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dungeon_instance
-- ----------------------------
DROP TABLE IF EXISTS `dungeon_instance`;
CREATE TABLE `dungeon_instance` (
  `id` int(11) NOT NULL,
  `dungeon_type` varchar(255) DEFAULT NULL,
  `users` varchar(1024) DEFAULT NULL,
  `enroll_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dungeon_status` tinyint(2) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dungeon_instance
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
