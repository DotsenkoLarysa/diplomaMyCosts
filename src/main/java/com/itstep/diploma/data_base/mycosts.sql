CREATE SCHEMA IF NOT EXISTS `mycosts` DEFAULT CHARACTER SET utf8;

USE `mycosts`;

CREATE TABLE IF NOT EXISTS `mycosts`.`user`
(
    `username`    VARCHAR(45) NOT NULL,
    `password`    VARCHAR(90) NOT NULL,
    `create_time` TIMESTAMP   NULL DEFAULT CURRENT_TIMESTAMP,
    `user_id`     INT         NOT NULL AUTO_INCREMENT,
    `roleId`      INT         NOT NULL,
    PRIMARY KEY (`user_id`),
    INDEX `role_id_idx` (`roleId` ASC),
    CONSTRAINT `roleId`
        FOREIGN KEY (`roleId`)
            REFERENCES `mycosts`.`role` (`role_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mycosts`.`role`
(
    `role_id` INT         NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`role_id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mycosts`.`category`
(
    `category_id`      INT          NOT NULL AUTO_INCREMENT,
    `name_category`    VARCHAR(255) NOT NULL,
    `percentage_value` INT          NOT NULL,
    PRIMARY KEY (`category_id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mycosts`.`transaction`
(
    `transaction_id`   INT         NOT NULL AUTO_INCREMENT,
    `name_transaction` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`transaction_id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mycosts`.`period`
(
    `period_id`   INT  NOT NULL AUTO_INCREMENT,
    `period_name` DATE NOT NULL,
    PRIMARY KEY (`period_id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mycosts`.`journal`
(
    `event_id`      INT          NOT NULL AUTO_INCREMENT,
    `categoryId`    INT          NOT NULL,
    `transactionId` INT          NOT NULL,
    `event_date`    DATE         NOT NULL,
    `event_sum`     DOUBLE       NOT NULL,
    `description`   VARCHAR(255) NULL,
    `periodId`      INT          NOT NULL,
    PRIMARY KEY (`event_id`),
    INDEX `category_id_idx` (`categoryId` ASC),
    INDEX `transaction_id_idx` (`transactionId` ASC),
    INDEX `period_id_idx` (`periodId` ASC),
    CONSTRAINT `category_id`
        FOREIGN KEY (`categoryId`)
            REFERENCES `mycosts`.`category` (`category_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `transaction_id`
        FOREIGN KEY (`transactionId`)
            REFERENCES `mycosts`.`transaction` (`transaction_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `period_id`
        FOREIGN KEY (`periodId`)
            REFERENCES `mycosts`.`period` (`period_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mycosts`.`balance`
(
    `balance_id`           INT    NOT NULL AUTO_INCREMENT,
    `periodId_balance`     INT    NOT NULL,
    `create_date`          DATE   NOT NULL,
    `necessary_plus`       DOUBLE NULL,
    `necessary_minus`      DOUBLE NULL,
    `necessary_balance`    DOUBLE NULL,
    `education_plus`       DOUBLE NULL,
    `education_minus`      DOUBLE NULL,
    `education_balance`    DOUBLE NULL,
    `accumulation_plus`    DOUBLE NULL,
    `accumulation_minus`   DOUBLE NULL,
    `accumulation_balance` DOUBLE NULL,
    `stocks_plus`          DOUBLE NULL,
    `stocks_minus`         DOUBLE NULL,
    `stocks_balance`       DOUBLE NULL,
    `leisure_plus`         DOUBLE NULL,
    `leisure_minus`        DOUBLE NULL,
    `leisure_balance`      DOUBLE NULL,
    `charity_plus`         DOUBLE NULL,
    `charity_minus`        DOUBLE NULL,
    `charity_balance`      DOUBLE NULL,
    `cashbook_plus`        DOUBLE NULL,
    `cashbook_minus`       DOUBLE NULL,
    `cashbook_balance`     DOUBLE NULL,
    PRIMARY KEY (`balance_id`),
    INDEX `period_id_idx` (`periodId_balance` ASC),
    CONSTRAINT `periodId_balance`
        FOREIGN KEY (`periodId_balance`)
            REFERENCES `mycosts`.`period` (`period_id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)
    ENGINE = InnoDB;

INSERT `mycosts`.`category`(category_id, name_category, percentage_value)
VALUES (1, 'necessary', 55),
       (2, 'education', 10),
       (3, 'accumulation', 10),
       (4, 'stocks', 10),
       (5, 'leisure', 10),
       (6, 'charity', 5),
       (7, 'cashbook', 100);

INSERT `mycosts`.`transaction`(transaction_id, name_transaction)
VALUES (1, 'deposit'),
       (2, 'transfer'),
       (3, 'withdrawal');

INSERT `mycosts`.`role`(role_id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT `mycosts`.`user`(user_id, username, password, roleId)
VALUES (1, 'Larisa', '123123', 1);

INSERT `mycosts`.`user`(user_id, username, password, roleId)
VALUES (2, 'Alex', '112233', 2);

