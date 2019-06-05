/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-05-30 12:00:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_article`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_article`;
CREATE TABLE `tbl_article` (
  `aId` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `content` text,
  `sendtime` datetime DEFAULT NULL,
  `likecount` int(11) DEFAULT NULL,
  PRIMARY KEY (`aId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='���±�';

-- ----------------------------
-- Records of tbl_article
-- ----------------------------
INSERT INTO `tbl_article` VALUES ('1', '1', '快速提升高中化学成绩的方法', '听课的重要性不用多介绍，道理大家都懂，只不过学霸做到了，而学渣只看到了，听讲的时候除了要集中精力，而且一定要多积极思考，随时准备向老师提高（但不一定真……', '2019-05-02 10:50:06', '36');
INSERT INTO `tbl_article` VALUES ('2', '2', '快速提升高中物理成绩的方法', '我们一直提倡不懂就问，在学习的时候，肯定会遇到很多问题，但千万不要一遇到问题马上就请教别人，先独立思考一下，真正解决不了再去问，养成独立思考的好习惯……', '2019-05-16 10:51:26', '11');
INSERT INTO `tbl_article` VALUES ('3', '4', '快速提高高中生物成绩的方法', '又是老生常谈的学习方法，其实最简单的方法反而是最有效的，前提是你能不能做到。也要承认，高中的学业任务很重，课前预习时间可能不是太多，哪怕粗略看一下……', '2019-05-15 10:52:20', '100');
INSERT INTO `tbl_article` VALUES ('4', '3', '快速提升高中数学成绩的方法', '课本也是很有必要，预习目的就是找到自己没有理解的问题，然后上课的时候重点听讲。课后一定要复习，对于化学这个科目复习的建议是：学习结束二十四小时、一周后、一月后、以及……', '2019-05-09 10:53:49', '250');
INSERT INTO `tbl_article` VALUES ('5', '6', '快速提升初中数学成绩的方法', '化学虽然是一门理科，但需要记忆的知识确实很多，不要指望自己能过目不忘，知识要多次重复才能真正记住，对一些化学概念，如元素符号、化学式、某些定义等反复记忆，多……', '2019-05-09 10:55:39', '20');
INSERT INTO `tbl_article` VALUES ('6', '5', '快速提升初中物理成绩的方法', '多次加深印象，是有效记忆最基本的方法。不提倡死记硬背，一定要在理解的前提下进行记忆。也可以把这些公式、定理记到一个小本子上，利用零碎时间看一眼，也是效果很好的记忆方法……', '2019-05-11 10:57:27', '30');
INSERT INTO `tbl_article` VALUES ('7', '7', '快速提升初中英语成绩的方法', '很多人都感觉课本太简单，但多数人都没有真正把课本吃透，课本上最基础的知识都没有真正掌握住，以课本为主线，认真吃透课本，这是学好化学的根本。为此，同学们……', '2019-05-02 10:59:09', '100');
