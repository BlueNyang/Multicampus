-- 테이블 DROP: TABLE의 모든 Schema와 data가 삭제됨
-- (Data만 삭제: Table의 Schema는 유지됨 - DML: DELETE FROM table_name;)
-- DROP TABLE table_name [PURGE|CASCADE CONSTRAINTS];
-- PURGE: 복구가능한 Temp table을 생성하지 않고 바로 삭제
-- CASCADE CONSTRAINTS: referenced 되는 모든 constraints를 삭제함
DROP TABLE department;

-- 안됨: department table이 student, professor table에 referenced되고 있음
-- reference와 상관없이 무조건 table drop
DROP TABLE department CASCADE CONSTRAINTS;