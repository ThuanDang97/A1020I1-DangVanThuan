drop database if exists bai_tap_4;

create database bai_tap_4;

use bai_tap_4;

CREATE TABLE products (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    productCode VARCHAR(20) NOT NULL,
    productName VARCHAR(50) NOT NULL,
    productPrice INT(20) NOT NULL,
    productAmount INT(20) NOT NULL,
    productDescription VARCHAR(255),
    productStatus VARCHAR(255) NOT NULL
);

insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
values	("P01","SamSung",2000,1000,"Product from Samsung","not available"),
		("P02","Huawei",1000,1200,"Product from Huawei","available"),
		("P03","Xiaomi",900,10000,"Product from Xiaomi","not available"),
		("P04","Iphone",1800,9000,"Product from Apple","available");

alter table products
add index indexProduct(productCode);

alter table products
add index compositeIndex(productName,productPrice);

SELECT *
FROM products
WHERE productCode = 'P03';
explain select * from products where productCode = 'P03';

SELECT *
FROM products
WHERE productName = 'SamSung' AND productPrice = '2000';
explain select * from products where productName = 'SamSung' and productPrice = '2000';

CREATE OR REPLACE VIEW ProductInfor AS
    SELECT productCode, productName, productPrice, productStatus
    FROM products;
    
SELECT *
FROM ProductInfor;