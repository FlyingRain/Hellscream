/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : plan

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-22 10:28:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_word_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_word_relation`;
CREATE TABLE `user_word_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `word_id` int(11) DEFAULT NULL,
  `proficiency` tinyint(2) DEFAULT NULL,
  `data_added` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  UNIQUE KEY `relation` (`user_id`,`word_id`) USING BTREE,
  KEY `wordIndex` (`word_id`) USING BTREE,
  KEY `userIndex` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
