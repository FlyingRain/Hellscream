/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : userCenter

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-29 18:08:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `data_added` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
