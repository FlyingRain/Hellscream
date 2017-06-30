/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : userCenter

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-29 18:07:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(125) DEFAULT NULL,
  `gender` tinyint(2) DEFAULT NULL,
  `school` varchar(125) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `verify_phone` tinyint(2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `verify_email` tinyint(2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `data_added` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
