-- 2021.06.22 chapter 1. 연습문제
-- 1. 사원 테이블 emp의 모든 정보를 출력하는 sql문
select * from emp;
-- 2. 사원의 이름과 급여, 입사일을 출력하는 sql문
select ENAME, SAL from emp;
-- 3. 사원들이 어떤 부서에 소속되어 있는지, 소속 부서 만을 출력하되,
--중복 하지 않고 한번씩 출력하는 sql문
select DISTINCT DEPTNO from emp;
-- 4. 테이블 emp중에서 부서번호가 10번인 사원에 관한 모든 정보를 출력하는 sql문
select * from emp
where deptno = 10;
-- 5. 테이블 emp중에서 급여가 2000미만이 되는 사원의 정보 중에서
--사번, 이름, 급여를 출력하는 sql문
select EMPNO, ENAME, SAL 
from emp
where SAL < 2000;
-- 6. 이름이 miller인 사원의 사번과 사원명, 직급을 출력하는 sql문
select EMPNO, ENAME, MGR
from emp
where ENAME = 'MILLER';
 
-- 7. 커미션이 300 또는 500 또는 1400인 사원의 사번, 이름, 커미션을 출력하는 sql문
-- 위 문제를 해결하는 방법이 2가지 있습니다. 둘 다 모두 쓰세요
select EMPNO, ENAME, COMM
from emp
where comm = 300 or comm = 500 or comm = 1400;

select EMPNO, ENAME, COMM
from emp
where comm in(300,500, 1400);

--8. 급여가 1500과 2500사이인 사원의 사번, 이름, 급여를 출력하는 sql문
-- 위 문제를 해결하는 방법이 2가지 있습니다. 둘 다 모두 쓰세요
select EMPNO, ENAME,SAL
from emp
where SAL >= 1500 and SAL <= 2500;

select EMPNO, ENAME,SAL
from emp
where SAL BETWEEN 1500 and 2500;
-- 9. 이름에 A를 포함하지 않은 사원의 사번, 이름을 출력하는 sql문
select EMPNO, ENAME
from emp
where ENAME not like '%A%';
-- 10. 자신의 직속 상관이 없는 사원의 이름과 직급과 직속상관의 사번을 출력하는 sql문
select  ENAME, JOB, mgr
from emp
where MGR is NULL;
-- 11. 사원의 사번, 이름 ,급여를 출력하되, 급여가 높은 순으로 출력하는 sql문
select  EMPNO, ENAME, SAL
from emp
ORDER by sal DESC;
-- 12. 입사일이 가장 최근인 사원 순으로 사번, 이름, 입사일을 출력하는 sql문
select  EMPNO, ENAME, HIREDATE
from emp
ORDER by HIREDATE DESC;


-- 2021년 6월 23일 chapter2. 연습 문제

-- 1. 사번이 짝수인 사원들의 사번, 이름, 직급을 출력
SELECT  EMPNO, ENAME, JOB FROM EMP 
--where substr(EMPNO, -1, 1)in(0, 2, 4, 6, 8);
where mod(EMPNO,2) = 0;
-- 2. 'Smith'란 이름을 가진 사원의 사번, 이름, 급여, 커미션을 출력
-- 2-1. initcap 사용
-- 2-2. upper 사용
SELECT  EMPNO, ENAME, SAL, COMM FROM EMP 
WHERE upper(ENAME) = 'SMITH';

SELECT  EMPNO, ENAME, SAL, COMM FROM EMP 
WHERE initcap(ENAME) = 'Smith';

-- 3. 이름의 두번째 자리에 A가 있는 사원의 사번, 이름, 직급 출력
-- 3-1. substr 사용
-- 3-2. instr 사용
SELECT EMPNO, ENAME, JOB FROM EMP 
WHERE substr(ENAME, 2, 1) = 'A';
-- 4. 이름이 K로 끝나는 직원의 사번, 이름, 직급 출력
SELECT  EMPNO, ENAME, JOB FROM EMP 
WHERE substr(ENAME, -1, 1) = 'K';
-- 5. 82년도에 입사한 사원의 사번, 이름, 입사일 출력
SELECT  EMPNO, ENAME, HIREDATE FROM EMP 
WHERE substr(HIREDATE, 1, 2) = '82';
-- 6. 이름이 6글자 이상인 사원의 사번, 이름, 급여 출력
SELECT  EMPNO, ENAME, SAL FROM EMP 
WHERE length(ENAME) >= 6;
-- 7. 모든 사원은 자신의 상관이 있다. 하지만 emp 테이블에 상관이 없는 사원이 있는데, 
-- 그 사원의 mgr 컬럼 값이 null이다. 상관이 없는 사원만 출력하되,
--mgr 컬럼 값 null대신 'CEO'라고 출력해라
SELECT  EMPNO, ENAME, nvl2(MGR, 'has Manager','CEO') FROM EMP
where MGR is NULL;
-- 8. 직급에 따라 급여를 인상하도록 한다. 
--직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%
--  'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20% 인상하여 출력한다
SELECT  EMPNO, ENAME, JOB,case when JOB= 'ANALYST' then SAL + (SAL * 0.05)
                            when  JOB= 'SALESMAN' then SAL + (SAL * 0.1)
                            when  JOB= 'MANAGER' then SAL + (SAL * 0.15)
                            when  JOB= 'MANAGER' then SAL + (SAL * 0.2)
                            else SAL
                            end as "salary + commission"
                            FROM EMP;



