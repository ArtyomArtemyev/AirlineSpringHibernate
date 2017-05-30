CREATE SCHEMA `airline` DEFAULT CHARACTER SET utf8 ;

USE airline;

CREATE TABLE `airline`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `airline`.`user_role` (`name`) VALUES ('ADMINISTRATOR');
INSERT INTO `airline`.`user_role` (`name`) VALUES ('DISPATCHER');

CREATE TABLE `airline`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(120) NOT NULL,
  `password` VARCHAR(120) NOT NULL,
  `mail` VARCHAR(120) NOT NULL,
  `user_role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_role_id`)
  REFERENCES `airline`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `airline`.`user` (`login`, `password`, `mail`, `user_role_id`) VALUES ('admin', '92668751', 'admin@mail.ru', '1');
INSERT INTO `airline`.`user` (`login`, `password`, `mail`, `user_role_id`) VALUES ('dispatcher', '-1212540249', 'dispatcher@mail.ru', '2');

CREATE TABLE `airline`.`gender` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `airline`.`gender` (`name`) VALUES ('FEMALE');
INSERT INTO `airline`.`gender` (`name`) VALUES ('MALE');

CREATE TABLE `airline`.`appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(180) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `airline`.`appointment` (`name`) VALUES ('PILOT');
INSERT INTO `airline`.`appointment` (`name`) VALUES ('STEWARDESS');
INSERT INTO `airline`.`appointment` (`name`) VALUES ('NAVIGATOR');
INSERT INTO `airline`.`appointment` (`name`) VALUES ('RADIO_OPERATOR');

CREATE TABLE `airline`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(120) NOT NULL,
  `surname` VARCHAR(120) NOT NULL,
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

INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Anton', 'Kylick', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Kirill', 'Archipenko', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Viktor', 'Antipin', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Igor', 'Panarin', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Patrick', 'Maccinon', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Sergey', 'Matus', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Daniil', 'Rozin', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mike', 'Tawiz', '2', '1');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Anna', 'Kisel', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Viktoria', 'Tkacheva', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Adelina', 'Salsanova', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Olga', 'Petrova', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Inna', 'Grigorovich', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Maria', 'Kapustina', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Angelina', 'Dancevich', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Irina', 'Litvin', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Veronika', 'Loginova', '1', '2');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Anton', 'Ostapchuk', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Andrew', 'Mithcen', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mark', 'Shafell', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mich', 'Marnen', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Artyom', 'Biroeyv', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Kirill', 'Gotovets', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Kevin', 'MacDavid', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Alan', 'Lincoln', '2', '3');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Stew', 'Moris', '2', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mat', 'Dushen', '2', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Shon', 'Cuterie', '2', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Yegeniy', 'Andronov', '2', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mike', 'Scrivens', '2', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Alex', 'Simons', '2', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Mich', 'Marner', '2', '4');
INSERT INTO `airline`.`employee` (`name`, `surname`, `gender_id`, `appointment_id`) VALUES ('Oskar', 'Osala', '2', '4');

CREATE TABLE `airline`.`airplane_team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `team` JSON NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `airline`.`airplane_team` (`team`) VALUES ('{\"pilots\":\"2\",\"stewardess\":\"4\",\"radio_operators\":\"2\",\"navigators\":\"2\"}');
INSERT INTO `airline`.`airplane_team` (`team`) VALUES ('{\"pilots\":\"2\",\"stewardess\":\"3\",\"radio_operators\":\"1\",\"navigators\":\"1\"}');
INSERT INTO `airline`.`airplane_team` (`team`) VALUES ('{\"pilots\": \"2\", \"navigators\": \"3\", \"stewardess\": \"5\", \"radio_operators\": \"2\"}');

CREATE TABLE `airline`.`airplane` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(120) NOT NULL,
  `team_id` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`team_id`)
  REFERENCES `airline`.`airplane_team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `airline`.`airplane` (`model`, `team_id`) VALUES (' Airbus A310', '1');
INSERT INTO `airline`.`airplane` (`model`, `team_id`) VALUES ('Airbus A320', '2');
INSERT INTO `airline`.`airplane` (`model`, `team_id`) VALUES ('Airbus A330', '3');
INSERT INTO `airline`.`airplane` (`model`, `team_id`) VALUES ('Boeing-737', '2');
INSERT INTO `airline`.`airplane` (`model`, `team_id`) VALUES ('Boeing-777', '3');

CREATE TABLE `airline`.`team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_members` JSON NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE `airline`.`flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `navigation` VARCHAR(220) NOT NULL,
  `team_id` INT,
  `airplane_id` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`team_id`)
  REFERENCES `airline`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (`airplane_id`)
  REFERENCES `airline`.`airplane` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `airline`.`flight` (`navigation`) VALUES ('Minsk-Moscow');
INSERT INTO `airline`.`flight` (`navigation`) VALUES ('Minsk-Paris');
INSERT INTO `airline`.`flight` (`navigation`) VALUES ('Minsk-Lion');
INSERT INTO `airline`.`flight` (`navigation`) VALUES ('Minsk-Praha');
INSERT INTO `airline`.`flight` (`navigation`) VALUES ('Minsk-Sochi');
INSERT INTO `airline`.`flight` (`navigation`) VALUES ('Minsk-Yalta');
INSERT INTO `airline`.`flight` (`navigation`) VALUES ('Minsk-London');

CREATE TABLE `airline`.`user_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(220) NOT NULL,
  `surname` VARCHAR(220) NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `mail` VARCHAR(120) NOT NULL,
  `user_id` INT,
  `flight_id` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`)
  REFERENCES `airline`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (`flight_id`)
  REFERENCES `airline`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


