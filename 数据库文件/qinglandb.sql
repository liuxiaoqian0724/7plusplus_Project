/*
Navicat MySQL Data Transfer

Source Server         : hy
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2018-12-05 14:14:01
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_grade
-- ----------------------------
INSERT INTO `tbl_grade` VALUES ('1', '一年级');
INSERT INTO `tbl_grade` VALUES ('2', '二年级');
INSERT INTO `tbl_grade` VALUES ('3', '三年级');
INSERT INTO `tbl_grade` VALUES ('4', '四年级');
INSERT INTO `tbl_grade` VALUES ('5', '五年级');
INSERT INTO `tbl_grade` VALUES ('6', '六年级');
INSERT INTO `tbl_grade` VALUES ('7', '初一');
INSERT INTO `tbl_grade` VALUES ('8', '初二');
INSERT INTO `tbl_grade` VALUES ('9', '初三');
INSERT INTO `tbl_grade` VALUES ('10', '高一');
INSERT INTO `tbl_grade` VALUES ('11', '高二');
INSERT INTO `tbl_grade` VALUES ('12', '高三');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_homework
-- ----------------------------
INSERT INTO `tbl_homework` VALUES ('0', '老师留的作业内容', '学生交的作业内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '已完成', '未查看', '1', '1');
INSERT INTO `tbl_homework` VALUES ('2', '老师留的作业内容', '学生交的作业内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', null, '未完成', '未查看', '2', '4');
INSERT INTO `tbl_homework` VALUES ('3', '老师留的作业内容', '学生交的作业内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '已完成', '未查看', '3', '2');
INSERT INTO `tbl_homework` VALUES ('4', '老师留的作业内容', '学生交的作业内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '已完成', '未查看', '4', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_msg
-- ----------------------------
INSERT INTO `tbl_msg` VALUES ('1', '3', '1', '李四发给张三的', '2018-08-09 10:43:54', '2');
INSERT INTO `tbl_msg` VALUES ('2', '3', '2', '李四发给王五的', '2018-07-12 10:44:18', '0');
INSERT INTO `tbl_msg` VALUES ('3', '4', '1', '小明发给张三的', '2018-11-16 10:45:49', '1');
INSERT INTO `tbl_msg` VALUES ('4', '4', '2', '小明发给李四的', '2018-12-01 10:46:06', '0');

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
  PRIMARY KEY (`jid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjob
-- ----------------------------
INSERT INTO `tbl_myjob` VALUES ('1', '1', '河北师范大学', '110', '1年');
INSERT INTO `tbl_myjob` VALUES ('2', '2', '河北师范大学', '100', '2年');

-- ----------------------------
-- Table structure for `tbl_myjobcourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobcourse`;
CREATE TABLE `tbl_myjobcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobgrade
-- ----------------------------
INSERT INTO `tbl_myjobgrade` VALUES ('1', '4', '2');
INSERT INTO `tbl_myjobgrade` VALUES ('2', '7', '1');

-- ----------------------------
-- Table structure for `tbl_myjobtime`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobtime`;
CREATE TABLE `tbl_myjobtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobtime
-- ----------------------------
INSERT INTO `tbl_myjobtime` VALUES ('1', '2', '1');
INSERT INTO `tbl_myjobtime` VALUES ('2', '3', '2');

-- ----------------------------
-- Table structure for `tbl_review`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_review`;
CREATE TABLE `tbl_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reviewtime` datetime DEFAULT NULL,
  `reviewcontent` varchar(500) DEFAULT NULL,
  `reviewstart` int(11) DEFAULT NULL,
  `crid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_review
-- ----------------------------
INSERT INTO `tbl_review` VALUES ('1', '2018-12-19 11:07:05', '李四对张三的评价', '90', '1');
INSERT INTO `tbl_review` VALUES ('2', '2018-12-14 11:08:25', '李四对王五的评价', '90', '2');
INSERT INTO `tbl_review` VALUES ('3', '2018-12-22 11:11:22', '小明对张三的评价', '80', '3');
INSERT INTO `tbl_review` VALUES ('4', '2018-12-18 11:11:38', '小明对王五的评价', '85', '4');

-- ----------------------------
-- Table structure for `tbl_teach`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teach`;
CREATE TABLE `tbl_teach` (
  `trid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `classtime` int(11) DEFAULT NULL,
  PRIMARY KEY (`trid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_teach
-- ----------------------------
INSERT INTO `tbl_teach` VALUES ('1', '1', '2', '3');
INSERT INTO `tbl_teach` VALUES ('2', '1', '3', '4');
INSERT INTO `tbl_teach` VALUES ('3', '2', '2', '3');
INSERT INTO `tbl_teach` VALUES ('4', '2', '3', '4');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

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
  `timeid` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`timeid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_time
-- ----------------------------
INSERT INTO `tbl_time` VALUES ('1', '周一上午');
INSERT INTO `tbl_time` VALUES ('2', '周一下午');
INSERT INTO `tbl_time` VALUES ('3', '周一晚上');
INSERT INTO `tbl_time` VALUES ('4', '周二上午');
INSERT INTO `tbl_time` VALUES ('5', '周二下午');
INSERT INTO `tbl_time` VALUES ('6', '周二晚上');
INSERT INTO `tbl_time` VALUES ('7', '周三上午');
INSERT INTO `tbl_time` VALUES ('8', '周三下午');
INSERT INTO `tbl_time` VALUES ('9', '周三晚上');
INSERT INTO `tbl_time` VALUES ('10', '周四上午');
INSERT INTO `tbl_time` VALUES ('11', '周四下午');
INSERT INTO `tbl_time` VALUES ('12', '周四晚上');
INSERT INTO `tbl_time` VALUES ('13', '周五上午');
INSERT INTO `tbl_time` VALUES ('14', '周六下午');
INSERT INTO `tbl_time` VALUES ('15', '周六晚上');
INSERT INTO `tbl_time` VALUES ('16', '周日上午');
INSERT INTO `tbl_time` VALUES ('17', '周日下午');
INSERT INTO `tbl_time` VALUES ('18', '周日晚上');

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
  `school` varchar(50) DEFAULT NULL,
  `grade` char(20) DEFAULT NULL,
  `phonenumber` char(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `publickey` varchar(255) DEFAULT NULL,
  `privatekey` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '张三', '123', 'zhangsan@qq.com', '老师', '2018-11-02 10:29:39', '张三', '430621200001015432', '男', null, null, '河北师范大学', '18级', '110', '河北师范大学', '我是张三', '软件', '1', null, null);
INSERT INTO `tbl_user` VALUES ('2', '王五', '123', 'wangwu@', '老师', '2018-12-10 10:34:30', '王五', '430621199901012222', '男', null, null, '河北师范大学', '17级', '130', '河北大学', '我是王武', '数信', '1', null, null);
INSERT INTO `tbl_user` VALUES ('3', '李四', '123', 'lisi@qq.com', '学生', '2018-11-14 10:29:30', '李四', '430621198501013456', '男', null, null, null, null, '120', '河北工业大学', '我是李四', null, null, null, null);
INSERT INTO `tbl_user` VALUES ('4', '小明', '123', 'xiaoming@', '学生', '2018-12-02 10:36:31', '小明', '430621201001013345', '男', null, null, null, null, '140', '天津大学', '我是小明', null, null, null, null);
