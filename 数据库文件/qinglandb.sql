/*
Navicat MySQL Data Transfer

Source Server         : 本机Mysql数据库
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : qinglan1

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-05-07 10:25:56
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
INSERT INTO `tbl_classrelation` VALUES ('1', '10', '1');
INSERT INTO `tbl_classrelation` VALUES ('2', '11', '1');
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
INSERT INTO `tbl_course` VALUES ('10', '英语');
INSERT INTO `tbl_course` VALUES ('11', '英语');
INSERT INTO `tbl_course` VALUES ('12', '英语');
INSERT INTO `tbl_course` VALUES ('13', '英语');
INSERT INTO `tbl_course` VALUES ('14', '语文');
INSERT INTO `tbl_course` VALUES ('15', '语文');
INSERT INTO `tbl_course` VALUES ('16', '语文');
INSERT INTO `tbl_course` VALUES ('17', '数学');
INSERT INTO `tbl_course` VALUES ('18', '英语');
INSERT INTO `tbl_course` VALUES ('19', '数学');
INSERT INTO `tbl_course` VALUES ('20', '语文');
INSERT INTO `tbl_course` VALUES ('21', '语文');
INSERT INTO `tbl_course` VALUES ('22', '数学');

-- ----------------------------
-- Table structure for `tbl_grade`
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
INSERT INTO `tbl_grade` VALUES ('17', '高二 ', null);
INSERT INTO `tbl_grade` VALUES ('18', '初二 ', null);
INSERT INTO `tbl_grade` VALUES ('19', '高三 ', null);
INSERT INTO `tbl_grade` VALUES ('20', '初二 ', null);
INSERT INTO `tbl_grade` VALUES ('21', '高二 ', null);
INSERT INTO `tbl_grade` VALUES ('22', '高三 ', null);
INSERT INTO `tbl_grade` VALUES ('23', '二年级', null);
INSERT INTO `tbl_grade` VALUES ('24', '二年级', null);
INSERT INTO `tbl_grade` VALUES ('25', '初一 ', null);
INSERT INTO `tbl_grade` VALUES ('26', '一年级', null);
INSERT INTO `tbl_grade` VALUES ('27', '一年级', null);
INSERT INTO `tbl_grade` VALUES ('28', '初二 ', null);
INSERT INTO `tbl_grade` VALUES ('29', '初二 ', null);
INSERT INTO `tbl_grade` VALUES ('30', '高二 ', null);
INSERT INTO `tbl_grade` VALUES ('31', '一年级', null);

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
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

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
INSERT INTO `tbl_msg` VALUES ('10', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 16:39:05', '0');
INSERT INTO `tbl_msg` VALUES ('11', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 16:39:05', '0');
INSERT INTO `tbl_msg` VALUES ('12', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 16:39:09', '0');
INSERT INTO `tbl_msg` VALUES ('13', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 16:39:09', '0');
INSERT INTO `tbl_msg` VALUES ('14', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 17:02:18', '0');
INSERT INTO `tbl_msg` VALUES ('15', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 17:02:18', '0');
INSERT INTO `tbl_msg` VALUES ('16', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 17:05:52', '0');
INSERT INTO `tbl_msg` VALUES ('17', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 17:05:52', '0');
INSERT INTO `tbl_msg` VALUES ('18', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 17:38:17', '0');
INSERT INTO `tbl_msg` VALUES ('19', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 17:38:17', '0');
INSERT INTO `tbl_msg` VALUES ('20', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 17:44:47', '0');
INSERT INTO `tbl_msg` VALUES ('21', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 17:44:47', '0');
INSERT INTO `tbl_msg` VALUES ('22', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 17:46:05', '0');
INSERT INTO `tbl_msg` VALUES ('23', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 17:46:05', '0');
INSERT INTO `tbl_msg` VALUES ('24', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 18:05:53', '0');
INSERT INTO `tbl_msg` VALUES ('25', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 18:05:53', '0');
INSERT INTO `tbl_msg` VALUES ('26', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-25 19:47:31', '0');
INSERT INTO `tbl_msg` VALUES ('27', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-25 19:47:31', '0');
INSERT INTO `tbl_msg` VALUES ('28', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-26 08:44:48', '0');
INSERT INTO `tbl_msg` VALUES ('29', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-26 08:44:48', '0');
INSERT INTO `tbl_msg` VALUES ('30', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-26 08:48:48', '0');
INSERT INTO `tbl_msg` VALUES ('31', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-26 08:48:48', '0');
INSERT INTO `tbl_msg` VALUES ('32', '11', null, '<h4>敬爱的zhangsan@qq.com您好：</h4><p>用户lisi@qq.com于1545785768738预约了您的三年级课程，请选择是否同意自己联系方式发送给ta。</p>', '2018-12-26 08:56:08', '0');
INSERT INTO `tbl_msg` VALUES ('33', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-26 08:56:08', '0');
INSERT INTO `tbl_msg` VALUES ('34', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-26 08:56:08', '0');
INSERT INTO `tbl_msg` VALUES ('35', '11', null, '<h4>敬爱的zhangsan@qq.com您好：</h4><p>用户lisi@qq.com于1545786178295预约了您的初一课程，请选择是否同意自己联系方式发送给ta。</p>', '2018-12-26 09:02:58', '0');
INSERT INTO `tbl_msg` VALUES ('36', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-26 09:02:58', '0');
INSERT INTO `tbl_msg` VALUES ('37', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-26 09:02:58', '0');
INSERT INTO `tbl_msg` VALUES ('38', '11', null, '<h4>敬爱的zhangsan@qq.com您好：</h4><p>用户lisi@qq.com于1545786686461预约了您的初一课程，请选择是否同意自己联系方式发送给ta。</p>', '2018-12-26 09:11:26', '0');
INSERT INTO `tbl_msg` VALUES ('39', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-26 09:11:26', '0');
INSERT INTO `tbl_msg` VALUES ('40', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-26 09:11:26', '0');
INSERT INTO `tbl_msg` VALUES ('41', '11', null, '<h4>敬爱的zhangsan@qq.com您好：</h4><p>用户lisi@qq.com于1545791248738预约了您的高三课程，请选择是否同意自己联系方式发送给ta。</p>', '2018-12-26 10:27:28', '0');
INSERT INTO `tbl_msg` VALUES ('42', '1', null, '<h3>请选择zhangsan@qq.com是否成为了您的家教：</h3>', '2018-12-26 10:27:28', '0');
INSERT INTO `tbl_msg` VALUES ('43', '11', null, '<h3>请选择您是否成为了lisi@qq.com的家教：</h3>', '2018-12-26 10:27:28', '0');

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
  `experience` text,
  `success` text,
  PRIMARY KEY (`jid`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_myjob
-- ----------------------------
INSERT INTO `tbl_myjob` VALUES ('1', '1', '', '110', '1-2', '刘同学，从三年级开始奥数，学习一年后效果不佳，对奥数也有了一些抵触，我从四年级开始带他，注重教学方法，课堂效率，激发他的学习兴趣，**生活实际，在快乐中学习，帮助刘同学迅速建立了信心，使其在奥数学习中如鱼得水。在五年级的一次数学邀请赛中取得了二等奖的好成绩。', ' 兼职在教育机构从事培训工作，尤其擅长一对一个性化辅导，根据学生特点因材施教。经验丰富，教学突出，深受学生喜爱！');
INSERT INTO `tbl_myjob` VALUES ('2', '2', '', '100', '2-4', null, null);
INSERT INTO `tbl_myjob` VALUES ('3', '3', '', '133', '3-5', '', '');
INSERT INTO `tbl_myjob` VALUES ('4', '4', '', '455', '4-10', '', '');
INSERT INTO `tbl_myjob` VALUES ('5', '5', '', '555', '5-11', '', '');
INSERT INTO `tbl_myjob` VALUES ('6', '6', '', '666', '6-10', '', '');
INSERT INTO `tbl_myjob` VALUES ('7', '7', '', '777', '7-9', '', '');
INSERT INTO `tbl_myjob` VALUES ('8', '8', '', '888', '8-10', '', '');
INSERT INTO `tbl_myjob` VALUES ('9', '9', '', '999', '9-10', '', '');
INSERT INTO `tbl_myjob` VALUES ('14', '20', '河北省-石家庄市-裕华区', '100', '0-2', '老师看到解放路口的设计费', '颠倒是非家里看电视机房');

-- ----------------------------
-- Table structure for `tbl_myjobcourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobcourse`;
CREATE TABLE `tbl_myjobcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

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
INSERT INTO `tbl_myjobcourse` VALUES ('14', '17', '12');
INSERT INTO `tbl_myjobcourse` VALUES ('15', '18', '12');
INSERT INTO `tbl_myjobcourse` VALUES ('16', '19', '13');
INSERT INTO `tbl_myjobcourse` VALUES ('17', '20', '13');
INSERT INTO `tbl_myjobcourse` VALUES ('18', '21', '14');
INSERT INTO `tbl_myjobcourse` VALUES ('19', '22', '14');

-- ----------------------------
-- Table structure for `tbl_myjobgrade`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobgrade`;
CREATE TABLE `tbl_myjobgrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

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
INSERT INTO `tbl_myjobgrade` VALUES ('18', '25', '12');
INSERT INTO `tbl_myjobgrade` VALUES ('19', '26', '12');
INSERT INTO `tbl_myjobgrade` VALUES ('20', '27', '13');
INSERT INTO `tbl_myjobgrade` VALUES ('21', '28', '13');
INSERT INTO `tbl_myjobgrade` VALUES ('22', '29', '14');
INSERT INTO `tbl_myjobgrade` VALUES ('23', '30', '14');
INSERT INTO `tbl_myjobgrade` VALUES ('24', '31', '14');

-- ----------------------------
-- Table structure for `tbl_myjobtime`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_myjobtime`;
CREATE TABLE `tbl_myjobtime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

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
INSERT INTO `tbl_review` VALUES ('1', '2018-12-19 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '1');
INSERT INTO `tbl_review` VALUES ('2', '2018-12-14 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '2');
INSERT INTO `tbl_review` VALUES ('3', '2018-12-22 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '3');
INSERT INTO `tbl_review` VALUES ('4', '2018-12-18 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '4');
INSERT INTO `tbl_review` VALUES ('5', '2018-12-07 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '5');
INSERT INTO `tbl_review` VALUES ('6', '2018-12-06 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '4', '6');
INSERT INTO `tbl_review` VALUES ('7', '2018-12-12 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '7');
INSERT INTO `tbl_review` VALUES ('8', '2018-12-01 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '3', '8');
INSERT INTO `tbl_review` VALUES ('9', '2018-12-12 00:00:00', '老师善于引导，课件清晰完整，讲课生动，学生很喜欢', '5', '9');
INSERT INTO `tbl_review` VALUES ('10', '2018-12-06 15:14:38', '见识到了开发聚隆科技乐山大佛会计师的房价来看莱克斯顿', null, '1');
INSERT INTO `tbl_review` VALUES ('11', '2018-09-20 15:15:12', '诶UR偶尔有我多个梵蒂冈梵蒂冈让业务i', null, '1');
INSERT INTO `tbl_review` VALUES ('12', '2018-11-05 19:15:34', '反倒是离开家里看电视弗兰克股份梵蒂冈', null, '1');

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
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

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
INSERT INTO `tbl_user` VALUES ('1', 'li123456', 'R5TRXUNakjA3gckn2CuiWRCrA/gdxYH1PjOBF4ZZsP5aIeM+GKmti4oQlt8EFXtz4KuwJLWWF76FL6CPg4X46w==', '1945642767@qq.com', '家长', '2018-11-02 00:04:00', '李哈哈', '372323199707240000', '女', 'images/detail-img2.png', 'images/idphoto5.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '15226579789', null, '似懂非懂所发生的', '理科', '1', 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJk9quYtp2bB0gtYYvXYFhUftu5GHALbGHgGtFpZgqBpVroYSdZmrPvymF+ov4TGOv8RglLRyIJH9+eGpNpZ9ksCAwEAAQ==', 'MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAmT2q5i2nZsHSC1hi9dgWFR+27kYcAtsYeAa0WlmCoGlWuhhJ1mas+/KYX6i/hMY6/xGCUtHIgkf354ak2ln2SwIDAQABAkEAihw0PMQEze39mtAMULpyHJO60UFK2aARi4uvXIaz3lHjtXec20obJmpRjdUMVkb3E6e5WfsWbdXpgYcv+8zYQQIhAPkJv+vevK4glO7i4Tz0NLQ+NANsQ522KH/1nTpU8LUbAiEAnYZXeQsPOMAAoCsastvLc1ep455WjL6rFSEONNNaRpECIQCcGT9iYngUETopTq7uHQhYHlFN//OWDJLwOg02ff1vFwIgXcgCQbz01ftxI+olngA+8q9pJGs66dYF8rFYTNjbcRECIEDaaR5de3CSHSbrH9SOdR62gY7+Z3ZpN8cfP4rjqTfn');
INSERT INTO `tbl_user` VALUES ('2', 'liu123', 'dKNWRmrsHjqbGP0EZHsbBx6qDXbgrEWJSe+gZOwiHWJiVz7DWTRIAJ/C2Ae/yVH7fD3yUTgn9141MRW1cgUCzQ==', '381929295@qq.com', '老师', '2018-12-04 15:41:20', '刘晓倩', '372323199707240000', '女', 'images/detail-img2.png', 'images/idphoto6.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大三', '15226579789', '石家庄市', '算了肯德基法律手段', '文科', '1', 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIdVJaCB3yRU3qQ6g8sH/Sa+djgjdYvNJq9NYe2LMG8fnWbJIBWOy0Kvy8ALANP4oP9BytEh2nuySTIbQ2pW14kCAwEAAQ==', 'MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAh1UloIHfJFTepDqDywf9Jr52OCN1i80mr01h7Yswbx+dZskgFY7LQq/LwAsA0/ig/0HK0SHae7JJMhtDalbXiQIDAQABAkBxSXDHDRCLbFQ37BfZROXAoh16XwyOK/zfMIrye9remcOiNAKKFrDe66x9c+WF5HynZndkEijq1mKtdbYvsL51AiEAwVqQutn00uIOTPVOl/PWJGUmjdoeyZJpG3km7TKAeesCIQCzLhqvoejrkfcq1tkVnXKxoXqI+1ECCid1DYeuyIlDWwIgRDzLITZ0ocwn0d8tCpGCfLu5/IwDG45xS8HZDBMrplsCIFG/WxV+PRIcyjOVSf1+k/FOxuTwJAlWMKJKxfiMLXO5AiAglSES0WuXO2R/jiHdkmMI69s01UvFhVR3b3DbNO7ggw==');
