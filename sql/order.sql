SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 用户订单数据
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `service_id` bigint(20) NOT NULL,
  -- other data
  PRIMARY KEY (`order_id`),
  FOREIGN KEY (`service_id`) REFERENCES `service`(`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, 1);
INSERT INTO `orders` VALUES (2, 2, 4);
INSERT INTO `orders` VALUES (3, 1, 3);
