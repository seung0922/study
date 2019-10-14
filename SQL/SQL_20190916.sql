-- 1. 직원 테이블의 모든 행을 삭제
--TRUNCATE TABLE S_EMP;
DELETE FROM S_EMP;

-- 2. 직원 테이블에 존재하는 모든 직급을 중복없이 출력
SELECT DISTINCT TITLE
FROM S_EMP
ORDER BY 1
;

-- 3. 직원 테이블을 부서별 내림차순, 연봉 오름차순으로 정렬
SELECT *
FROM S_EMP
ORDER BY DEPT_ID DESC, SALARY
;

-- 4. 직원 테이블에서 2016년도 이전에 입사한 직원의 수를 출력하시오.
SELECT COUNT(*)
FROM S_EMP
--WHERE START_DATE < '2016/01/01'
WHERE START_DATE < TO_DATE('2016/01/01', 'YY/MM/DD')
;

-- 5. 연봉이 1000이상 5000이하인 직원을 모두 출력하시오.
SELECT *
FROM S_EMP
WHERE SALARY BETWEEN 1000 AND 5000
;

-- 6. 각 부서별 평균 급여를 계산해서 보여주시오.
SELECT DEPT_ID, AVG(SALARY)
FROM S_EMP
GROUP BY DEPT_ID
;

-- 7. 각 부서별로 직책이 사원인 직원들의 평균 급여를 계산해서 보여주시오.
SELECT DEPT_ID, AVG(SALARY)
FROM S_EMP
WHERE TITLE = '사원'
GROUP BY DEPT_ID
;

-- 8. 각 지역별로 몇 개의 부서가 있는지를 나타내시오.
SELECT REGION_ID, COUNT(*)
FROM S_DEPT E, S_REGION R
WHERE E.REGION_ID = R.ID
GROUP BY E.REGION_ID
ORDER BY 1
;

-- 9. 각 부서별로 평균 급여를 구하되 평균 급여가 2000이상인 부서만 나타내시오.
SELECT DEPT_ID, AVG(SALARY)
FROM S_EMP
GROUP BY DEPT_ID
HAVING AVG(SALARY) >= 2000
;

-- 10. 각 직책별로 급여의 총합을 구하되 직책이 부장인 사람은 제외하시오.
-- 단, 급여총합이 8000이상인 직책만 나타내며, 급여 총합에 대한 오름차순 정렬
SELECT TITLE, SUM(SALARY)
FROM S_EMP
GROUP BY TITLE
HAVING SUM(SALARY) >= 8000
ORDER BY 2
;

-- 11. 각 부서별로 직책이 사원인 직원들에 대해서만 평균 급여를 구하시오. (사원 10명)
SELECT DEPT_ID, AVG(SALARY)
FROM S_EMP
WHERE TITLE = '사원'
GROUP BY DEPT_ID
ORDER BY 1
;

-- 12. 각 부서내에서 각 직책별로 몇 명의 인원이 있는지 나타내시오.
SELECT DEPT_ID, TITLE, COUNT(*)
FROM S_EMP
GROUP BY DEPT_ID, TITLE
ORDER BY 1, 2
;

-- 13. 각 부서내에서 몇 명의 직원이 근무하는지를 나타내시오.
SELECT DEPT_ID, COUNT(*)
FROM S_EMP
GROUP BY DEPT_ID
ORDER BY 1
;

-- 14. 각 부서별로 급여의 최소값과 최대값을 나타내시오.
-- 단, 최소값과 최대값이 같은 부서는 출력하지 마시오.
SELECT DEPT_ID, MIN(SALARY), MAX(SALARY)
FROM S_EMP
GROUP BY DEPT_ID
HAVING MIN(SALARY) <> MAX(SALARY)
ORDER BY 1
;

-- 15. 직원 테이블과 부서 테이블을 JOIN하여, 사원의 이름과 부서, 부서명을 나타내시오.
SELECT E.NAME, E.DEPT_ID, D.NAME
FROM S_EMP E, S_DEPT D
WHERE E.DEPT_ID = D.ID
;

-- 16. 서울 지역에 근무하는 사원에 대해 각 사원의 이름과 근무하는 부서명을 나타내시오.
SELECT E.NAME, D.NAME
FROM S_EMP E, S_DEPT D, S_REGION R
WHERE E.DEPT_ID = D.ID
AND D.REGION_ID = R.ID
AND REGION_ID = 1
;

-- 17. 직원 테이블과 급여 테이블을 JOIN하여 사원의 이름과 급여, 그리고 해당 급여등급을 나타내시오.
-- 21개 데이터 나와야함
SELECT E.NAME, E.SALARY, S.GRADE
FROM S_EMP E, SALGRADE S
WHERE E.SALARY BETWEEN S.LOSAL AND S.HISAL
ORDER BY 2 DESC
;

-- 18. 직원 테이블과 고객 테이블에서 사원의 이름과 사번, 그리고 각 사원의 담당고객 이름을 나타내시오.
-- 단, 고객에 대하여 담당영업사원이 없더라도 모든 고객의 이름을 나타내고, 사번 순으로 오름차순 정렬
SELECT E.NAME, E.ID, C.NAME
FROM S_EMP E, S_CUSTOMER C
WHERE E.ID(+) = C.SALES_REP_ID
ORDER BY E.ID
;

