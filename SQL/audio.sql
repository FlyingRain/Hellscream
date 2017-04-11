/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-11 18:00:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for audio
-- ----------------------------
DROP TABLE IF EXISTS `audio`;
CREATE TABLE `audio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word_id` int(11) NOT NULL,
  `audio_address` varchar(255) DEFAULT NULL,
  `audio_type` tinyint(2) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
