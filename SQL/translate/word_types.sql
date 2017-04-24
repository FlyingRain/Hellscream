/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-12 16:02:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for word_types
-- ----------------------------
DROP TABLE IF EXISTS `word_types`;
CREATE TABLE `word_types` (
  `id` int(11) NOT NULL,
  `type_name` varchar(100) DEFAULT NULL,
  `type_code` varchar(100) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word_types
-- ----------------------------
INSERT INTO `word_types` VALUES ('1', '托福基本词汇', '50', '2017-04-12 11:55:37.948', '2017-04-12 11:56:19');
INSERT INTO `word_types` VALUES ('2', '基础词汇', '1', '2017-04-12 11:56:38.649', '2017-04-12 14:39:31');
INSERT INTO `word_types` VALUES ('3', '托福中级词汇', '51', '2017-04-12 11:56:49.640', '2017-04-12 11:56:53');
INSERT INTO `word_types` VALUES ('4', '托福高级词汇', '52', '2017-04-12 11:57:04.990', '2017-04-12 11:57:04');
