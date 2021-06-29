drop database if exists he_thong_ban_hang;

create database he_thong_ban_hang;

use he_thong_ban_hang;

create table productlines(
	product_line varchar(50) primary key not null,
    text_decription text,
    image varchar(10)
    
);

create table offices (
	office_code varchar(10) primary key not null,
    city varchar(50) not null,
    phone varchar(50) not null,
    address_line_1 varchar(50) not null,
    address_line_2 varchar(50),
    state varchar(50),
    country varchar(50) not null,
    postal_code varchar(15) not null
    
);

create table employees (
	employee_number int primary key not null,
    last_name varchar(50) not null, 
    first_name varchar(50) not null, 
    email varchar(100) not null,
    job_title varchar(50) not null,
    report_to int not null,
    office_code varchar(10) not null,
    
    foreign key(report_to) references employees(employee_number),
    foreign key(office_code) references offices(office_code)
);

create table customers(
	customer_number int primary key not null,
    customer_name varchar(50) not null,
    contact_last_name varchar(50) not null,
	contact_first_name varchar(50) not null,
    phone_number varchar(50) not null,
    address_line_1 varchar(50) not null,
	address_line_2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postal_code varchar(15) not null,
    country varchar(50) not null,
    credit_limit float,
    sales_rep_employee_number int not null,
    
    foreign key(sales_rep_employee_number) references employees(employee_number)
);

create table orders(
	order_number int primary key not null,
    order_date date not null,
    required_date date not null,
    shipped_date date,
    `status` varchar(15) not null,
    comments text,
    quantity_ordered int not null,
    price_each float not null,
	customer_number int not null,
    
    foreign key (customer_number) references customers(customer_number)
);

create table payments (
	customer_number int primary key not null,
    check_number varchar(50) not null,
    payment_date date not null,
    amount float not null,
    
    foreign key(customer_number) references customers(customer_number)
);

create table products (
	product_code varchar(15) primary key not null,
    product_name varchar(70) not null,
    product_scale varchar(10) not null,
    product_vendor varchar(50) not null,
    product_decription text not null,
    quantity_in_stock int not null,
    buy_price float not null,
	msrp float not null,
    product_line varchar(50) not null,
    
    foreign key(product_line) references productlines(product_line)
);

create table order_details (
	order_number int not null,
    product_code varchar(15) not null,
    
    primary key(order_number,product_code),
    foreign key(order_number) references orders(order_number),
    foreign key(product_code) references products(product_code)
);