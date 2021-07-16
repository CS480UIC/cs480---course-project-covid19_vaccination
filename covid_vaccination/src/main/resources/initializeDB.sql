use covid_vaccination;

create table vaccine(
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
email varchar(100) not null,
`password` char(100) not null,
county char(100),
state char(100),
primary key(ssn)
);

create table vaccination_center(
id int,
name char(100),
county char(100),
state char(100),
vaccinated int,
primary key(id)
);

create table receiver(
id int auto_increment,
user_id int,
vaccine_id int,
center_id int,
primary key(id),
foreign key(user_id) references user(ssn) on delete cascade on update cascade,
foreign key(vaccine_id) references vaccine(id) on delete cascade on update cascade,
foreign key(center_id) references vaccination_center(id) on delete cascade on update cascade
);

create table side_effects (
`index` int auto_increment,
user_id int,
vaccine_id int,
side_effect varchar(1000),
duration int,
primary key(`index`),
foreign key(user_id) references user(ssn) on delete cascade on update cascade,
foreign key(vaccine_id) references vaccine(id) on delete cascade on update cascade
)

create table stock(
stock_id int auto_increment,
vaccine_id int,
center_id int,
stock bigint,
primary key(stock_id),
foreign key(vaccine_id) references vaccine(id) on delete cascade on update cascade,
foreign key(center_id) references vaccination_center(id) on delete cascade on update cascade
);
