DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`
(
    `id`      int(11)       NOT NULL AUTO_INCREMENT,
    `name`    varchar(50)   DEFAULT NULL,
    `price`   int           DEFAULT NULL,
    `amount`  int           DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = utf8;

INSERT INTO `tb_product` (`id`, `name`, `price`, `amount`) VALUES (1, 'Piano', '1299900', 1000);