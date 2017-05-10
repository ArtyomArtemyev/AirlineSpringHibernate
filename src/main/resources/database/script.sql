CREATE SCHEMA `airline` DEFAULT CHARACTER SET utf8 ;

USE airline;

CREATE TABLE `airline`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(70) NOT NULL,
  `password` VARCHAR(70) NOT NULL,
  `mail` VARCHAR(20) NOT NULL,
  `user_role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_role_id`)
  REFERENCES `airline`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`gender` (
  `gender_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`gender_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`appointment` (
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`appointment_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  `surname` VARCHAR(70) NOT NULL,
  `gender_id` INT NOT NULL,
  `appointment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`gender_id`)
  REFERENCES `airline`.`gender` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `appointment_id`
  FOREIGN KEY (`appointment_id`)
  REFERENCES `airline`.`appointment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_members` JSON NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`flight` (
  `flight_id` INT NOT NULL AUTO_INCREMENT,
  `navigation` VARCHAR(100) NOT NULL,
  `team_id` INT,
  PRIMARY KEY (`flight_id`),
  FOREIGN KEY (`team_id`)
  REFERENCES `airline`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

ALTER TABLE `airline`.`appointment`
  CHANGE COLUMN `appointment_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `airline`.`employee`
  CHANGE COLUMN `employee_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `airline`.`flight`
  CHANGE COLUMN `flight_id` `id` INT(11) NOT NULL ;

ALTER TABLE `airline`.`gender`
  CHANGE COLUMN `gender_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `airline`.`team`
  CHANGE COLUMN `team_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `airline`.`user`
  CHANGE COLUMN `user_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `airline`.`user_role`
  CHANGE COLUMN `user_role_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `airline`.`employee`
  DROP FOREIGN KEY `gender_id`,
  DROP FOREIGN KEY `appointment_id`,
  DROP FOREIGN KEY `FKe0w26qjedr99vwno4pqauw9i9`,
  DROP FOREIGN KEY `FK8p1au9mavecfs8f2erqhisa7i`;
ALTER TABLE `airline`.`employee`
  ADD INDEX `id_idx` (`gender_id` ASC),
  ADD INDEX `id_idx1` (`appointment_id` ASC),
  DROP INDEX `appointment_id_idx` ,
  DROP INDEX `gender_id_idx` ;
ALTER TABLE `airline`.`employee`
  ADD CONSTRAINT `id`
FOREIGN KEY (`gender_id`)
REFERENCES `airline`.`gender` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
