/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-18 14:11:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for word_sentence
-- ----------------------------
DROP TABLE IF EXISTS `word_sentence`;
CREATE TABLE `word_sentence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sentence` varchar(1250) DEFAULT NULL,
  `transaction` varchar(1250) DEFAULT NULL,
  `like` int(4) DEFAULT NULL,
  `unlike` int(4) DEFAULT NULL,
  `word_id` int(11) DEFAULT NULL,
  `channel_id` int(11) DEFAULT NULL,
  `first` varchar(500) DEFAULT NULL,
  `last` varchar(500) DEFAULT NULL,
  `word` varchar(50) DEFAULT NULL,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data_added` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=891 DEFAULT CHARSET=utf8;
