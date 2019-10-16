select * from v$session;

select * from v$sql;

-- �̸� �տ� �������־����
-- tbl_ ���̺�
-- idx_ �ε���
-- seq_ ������
create table tbl_board (
    bno number,
    title varchar2(300) not null,   -- �ε����� null�� ������ ����ϴϱ� not null ���ִ°�
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
'����' || seq_board.currval,
'����' || seq_board.currval,
'user00')
;

select * from tbl_board;

-- ��ͺ���
insert into tbl_board (bno, title, content, writer)
(SELECT
    seq_board.nextval, title, content, writer
from tbl_board)
;

select count(*) from tbl_board;

-- ��� �ϸ� �ε����� �� Ż��?
-- => �ε����� ������ �ɾ�� (�ϳ��ϳ� �ҷ��� ������ ��Ŵ)

-- 5.301 ��
-- �����ȹ : full �� �а� sort��
select bno, title, content
from tbl_board
order by bno+1 desc
;

-- 0.004 ��
-- �����ȹ : ���̺� �ٷ� �＼���Ѱ� �ƴ� index�� �ٷ� �＼��, full scan descending
select bno, title, content
from tbl_board
order by bno desc
;

--order by �� ��Ʈ�� �����غ���
select
/*+ INDEX_DESC (tbl_board pk_board) */  --���̺� �̸�, �ε����̸�
bno, title, content
from tbl_board
--where bno > 0   -- full scan �ȶ߰� �� -> range scan���� ��
;

-- 20�� ����
select
/*+ INDEX_DESC (tbl_board pk_board) */  --���̺� �̸�, �ε����̸�
rownum rn, bno, title, content
from tbl_board
where rownum <= 20
;

-- �ƹ� ��� �ȳ���
-- rownum > 10 ���Ͷ� ������ ���� ���� �ȳ����°���
-- �ε����� Ÿ�� ���̺��� �����͸� �������� �ϴ� rownum �� 1�� ����
-- �׷��� ó�� ������ rownum > 10 �̹Ƿ� ���ǿ� �����ʾƼ� �����
-- �� �ε����� Ÿ�� ������ �������� rownum �� 1�̵�, ����� => �ݺ��Ǵϱ� ����� �����°� ����
select
/*+ INDEX_DESC (tbl_board pk_board) */  --���̺� �̸�, �ε����̸�
rownum rn, bno, title, content
from tbl_board
where rownum > 10 and rownum <= 20
;

-- 11���� 20���� �������� ������ ���?
select
/*+ INDEX_DESC (tbl_board pk_board) */  --���̺� �̸�, �ε����̸�
rownum rn, bno, title, content
from tbl_board
where rownum > 10 and rownum <= 20
;

select
/*+ INDEX_DESC (tbl_board pk_board) */  --���̺� �̸�, �ε����̸�
rownum rn, bno, title, content
from tbl_board
where rownum <= 20
;

-- ����Ŭ ����¡
-- �ؿ������� ��ü �� �����ϱ� ������
-- ���� ��� �Խ��� ���� ��� ������ �������� ���� ��ư ���� ��� ���� (������ ��ư ������ ��� �� �о���ϴϱ� ��������)
-- ��, �����̳� ������ȸ ���� ��� �ֱ� 1~6���� �����͸� �� �� �ֵ��� ������ ��
select
*
from
 (  select
    /*+ INDEX_DESC (tbl_board pk_board) */  --���̺� �̸�, �ε����̸�
    rownum rn, bno, title, content
    from tbl_board
    where rownum <= 20
 )
where rn > 10
;

-- rownum ���̸� count �� (�����Ͱ� �����鼭 ���� counting)
select
bno, title, content
from tbl_board
;