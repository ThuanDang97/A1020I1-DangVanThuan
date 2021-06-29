drop database if exists quan_ly_thu_vien;

create database quan_ly_thu_vien;

use quan_ly_thu_vien;

create table category (
	id_category int primary key auto_increment,
    category_book varchar(50) not null
    
);

create table student (
	student_number int primary key auto_increment,
    student_name varchar(50) not null,
    address varchar(500) not null,
    email varchar(50) not null,
    image varchar(10)
);

create table book (
	id_book int primary key auto_increment,
	book_name varchar(50) not null,
    id_category int not null,
    author varchar(50) not null,
    
    foreign key(id_category) references category(id_category)
);

create table borrow_order (
	id_borrow_order int primary key auto_increment,
    student_number int not null,
    id_book int not null,
    borrowed_date date not null,
    refund_date date not null,

	foreign key(student_number) references student(student_number),
    foreign key(id_book) references book(id_book)
);


insert into category(category_book)
values
('văn học'),
('truyện ngắn'),
('tiểu thuyết'),
('sách giải'),
('sách bài tập');

insert into student(student_name,address,email,image)
values 
('Nguyễn Văn A', 'Đà Nẵng', 'abc@abc.com', ' '),
('Nguyễn Văn B', 'Huế', '123@abc.com', ' '),
('Nguyễn Văn C', 'Quảng Nam', '345@abc.com', ' '),
('Nguyễn Văn D', 'Gia Lai', '567@abc.com', ' '),
('Nguyễn Văn E', 'Đà Nẵng', '154@abc.com', ' ');

insert into book(book_name, id_category, author)
values
('Chí Phèo', 1, 'Nam Cao'),
('ABC', 3, 'BCD'),
('Sách bài tập Anh', 5, 'abcd'),
('Mắt Biếc', 2, 'NNA'),
('Sách giải toán', 4, 'BCD');