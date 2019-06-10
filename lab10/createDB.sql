create database Users;
drop table users;
use Users;
create table users
(
	id int primary key auto_increment,
    firstName nvarchar(50),    
    secondName nvarchar(50),    
    mail nvarchar(50),    
    password nvarchar(50),
    privilege nvarchar(5) default 'user'
);
