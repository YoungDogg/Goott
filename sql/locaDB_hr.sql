--dual table = dummy table
select 30 + 20 from dual;

-- lower : 소문자로
select 'Danel' D , lower('Danel') d from dual;

SELECT * from employees;

SELECT *FROM employees WHERE lower(first_name) = 'steven';

--upper
select 'Danel'  , upper('Danel')  from dual;

SELECT *FROM employees WHERE upper(first_name) = 'STEVEN';

--initcap : 첫글자만 대문자
SELECT job_id, initcap(job_id) from employees;

-- concat : 문자열 붙이기
SELECT concat('data','something') from dual;
-- 3개 이상 문자열 붙이기
SELECT 'data' || 'data' || 'data' FROM dual;

--EMPLOYEE, '이름, 성'으로 출력
SELECT first_name || ', ' || last_name FROM employees;

-- length 문자열 길이
SELECT length(concat('h','i')) from dual;
SELECT lengthb(concat('h','i')) from dual;
SELECT length(concat('안녕','하세요')) from dual; -- 한글
SELECT lengthb(concat('안녕','하세요')) from dual; --바이트변환 5글자 * 3바이트

-- substr : 문자열 자르기
SELECT substr('반갑습니다', 0, 3) from dual; --1번부터 3글자
SELECT substr('반갑습니다', 1, 3) from dual; --1번부터 3글자 이거써라

SELECT substr('반갑습니다', -2, 2) from dual; --뒤부터부터 3글자

--employees, 입사연도 05 중에 이름, 입사년도 출력
SELECT first_name|| ', ' || hire_date from employees
where hire_date BETWEEN '05/01/01' and '05/12/31';

SELECT first_name|| ', ' || hire_date from employees
where hire_date like '05%';

SELECT first_name|| ', ' || hire_date from employees
where SUBSTR(hire_date, 1, 2) = '05';

--이름 e로 끝나는 사원의 이름 검색
SELECT first_name from employees
where substr(first_name, -1, 1) = 'e';

--instr : 특정 문자의 위치를 구해주는 함수
--instr('대상문자열', '찾을문자열')
SELECT instr('반갑습니다니습갑반', '니') FROM dual;

--instr('대상문자열', '찾을문자열', 시작위치, 몇번째)
SELECT instr('반갑습니다니습갑반니', '니', 5) FROM dual;

-- lpad, rpad : 특정문자 채우는 함수 lpad(왼족에 채움), rpad(오른쪽에 채움) , 잘 안씀
SELECT lpad('반갑습니다', 3, '친구야') FROM dual;
SELECT lpad('반갑습니다', 30, '친구야') FROM dual;

-- trim 문자 자르기, 앞뒤만 자름
SELECT trim('a' FROM 'aaa피aaa카추aaa') FROM dual;

--replace(문자열, 찾을거, 바꿀거)
SELECT replace('aaa피aaa카추aaa', 'a', '') FROM dual;
SELECT replace('피 카 추',' ', '') from dual;

--전번 . ->  -
SELECT
    REPLACE(phone_number,'.','-') 
FROM employees;

--abs 절댓값
SELECT abs(-100) from dual;

-- floor : 소수 버림
SELECT floor(-100.254354) from dual;

-- round : 특정자리 반올림
SELECT round(100.123456789, 5) from dual;
SELECT round(100.123456789, 4) from dual;
SELECT round(100.123456789, 3) from dual;

SELECT round(100.123456789, -1) from dual;
SELECT round(100.523456789, -1) from dual;
SELECT round(100.623456789, -1) from dual;
SELECT round(105.523456789, -1) from dual;

SELECT round(105.423456789) from dual;
SELECT round(105.523456789) from dual;

--trunc 자른다 
SELECT trunc(987.654, 2) from dual;
SELECT trunc(987.654, 0) from dual;

-- mod : 나머지 값 반환 함수
select mod(981, 2) from dual;

--날짜 
--sysdate : 현재 날짜 시간 얻어온다
select sysdate from dual;

