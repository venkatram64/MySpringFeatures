create table Employee(
    id int auto_increment primary key,
    name varchar(100) not null,
    email varchar(50) not null,
    salary numeric(10,2)
);

insert into Employee(name, email,salary) values('Venkatram', 'venkat@venkat.com', 1234567.00)
insert into Employee(name, email,salary) values('Srijan', 'srijan@srijan.com', 123456789.00)