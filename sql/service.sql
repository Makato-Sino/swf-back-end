SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 创建服务表
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `level` int(20) NOT NULL COMMENT '服务级别',
  `limit` int(20) NOT NULL COMMENT '最大并发实例限制',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 填充服务表
-- ----------------------------
INSERT INTO `service` VALUES (1, 'neocn', 1, 1);
INSERT INTO `service` VALUES (2, 'triniticn', 2, 2);
INSERT INTO `service` VALUES (3, 'sinocn', 3, 5);
INSERT INTO `service` VALUES (4, 'theocn', 4, 10);
