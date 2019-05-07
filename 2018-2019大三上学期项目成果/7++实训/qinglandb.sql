/*
Navicat MySQL Data Transfer

Source Server         : 本机Mysql数据库
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-01-01 21:43:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_classrelation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_classrelation`;
CREATE TABLE `tbl_classrelation` (
  `crid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `trid` int(11) DEFAULT NULL,
  PRIMARY KEY (`crid`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_classrelation
-- ----------------------------
INSERT INTO `tbl_classrelation` VALUES ('1', '24', '1');
INSERT INTO `tbl_classrelation` VALUES ('2', '24', '2');
INSERT INTO `tbl_classrelation` VALUES ('10', '1', '3');
INSERT INTO `tbl_classrelation` VALUES ('11', '1', '4');

-- ----------------------------
-- Table structure for tbl_course
-- ----------------------------
DROP TABLE IF EXISTS `tbl_course`;
CREATE TABLE `tbl_course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

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
-- Table structure for tbl_grade
-- ----------------------------
DROP TABLE IF EXISTS `tbl_grade`;
CREATE TABLE `tbl_grade` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) DEFAULT NULL,
  `schooltype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

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
-- Table structure for tbl_homework
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
INSERT INTO `tbl_homework` VALUES ('2', '作业一作业一内容', '作业一作业一内容作业一作业一内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '44', '已完成', '已评价', '1', '1', null, null, 'sfsdfdsf');
INSERT INTO `tbl_homework` VALUES ('3', '作业二作业二内容', '数学作业：1=1 2=2 3=3 4=4 5=5', '2018-11-13 14:05:33', '2018-12-06 14:05:45', null, '已完成', '未完成', '2', '2', null, '', null);
INSERT INTO `tbl_homework` VALUES ('4', '作业三作业三内容', '作业三作业三内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', null, '未完成', '未完成', '10', '3', null, null, null);

-- ----------------------------
-- Table structure for tbl_msg
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
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_msg
-- ----------------------------
INSERT INTO `tbl_msg` VALUES ('50', '1', '2', '敬爱的381929295@qq.com您好：用户1945642767@qq.com于1546330271699预约了您的null课程，请选择是否同意自己联系方式发送给ta。', '2019-01-01 16:11:11', '0');
INSERT INTO `tbl_msg` VALUES ('51', '1', '2', '请选择381929295@qq.com是否成为了您的家教：', '2019-01-01 16:11:11', '2');
INSERT INTO `tbl_msg` VALUES ('52', '2', '1', '请选择您是否成为了1945642767@qq.com的家教：', '2019-01-01 16:11:11', '2');
INSERT INTO `tbl_msg` VALUES ('56', '2', '1', '15226579789', '2019-01-01 20:26:37', '0');
INSERT INTO `tbl_msg` VALUES ('57', '1', '2', '敬爱的381929295@qq.com您好：用户1945642767@qq.com于1546348149808预约了您的一年级课程，请选择是否同意自己联系方式发送给ta。', '2019-01-01 21:09:09', '0');
INSERT INTO `tbl_msg` VALUES ('58', '2', '1', '请选择381929295@qq.com是否成为了您的家教：', '2019-01-01 21:09:09', '1');
INSERT INTO `tbl_msg` VALUES ('59', '1', '2', '请选择您是否成为了1945642767@qq.com的家教：', '2019-01-01 21:09:09', '0');
INSERT INTO `tbl_msg` VALUES ('60', '1', '2', 'He refuse your message', '2019-01-01 21:09:36', '2');

-- ----------------------------
-- Table structure for tbl_myjob
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjob`;
CREATE TABLE `tbl_myjob` (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `teacherage` varchar(10) DEFAULT NULL,
  `experience` text,
  `success` text,
  PRIMARY KEY (`jid`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjob
-- ----------------------------
INSERT INTO `tbl_myjob` VALUES ('16', '10', null, '321', '3-5', 'aaaaaaaaaaaa', '1fadsfjka');
INSERT INTO `tbl_myjob` VALUES ('17', '11', null, '542', '3-5', 'asffasdf', 'dsfadfa');
INSERT INTO `tbl_myjob` VALUES ('15', '2', '北京-北京市-东城区', '111', '2-5', 'aaa', '123');
INSERT INTO `tbl_myjob` VALUES ('3', '3', '', '133', '3-5', '', '');
INSERT INTO `tbl_myjob` VALUES ('4', '4', '', '455', '4-10', '', '');
INSERT INTO `tbl_myjob` VALUES ('5', '5', '', '555', '5-11', '', '');
INSERT INTO `tbl_myjob` VALUES ('6', '6', '', '666', '6-10', '', '');
INSERT INTO `tbl_myjob` VALUES ('7', '7', '', '777', '7-9', '', '');
INSERT INTO `tbl_myjob` VALUES ('8', '8', '', '888', '8-10', '', '');
INSERT INTO `tbl_myjob` VALUES ('9', '9', '', '999', '9-10', '', '');

-- ----------------------------
-- Table structure for tbl_myjobcourse
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobcourse`;
CREATE TABLE `tbl_myjobcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobcourse
-- ----------------------------
INSERT INTO `tbl_myjobcourse` VALUES ('20', '1', '15');
INSERT INTO `tbl_myjobcourse` VALUES ('2', '3', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('3', '1', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('4', '4', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('5', '5', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('27', '8', '6');
INSERT INTO `tbl_myjobcourse` VALUES ('28', '1', '7');
INSERT INTO `tbl_myjobcourse` VALUES ('8', '1', '3');
INSERT INTO `tbl_myjobcourse` VALUES ('9', '2', '3');
INSERT INTO `tbl_myjobcourse` VALUES ('10', '3', '4');
INSERT INTO `tbl_myjobcourse` VALUES ('11', '1', '4');
INSERT INTO `tbl_myjobcourse` VALUES ('12', '2', '4');
INSERT INTO `tbl_myjobcourse` VALUES ('13', '3', '3');
INSERT INTO `tbl_myjobcourse` VALUES ('21', '2', '5');
INSERT INTO `tbl_myjobcourse` VALUES ('22', '1', '5');
INSERT INTO `tbl_myjobcourse` VALUES ('23', '3', '5');
INSERT INTO `tbl_myjobcourse` VALUES ('24', '8', '5');
INSERT INTO `tbl_myjobcourse` VALUES ('25', '2', '6');
INSERT INTO `tbl_myjobcourse` VALUES ('26', '4', '6');
INSERT INTO `tbl_myjobcourse` VALUES ('29', '4', '7');
INSERT INTO `tbl_myjobcourse` VALUES ('30', '8', '7');
INSERT INTO `tbl_myjobcourse` VALUES ('31', '8', '8');
INSERT INTO `tbl_myjobcourse` VALUES ('32', '1', '8');
INSERT INTO `tbl_myjobcourse` VALUES ('33', '4', '8');
INSERT INTO `tbl_myjobcourse` VALUES ('34', '1', '9');
INSERT INTO `tbl_myjobcourse` VALUES ('35', '5', '9');
INSERT INTO `tbl_myjobcourse` VALUES ('36', '2', '9');
INSERT INTO `tbl_myjobcourse` VALUES ('37', '1', '10');
INSERT INTO `tbl_myjobcourse` VALUES ('38', '3', '10');
INSERT INTO `tbl_myjobcourse` VALUES ('39', '5', '10');
INSERT INTO `tbl_myjobcourse` VALUES ('40', '1', '11');
INSERT INTO `tbl_myjobcourse` VALUES ('41', '3', '11');

-- ----------------------------
-- Table structure for tbl_myjobgrade
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobgrade`;
CREATE TABLE `tbl_myjobgrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobgrade
-- ----------------------------
INSERT INTO `tbl_myjobgrade` VALUES ('25', '1', '15');
INSERT INTO `tbl_myjobgrade` VALUES ('2', '7', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('3', '8', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('4', '11', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('5', '12', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('6', '1', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('7', '2', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('8', '3', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('9', '4', '1');
INSERT INTO `tbl_myjobgrade` VALUES ('10', '1', '3');
INSERT INTO `tbl_myjobgrade` VALUES ('11', '2', '3');
INSERT INTO `tbl_myjobgrade` VALUES ('33', '1', '8');
INSERT INTO `tbl_myjobgrade` VALUES ('13', '1', '4');
INSERT INTO `tbl_myjobgrade` VALUES ('14', '9', '4');
INSERT INTO `tbl_myjobgrade` VALUES ('15', '6', '4');
INSERT INTO `tbl_myjobgrade` VALUES ('16', '6', '3');
INSERT INTO `tbl_myjobgrade` VALUES ('34', '2', '8');
INSERT INTO `tbl_myjobgrade` VALUES ('26', '2', '5');
INSERT INTO `tbl_myjobgrade` VALUES ('27', '6', '5');
INSERT INTO `tbl_myjobgrade` VALUES ('28', '4', '5');
INSERT INTO `tbl_myjobgrade` VALUES ('29', '1', '6');
INSERT INTO `tbl_myjobgrade` VALUES ('30', '5', '6');
INSERT INTO `tbl_myjobgrade` VALUES ('31', '1', '7');
INSERT INTO `tbl_myjobgrade` VALUES ('32', '7', '7');
INSERT INTO `tbl_myjobgrade` VALUES ('35', '5', '8');
INSERT INTO `tbl_myjobgrade` VALUES ('36', '3', '9');
INSERT INTO `tbl_myjobgrade` VALUES ('37', '1', '9');
INSERT INTO `tbl_myjobgrade` VALUES ('38', '8', '9');
INSERT INTO `tbl_myjobgrade` VALUES ('39', '1', '10');
INSERT INTO `tbl_myjobgrade` VALUES ('40', '3', '10');
INSERT INTO `tbl_myjobgrade` VALUES ('41', '1', '11');
INSERT INTO `tbl_myjobgrade` VALUES ('42', '9', '11');
INSERT INTO `tbl_myjobgrade` VALUES ('43', '3', '15');
INSERT INTO `tbl_myjobgrade` VALUES ('44', '4', '15');
INSERT INTO `tbl_myjobgrade` VALUES ('45', '7', '15');
INSERT INTO `tbl_myjobgrade` VALUES ('46', '8', '15');

-- ----------------------------
-- Table structure for tbl_myjobtime
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobtime`;
CREATE TABLE `tbl_myjobtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobtime
-- ----------------------------
INSERT INTO `tbl_myjobtime` VALUES ('1', '2', '1');
INSERT INTO `tbl_myjobtime` VALUES ('26', '1', '15');
INSERT INTO `tbl_myjobtime` VALUES ('3', '6', '1');
INSERT INTO `tbl_myjobtime` VALUES ('4', '4', '1');
INSERT INTO `tbl_myjobtime` VALUES ('5', '16', '1');
INSERT INTO `tbl_myjobtime` VALUES ('6', '18', '1');
INSERT INTO `tbl_myjobtime` VALUES ('7', '16', '7');
INSERT INTO `tbl_myjobtime` VALUES ('8', '16', '8');
INSERT INTO `tbl_myjobtime` VALUES ('9', '16', '9');
INSERT INTO `tbl_myjobtime` VALUES ('10', '8', '12');
INSERT INTO `tbl_myjobtime` VALUES ('11', '6', '12');
INSERT INTO `tbl_myjobtime` VALUES ('12', '7', '12');
INSERT INTO `tbl_myjobtime` VALUES ('13', '2', '12');
INSERT INTO `tbl_myjobtime` VALUES ('14', '1', '12');
INSERT INTO `tbl_myjobtime` VALUES ('15', '1', '13');
INSERT INTO `tbl_myjobtime` VALUES ('16', '5', '13');
INSERT INTO `tbl_myjobtime` VALUES ('17', '11', '13');
INSERT INTO `tbl_myjobtime` VALUES ('18', '14', '13');
INSERT INTO `tbl_myjobtime` VALUES ('19', '17', '13');
INSERT INTO `tbl_myjobtime` VALUES ('20', '1', '14');
INSERT INTO `tbl_myjobtime` VALUES ('21', '11', '14');
INSERT INTO `tbl_myjobtime` VALUES ('22', '8', '14');
INSERT INTO `tbl_myjobtime` VALUES ('23', '5', '14');
INSERT INTO `tbl_myjobtime` VALUES ('24', '9', '14');
INSERT INTO `tbl_myjobtime` VALUES ('25', '12', '14');

-- ----------------------------
-- Table structure for tbl_review
-- ----------------------------
DROP TABLE IF EXISTS `tbl_review`;
CREATE TABLE `tbl_review` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `reviewtime` datetime DEFAULT NULL,
  `reviewcontent` varchar(500) DEFAULT NULL,
  `reviewstar` int(11) DEFAULT NULL,
  `crid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_review
-- ----------------------------
INSERT INTO `tbl_review` VALUES ('1', '2018-12-19 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '1');
INSERT INTO `tbl_review` VALUES ('2', '2018-12-14 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '2');
INSERT INTO `tbl_review` VALUES ('3', '2018-12-22 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '3');
INSERT INTO `tbl_review` VALUES ('4', '2018-12-18 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '4');
INSERT INTO `tbl_review` VALUES ('5', '2018-12-07 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '1');
INSERT INTO `tbl_review` VALUES ('6', '2018-12-06 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '2');
INSERT INTO `tbl_review` VALUES ('7', '2018-12-12 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '3');
INSERT INTO `tbl_review` VALUES ('8', '2018-12-01 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '4');
INSERT INTO `tbl_review` VALUES ('9', '2018-12-12 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '5', '1');

-- ----------------------------
-- Table structure for tbl_teach
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teach`;
CREATE TABLE `tbl_teach` (
  `trid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `starttime` varchar(50) DEFAULT NULL,
  `endtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`trid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_teach
-- ----------------------------
INSERT INTO `tbl_teach` VALUES ('1', '2', '2', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('2', '2', '3', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('3', '2', '2', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('4', '2', '3', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('13', '3', '1', '9-11', '9-20');

-- ----------------------------
-- Table structure for tbl_teachplan
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teachplan`;
CREATE TABLE `tbl_teachplan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `time` datetime DEFAULT NULL,
  `trid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_teachplan
-- ----------------------------
INSERT INTO `tbl_teachplan` VALUES ('1', '1-1', '2018-12-06 10:51:31', '1');
INSERT INTO `tbl_teachplan` VALUES ('2', '1-2', '2018-12-05 10:52:19', '1');
INSERT INTO `tbl_teachplan` VALUES ('3', '2-1', '2018-12-11 10:52:40', '2');
INSERT INTO `tbl_teachplan` VALUES ('4', '2-2', '2018-12-16 10:52:59', '2');
INSERT INTO `tbl_teachplan` VALUES ('5', '1-1', '2018-12-13 15:23:09', '1');
INSERT INTO `tbl_teachplan` VALUES ('6', '2-1', '2018-12-14 15:23:24', '2');
INSERT INTO `tbl_teachplan` VALUES ('7', '1-1', '2018-12-14 17:28:42', '1');
INSERT INTO `tbl_teachplan` VALUES ('8', '1-2', '2018-12-12 17:29:04', '2');
INSERT INTO `tbl_teachplan` VALUES ('9', '1-1', '2018-11-02 17:29:15', '1');

-- ----------------------------
-- Table structure for tbl_time
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
-- Table structure for tbl_user
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
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('11', '张老师', '123', 'zhangsan@qq.com', '老师', '2018-11-02 00:04:00', '张老师', '430621200001015432', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '15226579789', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '理科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('10', '李舒', '123', 'wangwu@qq.com', '老师', '2018-12-10 00:00:00', '李舒', '430621199901012222', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大三', '130', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '文科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('9', '王小宾', '123', 'lisi@qq.com', '老师', '2018-11-14 00:00:00', '王小宾', '430621198501013456', '男', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大三', '120', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '理科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('8', '张三', '123', 'xiaoming@', '老师', '2018-12-02 00:00:00', '张三', '430621201001013345', '男', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '140', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '文科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('7', '赵一', '123', 'zhangsan@qq.com', '老师', '2018-11-02 00:00:00', '赵一', '430621200001015432', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '110', '', '我是赵一', '理科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('6', '钱二', '123', 'wangwu@', '老师', '2018-12-10 00:00:00', '钱二', '430621199901012222', '男', 'images/detail-img2.png', 'images/idphoto2.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '130', '', '我是钱二', '理科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('5', '孙三', '123', 'lisi@qq.com', '老师', '2018-11-14 00:00:00', '孙三', '430621198501013456', '女', 'images/detail-img2.png', 'images/idphoto3.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '120', '', '我是孙三', '文科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('4', '李四', '123', 'xiaoming@', '老师', '2018-12-02 00:00:00', '李四', '430621201001013345', '男', 'images/detail-img2.png', 'images/idphoto4.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '140', '', '我是李四', '文科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('3', '周五', '123', 'e@qq.com', '老师', '2018-12-13 00:00:00', '周五', '430621201001013345', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '150', '', '我是周五', '理科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('1', 'li123456', 'R5TRXUNakjA3gckn2CuiWRCrA/gdxYH1PjOBF4ZZsP5aIeM+GKmti4oQlt8EFXtz4KuwJLWWF76FL6CPg4X46w==', '1945642767@qq.com', '家长', '2018-11-02 00:04:00', '李哈哈', '372323199707240000', '女', 'images/detail-img2.png', 'images/idphoto5.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '15226579789', null, '这是个人简介', '理科', '1', 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJk9quYtp2bB0gtYYvXYFhUftu5GHALbGHgGtFpZgqBpVroYSdZmrPvymF+ov4TGOv8RglLRyIJH9+eGpNpZ9ksCAwEAAQ==', 'MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAmT2q5i2nZsHSC1hi9dgWFR+27kYcAtsYeAa0WlmCoGlWuhhJ1mas+/KYX6i/hMY6/xGCUtHIgkf354ak2ln2SwIDAQABAkEAihw0PMQEze39mtAMULpyHJO60UFK2aARi4uvXIaz3lHjtXec20obJmpRjdUMVkb3E6e5WfsWbdXpgYcv+8zYQQIhAPkJv+vevK4glO7i4Tz0NLQ+NANsQ522KH/1nTpU8LUbAiEAnYZXeQsPOMAAoCsastvLc1ep455WjL6rFSEONNNaRpECIQCcGT9iYngUETopTq7uHQhYHlFN//OWDJLwOg02ff1vFwIgXcgCQbz01ftxI+olngA+8q9pJGs66dYF8rFYTNjbcRECIEDaaR5de3CSHSbrH9SOdR62gY7+Z3ZpN8cfP4rjqTfn');
INSERT INTO `tbl_user` VALUES ('2', 'liu123', 'dKNWRmrsHjqbGP0EZHsbBx6qDXbgrEWJSe+gZOwiHWJiVz7DWTRIAJ/C2Ae/yVH7fD3yUTgn9141MRW1cgUCzQ==', '381929295@qq.com', '老师', '2018-12-04 15:41:20', '刘一', '372323199707240000', '女', 'images/detail-img2.png', 'images/idphoto6.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大三', '15226579789', '石家庄市', '这是个人简介', '文科', '1', 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIdVJaCB3yRU3qQ6g8sH/Sa+djgjdYvNJq9NYe2LMG8fnWbJIBWOy0Kvy8ALANP4oP9BytEh2nuySTIbQ2pW14kCAwEAAQ==', 'MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAh1UloIHfJFTepDqDywf9Jr52OCN1i80mr01h7Yswbx+dZskgFY7LQq/LwAsA0/ig/0HK0SHae7JJMhtDalbXiQIDAQABAkBxSXDHDRCLbFQ37BfZROXAoh16XwyOK/zfMIrye9remcOiNAKKFrDe66x9c+WF5HynZndkEijq1mKtdbYvsL51AiEAwVqQutn00uIOTPVOl/PWJGUmjdoeyZJpG3km7TKAeesCIQCzLhqvoejrkfcq1tkVnXKxoXqI+1ECCid1DYeuyIlDWwIgRDzLITZ0ocwn0d8tCpGCfLu5/IwDG45xS8HZDBMrplsCIFG/WxV+PRIcyjOVSf1+k/FOxuTwJAlWMKJKxfiMLXO5AiAglSES0WuXO2R/jiHdkmMI69s01UvFhVR3b3DbNO7ggw==');
INSERT INTO `tbl_user` VALUES ('24', 'aa8023', 'nr+v27dNTtYPzFLg60Br6TCb02dRmaPcLpvkftBl3A0fLndazxvkf/Y1QKZjz6HL5/xh8xPItnmR1mZ40QGjJw==', '760543074@qq.com', '家长', '2019-01-01 20:27:13', '张同学', '123454321234567898', '男', 'images/detail-img2.png', 'images/idphoto6.png', 'img5.jpg', 'img1.png', 'img2.png', 'img3.png', null, null, null, null, '这是个人简介', null, null, 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANjyKqzbxjQ4pJMRztoUZTV58ZoiduIU67PT8xZFW0Xs8xfmqfFJAUVOguGqJNB+x4RCJk2MYZrSuVdWbjU9Qo8CAwEAAQ==', 'MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEA2PIqrNvGNDikkxHO2hRlNXnxmiJ24hTrs9PzFkVbRezzF+ap8UkBRU6C4aok0H7HhEImTYxhmtK5V1ZuNT1CjwIDAQABAkEAjOYbGVFTlS8ElBAIzFJauTSN2ZFwrLzxqEWLp3c8JFjiFr+U3FxoeuDTCRuIMrE9av5lzTD8rmFjmM/sZo5DIQIhAO4ogDY8MtytO1vsWSUcPPtLaQ9D/ql8P4ioSmGY2RPjAiEA6TLZNeECMaNA/rjLnTKf3QmA0Rp/ZL0UdyLXL9EWDmUCIQDB2mOqQcvgxn0XsMVLKLYWkmZcz6rdiE4qzVlmIcUoowIgLxC3LBukoLYNSRus5KYyA5+GYy2Q5pkOx1i9y4XMiM0CIQCzimhS1Dch4/wYiCfUgCikkMwP6F1ewZ1fYcI502wpqw==');
