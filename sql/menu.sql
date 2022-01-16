SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '首页', '/welcome');
INSERT INTO `menu` VALUES ('2', '资源管理', '/resource');
INSERT INTO `menu` VALUES ('3', '实例管理', '/instance');
INSERT INTO `menu` VALUES ('4', '质量管理', '/quality');
INSERT INTO `menu` VALUES ('5', '租户管理', '/tenant');