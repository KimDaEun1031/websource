create table member(
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	gender varchar2(2) not null,
	email varchar2(50) not null
);

insert into member values('admin','admin123','운영자','여','admin123@gmail.com');

select * from member;