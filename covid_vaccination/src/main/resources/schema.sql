use covid_vaccination;

create table vaccination_entity(
id int auto_increment,
vaccine_name varchar(100) not null,
doses int not null check (doses in (1,2,3)),
type varchar(100),
primary key(id)
);

create table user(
ssn int,
name char(100) not null,
phone_number bigint not null,
email char(100) not null,
password char(100) not null,
county char(100),
state char(100),
primary key(ssn)
);

create table center(
id int,
name char(100),
county char(100),
state char(100),
vaccinated int,
primary key(id)
);