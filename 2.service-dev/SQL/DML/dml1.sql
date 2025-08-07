-- DML: Data Manipulation Language
-- 데이터 조작 언어: 데이터베이스의 데이터를 조회, 삽입, 수정, 삭제하는 데 사용됨
-- SELECT, INSERT, UPDATE, DELETE 문이 포함됨

-- INSERT: table에 data(tuple)을 추가하는 명령어
-- INSERT INTO table_name (column_list) VALUES (value_list);
--    부분 열만 추가할 수 있음 - NULL 값을 허용하는 column은 생략 가능
-- INSERT INTO table_name VALUES (value_list); - 모든 column에 값을 추가할 때 사용
--    TABLE에 정의된 순서대로 값을 입력해야 함

-- STUDENT table에 data 삽입
INSERT INTO STUDENT (stdNo, stdName, stdYear, deptNo)
VALUES ('S001', 'Alice', 2, '001');
-- 값 string은 small quotes로 wrapping

--  출판사 테이블 생성(앞에서 삭제함)
CREATE TABLE publisher (
    pubNo VARCHAR(10) NOT NULL PRIMARY KEY,
    pubName VARCHAR(30) NOT NULL
);

-- INSERT 문
-- publisher 테이블에 데이터 입력
INSERT INTO publisher (pubNo, pubName)
SELECT '1', '서울 출판사' FROM dual UNION ALL
SELECT '2', '강남 출판사' FROM dual UNION ALL
SELECT '3', '종로 출판사' FROM dual;

-- publisher 테이블 내용 조회
SELECT * FROM publisher;
-- * : ALL : 모든 열 (pubNo, pubName)