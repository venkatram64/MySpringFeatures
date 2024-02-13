
CREATE SCHEMA `my_user_db` ;

create table users(
id int not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(50) not null,
password varchar(500) not null,
role varchar(50) not null,
primary key (id)
);

insert into users(first_name, last_name, email, password, role) 
values('Venkatram','Veerareddy','venkat@venkat.com', 'venkat', 'admin')