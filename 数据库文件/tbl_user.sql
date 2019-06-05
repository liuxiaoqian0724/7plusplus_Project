/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-06-05 09:36:13
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `img5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('11', '张老师', '123', 'zhangsan@qq.com', '老师', '2018-11-02 00:04:00', '张老师', '430621200001015432', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '15226579789', '', '主要是初中英语，数学，小学全科的教程奥语及课内外作业，针对性补差，提高简单题的做题速度和难题的解题思路方法，培养良好的习惯和自学能力。在一教育机构任职，课后进行私人辅导，喜欢小孩有责任心，耐心。希望在这过程中共同成长进步。', '理科', '1', null, null, 'images/idphotocircle1.png');
INSERT INTO `tbl_user` VALUES ('10', '李舒', '123', 'wangwu@qq.com', '老师', '2018-12-10 00:00:00', '李舒', '430621199901012222', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大三', '130', '', '本人现为教师，有4年的教学经验。所带班学生平均成绩一直保持在90分以上，教学成绩优异。擅长小学数学和小学奥数的辅导。本人现为教师，有4年的教学经验。所带班学生平均成绩一直保持在90分以上，教学成绩优异。擅长小学数学和小学奥数的辅导', '文科', '1', null, null, 'images/idphotocircle2.png');
INSERT INTO `tbl_user` VALUES ('9', '王小宾', '123', 'lisi@qq.com', '老师', '2018-11-14 00:00:00', '王小宾', '430621198501013456', '男', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大三', '120', '', '我高中是理科生是河北经贸大学在校大二学生，法学院法学专业，擅长英语和数学，高考英语130，数学120，有经验，带过小学全科，初中全科，高一数学。课余时间长，有爱心有责任心，好相处，有耐心，活泼开朗。', '理科', '1', null, null, 'images/idphotocircle3.png');
INSERT INTO `tbl_user` VALUES ('8', '张三', '123', 'xiaoming@', '老师', '2018-12-02 00:00:00', '张三', '430621201001013345', '男', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '140', '', '我是河北科技大学英语专业在校大学生，已经有两年的家教经验，有很多的成功案例，并得到了家长和学生的一致认同。我是河北科技大学英语专业在校大学生，已经有两年的家教经验，有很多的成功案例，并得到了家长和学生的一致认同。', '文科', '1', null, null, 'images/idphotocircle4.png');
INSERT INTO `tbl_user` VALUES ('7', '赵一', '123', 'zhangsan@qq.com', '老师', '2018-11-02 00:00:00', '赵一', '430621200001015432', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '110', '', '高中化学教师，带过10几届毕业班，对高中教材了如指掌，熟知高考知识点、考点、重点、难点。教学认真负责，在各大机构带过多年一对一、小班课程。经验丰富，教学风趣幽默，不死舨，深受学生喜爱。', '理科', '1', '', '', 'images/idphotocircle5.png');
INSERT INTO `tbl_user` VALUES ('6', '钱二', '123', 'wangwu@', '老师', '2018-12-10 00:00:00', '钱二', '430621199901012222', '男', 'images/detail-img2.png', 'images/idphoto2.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '130', '', '河北外国语学院毕业生，23岁。曾在嘉贝教育.尖叫童年幼儿早教中心做过一年的外语教师；现于新东方英语学校泡泡少儿部任教。有丰富各年级英语教学和五六年级数学教学经验。', '理科', '1', '', '', 'images/idphotocircle6.png');
INSERT INTO `tbl_user` VALUES ('5', '孙三', '123', 'lisi@qq.com', '老师', '2018-11-14 00:00:00', '孙三', '430621198501013456', '女', 'images/detail-img2.png', 'images/idphoto3.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大二', '120', '', '河北大学数学系毕业。初三参加数学奥林匹克竞赛，获得河北省一等奖；参加物理奥林匹克竞赛，获得河北省二等奖。 能抓住各个知识点的突破点。 难题如何转化为容易题就是如何发现突破点。 学习有学习技巧，做题有做题技巧。我会把我所总结的技巧分享给各个学生。谢谢！', '文科', '1', '', '', 'images/idphotocircle7.png');
INSERT INTO `tbl_user` VALUES ('4', '李四', '123', 'xiaoming@', '老师', '2018-12-02 00:00:00', '李四', '430621201001013345', '男', 'images/detail-img2.png', 'images/idphoto4.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '140', '', '河北考生，高考638，河北省三好学生、国家励志奖学金、唐南军奖学金、优秀学生奖学金、优秀学生称号、优秀团员称号、2012年美国大学生数学建模竞赛一等奖。', '文科', '1', '', '', 'images/idphotocircle1.png');
INSERT INTO `tbl_user` VALUES ('3', '周五', '123', 'e@qq.com', '老师', '2018-12-13 00:00:00', '周五', '430621201001013345', '女', 'images/detail-img2.png', 'images/idphoto1.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '150', '', '从事家教三年，本科专业应用数学，在校期间担任班长，并多次获得学校奖学金。大学期间曾担任辅导机构班主任，善于与学生沟通，并为学员制定各自的学习计划，让学生在学习中获得更大的乐趣。', '理科', '1', '', '', 'images/idphotocircle2.png');
INSERT INTO `tbl_user` VALUES ('1', 'li123456', 'R5TRXUNakjA3gckn2CuiWRCrA/gdxYH1PjOBF4ZZsP5aIeM+GKmti4oQlt8EFXtz4KuwJLWWF76FL6CPg4X46w==', '1945642767@qq.com', '家长', '2018-11-02 00:04:00', '李哈哈', '372323199707240000', '女', 'images/detail-img2.png', 'images/idphoto5.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大一', '15226579789', null, '似懂非懂所发生的', '理科', '1', 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJk9quYtp2bB0gtYYvXYFhUftu5GHALbGHgGtFpZgqBpVroYSdZmrPvymF+ov4TGOv8RglLRyIJH9+eGpNpZ9ksCAwEAAQ==', 'MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAmT2q5i2nZsHSC1hi9dgWFR+27kYcAtsYeAa0WlmCoGlWuhhJ1mas+/KYX6i/hMY6/xGCUtHIgkf354ak2ln2SwIDAQABAkEAihw0PMQEze39mtAMULpyHJO60UFK2aARi4uvXIaz3lHjtXec20obJmpRjdUMVkb3E6e5WfsWbdXpgYcv+8zYQQIhAPkJv+vevK4glO7i4Tz0NLQ+NANsQ522KH/1nTpU8LUbAiEAnYZXeQsPOMAAoCsastvLc1ep455WjL6rFSEONNNaRpECIQCcGT9iYngUETopTq7uHQhYHlFN//OWDJLwOg02ff1vFwIgXcgCQbz01ftxI+olngA+8q9pJGs66dYF8rFYTNjbcRECIEDaaR5de3CSHSbrH9SOdR62gY7+Z3ZpN8cfP4rjqTfn', 'images/idphotocircle3.png');
INSERT INTO `tbl_user` VALUES ('2', 'liu123', 'dKNWRmrsHjqbGP0EZHsbBx6qDXbgrEWJSe+gZOwiHWJiVz7DWTRIAJ/C2Ae/yVH7fD3yUTgn9141MRW1cgUCzQ==', '381929295@qq.com', '老师', '2018-12-04 15:41:20', '刘晓倩', '372323199707240000', '女', 'images/detail-img2.png', 'images/idphoto6.png', 'images/big-img5.jpg', 'images/detail-img1.png', 'images/detail-img2.png', 'images/detail-img3.png', '河北师范大学', '大三', '15226579789', '石家庄市', '有家教经验，性格开朗活泼，善于交谈，初中高中一直担任班委及数学课代表，数学成绩一直名列前茅，高考数学成绩134，大学期间担任学生会干部，任校团委委员，获得演讲比赛三等奖，校级优秀团学先进个人。', '文科', '1', 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIdVJaCB3yRU3qQ6g8sH/Sa+djgjdYvNJq9NYe2LMG8fnWbJIBWOy0Kvy8ALANP4oP9BytEh2nuySTIbQ2pW14kCAwEAAQ==', 'MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAh1UloIHfJFTepDqDywf9Jr52OCN1i80mr01h7Yswbx+dZskgFY7LQq/LwAsA0/ig/0HK0SHae7JJMhtDalbXiQIDAQABAkBxSXDHDRCLbFQ37BfZROXAoh16XwyOK/zfMIrye9remcOiNAKKFrDe66x9c+WF5HynZndkEijq1mKtdbYvsL51AiEAwVqQutn00uIOTPVOl/PWJGUmjdoeyZJpG3km7TKAeesCIQCzLhqvoejrkfcq1tkVnXKxoXqI+1ECCid1DYeuyIlDWwIgRDzLITZ0ocwn0d8tCpGCfLu5/IwDG45xS8HZDBMrplsCIFG/WxV+PRIcyjOVSf1+k/FOxuTwJAlWMKJKxfiMLXO5AiAglSES0WuXO2R/jiHdkmMI69s01UvFhVR3b3DbNO7ggw==', 'images/idphotocircle4.png');
