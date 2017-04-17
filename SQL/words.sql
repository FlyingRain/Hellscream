/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-17 18:09:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(50) NOT NULL,
  `channel_word_id` int(20) DEFAULT NULL,
  `uk_pronunciation` varchar(50) DEFAULT NULL,
  `channel_code` varchar(50) DEFAULT NULL,
  `has_sentences` tinyint(2) DEFAULT '0',
  `has_audio` tinyint(2) DEFAULT NULL,
  `us_pronunciation` varchar(50) DEFAULT NULL,
  `default_audio` varchar(255) DEFAULT NULL,
  `mean` varchar(500) DEFAULT NULL,
  `data_added` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  UNIQUE KEY `word_index` (`word`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1560 DEFAULT CHARSET=utf8;
