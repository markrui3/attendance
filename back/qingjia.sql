/*
Navicat MySQL Data Transfer

Source Server         : calculate
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : qingjia

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-12-27 18:19:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `holidayid` bigint(20) NOT NULL,
  `lastday` float NOT NULL,
  `startday` varchar(50) NOT NULL,
  `endday` varchar(50) NOT NULL,
  `reason` varchar(255) NOT NULL,
  `applyday` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '1', '2', '4', '2015-06-10 15:14:18', '2015-06-15 15:14:18', '赵瑞去打胎', '2015-12-05 22:54:56', '21');

-- ----------------------------
-- Table structure for `check`
-- ----------------------------
DROP TABLE IF EXISTS `check`;
CREATE TABLE `check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attendanceid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `reason` varchar(500) DEFAULT NULL,
  `checkresult` int(11) NOT NULL,
  `property` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check
-- ----------------------------
INSERT INTO `check` VALUES ('1', '1', '2', '男人打什么胎，老实呆着', '0', '1');

-- ----------------------------
-- Table structure for `holiday`
-- ----------------------------
DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `holidayid` varchar(50) NOT NULL,
  `holidayname` varchar(50) NOT NULL,
  `lastday` varchar(50) NOT NULL,
  `holidayproperity` int(11) NOT NULL,
  `remainday` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of holiday
-- ----------------------------
INSERT INTO `holiday` VALUES ('1', '1', '事假', '10000', '1', '10000');
INSERT INTO `holiday` VALUES ('2', '2', '病假', '10000', '1', '10000');
INSERT INTO `holiday` VALUES ('3', '3', '婚假1', '7', '0', '7');
INSERT INTO `holiday` VALUES ('4', '4', '婚假2', '10', '0', null);
INSERT INTO `holiday` VALUES ('5', '5', '产假', '90', '0', null);
INSERT INTO `holiday` VALUES ('6', '6', '陪产假', '7', '0', '7');
INSERT INTO `holiday` VALUES ('7', '7', '年假1', '10', '0', '10');
INSERT INTO `holiday` VALUES ('8', '8', '年假2', '15', '0', null);
INSERT INTO `holiday` VALUES ('9', '9', '出差', '10000', '0', '10000');

-- ----------------------------
-- Table structure for `sign`
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `timecome` int(11) NOT NULL,
  `timeleave` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES ('1', '3', '1', '1', '2001-11-11 00:00:00');
INSERT INTO `sign` VALUES ('2', '3', '0', '2', '2015-12-26 12:00:00');
INSERT INTO `sign` VALUES ('3', '2', '2', '0', '2015-12-27 12:00:00');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(50) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `position` varchar(50) NOT NULL,
  `startworkdate` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '13920742173', '技术部', 'dcj', '董春江', '0', '1991-06-24', '0', '2013-06-24', '111');
INSERT INTO `user` VALUES ('2', '1234', '技术部', 'zr', '赵瑞', '0', '1993-12-11', '1', '2012-07-04', '');
INSERT INTO `user` VALUES ('3', '1122', '技术部', 'dyq', '董一强', '0', '1993-04-06', '2', '2012-07-09', '');
INSERT INTO `user` VALUES ('4', '2211', '技术部', 'xhl', '谢杭伦', '1', '1993-01-01', '3', '2011-06-06', '');
INSERT INTO `user` VALUES ('5', 'admin', '技术部', 'admin', '超级管理员', '0', '2015-12-23', '10', '2015-12-23', 'admin@qq.com');
INSERT INTO `user` VALUES ('6', '1', '技术部', '1', '1', '1', '2011-11-11', '1', '2011-11-11', 'qq');
