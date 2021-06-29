drop database if exists bai1_csdl_over_view;

create database bai1_csdl_over_view;

use bai1_csdl_over_view;

create table student(
id int primary key auto_increment,
`name` varchar(30),
age int
);

insert into student(`name`, age)
value 
('thuan',25),
('thong', 20),
('tien',30);

select `name`
from student
where name = 'thuan';
