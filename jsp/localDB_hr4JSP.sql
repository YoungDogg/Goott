CREATE TABLE "HR"."MEMBER" 
   (   "USERID" VARCHAR2(15 BYTE), 
   "PASSWORD" VARCHAR2(21 BYTE), 
   "USERNAME" VARCHAR2(12 BYTE) CONSTRAINT "MEMBER_NAME_NN" NOT NULL ENABLE, 
   "GENDER" VARCHAR2(1 BYTE), 
   "EMAIL" VARCHAR2(50 BYTE), 
   "POINT" NUMBER(5,0) DEFAULT 100, 
   "REGISTERDATE" DATE DEFAULT sysdate, 
    CHECK (gender in ('m', 'f')) ENABLE, 
    CONSTRAINT "MEMBER_USERID_PK" PRIMARY KEY ("USERID"));
     
     
create table Friends(
    friendNo number,
    FRIENDNAME VARCHAR2(50),
    FRIENDMOBILE VARCHAR2(50),
    FRIENDADDRESS VARCHAR2(50),
    PRIMARY KEY (friendNo)
);

create table notice(
    id number,
    title VARCHAR2(100),
    writerid VARCHAR2(50),
    content VARCHAR2(50),
    regdate DATE,
    hit number,
    files varchar2(100) default null,
    PRIMARY KEY (id)
);

insert into notice values(1, 'JDBC란 무엇인가?', 'okay', 'aaa', sysdate, 1, '');
insert into notice values(2, 'JDBC 드라이버 다운로드 방법', 'newlec', 'aaa', sysdate, 10, '');
insert into notice values(3, '전화주시기 바랍니다.', 'newlec', '연락처 남깁니다. 010-2222-2333', sysdate, 22, '');
insert into notice values(4, 'Service 계층 추가하기', 'dragon', 'aaa', sysdate, 1, '');
insert into notice values(5, 'JSP에서 JDBC 사용하기', 'newlec', 'soso', sysdate, 33, '');
insert into notice values(6, '파라미터를 가지는 문장 실행하기', 'okay', 'aaa', sysdate, 1, '');
insert into notice values(7, '추가요', 'dragon', 'aaa', sysdate, 44, '');
insert into notice values(8, '디엔드', 'okay', 'aaa', sysdate, 55, '');

select * from notice;
