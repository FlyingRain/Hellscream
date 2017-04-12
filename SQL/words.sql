/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-12 16:02:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(50) CHARACTER SET utf8 NOT NULL,
  `channel_word_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `uk_pronunciation` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `channel_code` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `has_audio` tinyint(2) DEFAULT NULL,
  `us_pronunciation` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `default_audio` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `mean` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `data_added` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `word_index` (`word`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
