/*
Navicat MySQL Data Transfer

Source Server         : mydatabase
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-11 10:26:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for en_mean
-- ----------------------------
DROP TABLE IF EXISTS `en_mean`;
CREATE TABLE `en_mean` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word_id` int(10) DEFAULT NULL,
  `n` varchar(255) DEFAULT NULL,
  `adj` varchar(255) DEFAULT NULL,
  `adv` varchar(255) DEFAULT NULL,
  `v` varchar(255) DEFAULT NULL,
  `vt` varchar(255) DEFAULT NULL,
  `vi` varchar(255) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
