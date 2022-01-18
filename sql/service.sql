SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 服务数据
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `price` numeric(6,2) NOT NULL,
  -- other data
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service` VALUES (1, 'test', 12.34);
INSERT INTO `service` VALUES (2, 'apple', 35);
INSERT INTO `service` VALUES (3, 'hello', 1254.6);
INSERT INTO `service` VALUES (4, 'big', 2154.67);
