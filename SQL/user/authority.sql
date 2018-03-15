/*
Navicat MySQL Data Transfer

Source Server         : 10.243.121.53_3306
Source Server Version : 50721
Source Host           : 10.243.121.53:3306
Source Database       : userCenter

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-03-15 16:48:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `desc` varchar(512) DEFAULT NULL,
  `data_added` datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uel_index` (`url`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '用户详情', 'user/userInfo', '查询用户详细信息', '2017-08-07 10:17:39.318', '2018-03-12 14:24:11');
INSERT INTO `authority` VALUES ('2', '登陆', 'auth/login', '用户登陆', '2017-08-09 16:13:46.277', '2017-08-09 16:40:11');
INSERT INTO `authority` VALUES ('3', '注册', 'auth/register', '用户注册', '2017-08-09 16:16:03.240', '2017-08-09 16:40:13');
INSERT INTO `authority` VALUES ('4', '微信注册', 'auth/wxBind', '微信注册', '2018-03-12 14:21:29.591', '2018-03-12 14:25:01');
INSERT INTO `authority` VALUES ('5', '微信登陆', 'auth/wxLogin', '微信登陆', '2018-03-12 14:25:41.493', '2018-03-12 14:40:09');
INSERT INTO `authority` VALUES ('6', '登出', 'auth/logoff', '登出', '2018-03-12 14:26:53.400', '2018-03-12 14:41:03');
INSERT INTO `authority` VALUES ('7', '制定计划', 'plan/make', '制定计划', '2018-03-12 14:29:32.013', '2018-03-15 15:16:38');
INSERT INTO `authority` VALUES ('8', '获取用户正在进行中的计划', 'plan/getUserPlan', '获取用户正在进行中的计划', '2018-03-15 15:18:12.362', '2018-03-15 15:18:12');
INSERT INTO `authority` VALUES ('9', '查询计划', 'plan/query', '查询计划', '2018-03-15 15:44:42.315', '2018-03-15 15:45:18');
INSERT INTO `authority` VALUES ('10', '修改计划', 'plan/modify', '修改计划', '2018-03-15 15:45:42.629', '2018-03-15 15:46:06');
INSERT INTO `authority` VALUES ('11', '获取任务', 'task/getTask', '获取任务', '2018-03-15 15:47:17.864', '2018-03-15 15:47:35');
INSERT INTO `authority` VALUES ('12', '获取任务摘要', 'task/getTaskSummary', '获取任务摘要', '2018-03-15 15:48:50.605', '2018-03-15 15:49:04');
INSERT INTO `authority` VALUES ('13', '同步任务', 'task//synchronize/TaskResult', '同步任务完成情况', '2018-03-15 15:59:06.477', '2018-03-15 15:59:41');
INSERT INTO `authority` VALUES ('14', '查询剩余时间', 'plan/leftDay', '查询剩余时间', '2018-03-15 16:00:19.015', '2018-03-15 16:00:59');
INSERT INTO `authority` VALUES ('15', '查询书本', 'book/books', '查询所有书本', '2018-03-15 16:03:45.316', '2018-03-15 16:04:06');
INSERT INTO `authority` VALUES ('16', '类型查询', 'book/query/book', '类型查询', '2018-03-15 16:08:48.872', '2018-03-15 16:09:01');
INSERT INTO `authority` VALUES ('17', '根据名称查询', 'book/query/bookByName', '据名称查询', '2018-03-15 16:21:44.458', '2018-03-15 16:22:06');
INSERT INTO `authority` VALUES ('18', '查询单词', 'words/query/word', '查询单词', '2018-03-15 16:22:43.774', '2018-03-15 16:22:48');
