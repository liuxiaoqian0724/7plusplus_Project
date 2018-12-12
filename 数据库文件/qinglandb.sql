/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2018-12-12 15:00:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_classrelation`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_classrelation`;
CREATE TABLE `tbl_classrelation` (
  `crid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `trid` int(11) DEFAULT NULL,
  PRIMARY KEY (`crid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_classrelation
-- ----------------------------
INSERT INTO `tbl_classrelation` VALUES ('1', '3', '1');
INSERT INTO `tbl_classrelation` VALUES ('2', '3', '4');
INSERT INTO `tbl_classrelation` VALUES ('3', '4', '2');
INSERT INTO `tbl_classrelation` VALUES ('4', '4', '3');

-- ----------------------------
-- Table structure for `tbl_course`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_course`;
CREATE TABLE `tbl_course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_course
-- ----------------------------
INSERT INTO `tbl_course` VALUES ('1', '语文');
INSERT INTO `tbl_course` VALUES ('2', '数学');
INSERT INTO `tbl_course` VALUES ('3', '英语');
INSERT INTO `tbl_course` VALUES ('4', '物理');
INSERT INTO `tbl_course` VALUES ('5', '化学');
INSERT INTO `tbl_course` VALUES ('6', '生物');
INSERT INTO `tbl_course` VALUES ('7', '地理');
INSERT INTO `tbl_course` VALUES ('8', '政治');
INSERT INTO `tbl_course` VALUES ('9', '历史');

-- ----------------------------
-- Table structure for `tbl_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_grade`;
CREATE TABLE `tbl_grade` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) DEFAULT NULL,
  `schooltype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_grade
-- ----------------------------
INSERT INTO `tbl_grade` VALUES ('1', '一年级', '小学');
INSERT INTO `tbl_grade` VALUES ('2', '二年级', '小学');
INSERT INTO `tbl_grade` VALUES ('3', '三年级', '小学');
INSERT INTO `tbl_grade` VALUES ('4', '四年级', '小学');
INSERT INTO `tbl_grade` VALUES ('5', '五年级', '小学');
INSERT INTO `tbl_grade` VALUES ('6', '六年级', '小学');
INSERT INTO `tbl_grade` VALUES ('7', '初一', '初中');
INSERT INTO `tbl_grade` VALUES ('8', '初二', '初中');
INSERT INTO `tbl_grade` VALUES ('9', '初三', '初中');
INSERT INTO `tbl_grade` VALUES ('10', '高一', '高中');
INSERT INTO `tbl_grade` VALUES ('11', '高二', '高中');
INSERT INTO `tbl_grade` VALUES ('12', '高三', '高中');
INSERT INTO `tbl_grade` VALUES ('13', '大一', '大学');
INSERT INTO `tbl_grade` VALUES ('14', '大二', '大学');
INSERT INTO `tbl_grade` VALUES ('15', '大三', '大学');
INSERT INTO `tbl_grade` VALUES ('16', '大四', '大学');

-- ----------------------------
-- Table structure for `tbl_homework`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_homework`;
CREATE TABLE `tbl_homework` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `tcontent` varchar(1024) DEFAULT NULL,
  `scontent` varchar(1024) DEFAULT NULL,
  `tstarttime` datetime DEFAULT NULL,
  `sfinishtime` datetime DEFAULT NULL,
  `score` decimal(10,0) DEFAULT NULL,
  `sstatus` varchar(20) DEFAULT NULL,
  `tstatus` varchar(20) DEFAULT NULL,
  `crid` int(11) DEFAULT NULL,
  `trid` int(11) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_homework
-- ----------------------------
INSERT INTO `tbl_homework` VALUES ('2', '', 'ѧ', '2018-11-13 14:05:33', '2018-12-06 14:05:45', null, 'δ', 'δ', '2', '4');
INSERT INTO `tbl_homework` VALUES ('3', '', 'ѧ', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '', 'δ', '3', '2');
INSERT INTO `tbl_homework` VALUES ('4', '', 'ѧ', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '', 'δ', '4', '3');
INSERT INTO `tbl_homework` VALUES ('5', '', 'ѧ', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '', 'δ', '1', '1');

-- ----------------------------
-- Table structure for `tbl_msg`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_msg`;
CREATE TABLE `tbl_msg` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `sendid` int(11) DEFAULT NULL,
  `receiveid` int(11) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `sendtime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_msg
-- ----------------------------
INSERT INTO `tbl_msg` VALUES ('1', '3', '1', '', '2018-08-09 10:43:54', '2');
INSERT INTO `tbl_msg` VALUES ('2', '3', '2', '', '2018-07-12 10:44:18', '0');
INSERT INTO `tbl_msg` VALUES ('3', '4', '1', 'С', '2018-11-16 10:45:49', '1');
INSERT INTO `tbl_msg` VALUES ('4', '4', '2', 'С', '2018-12-01 10:46:06', '0');

-- ----------------------------
-- Table structure for `tbl_myjob`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjob`;
CREATE TABLE `tbl_myjob` (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `teacherage` varchar(10) DEFAULT NULL,
  `myExperience` text,
  `sucesses` text,
  PRIMARY KEY (`jid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjob
-- ----------------------------
INSERT INTO `tbl_myjob` VALUES ('1', '1', '', '110', '1', null, null);
INSERT INTO `tbl_myjob` VALUES ('2', '2', '', '100', '2', null, null);

