CREATE TABLE friends(
    friendno NUMBER,
    friendname VARCHAR2(50) NOT NULL,
    friendmobile VARCHAR2(50) NOT NULL,
    friendaddress VARCHAR2(50) NOT NULL,
    PRIMARY KEY(friendno)
);
CREATE TABLE journal(
    journalno NUMBER,
    journaldate VARCHAR2(50) NOT NULL,
    journalcontent VARCHAR2(500) NOT NULL,
    PRIMARY KEY(journalno)
);

alter table journal modify journaldate date default sysdate;

delete from journal;

insert INTO journal values(1, '2021/07/26', '¿À´Ã Áñ°Å¿ü´Ù.');
insert INTO journal values(2, '2021/07/27', '¿À´Ã ³Ê¹« Áñ°Å¿ü´Ù.');

update journal set journaldate = sysdate where journaldate is not null;

select max(journalno + 1) as nextNo from journal;
select journaldate+1 from journal;
select * from journal;

drop table friends;
drop table member;
CREATE TABLE MEMBER
   (   "USERID" VARCHAR2(15 BYTE), 
   "PASSWORD" VARCHAR2(21 BYTE), 
   "USERNAME" VARCHAR2(12 BYTE) CONSTRAINT "MEMBER_NAME_NN" NOT NULL ENABLE, 
   "GENDER" VARCHAR2(1 BYTE), 
   "EMAIL" VARCHAR2(50 BYTE), 
   "POINT" NUMBER(5,0) DEFAULT 100, 
   "REGISTERDATE" DATE DEFAULT sysdate, 
    CHECK (gender in ('m', 'f')) ENABLE, 
    CONSTRAINT "MEMBER_USERID_PK" PRIMARY KEY ("USERID"));
insert into member values();
select * from member;
