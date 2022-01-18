SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 租户界面menu
-- ----------------------------
DROP TABLE IF EXISTS `tenant_menu`;
CREATE TABLE `tenant_menu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_menu
-- ----------------------------
INSERT INTO `tenant_menu` VALUES ('1', '首页', '/tenantwelcome');
INSERT INTO `tenant_menu` VALUES ('2', '服务选购', '/purchase');
INSERT INTO `tenant_menu` VALUES ('3', '查看订单', '/order');
