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
