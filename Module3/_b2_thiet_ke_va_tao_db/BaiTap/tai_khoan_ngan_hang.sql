drop database if exists tai_khoan_ngan_hang;

create database tai_khoan_ngan_hang;

use tai_khoan_ngan_hang;

create table customers(
	customer_number int primary key,
    full_name varchar(50),
    address varchar(150),
    email varchar(50),
    phone int
    
);

create table accounts(
	account_number int primary key auto_increment,
    account_type varchar(15),
    `date` date,
    balance int,
    customers_customer_number int,
    
    foreign key (customers_customer_number) references customers(customer_number)
    
);

create table transactions (
	tran_number int primary key,
    account_number int,
    `date` date,
    amounts int,
    descriptions varchar(150),
    account_number_account int,
    
    foreign key (account_number_account) references accounts(account_number)
);