-- ----------------------------
-- Table structure for `tbl_myjobcourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobcourse`;
CREATE TABLE `tbl_myjobcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobcourse
-- ----------------------------
INSERT INTO `tbl_myjobcourse` VALUES ('1', '2', '2');
INSERT INTO `tbl_myjobcourse` VALUES ('2', '3', '1');

-- ----------------------------
-- Table structure for `tbl_myjobgrade`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobgrade`;
CREATE TABLE `tbl_myjobgrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobgrade
-- ----------------------------
INSERT INTO `tbl_myjobgrade` VALUES ('1', '4', '2');
INSERT INTO `tbl_myjobgrade` VALUES ('2', '7', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('3', '8', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('4', '11', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('5', '12', '1');

-- ----------------------------
-- Table structure for `tbl_myjobtime`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobtime`;
CREATE TABLE `tbl_myjobtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobtime
-- ----------------------------
INSERT INTO `tbl_myjobtime` VALUES ('1', '2', '1');
INSERT INTO `tbl_myjobtime` VALUES ('2', '3', '2');
INSERT INTO `tbl_myjobtime` VALUES ('3', '6', '1');
INSERT INTO `tbl_myjobtime` VALUES ('4', '4', '1');
INSERT INTO `tbl_myjobtime` VALUES ('5', '16', '1');
INSERT INTO `tbl_myjobtime` VALUES ('6', '18', '1');

-- ----------------------------
-- Table structure for `tbl_review`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_review`;
CREATE TABLE `tbl_review` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `reviewtime` datetime DEFAULT NULL,
  `reviewcontent` varchar(500) DEFAULT NULL,
  `reviewstar` int(11) DEFAULT NULL,
  `crid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_review
-- ----------------------------
INSERT INTO `tbl_review` VALUES ('1', '2018-12-19 11:07:05', '', '90', '1');
INSERT INTO `tbl_review` VALUES ('2', '2018-12-14 11:08:25', '', '90', '2');
INSERT INTO `tbl_review` VALUES ('3', '2018-12-22 11:11:22', 'С', '80', '3');
INSERT INTO `tbl_review` VALUES ('4', '2018-12-18 11:11:38', 'С', '85', '4');

-- ----------------------------
-- Table structure for `tbl_teach`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teach`;
CREATE TABLE `tbl_teach` (
  `trid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `starttime` varchar(50) DEFAULT NULL,
  `endtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`trid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_teach
-- ----------------------------
INSERT INTO `tbl_teach` VALUES ('1', '1', '2', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('2', '1', '3', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('3', '2', '2', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('4', '2', '3', '9-11', '9-20');

-- ----------------------------
-- Table structure for `tbl_teachplan`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teachplan`;
CREATE TABLE `tbl_teachplan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `time` datetime DEFAULT NULL,
  `trid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_teachplan
-- ----------------------------
INSERT INTO `tbl_teachplan` VALUES ('1', '1-1', '2018-12-06 10:51:31', '1');
INSERT INTO `tbl_teachplan` VALUES ('2', '1-2', '2018-12-05 10:52:19', '1');
INSERT INTO `tbl_teachplan` VALUES ('3', '2-1', '2018-12-11 10:52:40', '2');
INSERT INTO `tbl_teachplan` VALUES ('4', '2-2', '2018-12-16 10:52:59', '2');

-- ----------------------------
-- Table structure for `tbl_time`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_time`;
CREATE TABLE `tbl_time` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_time
-- ----------------------------
INSERT INTO `tbl_time` VALUES ('1', '');
INSERT INTO `tbl_time` VALUES ('2', '');
INSERT INTO `tbl_time` VALUES ('3', '');
INSERT INTO `tbl_time` VALUES ('4', '');
INSERT INTO `tbl_time` VALUES ('5', '');
INSERT INTO `tbl_time` VALUES ('6', '');
INSERT INTO `tbl_time` VALUES ('7', '');
INSERT INTO `tbl_time` VALUES ('8', '');
INSERT INTO `tbl_time` VALUES ('9', '');
INSERT INTO `tbl_time` VALUES ('10', '');
INSERT INTO `tbl_time` VALUES ('11', '');
INSERT INTO `tbl_time` VALUES ('12', '');
INSERT INTO `tbl_time` VALUES ('13', '');
INSERT INTO `tbl_time` VALUES ('14', '');
INSERT INTO `tbl_time` VALUES ('15', '');
INSERT INTO `tbl_time` VALUES ('16', '');
INSERT INTO `tbl_time` VALUES ('17', '');
INSERT INTO `tbl_time` VALUES ('18', '');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `userpwd` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` char(30) DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  `realname` varchar(30) DEFAULT NULL,
  `idnumber` char(50) DEFAULT NULL,
  `sex` char(10) DEFAULT NULL,
  `stuimg` char(50) DEFAULT NULL,
  `userimg` char(50) DEFAULT NULL,
  `img1` varchar(255) DEFAULT NULL,
  `img2` varchar(255) DEFAULT NULL,
  `img3` varchar(255) DEFAULT NULL,
  `img4` varchar(255) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `grade` char(20) DEFAULT NULL,
  `phonenumber` char(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `publickey` text,
  `privatekey` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '', '123', 'zhangsan@qq.com', '', '2018-11-02 10:29:39', '张老师', '430621200001015432', '', null, null, 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '', '18', '110', '', '', '', '1', null, null);
INSERT INTO `tbl_user` VALUES ('2', '', '123', 'wangwu@', '', '2018-12-10 10:34:30', '', '430621199901012222', '', null, null, null, null, null, null, '', '17', '130', '', '', '', '1', null, null);
INSERT INTO `tbl_user` VALUES ('3', '', '123', 'lisi@qq.com', 'ѧ', '2018-11-14 10:29:30', '', '430621198501013456', '', null, null, null, null, null, null, null, null, '120', '', '', null, null, null, null);
INSERT INTO `tbl_user` VALUES ('4', 'С', '123', 'xiaoming@', 'ѧ', '2018-12-02 10:36:31', 'С', '430621201001013345', '', null, null, null, null, null, null, null, null, '140', '', '', null, null, null, null);
