drop database if exists computer_a1020i1;

create database computer_a1020i1;

use computer_a1020i1;

create table `type` (
	type_id int primary key not null,
    type_name int
);

create table manufacturer (
	manufacturer_id int primary key not null,
    manufacturer_name varchar(40) not null
);

create table `status` (
	status_id int primary key not null,
    status_name varchar(20) not null
);

create table computer (
	computer_id int primary key not null,
    computer_id_status int not null,
    computer_location varchar(10) not null,
    computer_start_used_date date not null,
    computer_configuration varchar(150) not null,
    computer_id_type int not null,
    computer_id_manufacturer int not null,
    computer_warranty_period varchar(20) not null,
    
    foreign key(computer_id_status) references `status`(status_id) on delete cascade,
	foreign key(computer_id_type) references `type`(type_id) on delete cascade,
    foreign key(computer_id_manufacturer) references manufacturer(manufacturer_id) on delete cascade
);