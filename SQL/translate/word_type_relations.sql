/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-12 16:02:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for word_type_relations
-- ----------------------------
DROP TABLE IF EXISTS `word_type_relations`;
CREATE TABLE `word_type_relations` (
  `word_id` int(11) DEFAULT NULL,
  `type_code` varchar(100) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
