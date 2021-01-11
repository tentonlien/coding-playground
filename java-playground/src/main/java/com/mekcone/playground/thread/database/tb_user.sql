DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
    `id`          int(11)       NOT NULL AUTO_INCREMENT,
    `username`    varchar(20)   DEFAULT NULL,
    `password`    varchar(20)   DEFAULT NULL,
    `head_root`   varchar(80)   DEFAULT NULL,
    `real_name`   varchar(10)   DEFAULT NULL,
    `net_name`    varchar(20)   DEFAULT NULL,
    `email`       varchar(20)   DEFAULT NULL,
    `age`         int(10)       DEFAULT NULL,
    `gender`      varchar(2)    DEFAULT NULL,
    `birth_year`  int(10)       DEFAULT NULL,
    `birth_month` int(10)       DEFAULT NULL,
    `birth_day`   int(10)       DEFAULT NULL,
    `address_id`  int(11)       DEFAULT NULL COMMENT '地址详细信息',
    `height`      double(11, 0) DEFAULT NULL,
    `user_grade`  varchar(10)   DEFAULT NULL,
    `income`      double(20, 0) DEFAULT NULL,
    `marriage`    varchar(5)    DEFAULT NULL,
    `bio`         varchar(80)   DEFAULT NULL,
    `vip`         int(10)       DEFAULT NULL,
    `money`       int(11)       DEFAULT NULL,
    `auth`        varchar(10)   DEFAULT NULL,
    `category`    varchar(10)   DEFAULT NULL,
    `label`       int(11)       DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = utf8;

INSERT INTO `tb_user` (`id`, `username`, `password`) VALUES ('1', 'Tom', '123456');