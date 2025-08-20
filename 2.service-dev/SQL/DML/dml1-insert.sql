-- DML: Data Manipulation Language
-- 데이터 조작 언어: 데이터베이스의 데이터를 조회, 삽입, 수정, 삭제하는 데 사용됨
-- SELECT, INSERT, UPDATE, DELETE 문이 포함됨
-- INSERT: table에 data(tuple)을 추가하는 명령어
-- INSERT INTO table_name (column_list) VALUES (value_list);
--    부분 열만 추가할 수 있음 - NULL 값을 허용하는 column은 생략 가능
-- INSERT INTO table_name VALUES (value_list); - 모든 column에 값을 추가할 때 사용
--    TABLE에 정의된 순서대로 값을 입력해야 함
-- STUDENT table에 data 삽입
INSERT INTO student (
   s_no,
   s_name,
   s_year,
   dept_no
) VALUES ( 'S004',
           'Alice',
           2,
           '001' );

-- 값 string은 small quotes로 wrapping
-- 반드시 column 순서에 맞춰야 함
INSERT INTO student VALUES ( 'S005',
                             'Alice',
                             '002',
                             2 );

-- BOOK table에 data 삽입 전 publisher 추가
INSERT INTO publisher (
   pub_no,
   pub_name
) VALUES ( 'P001',
           'Tech Books' );

-- BOOK table에 data 삽입
INSERT INTO book VALUES ( 'B001',
                          'SQL Basics',
                          23000,
                          TO_DATE('2019-01-01','YYYY-MM-DD'),
                          'P001' );

-- Book table 데이터 조회
SELECT *
  FROM book;

-- SELECT EX
SELECT book_name
  FROM book
 WHERE book_no = 'B001';

-- 여러 개의 DATA를 저장: INSERT INTO ALL INTO table_name (cols) VALUES (values) INTO ... 
INSERT ALL INTO book VALUES ( 'B002',
                              'Database',
                              35000,
                              TO_DATE('2021-05-12','YYYY-MM-DD'),
                              'P001' ) INTO book VALUES ( 'B003',
                                                          'Algorithms',
                                                          35000,
                                                          TO_DATE('2020-05-12','YYYY-MM-DD'),
                                                          'P001' ) SELECT *
           FROM dual;

-- 같은 table에 여러 data를 저장: INSERT INTO table_name (cols) SELECT (cols) FROM dual UNION ALL SELECT ...;
INSERT INTO book
   SELECT 'B004',
          'Database',
          35000,
          TO_DATE('2021-05-12','YYYY-MM-DD'),
          'P001'
     FROM dual
   UNION ALL
   SELECT 'B005',
          'Algorithms',
          35000,
          TO_DATE('2020-05-12','YYYY-MM-DD'),
          'P001'
     FROM dual;