-- bookTBL
-- code ���� 4 pk
-- title ���� 50
-- writher ���� 20
-- price ���� 8
drop table bookTBL;

create table bookTBL(
	code number(4) primary key,
	title nvarchar2(50) not null,
	writer nvarchar2(20) not null,
	price number(8) not null	
);

insert into bookTBL values(1001,'�̰��� �ڹٴ�', '�ſ��', 28000);
insert into bookTBL values(1002,'�ڹ��� ��', '���ſ�', 29000);
insert into bookTBL values(1003,'�ڹ� 1000��', '��븸', 27000);
insert into bookTBL values(1004,'����Ŭ�� ���� �����ͺ��̽� �Թ�', '������', 32000);

select * from booktbl;









