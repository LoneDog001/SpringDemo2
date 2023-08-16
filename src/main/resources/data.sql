insert into CUSTOMERS(name, surname, age, phone_number)
values ('Andrey', 'Pomeschikov', 21, 154684849),
       ('Vlad', 'Kotov', 63, 868454561651),
       ('Andrey', 'Petrov', 29, 5253434),
       ('Irina', 'Ivanova', 22, 5484984498);

insert into ORDERS (customer_id, product_name, amount)
values (1, 'Coca-Cola', 56),
       (2, 'Pepsi', 68),
       (3, 'Sprite', 59),
       (4, 'Fanta', 57);