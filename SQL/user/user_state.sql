/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : userCenter

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-29 18:08:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_state
-- ----------------------------
DROP TABLE IF EXISTS `user_state`;
CREATE TABLE `user_state` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` int(5) DEFAULT NULL,
  `is_frezze` tinyint(2) DEFAULT NULL,
  `level` int(5) DEFAULT NULL,
  `data_added` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
