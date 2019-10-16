-- 부서별 최저 연봉받는 사람?
-- 부서id, 부서명, 직원이름, 연봉
select
a.id, a.name, e_salary
from
 (
    select id, name,
    (
        select min(salary) ms
        from s_emp e
        group by dept_id
        having d.id = e.dept_id
    ) e_salary
    from s_dept d
 ) a
, s_emp
where a.id = s_emp.dept_id
and e_salary = s_emp.salary
;
