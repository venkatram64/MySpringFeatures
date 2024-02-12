step 1:

CREATE SCHEMA `my_venn_db` ;

step 2: taken below script from spring security 
or 
https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html

create table users(
username varchar(50) not null,
password varchar(500) not null,
enabled boolean not null,
primary key (username)
);

create table authorities (
username varchar(50) not null,
authority varchar(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

insert into users(username, password, enabled) values('venkat', 'venkat', '1');
insert into authorities(username, authority) values('venkat', 'write');
insert into users(username, password, enabled) values('srijan', 'srijan', '1');
insert into authorities(username, authority) values('srijan', 'write');




