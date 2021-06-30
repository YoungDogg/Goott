-- 순서대로 집어넣는 방법
-- 직접 집어넣기, 최악
-- rownum, 안정적
-- sequence
-- trigger
-- 넷 다 해보자

create table video(
    videoID NUMBER(4),
    name varchar2(41),
    numOfVdo NUMBER(5) constraint video_numOfVdo_nn not null,
    rentedNum NUMBER(5) constraint video_rentedNum_nn not null,
    genreID NUMBER(4),  -- set as froreign key from genre table
    
    constraint video_videoID_pk primary key(videoID),
    constraint video_name_uq unique(name)
);

-- 시퀀스를 만들어서 프라이머리 키가 자동으로 증가하게 만든다
--CREATE SEQUENCE videoSequence
--START WITH 1 INCREMENT BY 1 MAXVALUE 9999 NOCYCLE NOCACHE;
---- 트리거를 만든다
--create or replace trigger video_videoID_insertg
--    before insert on video
--    for each row
--begin
--    select videoSequence.nextval
--    INTO :new.videoID
--    FROM video;
--end;    

 drop SEQUENCE videoSequence;
-- 트리거 나중에 하자


select * from video;

-- pk 직접 집어넣기
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (1, '어벤저스', 2, 20, 1);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (2, '어벤저스2', 4, 17, 1);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (3, '캡틴아메리카: 시빌워', 6, 20, 1);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (4, '어벤저스: 인피니티워', 2, 80, 1);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (5, '어벤저스: 엔드게임', 7, 220, 1);

insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (6, '트랜스포머', 5, 100, 2);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (7, '트랜스포머2', 1, 81, 2);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (8, '트랜스포머3', 2, 69, 2);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (9, '트랜스포머4', 0, 12,2);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (10, '트랜스포머5', 2, 8, 2);

insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (11, '새콤달콤', 1, 55, 3);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (12, '장난스런 키스', 1, 33, 3);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (13, '너의 췌장을 먹고 싶어', 2, 59, 3);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (14, '너의 결혼식', 7, 15, 3);

insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (15, '센트럴 인텔리전스', 1, 5, 4);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (16, '센트럴 인텔리전스', 2, 15, 4);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (17, '행오버3', 1, 9, 4);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (18, '나쁜 이웃들', 3, 99, 4);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (19, '리틀맨', 6, 21, 4);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (20, '킬러의 보디가드', 1, 72, 4);

insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (21, '그것', 2, 32, 5);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (22, '그것2', 1, 53, 5);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (23, '컨저링', 0, 3, 5);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (24, '컨저링2', 1, 63, 5);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (25, '컨저링3', 1, 55, 5);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (26, '새벽의 저주', 5, 73, 5);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (27, '곤지암', 2, 38, 5);

insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (28, '악마를 보았다', 2, 338, 6);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (29, '인셉션', 1, 538, 6);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (30, '미스 슬로운', 0, 0, 6);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (31, '조디악 미스터리', 4, 12, 6);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (32, '셔터 아일랜드', 7, 22, 6);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (32, '노인을 위한 나라는 없다', 4, 72, 6);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (32, '아이덴티티', 7, 51, 6);

insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (33, '색계', 2, 999, 7);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (34, '엄마친구', 2, 899, 7);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (35, '나만의 승진 테크닉', 0, 999, 7);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (36, 'LOLITA', 1, 598, 7);
insert into video(videoID, name, numOfVdo, rentedNum, genreID)
values (37, '착한아내', 50, 777, 7);

-- 장르 번호 : ["액션", "SF", "로맨스", "코미디", "공포", "스릴러", "성인"]

--rownum을 이용해서 pk 집어넣기
delete from video where videoID != 0; -- 있는 거 지우고

select ROWNUM from video;

UPDATE video SET videoID = rownum;




create table member(
    memberID NUMBER(4), -- 없애고 집어넣으면 rownum 
    overdueID number(4), -- f overdue table
    memberName varchar2(16) constraint member_memberName_nn not null,
    memberPhone varchar2(12) constraint member_memberPhone_nn not null,
    memberIsAdult varchar2(2) constraint member_memberIsAdult_nn not null, 
    memberRentable varchar2(2)constraint member_memberRentable_nn not null,
    
    constraint member_memberID_pk primary key(memberID),
    constraint member_memberName_uq unique(memberName)
);
select * from member;

alter table member 
modify (memberID default rownum); -- 안되네...

alter table member 
modify drop memberID; -- 이건 잘못된 표현

ALTER TABLE member 
DROP COLUMN memberID;   -- 나중에 rownum을 집어넣을 것이다.

select * from member;

insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('강우성','0100000001','y','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('류승범','0100000002','y','n');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('강동원','0100000003','y','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('권상우','0100000004','n','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('박용하','0100000005','y','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('박해일','0100000006','n','n');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('박희순','0100000007','n','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('배용준','0100000008','y','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('설경구','0100000009','n','n');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('송승헌','0100000010','y','n');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('이영애','0100000011','y','n');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('이나영','0100000012','y','n');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('이지아','0100000013','n','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('임수정','0100000014','y','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('전도연','0100000015','y','n');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('전지현','0100000016','n','y');
insert into member(memberName, memberPhone, memberIsAdult, memberRentable)
values ('한예슬','0100000017','y','y');

select * from member;

SAVEPOINT memberDataInput;


create table rent(
--    rentID NUMBER(4), -- 나중에 집어넣으면 rownum 
    memberID number(4), -- foreign key
    rentTotalFee number(7) constraint rent_rentTotalFee_nn not null,
    rentNonAdultVideoNum number(3) constraint rent_rentNonAdultVideo_nn not null,
    rentAdultVideoNum number(3) constraint rent_memberIsAdult_nn not null, 
    rentTotalNum number(3) constraint rent_rentNumOfRent_nn not null,
    returnDate DATE 
    
-- constraint member_memberID_pk primary key(memberID), -- 나중에 rownum 집어넣고
-- constraint rent_member_memberID_f foreign key(memberID) references member(memberID)
--나중에 member 테이블에 
);

alter table rent
add returnDate DATE;

select * from rent;
drop table rent;

insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (500,1,0,1);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (2500,1,2,3);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (1000,2,0,2);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (5000,10,0,10);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (1000,0,10,10);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (20000,0,20,20);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (3500,7,0,7);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (12000,8,8,16);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (2000,2,1,3);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (1000,0,1,1);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (500,1,0,1);
insert into rent(rentTotalFee, rentNonAdultVideoNum, rentAdultVideoNum, rentTotalNum)
values (500,1,0,1);


create table overdue(
--    overdueID NUMBER(4), -- 나중에 집어넣으면 rownum 
    memberID number(4), -- foreign key
    dueDate DATE, -- foreign key
    isOverdue varchar2(2), -- 현재 연체냐
    wasOverdue varchar2(2), -- 전에 연체였냐
    HowLongOvrDu DATE,
    rentTotalNum number(3), -- foreign key
    overdueFee number(7) -- 999999원 + 1일당 1000원

-- constraint overdue_overdueID_pk primary key(overdueID), -- 나중에 rownum 집어넣고
-- constraint overdue_member_memberID_f foreign key(memberID) references member(memberID)
-- 등등 
--나중에 member 테이블에 
);
alter table overdue
add (wasOverdue varchar2(2));

drop table overdue;

insert into overdue(isOverdue)
values ('n');
insert into overdue(isOverdue, HowLongOvrDu, overdueFee)
values ('n');

