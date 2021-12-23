DROP DATABASE todolist;

CREATE DATABASE todolist
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE todolist;

CREATE TABLE task (
  id                  bigint(20)    NOT NULL AUTO_INCREMENT,
  name                varchar(255)  NOT NULL,
  description         varchar(512)  NOT NULL,
  event_date          date    NOT NULL,
  deleted             int(1)        NOT NULL,
  attachment_id       bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

CREATE TABLE attachment (
  id bigint(20)    NOT NULL AUTO_INCREMENT,
  task_id bigint(20)    NOT NULL,
  file_name varchar(255) NOT NULL,
  file_path varchar(36)  NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;
