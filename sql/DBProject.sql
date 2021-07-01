-- 데이터 타입, 함수, 조언(ansi join)
use someone09;

create table memberLJW(
id varchar(20),
name varchar(20) not null,
regno varchar(13) not null,
hp varchar(13),
address varchar(100),
constraint member_id_pk primary key(id),
constraint member_regno_uq unique(regno),
constraint member_hp_uq unique(hp)
);

-- hp 칼럼에 unique 제약조건 추가
alter table memberLJW
add constraint memberLJW_hp_uq unique(hp);

CREATE TABLE `someone09`.`bookLJW` (
  `code` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `count` INT NULL,
  `price` INT NULL,
  `pulish` VARCHAR(50) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- insert into memberLJW
insert into memberLJW values('dooly', '둘리', '0001013418000', '01000000001', '서울시 성동구');

insert into someone09.memberLJW values('dooly2', '둘리2', '0001013418001', '01000000002', '서울시 성동구 선왕십리로1');
insert into someone09.memberLJW values('dooly3', '둘리3', '0001013418002', '01000000003', '서울시 성동구 선왕십리로2');
insert into someone09.memberLJW values('dooly4', '둘리4', '0001013418003', '01000000004', '서울시 성동구 선왕십리로3');

insert into someone09.bookLJW (title, count, price, pulish) values('bible', 1, 5000, '가나안출판사');
ALTER TABLE `someone09`.`bookLJW` 
CHANGE COLUMN `pulish` `publish` VARCHAR(50) NULL DEFAULT NULL;

insert into someone09.bookLJW (title, count, price, publish) values('자바1', 1, 15000, '가나안출판사');
insert into someone09.bookLJW (title, count, price, publish) values('자바2', 2, 25000, '가나안출판사');
insert into someone09.bookLJW (title, count, price, publish) values('자바3', 3, 35000, '가나안출판사');

select now() from dual;

alter table rentalLJH
add constraint rental_member_fk foreign key(id) references memberLJH(id);

alter table rentalLJW
add constraint rental_book_fk foreign key(code) references bookLJW(code);

select * from rentalLJW;

insert into rentalLJW (id, code, count, isrental, isreturn) 
values('dooly', 3, 3, 'y', 'n');
-- 대여한 책 만큼 -3
update bookLJW set count = count -3 where code = 3bookLJW;

ALTER TABLE `someone09`.`bookLJW` 
RENAME TO  `someone09`.`bookLJH` ;
ALTER TABLE `someone09`.`bookLJW` 
RENAME TO  `someone09`.`bookLJH` ;
ALTER TABLE `someone09`.`memberLJW` 
RENAME TO  `someone09`.`memberLJH` ;

select * from rentalLJH;

select m.name, b.title, r.rentalDate, m.hp
from memberLJH m inner join rentalLJH r inner join bookLJH b
on m.id = r.id
and r.code = b.code;

select * from rentalLJH;
select * from bookLJH;
select * from memberLJH;

-- --------------------------다시 해야할 것---------------------------
-- alter table rentalLJH
-- add constraint rental_member_fk foreign key(id) references memberLJH(id);

-- alter table rentalLJW
-- add constraint rental_book_fk foreign key(code) references bookLJW(code);
-- --------------------------------------------------------------------

Create Table memberLJH ( select * from  memberPHS);
Create Table bookLJH ( select * from  bookPHS);
Create Table rentalLJH ( select * from  rentalPHS);

alter table rentalLJH 
add constraint rentalLJH_memberLJH_fk foreign key(id) references memberLJH(id); 

alter table rentalLJH 
add constraint rentalLJH_bookLJH_fk foreign key(code) references bookLJH(code); 

select * from information_schema.table_constraints where table_name = rentalLJH;

