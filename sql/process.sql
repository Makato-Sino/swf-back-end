SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 创建流程表
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` int(20) NOT NULL COMMENT '服务级别',
  `instanceLimit` int(20) NOT NULL COMMENT '最大并发实例限制',
  `instanceNum` int(20) NOT NULL COMMENT '并发实例数',
  PRIMARY KEY (`id`)
  FOREIGN KEY (`id`) REFERENCES `act_re_procdef`(`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
