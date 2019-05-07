/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2018-12-18 15:57:30
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
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_classrelation
-- ----------------------------
INSERT INTO `tbl_classrelation` VALUES ('1', '3', '1');
INSERT INTO `tbl_classrelation` VALUES ('2', '3', '4');
INSERT INTO `tbl_classrelation` VALUES ('3', '4', '2');
INSERT INTO `tbl_classrelation` VALUES ('4', '4', '3');
INSERT INTO `tbl_classrelation` VALUES ('5', '5', '5');
INSERT INTO `tbl_classrelation` VALUES ('6', '6', '6');
INSERT INTO `tbl_classrelation` VALUES ('7', '7', '7');
INSERT INTO `tbl_classrelation` VALUES ('8', '8', '8');
INSERT INTO `tbl_classrelation` VALUES ('9', '9', '9');

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
INSERT INTO `tbl_homework` VALUES ('2', '作业一作业一内容', '作业一作业一内容作业一作业一内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '80', '已完成', 'δ', '2', '4', null, null, null);
INSERT INTO `tbl_homework` VALUES ('3', '作业二作业二内容', '', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '已完成', 'δ', '3', '2', null, '', null);
INSERT INTO `tbl_homework` VALUES ('4', '作业三作业三内容', '作业三作业三内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '', 'δ', '4', '3', null, null, null);
INSERT INTO `tbl_homework` VALUES ('5', '作业四作业四内容', '作业四作业四内容', '2018-11-13 14:05:33', '2018-12-06 14:05:45', '90', '', 'δ', '1', '1', null, null, null);

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
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_msg
-- ----------------------------
INSERT INTO `tbl_msg` VALUES ('1', '3', '1', '风刀霜剑施蒂利克福建省点开链接发了多少看风景', '2018-08-09 00:00:00', '2');
INSERT INTO `tbl_msg` VALUES ('2', '3', '2', '风刀霜剑看电视', '2018-07-12 00:00:00', '0');
INSERT INTO `tbl_msg` VALUES ('3', '4', '1', '收款发动机', '2018-11-16 00:00:00', '1');
INSERT INTO `tbl_msg` VALUES ('4', '4', '2', '速度快放假了斯柯达', '2018-12-01 00:00:00', '0');
INSERT INTO `tbl_msg` VALUES ('5', '5', '1', '', '0000-00-00 00:00:00', null);
INSERT INTO `tbl_msg` VALUES ('6', '6', '2', '', '0000-00-00 00:00:00', null);
INSERT INTO `tbl_msg` VALUES ('7', '7', '1', '', '0000-00-00 00:00:00', null);
INSERT INTO `tbl_msg` VALUES ('8', '8', '1', '', '0000-00-00 00:00:00', null);
INSERT INTO `tbl_msg` VALUES ('9', '9', '2', '', '0000-00-00 00:00:00', null);

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
  `success` text,
  PRIMARY KEY (`jid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjob
-- ----------------------------
INSERT INTO `tbl_myjob` VALUES ('1', '1', '', '110', '1', null, null);
INSERT INTO `tbl_myjob` VALUES ('2', '2', '', '100', '2', null, null);
INSERT INTO `tbl_myjob` VALUES ('3', '3', '', '133', '3', '', '');
INSERT INTO `tbl_myjob` VALUES ('4', '4', '', '455', '4', '', '');
INSERT INTO `tbl_myjob` VALUES ('5', '5', '', '555', '5', '', '');
INSERT INTO `tbl_myjob` VALUES ('6', '6', '', '666', '6', '', '');
INSERT INTO `tbl_myjob` VALUES ('7', '7', '', '777', '7', '', '');
INSERT INTO `tbl_myjob` VALUES ('8', '8', '', '888', '8', '', '');
INSERT INTO `tbl_myjob` VALUES ('9', '9', '', '999', '9', '', '');

-- ----------------------------
-- Table structure for `tbl_myjobcourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobcourse`;
CREATE TABLE `tbl_myjobcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobcourse
-- ----------------------------
INSERT INTO `tbl_myjobcourse` VALUES ('1', '2', '2');
INSERT INTO `tbl_myjobcourse` VALUES ('2', '3', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('3', '1', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('4', '4', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('5', '5', '1');
INSERT INTO `tbl_myjobcourse` VALUES ('6', '4', '2');
INSERT INTO `tbl_myjobcourse` VALUES ('7', '5', '2');
INSERT INTO `tbl_myjobcourse` VALUES ('8', '1', '3');
INSERT INTO `tbl_myjobcourse` VALUES ('9', '2', '3');
INSERT INTO `tbl_myjobcourse` VALUES ('10', '3', '4');
INSERT INTO `tbl_myjobcourse` VALUES ('11', '1', '4');
INSERT INTO `tbl_myjobcourse` VALUES ('12', '2', '4');
INSERT INTO `tbl_myjobcourse` VALUES ('13', '3', '3');

-- ----------------------------
-- Table structure for `tbl_myjobgrade`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobgrade`;
CREATE TABLE `tbl_myjobgrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobgrade
-- ----------------------------
INSERT INTO `tbl_myjobgrade` VALUES ('1', '4', '2');
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
INSERT INTO `tbl_myjobgrade` VALUES ('12', '3', '2');
INSERT INTO `tbl_myjobgrade` VALUES ('13', '1', '4');
INSERT INTO `tbl_myjobgrade` VALUES ('14', '2', '4');
INSERT INTO `tbl_myjobgrade` VALUES ('15', '6', '4');
INSERT INTO `tbl_myjobgrade` VALUES ('16', '6', '3');
INSERT INTO `tbl_myjobgrade` VALUES ('17', '5', '2');

-- ----------------------------
-- Table structure for `tbl_myjobtime`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobtime`;
CREATE TABLE `tbl_myjobtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjobtime
-- ----------------------------
INSERT INTO `tbl_myjobtime` VALUES ('1', '2', '1');
INSERT INTO `tbl_myjobtime` VALUES ('2', '3', '2');
INSERT INTO `tbl_myjobtime` VALUES ('3', '6', '1');
INSERT INTO `tbl_myjobtime` VALUES ('4', '4', '1');
INSERT INTO `tbl_myjobtime` VALUES ('5', '16', '1');
INSERT INTO `tbl_myjobtime` VALUES ('6', '18', '1');
INSERT INTO `tbl_myjobtime` VALUES ('7', '16', '7');
INSERT INTO `tbl_myjobtime` VALUES ('8', '16', '8');
INSERT INTO `tbl_myjobtime` VALUES ('9', '16', '9');

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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_review
-- ----------------------------
INSERT INTO `tbl_review` VALUES ('1', '2018-12-19 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '1', '1');
INSERT INTO `tbl_review` VALUES ('2', '2018-12-14 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '1', '2');
INSERT INTO `tbl_review` VALUES ('3', '2018-12-22 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '1', '3');
INSERT INTO `tbl_review` VALUES ('4', '2018-12-18 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '85', '4');
INSERT INTO `tbl_review` VALUES ('5', '2018-12-07 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '90', '5');
INSERT INTO `tbl_review` VALUES ('6', '2018-12-06 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '90', '6');
INSERT INTO `tbl_review` VALUES ('7', '2018-12-12 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '80', '7');
INSERT INTO `tbl_review` VALUES ('8', '2018-12-01 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '90', '8');
INSERT INTO `tbl_review` VALUES ('9', '2018-12-12 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '90', '9');
INSERT INTO `tbl_review` VALUES ('10', '2018-12-06 15:14:38', '见识到了开发聚隆科技乐山大佛会计师的房价来看莱克斯顿', null, '1');
INSERT INTO `tbl_review` VALUES ('11', '2018-09-20 15:15:12', '诶UR偶尔有我让业务i', null, '1');
INSERT INTO `tbl_review` VALUES ('12', '2018-11-05 19:15:34', '反倒是离开家里看电视弗兰克', null, '1');

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
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_teach
-- ----------------------------
INSERT INTO `tbl_teach` VALUES ('1', '1', '2', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('2', '1', '3', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('3', '2', '2', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('4', '2', '3', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('5', '5', '5', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('6', '6', '6', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('7', '7', '7', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('8', '8', '8', '9-11', '9-20');
INSERT INTO `tbl_teach` VALUES ('9', '9', '9', '9-11', '9-20');

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
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '张老师', '123', 'zhangsan@qq.com', '老师', '2018-11-02 00:04:00', '张老师', '430621200001015432', '女老师', null, 'images/b.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '18', '110', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '理科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('2', '李舒', '123', 'wangwu@qq.com', '老师', '2018-12-10 00:00:00', '李舒', '430621199901012222', '女老师', null, 'images/big-img3.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '17', '130', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '文科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('3', '王小宾', '123', 'lisi@qq.com', '老师', '2018-11-14 00:00:00', '王小宾', '430621198501013456', '男老师', null, 'images/big-img4.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '20', '120', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '理科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('4', '张三', '123', 'xiaoming@', '老师', '2018-12-02 00:00:00', '张三', '430621201001013345', '男老师', null, 'images/big-img5.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '19', '140', '', '一线教师，物理年级组长，年级主任，心理咨询师，让学生在短期内爱上学习', '文科', '1', null, null);
INSERT INTO `tbl_user` VALUES ('5', '赵一', '123', 'zhangsan@qq.com', '老师', '2018-11-02 00:00:00', '赵一', '430621200001015432', '女老师', '', 'images/idphoto1.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '18', '110', '', '我是赵一', '理科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('6', '钱二', '123', 'wangwu@', '老师', '2018-12-10 00:00:00', '钱二', '430621199901012222', '男老师', '', 'images/idphoto2.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '17', '130', '', '我是钱二', '理科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('7', '孙三', '123', 'lisi@qq.com', '老师', '2018-11-14 00:00:00', '孙三', '430621198501013456', '女老师', '', 'images/idphoto3.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '17', '120', '', '我是孙三', '文科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('8', '李四', '123', 'xiaoming@', '老师', '2018-12-02 00:00:00', '李四', '430621201001013345', '男老师', '', 'images/idphoto4.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '18', '140', '', '我是李四', '文科', '1', '', '');
INSERT INTO `tbl_user` VALUES ('9', '周五', '123', 'e@qq.com', '老师', '2018-12-13 00:00:00', '周五', '430621201001013345', '女老师', '', 'images/idphoto1.jpg', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '19', '150', '', '我是周五', '理科', '1', '', '');
