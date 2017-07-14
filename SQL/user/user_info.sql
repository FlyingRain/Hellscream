/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : userCenter

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-14 09:59:08
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
  `pet_name` varchar(255) DEFAULT NULL,
  `school` varchar(125) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `verify_phone` tinyint(2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `verify_email` tinyint(2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_index` (`email`) USING BTREE,
  UNIQUE KEY `phone_index` (`phone`) USING BTREE,
  UNIQUE KEY `petName_index` (`pet_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
