drop database if exists user_manager;
CREATE DATABASE user_manager;
USE user_manager;

create table users (
 id int NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);


create table permission(

id int primary key auto_increment,

`name` varchar(50)

);

create table user_permission(
permission_id int,
user_id int,

primary key(permission_id, user_id),
foreign key(permission_id) references permission(id),
foreign key(user_id) references users(id)
);

insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');

insert into permission(`name`) values('add');

insert into permission(`name`) values('edit');

insert into permission(`name`) values('delete');

insert into permission(`name`) values('view');

SELECT * FROM user_manager.users;
