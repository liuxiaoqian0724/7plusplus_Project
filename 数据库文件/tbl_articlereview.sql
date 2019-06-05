/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-06-05 09:38:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_articlereview`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_articlereview`;
CREATE TABLE `tbl_articlereview` (
  `arid` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `rcontent` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `rtime` datetime DEFAULT NULL,
  PRIMARY KEY (`arid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_articlereview
-- ----------------------------
INSERT INTO `tbl_articlereview` VALUES ('1', '11', '1', '炸丸子的肉馅里最好不要加葱花，葱花容易炸糊,吃起来影响口感和颜色。炸丸子时，油烧热后用小火，下入丸子，待全部下入后，在用中火炸，这样丸子成熟度一样，不会有的熟了有的没熟，炸制期间用勺子不停地搅动，使丸子炸的颜色一致，用大火容易炸的丸子外焦里不熟。喜欢这个菜肴的做法，你学会了吗?学会了别忘了点赞、收藏、转发，也欢迎在评论区发表您的看法，或者分享您的做法，欢迎关注-勺美食，每天都会发布家常美食做法。', '2019-06-05 19:21:15');
INSERT INTO `tbl_articlereview` VALUES ('2', '10', '1', '《围城》是钱钟书所著的长篇小说，是中国现代文学史上一部风格独特的讽刺小说。被誉为“新儒林外史”。第一版于1947年由上海晨光出版公司出版。故事主要写抗战初期知识分子的群相。', '2019-06-04 21:39:29');
INSERT INTO `tbl_articlereview` VALUES ('3', '4', '2', '方鸿渐在欧洲游学期间，不理学业。为了给家人一个交待，方于毕业前购买了虚构的“克莱登大学”的博士学位证书，并随海外学成的学生回国。在船上与留学生鲍小姐相识并热恋，但被鲍小姐欺骗感情。同时也遇见了大学同学苏文纨', '2019-05-28 08:13:39');
INSERT INTO `tbl_articlereview` VALUES ('4', '8', '2', '抗战开始，方家逃难至上海的租界。在赵辛楣的引荐下，与赵辛楣、孙柔嘉、顾尔谦、李梅亭几人同赴位于内地的三闾大学任教。由于方鸿渐性格等方面的弱点，陷入了复杂的人际纠纷当中。', '2019-05-30 08:14:09');
INSERT INTO `tbl_articlereview` VALUES ('5', '7', '3', '高中时就饭陈冠希的小孩不计其数，夏嘉欢也是因此初入潮流圈。偶尔穿着日本潮牌Tee去上课，被同班同学要求“代购”，于是加价的100块“跑腿费”就是夏嘉欢赚到的第一桶金。', '2019-05-31 08:15:06');
INSERT INTO `tbl_articlereview` VALUES ('6', '6', '3', '一般人听到“90后鞋王”这种捧杀型Title，都会谦虚地表示担不起这个称谓，但夏嘉欢满意地接受了，毕竟“没有我买不到的鞋”是他的至理名言。', '2019-06-03 08:15:25');
INSERT INTO `tbl_articlereview` VALUES ('9', '1', '2', '一般人听到“90后鞋王”这种捧杀型Title，都会谦虚地表示担不起这个称谓，但夏嘉欢满意地接受了，毕竟“没有我买不到的鞋”是他的至理名言。', '2019-06-05 08:27:03');
