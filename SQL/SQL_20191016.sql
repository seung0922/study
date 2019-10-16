select * from v$session;

select * from v$sql;

-- 이름 앞에 구분해주어야함
-- tbl_ 테이블
-- idx_ 인덱스
-- seq_ 시퀀스
create table tbl_board (
    bno number,
    title varchar2(300) not null,   -- 인덱스에 null이 있으면 곤란하니까 not null 해주는것
    content varchar2(500) not null,
    writer varchar2(100) not null,
    regdate date default sysdate,
    updatedate date default sysdate
);

alter table tbl_board add constraint
pk_board primary key (bno)
;

create sequence seq_board;

insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval,
'제목' || seq_board.currval,
'내용' || seq_board.currval,
'user00')
;

select * from tbl_board;

-- 재귀복사
insert into tbl_board (bno, title, content, writer)
(SELECT
    seq_board.nextval, title, content, writer
from tbl_board)
;

select count(*) from tbl_board;

-- 어떻게 하면 인덱스를 못 탈까?
-- => 인덱스에 연산을 걸어보자 (하나하나 불러서 연산을 시킴)

-- 5.301 초
-- 실행계획 : full 로 읽고 sort함
select bno, title, content
from tbl_board
order by bno+1 desc
;

-- 0.004 초
-- 실행계획 : 테이블 바로 억세스한게 아님 index로 바로 억세스, full scan descending
select bno, title, content
from tbl_board
order by bno desc
;

--order by 를 힌트로 유도해보자
select
/*+ INDEX_DESC (tbl_board pk_board) */  --테이블 이름, 인덱스이름
bno, title, content
from tbl_board
--where bno > 0   -- full scan 안뜨게 함 -> range scan으로 뜸
;

-- 20건 나옴
select
/*+ INDEX_DESC (tbl_board pk_board) */  --테이블 이름, 인덱스이름
rownum rn, bno, title, content
from tbl_board
where rownum <= 20
;

-- 아무 결과 안나옴
-- rownum > 10 필터랑 조건이 먼저 들어가서 안나오는거임
-- 인덱스를 타서 테이블에서 데이터를 가져오면 일단 rownum 이 1로 들어옴
-- 그런데 처음 조건이 rownum > 10 이므로 조건에 맞지않아서 사라짐
-- 또 인덱스를 타서 데이터 가져오면 rownum 또 1이됨, 사라짐 => 반복되니까 결과가 나오는게 없음
select
/*+ INDEX_DESC (tbl_board pk_board) */  --테이블 이름, 인덱스이름
rownum rn, bno, title, content
from tbl_board
where rownum > 10 and rownum <= 20
;

-- 11부터 20까지 가져오고 싶으면 어떻게?
select
/*+ INDEX_DESC (tbl_board pk_board) */  --테이블 이름, 인덱스이름
rownum rn, bno, title, content
from tbl_board
where rownum > 10 and rownum <= 20
;

select
/*+ INDEX_DESC (tbl_board pk_board) */  --테이블 이름, 인덱스이름
rownum rn, bno, title, content
from tbl_board
where rownum <= 20
;

-- 오라클 페이징
-- 밑에서부터 전체 다 훑으니까 느려짐
-- 예를 들어 게시판 같은 경우 마지막 페이지로 가기 버튼 없는 경우 많음 (마지막 버튼 누르면 모두 다 읽어야하니까 좋지않음)
-- 또, 은행이나 구매조회 같은 경우 최근 1~6개월 데이터만 볼 수 있도록 제한을 검
select
*
from
 (  select
    /*+ INDEX_DESC (tbl_board pk_board) */  --테이블 이름, 인덱스이름
    rownum rn, bno, title, content
    from tbl_board
    where rownum <= 20
 )
where rn > 10
;

-- rownum 붙이면 count 들어감 (데이터가 나오면서 들어가는 counting)
select
bno, title, content
from tbl_board
;