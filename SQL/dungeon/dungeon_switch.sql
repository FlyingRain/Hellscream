/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : dungeon

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-11 17:05:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dungeon_switch
-- ----------------------------
DROP TABLE IF EXISTS `dungeon_switch`;
CREATE TABLE `dungeon_switch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dungeon_id` int(11) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `dungeon_id_index` (`dungeon_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
