/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : qinglandb

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-06-05 08:51:33
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
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_classrelation
-- ----------------------------
INSERT INTO `tbl_classrelation` VALUES ('1', '10', '1');
INSERT INTO `tbl_classrelation` VALUES ('2', '11', '1');
INSERT INTO `tbl_classrelation` VALUES ('3', '2', '2');
INSERT INTO `tbl_classrelation` VALUES ('4', '1', '3');
INSERT INTO `tbl_classrelation` VALUES ('5', '5', '5');
INSERT INTO `tbl_classrelation` VALUES ('6', '6', '6');
INSERT INTO `tbl_classrelation` VALUES ('7', '7', '7');
INSERT INTO `tbl_classrelation` VALUES ('8', '8', '8');
INSERT INTO `tbl_classrelation` VALUES ('9', '9', '9');
INSERT INTO `tbl_classrelation` VALUES ('10', '1', '10');
INSERT INTO `tbl_classrelation` VALUES ('11', '1', '11');
INSERT INTO `tbl_classrelation` VALUES ('12', '1', '12');
INSERT INTO `tbl_classrelation` VALUES ('13', '1', '13');
INSERT INTO `tbl_classrelation` VALUES ('14', '1', '14');
INSERT INTO `tbl_classrelation` VALUES ('15', '1', '15');
INSERT INTO `tbl_classrelation` VALUES ('16', '1', '16');
INSERT INTO `tbl_classrelation` VALUES ('17', '1', '17');
INSERT INTO `tbl_classrelation` VALUES ('18', '1', '18');
INSERT INTO `tbl_classrelation` VALUES ('19', '1', '19');
INSERT INTO `tbl_classrelation` VALUES ('20', '1', '20');
INSERT INTO `tbl_classrelation` VALUES ('21', '1', '21');
