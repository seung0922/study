-- 아래의 문장 변경하여 최근 12개월의 날짜를
-- 'YYYYMM'의 형태로 출력
--select level-5 from dual
--connect by level <=11;


-- 1. 201504~ 201603 테이블 만들기
create view vw1 as
select to_char(add_months('16/03/01', level-12), 'yyyymm') yyyymm
from dual
connect by level <= 12
;

-- 2. s_emp테이블에서 입사월, 입사자수 구하기 ('yyyymm' 형태로)
create view vw2 as
select to_char(start_date, 'yyyymm') as yyyymm, count(*) cnt
from s_emp
group by to_char(start_date, 'yyyymm')
;

-- 3. 위 두개 테이블 조인
select vw1.yyyymm "입사월", decode(vw2.cnt, null, 0, vw2.cnt) "입사자의수"
from vw1, vw2
where vw1.yyyymm = vw2.yyyymm(+)
order by 1
;