-- chapter3 그룹함수 연습문제 

-- 1. 직업의 종류가 몇개인지, 즉 중복되지 않은 직업의 갯수를 카운트 하는 sql문 작성
SELECT COUNT(distinct JOB) from emp;
-- 2. 부서별로 사원의 수와 커미션을 받는 사원의 수를 각각 카운트 하는 sql문 작성
--SELECT DEPTNO, COUNT(DEPTNO), COUNT(COMM) from emp --- NULL값이 없는 * 쓴다 
SELECT DEPTNO, COUNT(DEPTNO), COUNT(COMM) from emp
group by DEPTNO;
-- 3. 부서별 급여 최대값과 급여 최소값을 구하되,
-- 최대 급여가 3000 이상인 부서만 출력하는 sql문 작성
SELECT DEPTNO, max(SAL), min(SAL)
from EMP
group by DEPTNO
having max(SAL) >= 3000;


--2021.06.25 서브쿼리 연습문제

-- 1. smith와 동일한 직급을 가진 사원의 이름과 직급을 출력하는 sql
Select ENAME, JOB from EMP where JOB = 
(Select JOB from EMP where ENAME =  'SMITH');

-- 2. 부서별로 가장 높은 급여를 받는 사원의 정보(사번, 이름, 급여, 입사일) 출력
Select EMPNO, ENAME, SAL, HIREDATE from EMP where sal in
(Select max(sal) from EMP GROUP by deptno);

--3. 직급이 'salesman'인 사원이 받는 급여중 최소 급여보다 많이 받는 
--사원의 이름, 급여 출력, 부서번호 20번인 사원 제외
Select ENAME, SAL from EMP where DEPTNO != 20 and SAL >
(Select min(SAL) from EMP where JOB = 'SALESMAN');

-- 직급이 'salesman'인 사원이 받는 급여 중 최대 급여보다 급여를 많이 받는 
--사원들의 이름, 급여를 출력하되, 부서번호 20번인 사원 제외
Select ENAME, SAL from EMP where DEPTNO != 20 and SAL >
(Select max(SAL) from EMP where JOB = 'SALESMAN');

-- 사번, 이름, 급여, 호봉 출력(non equi join), and 붙으면
Select EMPNO ,ENAME, SAL, s.GRADE
from EMP e, SALGRADE s
where  e.sal >= s.losal and e.sal <= s.hisal;

--JOIN
--1. 급여가 3000~5000 직원의 이름과 소속 부서명 출력
Select e.ENAME, d.DNAME
from EMP e, DEPT d
where e.deptno  = d.deptno and SAL BETWEEN 3000 and 5000;

--2. 직급이 manager 부서 직원 이름과 입사일 출력
Select ENAME, HIREDATE
from EMP
where lower(JOB) = 'manager';

--3. accounting 부서 직원 이름과 입사일 출력
Select ENAME, HIREDATE
from EMP 
where DEPTNO = 
(Select DEPTNO from DEPT where lower(DNAME) = 'accounting');

--4. 커미션 받는 사원 이름, 부서명 출력
Select e.ENAME, d.DNAME
from EMP e, DEPT d
where e.COMM is not null and e.DEPTNO = d.DEPTNO;

--5. 뉴욕 근무 사원 이름, 급여 출력
Select e.ENAME, e.SAL
from EMP e, DEPT d
where e.DEPTNO = d.DEPTNO and d.loc = 'NEW YORK';

--6. 급여 1200 이하 사원 이름, 급여, 근무지 출력
Select e.ENAME, e.SAL, d.loc
from EMP e, DEPT d
where e.DEPTNO = d.DEPTNO and e.SAL <= 1200;

--7. smith와 같은 근무지 직원 이름 출력
Select worker.ENAME
from EMP smith, EMP worker
where smith.ENAME = upper('smith') and smith.DEPTNO = worker.DEPTNO 
and worker.ENAME != upper('smith');

--8. 매니저 KING인 사원들의 이름, 직급 출력
Select worker.ENAME,  worker.JOB
from EMP worker, EMP mng 
where worker.MGR = mng.EMPNO and mng.ENAME = 'KING';


