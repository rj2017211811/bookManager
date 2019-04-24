/*
Navicat MySQL Data Transfer

Source Server         : mylink
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : bookmanager

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-01-10 11:29:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(50) NOT NULL,
  `writer` varchar(50) NOT NULL,
  `price` double(100,2) NOT NULL,
  `num` int(100) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookName` (`bookName`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('32', '计算机系统基础3', '孙胜利', '40.50', '11');
INSERT INTO `book` VALUES ('33', '计算机组成原理', '宋胜利', '57.40', '22');
INSERT INTO `book` VALUES ('34', '操作系统', '宋丽', '40.50', '13');
INSERT INTO `book` VALUES ('35', '数据结构', '孙俪', '34.00', '20');
INSERT INTO `book` VALUES ('36', '计算机', '邓巧', '57.40', '18');
INSERT INTO `book` VALUES ('38', '计算机组成原理1', '宋胜利', '57.00', '12');
INSERT INTO `book` VALUES ('39', '计算机1', '邓巧', '57.40', '12');
INSERT INTO `book` VALUES ('40', '数据结构', '张娟1', '50.30', '111');
INSERT INTO `book` VALUES ('42', '计算机系统基础', '孙胜利', '40.50', null);
INSERT INTO `book` VALUES ('43', '计算机系统基础3', '孙胜利1', '40.50', null);
INSERT INTO `book` VALUES ('44', '计算机系统基础', '孙胜利12', '40.00', null);
INSERT INTO `book` VALUES ('45', '计算机系统基础', '孙胜', '40.50', null);
INSERT INTO `book` VALUES ('46', '计算机系统基', '孙胜利', '40.50', null);

-- ----------------------------
-- Table structure for `borrowsituation`
-- ----------------------------
DROP TABLE IF EXISTS `borrowsituation`;
CREATE TABLE `borrowsituation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrowId` int(11) DEFAULT NULL,
  `bookName` varchar(50) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `borrowDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book` (`borrowId`),
  KEY `bookName` (`bookName`),
  KEY `userId` (`userId`),
  CONSTRAINT `book` FOREIGN KEY (`borrowId`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `borrowsituation_ibfk_1` FOREIGN KEY (`bookName`) REFERENCES `book` (`bookName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `borrowsituation_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowsituation
-- ----------------------------
INSERT INTO `borrowsituation` VALUES ('13', '36', '计算机', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('14', '34', '操作系统', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('15', '32', '计算机系统基础3', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('16', '40', '数据结构', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('17', '40', '数据结构', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('18', '35', '数据结构', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('19', '35', '数据结构', '2017111', '2019-01-09', null, '未还');
INSERT INTO `borrowsituation` VALUES ('20', '32', '计算机系统基础3', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('21', '34', '操作系统', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('22', '38', '计算机组成原理1', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('23', '33', '计算机组成原理', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('24', '32', '计算机系统基础3', '2017111', '2019-01-09', null, '未还');
INSERT INTO `borrowsituation` VALUES ('25', '34', '操作系统', '2017111', '2019-01-09', '2019-01-09', '已还');
INSERT INTO `borrowsituation` VALUES ('26', '34', '操作系统', '2017111', '2019-01-09', null, '未还');
INSERT INTO `borrowsituation` VALUES ('27', '34', '操作系统', '2017115', '2019-01-10', null, '未还');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `managerName` varchar(50) DEFAULT NULL,
  `managerPassword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'ewee', 'swrerere');
INSERT INTO `manager` VALUES ('2', 'wrwere', 'ewrwetret');
INSERT INTO `manager` VALUES ('4', '123456', '123456');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `borrowBooks` int(50) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `userName` (`userName`),
  KEY `borrowBooks` (`borrowBooks`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '李四', '2017111', '123456', '3');
INSERT INTO `user` VALUES ('16', '宋丽', '2017114', '1234567', '0');
INSERT INTO `user` VALUES ('17', '孙文', '2017115', '1234567', '1');
INSERT INTO `user` VALUES ('18', '王杰', '2017116', '1234567', '0');
INSERT INTO `user` VALUES ('21', '孔丽', '2017119', '1234567', '0');
INSERT INTO `user` VALUES ('22', '孔莉', '2017120', '1234567', '0');
INSERT INTO `user` VALUES ('23', '孔力', '2017121', '1234567', '0');
INSERT INTO `user` VALUES ('24', '孔流', '2017122', '1234567', '0');
INSERT INTO `user` VALUES ('25', '王杰', '2017123', '1234567', '0');
INSERT INTO `user` VALUES ('26', '李四', '2017991', '123456', '0');
INSERT INTO `user` VALUES ('27', '孙文', '2017198', '123456', '0');
INSERT INTO `user` VALUES ('28', '李', '2017344', '123456', '0');
INSERT INTO `user` VALUES ('29', '王杰', '2017888', '123456', '0');
INSERT INTO `user` VALUES ('30', '孔丽', '2017213', '123456', '0');
INSERT INTO `user` VALUES ('31', '宋丽', '2018114', '123456', '0');
INSERT INTO `user` VALUES ('32', '沾上干', '2017785', '123456', '0');
