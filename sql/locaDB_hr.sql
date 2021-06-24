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
SELECT
    FIRST_NAME, COMMISSION_PCT, nvl2(COMMISSION_PCT, '널 아님', '널 맞음')  --0 같은 숫자만 옴
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
                            
-- 2021년 6월 23일 chapter2. 연습 문제

-- 1. 사번이 짝수인 사원들의 사번, 이름, 직급을 출력
SELECt EMPLOYEE_ID, FIRST_NAME, JOB_ID from employees
where substr(EMPLOYEE_ID, -1, 1)in(0, 2, 4, 6, 8);

-- 2. 'Smith'란 이름을 가진 사원의 사번, 이름, 급여, 커미션을 출력
-- 2-1. initcap 사용
-- 2-2. upper 사용
SELECt EMPLOYEE_ID, FIRST_NAME, SALARY, COMMISSION_PCT  from employees
where  (FIRST_NAME ) = 'Smith';
-- 3. 이름의 두번째 자리에 A가 있는 사원의 사번, 이름, 직급 출력
-- 3-1. substr 사용
-- 3-2. instr 사용

-- 4. 이름이 K로 끝나는 직원의 사번, 이름, 직급 출력

-- 5. 82년도에 입사한 사원의 사번, 이름, 입사일 출력

-- 6. 이름이 6글자 이상인 사원의 사번, 이름, 급여 출력

-- 7. 모든 사원은 자신의 상관이 있다. 하지만 emp 테이블에 상관이 없는 사원이 있는데, 
-- 그 사원의 mgr 컬럼 값이 null이다. 상관이 없는 사원만 출력하되, mgr 컬럼 값 null대신 'CEO'라고 출력해라

-- 8. 직급에 따라 급여를 인상하도록 한다. 직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%
--  'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20% 인상하여 출력한다
