drop table weather;
drop table inhabitant_type;
drop table region;

create database Weather;
use Weather;
create table inhabitant_type
(
	id_type int auto_increment primary key ,
    name nvarchar(50),
    language nvarchar(50)
);
create table region
(
	id_region int auto_increment primary key,
    name nvarchar(100),
    area decimal,
    weather_id int references weather(weather_id),
    id_type int references INHABITANS_TYPE(id_type)
);
create table weather
(
	weather_id int auto_increment primary key,
    date date,
    temperature int,
	precipitation int
);
