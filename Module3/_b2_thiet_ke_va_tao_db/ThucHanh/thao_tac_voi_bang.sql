drop database if exists thao_tac_voi_bang;

create database thao_tac_voi_bang;

use thao_tac_voi_bang;

create table student (
	id int primary key not null auto_increment,
    full_name varchar(50) not null,
    email varchar(50) not null
);

DROP TABLE student;

ALTER TABLE student
  ADD address varchar(40) NOT NULL
    AFTER email;