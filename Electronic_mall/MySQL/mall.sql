/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-20 18:55:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` int(20) NOT NULL AUTO_INCREMENT,
  `adminName` char(50) NOT NULL,
  `adminPass` char(50) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'adnmin01', 'admin01');
INSERT INTO `admin` VALUES ('2', 'admin02', 'admin02');
INSERT INTO `admin` VALUES ('3', 'admin03', 'admin03');
INSERT INTO `admin` VALUES ('4', 'admin04', 'admin04');
INSERT INTO `admin` VALUES ('5', 'admin05', 'admin05');
INSERT INTO `admin` VALUES ('6', 'admin06', 'admin06');

-- ----------------------------
-- Table structure for `cost`
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `userName` char(50) NOT NULL,
  `goodsID` int(20) NOT NULL,
  `goodsName` char(50) NOT NULL,
  `goodsVIPmoney` decimal(20,2) NOT NULL,
  `goodsNum` decimal(20,2) NOT NULL,
  `userCost` decimal(20,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------
INSERT INTO `cost` VALUES ('百度网123', '10', '农夫山泉水', '2.50', '20.00', '50.000');
INSERT INTO `cost` VALUES ('百度网123', '9', '这是臭豆腐', '9.30', '30.00', '279.000');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsID` int(20) NOT NULL AUTO_INCREMENT,
  `goodsName` char(50) NOT NULL,
  `goodsDate` char(50) NOT NULL,
  `goodsVIPMoney` decimal(20,2) NOT NULL,
  `goodsMoney` decimal(20,2) NOT NULL,
  `goodsNum` int(20) NOT NULL,
  PRIMARY KEY (`goodsID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('9', '这是臭豆腐', '2018-06-15', '9.30', '11.50', '30');
INSERT INTO `goods` VALUES ('10', '农夫山泉水', '2018-06-14', '2.50', '3.30', '35');
INSERT INTO `goods` VALUES ('11', '娃哈哈的水', '2018-03-16', '2.30', '3.40', '23');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(20) NOT NULL AUTO_INCREMENT,
  `userName` char(50) NOT NULL,
  `userPass` char(50) NOT NULL,
  `userCard` char(20) NOT NULL,
  `userAge` int(2) NOT NULL,
  `userEmail` char(50) NOT NULL,
  `userAddress` char(200) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '王麻子123', 'wangmazi12345', '123456789123456789', '55', 'wangmazi12345@qq.com', '山东省济南市');
INSERT INTO `user` VALUES ('4', '李清华123', 'liqinghua12345', '123456789123456789', '44', 'liqinghua12345@123.com', '山东省滨州市');
INSERT INTO `user` VALUES ('5', '宋兆恒123', 'songzhaoheng123', '123456789123456789', '20', 'songzhaoheng123@qq.com', '山东省淄博市');
INSERT INTO `user` VALUES ('6', '张麻子123', 'wangmazi123', '123456789123456789', '33', 'wangmazi123@qq.com', '山东省青岛市');
INSERT INTO `user` VALUES ('7', '张三丰123', 'zhangsanfeng123', '123456789123456789', '62', 'zhangsanfeng123@qq.com', '山东省威海市');
INSERT INTO `user` VALUES ('8', '李大福123', 'lidafu123456', '123456789123456789', '26', 'lidafu123456@qq.com', '山东省烟台市');
INSERT INTO `user` VALUES ('10', '张翠花123', 'zhangcuihua123', '123456789123456789', '62', 'zhangcuihua123@qq.com', '山东省聊城市');
INSERT INTO `user` VALUES ('11', '百度网123', 'baiduwang123', '987654321987654321', '37', 'baiduwang123@qq.com', '山东省菏泽市');
