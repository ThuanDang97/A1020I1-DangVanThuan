drop database if exists case_study;

create database case_study;

use case_study;

create table `role` (
	role_id int primary key not null auto_increment,
    role_name varchar(255) not null 
);

create table `user` (
	username varchar(255) primary key not null,
    `password` varchar(255) not null
);

create table user_role (
	role_id int,
    username varchar(255),
    
    constraint user_role_pk primary key (role_id, username),
    foreign key(role_id) references `role`(role_id),
    foreign key(username) references `user`(username)
);

create table `position` (
	position_id int primary key not null auto_increment,
    position_name varchar(45) not null
);

create table education_degree (
	education_degree_id int primary key not null auto_increment,
    education_degree_name varchar(45) 
);

create table division(
	division_id int primary key not null auto_increment,
    division_name varchar(45) not null
);

create table employee (
	employee_id int primary key not null auto_increment,
    employee_name varchar(45) not null,
    employee_birthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45) not null,
    employee_address varchar(45) not null,
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
    username varchar(255),
    
    foreign key(position_id) references `position`(position_id),
    foreign key(education_degree_id) references education_degree(education_degree_id),
    foreign key(division_id) references division(division_id),
    foreign key(username) references `user`(username)
    
);

create table customer_type (
	customer_type_id int primary key not null auto_increment,
    customer_type_name varchar(45) not null
);

create table customer (
	customer_id int primary key not null auto_increment,
    customer_type_id int not null,
    customer_name varchar(45) not null,
    customer_birthday varchar(45) not null,
    customer_gender bit(1) not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45) not null,
    customer_address varchar(45) not null,
    
    foreign key(customer_type_id) references customer_type(customer_type_id)
);

create table service_type (
	service_type_id int primary key not null auto_increment,
    service_type_name varchar(45) not null
);

create table rent_type (
	rent_type_id int primary key not null auto_increment,
    rent_type_name varchar(45) not null,
    rent_type_cost double
);

create table service (
	service_id int primary key not null auto_increment,
    service_name varchar(45) not null,
    service_area int not null,
    service_cost double not null,
    service_max_people int not null,
    rent_type_id int not null,
    service_type_id int not null,
    standard_room varchar(45) ,
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    
    foreign key(service_type_id) references service_type(service_type_id),
    foreign key(rent_type_id) references rent_type(rent_type_id)
);

create table contract (
	contract_id int primary key not null auto_increment,
    contract_start_date datetime ,
    contract_end_date datetime ,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id int,
    service_id int,
    
    foreign key(employee_id) references employee(employee_id),
    foreign key(customer_id) references customer(customer_id),
    foreign key(service_id) references service(service_id)
);

create table attach_service (
	attach_service_id int primary key not null auto_increment,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit int not null,
    attach_service_status varchar (45)
);

create table contract_detail (
	contract_detail_id int primary key not null auto_increment,
    contract_id int not null,
    attach_service_id int not null,
    quantity int not null,
    
    foreign key(contract_id) references contract(contract_id),
    foreign key(attach_service_id) references attach_service(attach_service_id)
);

-- insert data

insert into `position` (position_name)
values
('Lễ Tân'),
('Phục Vụ'),
('Chuyên Viên'),
('Giám Sát'),
('Quản Lý'),
('Giám Đốc');

insert into education_degree (education_degree_name)
values
('Trung Cấp'),
('Cao Đẳng'),
('Đại Học'),
('Sau Đại Học');

insert into division (division_name)
values
('Sale – Marketing'),
('Hành Chính'),
('Phục Vụ'),
('Quản Lý');

insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)
values
('Đặng Văn Thuận', '1997-10-25', '123123123', '400', '123123123', 'abc@gmail.com', 'Đà Nẵng', 1, 4, 2, null), 
('Đăng Khoa', '1996-10-25', '123123123', '350', '123123123', 'abc@gmail.com', 'Huế', 2, 3, 3, null), 
('Trung Hiếu', '1995-10-25', '123123123', '350', '123123123', 'abc@gmail.com', 'Quảng nam', 3, 2, 3, null), 
('Duy Khánh', '1994-10-25', '123123123', '450', '123123123', 'abc@gmail.com', 'Vinh', 4, 1, 1, null), 
('Hữu Tài', '1993-10-25', '123123123', '600', '123123123', 'abc@gmail.com', 'Quảng Trị', 5, 3, 4, null), 
('Văn Hậu', '1992-10-25', '123123123', '350', '123123123', 'abc@gmail.com', 'Quảng Ngãi', 6, 4, 3, null);

insert into customer_type (customer_type_name)
values
("Diamond"),
("Platinum"),
("Gold"),
("Silver"),
("Member");

insert into customer (customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
values
(1,"Nguyen Van A","2004-01-01",1,"111111111","0901234567","abc@gmail.com","Đà Nẵng"),
(2,"Nguyen Van B","2002-01-01",0,"222222222","0902345678","abc@gmail.com","Quảng Ngãi"),
(3,"Nguyen Van C","1990-01-01",1,"333333333","0903456789","abc@gmail.com","Vinh"),
(5,"Nguyen Van D","1989-01-01",0,"444444444","0904567890","abc@gmail.com","Quảng Trị"),
(2,"Nguyen Van E","2003-05-01",1,"555555555","0905678901","abc@gmail.com","Đà Nẵng"),
(4,"Nguyen Van F","1980-01-01",0,"666666666","0906789012","abc@gmail.com","Huế");

insert into service_type(service_type_name)
values
("Villa"),
("House"),
("Room");

insert into rent_type(rent_type_name,rent_type_cost)
values
("Nam",50),
("Thang",60),
("Ngay",80),
("Gio",100);

insert into service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)
values 
("Villa1", 150, 200, 30, 3, 1, "VIP", "wifi", 30, 2),
("House1", 100, 100, 15, 3, 2, "VIP", "wifi", null, 3),
("Room1", 50, 50, 5, 2, 3, null, null, null, null),
("Villa2", 300, 450, 50, 4, 1, "VIP", "wifi", 30, 4),
("House2", 150, 300, 25, 1, 2, "VIP", "wifi", null, 5),
("Room2", 100, 100, 10, 3, 3, null, null, null, null);

insert into contract (contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id)
values
("2015-12-12","2019-03-12",100,400,1 ,6 ,1 ),
("2018-12-12","2019-03-12",100,400, 2, 5, 2),
("2018-01-12","2019-08-12",100,300, 3, 4, 3),
("2018-01-12","2019-08-12",100,250, 4, 3, 4),
("2018-01-12","2019-08-12",100,700, 5, 2, 5),
("2019-01-12","2020-10-12",100,550, 6, 1, 6),
("2019-05-01","2021-05-01",100,560, 3, 4, 1),
("2018-05-01","2021-05-01",100,450, 6, 2, 5),
("2019-10-01","2021-05-01",100,300, 6, 2, 5),
("2019-10-20","2021-05-01",100,670, 3, 1, 4);

insert into attach_service( attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values
("Massage",10,1,"Not available"),
("Karaoke",15,1,"Available"),
("Thuc an",20,1,"Not available"),
("Nuoc uong",15,1,"Not available"),
("Thue xe",50,1,"Available");

insert into contract_detail(contract_id, attach_service_id, quantity)
values
(1,1,3),
(2,4,2),
(3,3,3),
(4,4,5),
(5,2,4),
(6,3,3),
(7,1,3),
(8,2,4),
(9,1,4);