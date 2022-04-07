/*
Navicat MySQL Data Transfer

Source Server         : GREAT
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-10-12 18:54:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_person`
-- ----------------------------
DROP TABLE IF EXISTS `tb_person`;
CREATE TABLE `tb_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_id` (`card_id`),
  CONSTRAINT `tb_person_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `tb_idcard` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_person
-- ----------------------------
INSERT INTO `tb_person` VALUES ('1', 'kangmg', '29', '男', '1');
INSERT INTO `tb_person` VALUES ('2', 'kangxy', '27', '女', '2');
