/*
Navicat MySQL Data Transfer

Source Server         : qinglan
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-06-03 15:40:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_homework`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_homework`;
CREATE TABLE `tbl_homework` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `tcontent` text,
  `scontent` text,
  `tstarttime` datetime DEFAULT NULL,
  `sfinishtime` datetime DEFAULT NULL,
  `score` decimal(10,0) DEFAULT NULL,
  `sstatus` varchar(20) DEFAULT NULL,
  `tstatus` varchar(20) DEFAULT NULL,
  `crid` int(11) DEFAULT NULL,
  `trid` int(11) DEFAULT NULL,
  `deadlineTime` date DEFAULT NULL,
  `question` varchar(500) DEFAULT NULL,
  `workReview` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_homework
-- ----------------------------
INSERT INTO `tbl_homework` VALUES ('2', '作业一作业一内容', '作业一作业一内容作业一作业一内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '80', '已完成', '', '2', '4', null, null, null);
INSERT INTO `tbl_homework` VALUES ('3', '作业二作业二内容', '', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '已完成', '', '3', '2', null, '', null);
INSERT INTO `tbl_homework` VALUES ('4', '作业三作业三内容', '作业三作业三内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '', '', '4', '3', null, null, null);
INSERT INTO `tbl_homework` VALUES ('5', '作业四作业四内容', '作业四作业四内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '', '', '1', '1', null, null, null);