--employees 얼마나 입사한지 며칠 지났는지 이름, 지난날짜 출력
SELECT first_name, floor(sysdate - hire_date) as "근속 일수" from employees;

-- months_between : 두 날짜 사이의 개월 수
--months_between (날짜1,날짜2)
select first_name, trunc(months_between(sysdate, hire_date), 0) as 근속개월 
from employees;

--next_day(날짜, 요일)
select next_day(sysdate, '토요일') from dual;
select next_day(sysdate, 4) from dual; --일요일은 1

-- last_day : 해당 달의 마지막 날짜
SELECT last_day(SYSDATE) FROM dual;

--round 날짜
select hire_date, round(hire_date, 'month') from employees;

-- trunc 날짜
select first_name, hire_date, trunc(hire_date, 'month') from employees;

-- to_char : 데이터 -> 문자열
select first_name, hire_date, 
to_char(hire_date, 'day month year YYYY YY MM MON DD DAY DY') 
from employees;

select first_name, hire_date, 
to_char(hire_date, 'YYYY. MON. DD') || '일'
from employees;

--AM, PM, HH, HH24 MI SS
SELECT TO_char(SYSDATE, 'HH24:MI:SS') FROM dual;
SELECT TO_char(SYSDATE, 'HH24:MI:SS') FROM dual;

--숫자형 -> 문자형
SELECT to_char(12345) FROM dual;

SELECT first_name, salary, 
to_char(salary, '00000000000000000000000000000000000000') 
from employees;

SELECT first_name, salary, 
to_char(salary, '99999999999999') 
from employees;

SELECT first_name, salary, 
to_char(salary, 'L99,999,999,999,999') 
from employees;

--날짜형 to_date
SELECT * FROM employees where hire_date = '03/06/17';
SELECT * FROM employees where hire_date = to_date(20030617);
SELECT * FROM employees where hire_date = to_date(20030617, 'YYYYMMDD');

--문자 -> 숫자
select to_number('1,000', '99,999') + to_number('1,000', '99,999')from dual;

--nvl 함수 : NULL을 다른 숫자로 변환하는 함수
-- nvl(NULL이 될 값, 변환할 값)
SELECT
    FIRST_NAME, COMMISSION_PCT, nvl(COMMISSION_PCT, 0)  --0 같은 숫자만 옴
FROM employees;

--nvl2 함수 : NULL을 문자열로 변환하는 함수 
--0 같은 숫자만 옴
SELECT
    FIRST_NAME, COMMISSION_PCT, nvl2(COMMISSION_PCT, '널 아님', '널 맞음')  
FROM employees;

-- decode 
SELECt  department_id, DECODE(department_id, 10, 'Administration',
                                             20, 'Marketing',
                                             30, 'Purchasing',
                                             'IT Support')
FROM employees;                                            

--case 함수 (if ~ else if와 비슷)
SELECt  department_id, case when department_id=10 then 'Administration'
                            when department_id=20 then 'Marketing'
                            else 'Treasury'
                            end
                            from employees;
                            

------------------------------------------------------
--그룹함수 행 갯수 상관없이 결과 하나     NULL 제외

SELECT to_char(sum(salary), 'L9,999,999') as "sum" from employees;

SELECT to_char(avg(salary), 'L9,999,999.99') as "avg" from employees;

SELECT to_char(max(salary), 'L9,999,999.99') as "max" from employees;

SELECT to_char(min(salary), 'L9,999,999.99') as "min" from employees;

SELECT to_char(COUNT(*), '9,999,999') as "min" from employees; --데이터 개수 셀 때
--데이터 개수 셀 때 Primary Key: no null
SELECT to_char(COUNT(EMPLOYEE_ID), '9,999,999') as "min" from employees; 

-- stddev : 표준편차
SELECT STDDEV(salary) FROM employees;

-- variance : 분산값
SELECT variance(salary) FROM employees;

--group by
SELECT department_id FROM employees GROUP BY department_id;
SELECT JOB_ID FROM employees GROUP BY JOB_ID;