-- 19. 직원 중에 '김정미'와 같은 직책(TITLE)을 가지는 사원의 이름과 직책, 급여, 부서번호를 나타내시오.
-- (SELF JOIN 사용)
SELECT E2.NAME, E2.SALARY, E2.DEPT_ID
FROM S_EMP E1, S_EMP E2
WHERE E1.NAME = '정미'
AND E1.TITLE = E2.TITLE
AND E1.NAME <> E2.NAME
;

-- 20. 가장 적은 평균급여를 받는 직책에 대해 그 직책과 평균급여를 나타내시오.
SELECT TITLE, AVG(SALARY)
FROM S_EMP
GROUP BY TITLE
HAVING AVG(SALARY) = (  SELECT MIN(AVG(SALARY))
                        FROM S_EMP
                        GROUP BY TITLE)
;

-- 21. S_EMP 테이블에서 각 사원의 이름과 급여, 급여등급 나타내시오.
-- (급여가 4000이상 A등급, 3000이상 B등급, 2000이상 C등급, 1000이상 D등급, 그 이하 E등급)
-- 이상을 어떻게 표현???? 그렇다면 5000은 어떻게 A에 포함시키나?
SELECT NAME, SALARY, DECODE(TRUNC(SALARY/1000), 3, 'B', 2, 'C', 1, 'D', 0, 'E', 'A')
FROM S_EMP;

-- 22. 자신의 급여가 자신이 속한 부서의 평균 급여보다 적은 직원에 대해 이름, 급여, 부서 번호 출력
SELECT NAME, SALARY, DEPT_ID
FROM S_EMP OUTER
WHERE SALARY < (SELECT AVG(SALARY)
                FROM S_EMP
                WHERE DEPT_ID = OUTER.DEPT_ID)
ORDER BY 3
;

-- 23. 본인의 급여가 각 부서별 평균 급여 중 어느 한 부서의 평균급여보다 적은 급여를 받는 직원에 대해
-- 이름, 급여, 부서번호 출력 (ANY사용)
SELECT NAME, SALARY, DEPT_ID
FROM S_EMP
WHERE SALARY < ANY( SELECT AVG(SALARY)
                    FROM S_EMP
                    GROUP BY DEPT_ID)
ORDER BY 3
;

-- 24. 본인이 다른 사람의 관리자(MANAGER_ID)로 되어 있는 직원의 사번, 이름, 직책, 부서번호를 나타내시오.
-- (EXISTS 사용)
SELECT ID, NAME, TITLE, DEPT_ID
FROM S_EMP OUTER
WHERE EXISTS(   SELECT *
                FROM S_EMP
                WHERE OUTER.ID = MANAGER_ID)
;

SELECT E.ID FROM S_EMP E
WHERE EXISTS (SELECT COUNT(*) FROM S_EMP
WHERE MANAGER_ID = E.ID)
;

-- 25. 직원 테이블에서 이름을 사전순으로 정렬하여 5개의 데이터만 나타내시오.
SELECT NAME, ROWNUM
FROM (SELECT *
FROM S_EMP
ORDER BY NAME)
WHERE ROWNUM <= 5
;


---------------------------------------------------------------------


-- 1. 각 부서별 평균 급여 구하되 평균 급여 2000이상인 부서만
SELECT DEPT_ID, AVG(SALARY)
FROM S_EMP
GROUP BY DEPT_ID
HAVING AVG(SALARY) >= 2000
;

-- 2. 각 직책별로 급여의 총합을 구하되 직책이 사원인 사람 제외
-- 단, 급여총합 3000이상인 직책만, 급여 총합에 대한 내림차순 정렬
SELECT TITLE, SUM(SALARY)
FROM S_EMP
WHERE TITLE <> '사원'
GROUP BY TITLE
HAVING SUM(SALARY) >= 3000
ORDER BY SUM(SALARY) DESC
;

-- 3. 직급이 부장인 사람이 2명 이하인 부서가 몇개인지 나타내라
SELECT COUNT(*) 
FROM (SELECT COUNT(*)
FROM S_EMP
WHERE TITLE LIKE '%부장'
GROUP BY DEPT_ID
HAVING COUNT(*) <= 2)
;

-- 4. 담당직원이 배정되지 않은 고객을 모두 나타내라
SELECT C.NAME
FROM S_EMP E, S_CUSTOMER C
WHERE E.ID(+) = C.SALES_REP_ID
AND E.ID IS NULL
;

-- 8. 전체 임직원 중에서 연봉이 제일 높은 사람 3명의 이름과 연봉을 출력
SELECT NAME, SALARY
FROM (SELECT *
FROM S_EMP
ORDER BY SALARY DESC)
WHERE ROWNUM <= 3
;

-- 10. NOT EXISTS를 사용해서 효율적으로 작성
--SELECT ID, NAME, TITLE
--FROM S_EMP E
--WHERE E.TITLE <> '사원';
SELECT ID, NAME, TITLE
FROM S_EMP OUTER
WHERE NOT EXISTS(   SELECT 'X'   -- 상관쿼리!
                    FROM S_EMP
                    WHERE OUTER.TITLE = '사원')
ORDER BY 1
;
