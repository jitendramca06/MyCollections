-- tables
CREATE SCHEMA test;
CREATE TABLE Employee (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  managerId int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE A (
  id int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE B (
  id int(11) NOT NULL,
  PRIMARY KEY (`id`)
);
