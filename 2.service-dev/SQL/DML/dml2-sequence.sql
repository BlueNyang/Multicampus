-- SEQUENCE
-- generate a unique value serial number with Oracle database objects
-- Increase or decrease to a specified value
-- Useful when using auto-increase values for primary key columns
-- Up to 15 can be specified
-- Create storage independently of the table
-- One sequence can be used across multiple tables

-- Create a sequence
ALTER SEQUENCE NO_SEQ RESTART START WITH 1;
CREATE SEQUENCE NO_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;

-- create table to apply the sequence
-- DROP TABLE board;
CREATE TABLE  board(
    bNo NUMBER PRIMARY KEY,
    bSubject VARCHAR2(30) NOT NULL,
    bname   VARCHAR2(20) NOT NULL
);

-- INSERT data
INSERT INTO board VALUES (NO_SEQ.NEXTVAL, '추석', '홍길동');
INSERT INTO board VALUES (NO_SEQ.NEXTVAL, '미세먼지', '홍길동');
INSERT INTO board VALUES (NO_SEQ.NEXTVAL, '휴가', '홍길동');
COMMIT;

-- 조회
SELECT * FROM board;

-- 현재 시퀀스 값 확인
SELECT NO_SEQ.CURRVAL FROM dual;

-- sequence 수정
ALTER SEQUENCE NO_SEQ MAXVALUE 1000;

-- 수정 결과 검색: 구조에 대한 검색, sequence 정보 저장 table - USER_SEQUENCES
SELECT MAX_VALUE, MIN_VALUE FROM USER_SEQUENCES 
WHERE SEQUENCE_NAME = 'NO_SEQ';

-- DUAL table
-- table provided by Oracle DB
-- dummy table with one row and one column
-- SYS owned, but available to all user.
-- When checking simple function result values, can check the result value (get a return) with out create a table
SELECT CURRENT_DATE FROM dual;