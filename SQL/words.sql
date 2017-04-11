/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-11 18:01:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) DEFAULT NULL,
  `word` varchar(50) NOT NULL,
  `uk_pronunciation` varchar(50) DEFAULT NULL,
  `us_pronunciation` varchar(50) DEFAULT NULL,
  `default_audio` varchar(255) DEFAULT NULL,
  `mean` varchar(255) DEFAULT NULL,
  `data_added` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
