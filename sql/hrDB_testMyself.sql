--트리거 디엠엘 자동으로 수행 
create table empTrigger(
empno number(4) primary key,
ename varchar2(20),
job varchar2(20)
);

create or replace trigger trg_test
after insert --트리거 수행시점 insert/update/delete
on empTrigger
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원이 입사 했습니다');      
END;

INSERT into empTrigger VALUES(2,'someone', 'ceo');

