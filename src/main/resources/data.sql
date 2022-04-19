delete from admin where id=1;
delete from person where id=1;
insert into person (email, password, role) values ('admin@carparking.com', '12345', 'ADMIN');
insert into admin(address, firstname, lastname, phonenumber, id) values ('Delhi, India', 'Markus', 'Maverick', '+91 9936123405', 1);