SELECT department_id, to_char(sum(salary), '9,999,999') "sum", 
to_char(avg(salary), '9,999,999') "avg"
FROM employees 
GROUP BY department_id;

SELECT department_id, to_char(max(salary), '9,999,999') "max", 
to_char(min(salary), '9,999,999') "min"
FROM employees 
GROUP BY department_id;

--having 그룹 행에 제한
-- 부서별 평균급여가 5000이상인 부서의 번호, 평균 급여를 출력
SELECT department_id, avg(salary)
from employees
GROUP BY department_id
having  avg(salary) >= 10000;

----sub query
SELECT department_id FROM employees where employee_id = 100;

SELECT department_name FROM departments WHERE department_id = 90;

SELECT department_name FROM departments WHERE department_id = 
(SELECT department_id FROM employees where employee_id = 100);

--90번 부서의 우편번호 출력
SELECT POSTAL_CODE FROM LOCATIONS WHERE LOCATION_ID = 
(SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID = 90 );

--100번 사원의 우편번호, 도로명주소, 시, 도, 나라 출력
SELECT POSTAL_CODE, STREET_ADDRESS, CITY, STATE_PROVINCE, COUNTRY_ID 
FROM LOCATIONS WHERE LOCATION_ID = 
( SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID = 100);

-- 204번 사원이 근무하느 대륙
--- 1) 204번 사원의 근무 부서 번호
SELECT DEPARTMENT_ID from employees where  employee_id = 204;
--- 2) 70번 부서의 location_id?
SELECT location_id from departments where DEPARTMENT_ID = 70;
--- 3) location_id 2700번 컨트리 아이디?
SELECT COUNTRY_ID from LOCATIONS where LOCATION_ID = 2700;
-- 4) 컨트리 테이블에서 컨트라 아이디가 'DE'인 region_id?
SELECT REGION_ID from COUNTRIES where COUNTRY_ID = 'DE';
-- 5) 리전 테이블에서 리전 아이디가 1번인 리전 이름?
select  REGION_NAME from REGIONS where REGION_ID = 1;

select  REGION_NAME from REGIONS where REGION_ID = 
(SELECT REGION_ID from COUNTRIES where COUNTRY_ID =
(SELECT COUNTRY_ID from LOCATIONS where LOCATION_ID = 
(SELECT location_id from departments where DEPARTMENT_ID = 
(SELECT DEPARTMENT_ID from employees where  employee_id = 204))));

-- 단위 행 서브쿼리 : 내부 쿼리의 결과가 1개의 row가 되는 쿼리
-- > >= < <= = != 이것만 사용 가능
--사원들의 평균 급여보다 급여를 더 많이 받는 사원을 검색
select employee_id, FIRST_NAME, salary from employees
where salary >
(select avg(salary) from employees);

---다중행 서브쿼리 : 괄호 두 개 이상일 떄
-- in : or
-- any : or, 연산자 사용
-- all : and

--5000이상 받는 사원의 부서, 그 부서 사람들의 사번, 이름, 급여 출력
SELECT employee_id, FIRST_name, salary from employees where department_id in
(select DISTINCT department_id  from employees where salary >= 5000);

-- 30번 부서 사원 중 가장 많이 받는 사람보다 더 많이 받는 사람의 사번, 이름, 급여, 
-- 부서번호 출력
select EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID 
from employees where salary > all 
(select salary from employees where department_id = 30);

-- 50번 부서 사원 중 가장 적게 받는 사람보다 많은 급여 받는 사람의 사번, 이름, 급여 출력
select EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID 
from employees where salary > any
(select salary from employees where department_id = 50);

-- 101번 사원이 언제부터 언제까지 어떤 직무를 수행했는지 출력
--select FIRST_NAME, HIRE_DATE, JOB_ID 
--from employees 
--where sysdate -  HIRE_DATE > any 
select START_DATE, END_DATE, job_id from JOB_HISTORY where EMPLOYEE_ID = 101;