--2021.06.28 DDL문 연습문제 
-- 1. emp테이블의 사원번호, 이름, 직급, 매니저 칼럼을 복사 후 emp01 생성
create table emp01
as 
select EMPNO, ENAME, JOB, MGR from emp; --일종의 서브쿼리
-- 2. dept01 테이블 생성
-- deptno 숫자2자리, dname 문자열 14자리, loc 문자열 15자리
create table dept01(
deptno NUMBER(2), 
dname varchar2(14), 
loc varchar2(15)
);
-- 3. emp01 테이블에 hiredate 날씨/시간 타입 칼럼 추가
alter table emp01 
add (hiredate date);
-- 4. emp01 테이블에  직급 칼럼 크기 20으로 변경
alter table emp01 
modify (job varchar2(20));
-- 5. emp01 테이블에  매니저 칼럼 삭제
alter table emp01
drop column mgr;
-- 6. emp01 테이블 이름 emp02로 변경
rename emp01 to emp02;
-- 7. emp02, dept01 테이블 삭제
drop table dept01;
drop table emp02;

--DML 연습문제
-- 1. emp01 제거, emp 테이블 복사 이름 emp01
drop table emp01;
create table emp01 as select * from EMP;
-- 2. emp01 데이터 추가, 
-- 7969 smith clerk 7838 80/12/17 800 null 20
-- 7499 allen saleseman 7369 87/12/20 1600 300 30
-- 7839 king president null null 5000 null null
insert into emp01
values(7969, 'smith', 'clerk', 7838, '80/12/17', 800, null, 20);
insert into emp01
values(7499, 'allen', 'saleseman', 7369, '87/12/20', 1600, 300, 30);
insert into emp01
values(7839, 'king', 'president', null, null, 5000, null, null);
-- 3. emp01 급여인상 10% 
update emp01 set SAL = SAL + (SAL * 0.1);
-- 4. emp01 king 입사일 sysdate
update emp01 set HIREDATE = SYSDATE where lower(ENAME) = 'king'; --pk접근해라
-- 5. emp01 85년 이후 입사한 직원 모두 삭제
delete from emp01 where HIREDATE BETWEEN '85/01/01' and Sysdate;
delete from emp01 where substr(HIREDATE, 1,2) >= '85';
-- 6. emp01 커미션 못받는 사람 삭제
select * from emp01;
delete from emp01 where COMM is null;
ROLLBACK;
commit;

-- 2021.06.29 DDL + 제약조건 연습문제 
-- 1. member table 만들기
create table member(
id varchar2(20), --pk always not null
name varchar2(20) constraint dept01_name_nn not null,
regno varchar(13) constraint dept01_regno_nn not null,
hp varchar(13),
address varchar2(100),
CONSTRAINT member_id_pk primary key(id),
CONSTRAINT member_regno_hp_uq UNIQUE(regno, hp)
);

--2. create book table
create table book(
code number(4),
title varchar2(50) CONSTRAINT book_count_nn not null,
count number(6),
price number(10) ,
pulish varchar2(50),
CONSTRAINT book_code_pk primary key(code)
);

drop table book;

create table copyemp
as 
select * from emp;

insert into copyemp
select * from emp;


--view
-- 1. 사원번호, 사원이름, 부서이름, 부서위치 출력 뷰 작성 view_loc
create or replace force view view_loc
as 
select e.EMPNO, e.ENAME, d.DNAME, d.loc
from emp e, DEPT d
where e.deptno = d.deptno;

select * from view_loc;

-- 2. 30번부서 사원이름, 임사일, 부서명 출력 뷰     view_dept30
create or replace force view view_dept30
as 
select e.ENAME, HIREDATE, d.DNAME, d.loc
from emp e, DEPT d
where e.deptno = d.deptno and e.deptno = 30;

-- 3. 부서별 최대 급여 정보를 가지는 뷰       view_dept_maxsal
create or replace force view view_dept_maxsal
as 
select deptno, max(e.sal) as 최대급여
from emp e 
group by DEPTNO ;

select * from view_dept_maxsal;

-- 4. 급여를 많이 받는 순서 3명만 출력   view_sal_top5
create or replace view view_sal_top5
as 
select e.ENAME 
from emp e
order by SAL asc;

select ENAME 
from emp
where rownum <= 3;

-- 붙여서, 별명을 줘야 오류가 안뜬다 rownum에다만 안줘도 된다
-- 오류: ORA-00998: must name this expression with a column alias
create or replace view view_sal_top5
as select rownum 순위, ENAME 이름, sal 급여 from 
--as select rownum , ENAME , sal from 
(select rownum, ENAME, sal from EMP order by SAL asc)
where rownum <= 3;

select * from view_sal_top5;