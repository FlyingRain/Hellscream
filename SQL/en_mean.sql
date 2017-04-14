/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-14 15:11:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for en_mean
-- ----------------------------
DROP TABLE IF EXISTS `en_mean`;
CREATE TABLE `en_mean` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word_id` int(10) DEFAULT NULL,
  `n` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `adj` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `adv` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `v` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `vt` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `vi` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1560 DEFAULT CHARSET=latin1;
