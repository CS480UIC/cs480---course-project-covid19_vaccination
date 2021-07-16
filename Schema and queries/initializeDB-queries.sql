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

insert into `user` values (22312,"user 1",3127772134,"user1@gmail.com","password1","cook","Illinois");
insert into `user` values (22313,"user 2",3127772135,"user2@gmail.com","password2","cook","Illinois");
insert into `user` values (22314,"user 3",3127772136,"user3@gmail.com","password3","cook","Illinois");

alter table vaccine auto_increment=1000;
insert into vaccine (vaccine_name,doses,`type`) values ("Pfizer",2,"type1");
insert into vaccine (vaccine_name,doses,`type`) values ("Pfizer",2,"type1");
insert into vaccine (vaccine_name,doses,`type`) values ("Pfizer",2,"type2");

insert into vaccination_center values (101,"center1","cook","Illinois",5000);
insert into vaccination_center values (102,"center2","cook","Illinois",5000);
insert into vaccination_center values (103,"center3","cook","Illinois",5000);

insert into receiver(user_id,vaccine_id,center_id) values(22312,1001,103);
insert into receiver(user_id,vaccine_id,center_id) values(22313,1002,101);
insert into receiver(user_id,vaccine_id,center_id) values(22312,1001,103);

insert into side_effects(user_id,vaccine_id,side_effect,duration) values(22312,1001,"Body pain",24);
insert into side_effects(user_id,vaccine_id,side_effect,duration) values(22312,1001,"Headache",24);
insert into side_effects(user_id,vaccine_id,side_effect,duration) values(22313,1002,"Body pain",24);

insert into stock(vaccine_id,center_id,stock) values(1002,103,600000);
insert into stock(vaccine_id,center_id,stock) values(1002,101,600000);
insert into stock(vaccine_id,center_id,stock) values(1001,102,600000);