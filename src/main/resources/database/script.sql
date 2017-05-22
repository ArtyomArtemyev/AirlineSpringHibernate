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
  `id` INT NOT NULL AUTO_INCREMENT,
  `navigation` VARCHAR(100) NOT NULL,
  `team_id` INT,
  PRIMARY KEY (`id`),
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
  CHANGE COLUMN `flight_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

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

INSERT INTO `airline`.`flight` (`navigation`, `team_id`) VALUES ('Minsk-Moscow');
INSERT INTO `airline`.`flight` (`navigation`, `team_id`) VALUES ( 'Minsk-Paris');
INSERT INTO `airline`.`flight` (`navigation`, `team_id`) VALUES ('Minsk-Lion');
INSERT INTO `airline`.`flight` (`navigation`, `team_id`) VALUES ('Bern-Minsk');

INSERT INTO `airline`.`user_role` (`id`, `name`) VALUES ('4', 'ADMINISTRATOR');
INSERT INTO `airline`.`user` (`login`, `password`, `mail`, `user_role_id`) VALUES ('user', '3599307', 'user@mail.ru', '1');
INSERT INTO `airline`.`user` (`login`, `password`, `mail`, `user_role_id`) VALUES ('admin', '92668751', 'admin@mail.ru', '4');
INSERT INTO `airline`.`user` (`login`, `password`, `mail`, `user_role_id`) VALUES ('dispatcher', '-1212540249', 'dispatcher@mail.ru', '5');

ALTER TABLE `airline`.`user`
  CHANGE COLUMN `password` `password` VARCHAR(500) NOT NULL ,
  CHANGE COLUMN `mail` `mail` VARCHAR(300) NOT NULL ;

INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Anton', 'Kylich', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Kirill', 'Archipenko', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Viktor', 'Antipin', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Igor', 'Panarin', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Patrick', 'Maccinon', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Sergey', 'Matus', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Daniil', 'Rozin', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mike', 'Tawiz', '4', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Anna', 'Kisel', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Viktoria', 'Tkacheva', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Adelina', 'Salsanova', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Olga', 'Petrova', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Anna', 'Pinchuk', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Inna', 'Grigorovich', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Maria', 'Kapustina', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Angelina', 'Dancevich', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Irina', 'Litvin', '3', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Veronika', 'Loginova', '3', '2');

INSERT INTO `airline`.`appointment` (`id`, `name`) VALUES ('3', 'NAVIGATOR');
INSERT INTO `airline`.`appointment` (`id`, `name`) VALUES ('4', 'RADIO_OPERATOR');

INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Anton', 'Ostapchuk', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Andrew', 'Mithcen', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mark', 'Shafell', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mich', 'Marnen', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Artyom', 'Biroeyv', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Kirill', 'Gotovets', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Kevin', 'MacDavid', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Alan', 'Lincoln', '4', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Stew', 'Moris', '4', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mat', 'Dushen', '4', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Shon', 'Cuterie', '4', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Yegeniy', 'Andronov', '4', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mike', 'Scrivens', '4', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Alex', 'Simons', '4', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mich', 'Marner', '4', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Oskar', 'Osala', '4', '4');
