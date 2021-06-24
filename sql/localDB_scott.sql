-- 2021.06.22 chapter 1. 연습문제
-- 1. 사원 테이블 emp의 모든 정보를 출력하는 sql문
select * from emp;
-- 2. 사원의 이름과 급여, 입사일을 출력하는 sql문
select ENAME, SAL from emp;
-- 3. 사원들이 어떤 부서에 소속되어 있는지, 소속 부서 만을 출력하되, 중복 하지 않고 한번씩 출력하는 sql문
select DISTINCT DEPTNO from emp;
-- 4. 테이블 emp중에서 부서번호가 10번인 사원에 관한 모든 정보를 출력하는 sql문
select * from emp
where deptno = 10;
-- 5. 테이블 emp중에서 급여가 2000미만이 되는 사원의 정보 중에서 사번, 이름, 급여를 출력하는 sql문
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
-- 그 사원의 mgr 컬럼 값이 null이다. 상관이 없는 사원만 출력하되, mgr 컬럼 값 null대신 'CEO'라고 출력해라
SELECT  EMPNO, ENAME, nvl2(MGR, 'has Manager','CEO') FROM EMP
where MGR is NULL;
-- 8. 직급에 따라 급여를 인상하도록 한다. 직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%
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
-- 3. 부서별 급여 최대값과 급여 최소값을 구하되, 최대 급여가 3000 이상인 부서만 출력하는 sql문 작성
SELECT DEPTNO, max(SAL), min(SAL)
from EMP
group by DEPTNO
having max(SAL) >= 3000;
