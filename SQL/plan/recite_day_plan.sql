/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : plan

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-23 11:12:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for recite_day_plan
-- ----------------------------
DROP TABLE IF EXISTS `recite_day_plan`;
CREATE TABLE `recite_day_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word_ids` varchar(500) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `plan_date` datetime DEFAULT NULL,
  `complete_time` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `plan_id` int(11) DEFAULT NULL,
  `data_added` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  UNIQUE KEY `userdateIndex` (`user_id`,`plan_date`,`plan_id`) USING BTREE,
  KEY `userIndex` (`user_id`) USING BTREE,
  KEY `planIndex` (`plan_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
