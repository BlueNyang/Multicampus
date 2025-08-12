-- SEQUENCE
-- generate a unique value serial number with Oracle database objects
-- Increase or decrease to a specified value
-- Useful when using auto-increase values for primary key columns
-- Up to 15 can be specified
-- Create storage independently of the table
-- One sequence can be used across multiple tables
-- Create a sequence
ALTER SEQUENCE no_seq RESTART START WITH 1;

CREATE SEQUENCE no_seq START WITH 1 INCREMENT BY 1 MAXVALUE 10000 MINVALUE 1 NOCYCLE;

-- create table to apply the sequence
-- DROP TABLE board;
CREATE TABLE board (
   b_no      NUMBER PRIMARY KEY,
   b_subject VARCHAR2(30) NOT NULL,
   b_name    VARCHAR2(20) NOT NULL
);

-- INSERT DATA
INSERT INTO board VALUES ( no_seq.NEXTVAL,
                           '추석',
                           '홍길동' );

INSERT INTO board VALUES ( no_seq.NEXTVAL,
                           '미세먼지',
                           '홍길동' );

INSERT INTO board VALUES ( no_seq.NEXTVAL,
                           '휴가',
                           '홍길동' );

COMMIT;

-- 조회
SELECT *
  FROM board;

-- 현재 시퀀스 값 확인
SELECT no_seq.CURRVAL
  FROM dual;

-- sequence 수정
ALTER SEQUENCE no_seq MAXVALUE 1000;

-- 수정 결과 검색: 구조에 대한 검색, sequence 정보 저장 table - USER_SEQUENCES
SELECT max_value,
       min_value
  FROM user_sequences
 WHERE sequence_name = 'NO_SEQ';

-- DUAL table
-- table provided by Oracle DB
-- dummy table with one row and one column
-- SYS owned, but available to all user.
-- When checking simple function result values, can check the result value (get a return) with out create a table
SELECT current_date
  FROM dual;