/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : plan

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-26 10:42:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for recite_day_plan
-- ----------------------------
DROP TABLE IF EXISTS `recite_day_plan`;
CREATE TABLE `recite_day_plan` (
  `id` int(11) NOT NULL,
  `word_ids` varchar(500) DEFAULT NULL,
  `is_complete` varchar(2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `plan_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `complete_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `score` int(11) DEFAULT NULL,
  `plan_id` int(11) DEFAULT NULL,
  `data_added` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  UNIQUE KEY `userdateIndex` (`user_id`,`plan_date`,`plan_id`) USING BTREE,
  KEY `userIndex` (`user_id`) USING BTREE,
  KEY `planIndex` (`plan_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
