DELETE FROM admin where id=1;
DELETE FROM PERSON where id=1;
insert into person (id, email, password, role) values (1, 'admin@carparking.com', '12345', 'ADMIN');
insert into admin(address, age, firstname, lastname, phonenumber, id) values ('Delhi, India', 30, 'Markus', 'Maverick', '+91 9936123405', 1);
