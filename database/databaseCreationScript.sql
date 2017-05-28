SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `taskmanager_test` DEFAULT CHARACTER SET utf8 ;
USE `taskmanager_test` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `tasks` ;

CREATE TABLE IF NOT EXISTS `tasks` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `summary` CHAR(128) NOT NULL,
  `content` TEXT,
  `assigned_to` INT(11),
  `created_by` INT(11),
  `creation_date` DATETIME DEFAULT NOW(),
  `estimate` DATETIME DEFAULT NOW(),
  `last_updated` DATETIME DEFAULT NOW(),
  `priority` CHAR(128) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`assigned_to`) REFERENCES `users`(`UserId`),
  FOREIGN KEY (`created_by`) REFERENCES `users`(`UserId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `comments` ;

CREATE TABLE IF NOT EXISTS `comments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `author` INT(11),
  `task_id` INT (11),
  `creation_date` DATETIME DEFAULT NOW(),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`author`) REFERENCES `users`(`UserId`),
  FOREIGN KEY (`task_id`) REFERENCES `tasks`(`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- Migration 1

ALTER TABLE `tasks`
  ADD COLUMN `updated_by` INT(11) AFTER `last_updated`;
  ALTER TABLE `tasks`
ADD FOREIGN KEY (`updated_by`) REFERENCES `users` (`UserId`);

ALTER TABLE `tasks`
  ADD COLUMN `task_state` CHAR(128);

-- Migration 2

ALTER TABLE `users` ADD COLUMN `passwor` TEXT;
ALTER TABLE `tasks` CHANGE `task_state` `task_state` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL;
ALTER TABLE `tasks` CHANGE `priority` `priority` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
