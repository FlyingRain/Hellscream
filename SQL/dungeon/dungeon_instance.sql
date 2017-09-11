/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : dungeon

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-11 17:04:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dungeon_instance
-- ----------------------------
DROP TABLE IF EXISTS `dungeon_instance`;
CREATE TABLE `dungeon_instance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dungeon_source` int(11) DEFAULT NULL,
  `numbers` int(11) DEFAULT NULL COMMENT '实例个数',
  `enroll_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dungeon_status` tinyint(2) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `dungeon_resource_index` (`dungeon_source`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
