CREATE SCHEMA `airline` DEFAULT CHARACTER SET utf8 ;

USE airline;

CREATE TABLE `airline`.`user_role` (
  `user_role_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`user_role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(70) NOT NULL,
  `password` VARCHAR(70) NOT NULL,
  `mail` VARCHAR(20) NOT NULL,
  `user_role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `user_role_id_idx` (`user_role_id` ASC),
  CONSTRAINT `user_role_id`
  FOREIGN KEY (`user_role_id`)
  REFERENCES `airline`.`user_role` (`user_role_id`)
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
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  `surname` VARCHAR(70) NOT NULL,
  `gender_id` INT NOT NULL,
  `appointment_id` INT NOT NULL,
  PRIMARY KEY (`employee_id`),
  INDEX `gender_id_idx` (`gender_id` ASC),
  INDEX `appointment_id_idx` (`appointment_id` ASC),
  CONSTRAINT `gender_id`
  FOREIGN KEY (`gender_id`)
  REFERENCES `airline`.`gender` (`gender_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `appointment_id`
  FOREIGN KEY (`appointment_id`)
  REFERENCES `airline`.`appointment` (`appointment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
