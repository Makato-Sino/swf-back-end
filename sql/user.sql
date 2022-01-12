SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                            `id` int(24) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `username` varchar(255) NOT NULL,
                            `password` varchar(255) NOT NULL,
                            `email` varchar(255) NOT NULL,
                            `role` varchar(255) NOT NULL,
                            `state` tinyint(255) NOT NULL DEFAULT '0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin01', '123456', '123@qq.com', '管理员', '1');
INSERT INTO `user` VALUES ('2', 'admin02', '123456', '456@qq.com', '管理员', '0');
INSERT INTO `user` VALUES ('3', 'user01', '123456', 'aaa@qq.com', '普通用户', '1');
INSERT INTO `user` VALUES ('4', 'user02', '123456', 'bbb@163.com', '普通用户', '0');
INSERT INTO `user` VALUES ('5', 'user03', '123456', 'ccc@qq.com', '普通用户', '1');