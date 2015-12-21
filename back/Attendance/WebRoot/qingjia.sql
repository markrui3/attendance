/*
Navicat MySQL Data Transfer

Source Server         : calculate
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : qingjia

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-12-21 22:43:24
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
INSERT INTO `holiday` VALUES ('1', '0', '事假', '10000', '1', null);
INSERT INTO `holiday` VALUES ('2', '1', '病假', '10000', '1', '9996');
INSERT INTO `holiday` VALUES ('3', '2', '婚假1', '7', '0', null);
INSERT INTO `holiday` VALUES ('4', '3', '婚假2', '10', '0', null);
INSERT INTO `holiday` VALUES ('5', '4', '产假', '90', '0', null);
INSERT INTO `holiday` VALUES ('6', '5', '陪产假', '7', '0', null);
INSERT INTO `holiday` VALUES ('7', '6', '年假1', '10', '0', null);
INSERT INTO `holiday` VALUES ('8', '7', '年假2', '15', '0', null);
INSERT INTO `holiday` VALUES ('9', '8', '出差', '10000', '0', null);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------

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
  `startworkdate` date NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '13920742173', '技术部', 'dcj', '董春江', '0', '1991-06-24', '0', '2013-06-24', '');
INSERT INTO `user` VALUES ('2', '1234', '技术部', 'zr', '赵瑞', '0', '1993-12-11', '1', '2012-07-04', '');
INSERT INTO `user` VALUES ('3', '1122', '技术部', 'dyq', '董一强', '0', '1993-04-06', '2', '2012-07-09', '');
INSERT INTO `user` VALUES ('4', '2211', '技术部', 'xhl', '谢杭伦', '1', '1993-01-01', '3', '2011-06-06', '');
