create table CUSTOMERS
(
    id int PRIMARY KEY auto_increment,
    name varchar(255) not null,
    surname varchar(255) not null,
    age int not null check (age>0),
    phone_number varchar(255)
);

create table ORDERS
(
    id int PRIMARY KEY auto_increment,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    customer_id int references CUSTOMERS(id),
    product_name varchar(255) not null,
    amount bigint not null check (amount >= 0)
);