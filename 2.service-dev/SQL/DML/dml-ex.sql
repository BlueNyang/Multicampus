-- ----------------- Ex01 ----------------- --
-- ----------------- TABLE 생성 쿼리 ----------------- --
-- ex에 맞춰 department와 student table 생성
-- declaration of department table
CREATE TABLE department (
   dept_no   VARCHAR2(4),
   dept_name VARCHAR2(50),
    -- primary key constraint
   CONSTRAINT pk_dept_dept_no PRIMARY KEY ( dept_no ),
    -- not null constraints
   CONSTRAINT chk_dept_dept_no CHECK ( dept_no IS NOT NULL ),
   CONSTRAINT chk_dept_dept_name CHECK ( dept_name IS NOT NULL )
);

-- declaration of student table
CREATE TABLE student (
   std_no       VARCHAR2(10) PRIMARY KEY,
   std_name     VARCHAR2(50) NOT NULL,
   std_year     NUMBER(1),
   std_birthday DATE,
   dept_no      VARCHAR2(10),
   CONSTRAINT fk_student_dept_no FOREIGN KEY ( dept_no )
      REFERENCES department ( dept_no ),
   CONSTRAINT chk_student_year CHECK ( std_year BETWEEN 1 AND 4 )
);

-- insert sample data into department
INSERT INTO department (
   dept_no,
   dept_name
)
   SELECT *
     FROM (
      SELECT 'D001',
             'Computer Science'
        FROM dual
      UNION ALL
      SELECT 'D002',
             'Electrical Engineering'
        FROM dual
      UNION ALL
      SELECT 'D003',
             'Mechanical Engineering'
        FROM dual
   );

-- 변경 사항 반영
COMMIT;

-- ----------------- 예제 풀이 쿼리 ----------------- --
-- INSERT EX1
-- 여러 개의 data를 dual(더미테이블)을 사용하여 삽입
INSERT INTO student
   SELECT '2016001',
          '홍길동',
          4,
          TO_DATE('1997-01-01','YYYY-MM-DD'),
          'D001'
     FROM dual
   UNION ALL
   SELECT '2015002',
          '성춘향',
          3,
          TO_DATE('1996-12-10','YYYY-MM-DD'),
          'D003'
     FROM dual
   UNION ALL
   SELECT '2014004',
          '이몽룡',
          2,
          TO_DATE('1996-03-03','YYYY-MM-DD'),
          'D002'
     FROM dual
   UNION ALL
   SELECT '2016002',
          '변학도',
          4,
          TO_DATE('1995-05-07','YYYY-MM-DD'),
          'D001'
     FROM dual
   UNION ALL
   SELECT '2015003',
          '손흥민',
          3,
          TO_DATE('1997-11-11','YYYY-MM-DD'),
          'D002'
     FROM dual;

-- 변경 사항 반영
COMMIT;

-- 테이블 내용 조회
SELECT *
  FROM student;

-- 전체 데이터 삭제
DELETE FROM student;

COMMIT;

-- ----------------- Ex02 ----------------- --
INSERT INTO book
   SELECT book_seq_no.NEXTVAL,
          'JAVA 프로그래밍',
          30000,
          TO_DATE('2021-03-10','YYYY-MM-DD'),
          '서울 출판사'
     FROM dual
   UNION ALL
   SELECT book_seq_no.NEXTVAL,
          '파이썬 데이터 과학',
          24000,
          TO_DATE('2018-02-05','YYYY-MM-DD'),
          '도서출판 강남'
     FROM dual;

-- 도서명이 '데이터베이스'인 행의 가격을 22000으로 변경
UPDATE book
   SET
   book_price = 22000
 WHERE book_name = '데이터베이스';

-- 발행일(book_date)가 2018년도 인 tuple 삭제
DELETE FROM book
 WHERE EXTRACT(YEAR FROM book_date) = 2018;

-- 변경 사항 반영
COMMIT;

-- ----------------- 종합 연습문제 (EX03) ----------------- --
-- ----------------- 사전 작업 쿼리 ----------------- --
-- SEQ
CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1 NOCYCLE;

CREATE SEQUENCE customer_seq START WITH 1001 INCREMENT BY 1 NOCYCLE;

CREATE SEQUENCE orderproduct_seq START WITH 1 INCREMENT BY 1 NOCYCLE;

-- 이전에 작성한 product
CREATE TABLE product (
   prd_no      NUMBER NOT NULL,
   prd_name    VARCHAR2(30) NOT NULL,
   prd_price   NUMBER(8),
   prd_company VARCHAR2(30),
   CONSTRAINT pk_product2_prd_no PRIMARY KEY ( prd_no ),
   CONSTRAINT chk_product_prd_no CHECK ( prd_no IS NOT NULL ),
   CONSTRAINT chk_product_prd_name CHECK ( prd_name IS NOT NULL )
);

INSERT INTO product
   WITH data AS (
      SELECT '제품이름1' prd_name,
             15000 prd_price,
             '회사A' prd_company
        FROM dual
      UNION ALL
      SELECT '제품이름2',
             20000,
             '회사B'
        FROM dual
      UNION ALL
      SELECT '제품이름3',
             23000,
             '회사C'
        FROM dual
      UNION ALL
      SELECT '제품이름4',
             25000,
             '회사A'
        FROM dual
      UNION ALL
      SELECT '제품이름5',
             34000,
             '회사A'
        FROM dual
      UNION ALL
      SELECT '제품이름6',
             29000,
             '회사B'
        FROM dual
      UNION ALL
      SELECT '제품이름7',
             10000,
             '회사C'
        FROM dual
   )
   SELECT product_seq.NEXTVAL,
          prd_name,
          prd_price,
          prd_company
     FROM data;

COMMIT;

-- ----------------- 문제 풀이 쿼리 ----------------- --
-- 1. customer 테이블 생성
CREATE TABLE customer (
   cust_no      NUMBER PRIMARY KEY,
   cust_name    VARCHAR2(30) NOT NULL,
   cust_phone   VARCHAR2(15),
   cust_address VARCHAR2(100)
);

-- 2. orderProduct 테이블 생성
CREATE TABLE order_product (
   order_no   NUMBER PRIMARY KEY,
   order_date DATE NOT NULL,
   order_qty  NUMBER(3) NOT NULL,
   cust_no    NUMBER NOT NULL,
   prd_no     NUMBER NOT NULL,
   CONSTRAINT fk_customer_custno FOREIGN KEY ( cust_no )
      REFERENCES customer ( cust_no ),
   CONSTRAINT fk_customer_prdno FOREIGN KEY ( prd_no )
      REFERENCES product ( prd_no ),
   CONSTRAINT check_order_qty CHECK ( order_qty > 0 )
);

-- 3. customer table의 cust_phone은 NOT NULL로 설정 (CONSTRAINT 추가)
ALTER TABLE customer ADD CONSTRAINT chk_customer_cust_phone CHECK ( cust_phone IS NOT NULL );

-- 4. customer table에 성별, 나이 추가
ALTER TABLE customer ADD (
   cust_gender CHAR(4),
   cust_age    NUMBER(3),
   CONSTRAINT chk_customer_cust_gender
      CHECK ( cust_gender IN ( '남',
                               '여',
                               '기타' ) ),
   CONSTRAINT chk_customer_cust_age CHECK ( cust_age >= 0 )
);

-- 5. customer, order table에 data 삽입
INSERT INTO customer
   SELECT customer_seq.NEXTVAL,
          cust_name,
          cust_phone,
          cust_address,
          cust_gender,
          cust_age
     FROM (
      SELECT '홍길동' cust_name,
             '010-1111-1111' cust_phone,
             '강원도 평창' cust_address,
             '남' cust_gender,
             22 cust_age
        FROM dual
      UNION ALL
      SELECT '이몽룡',
             '010-2222-2222',
             '서울 종로구',
             '남',
             23
        FROM dual
      UNION ALL
      SELECT '성춘향',
             '010-3333-3333',
             '서울시 강남',
             '여',
             22
        FROM dual
   );

INSERT INTO order_product
   SELECT order_product_seq.NEXTVAL,
          order_date,
          order_qty,
          cust_no,
          prd_no
     FROM (
      SELECT TO_DATE('2018-01-10','YYYY-MM-DD') order_date,
             3 order_qty,
             1003 cust_no,
             3 prd_no
        FROM dual
      UNION ALL
      SELECT TO_DATE('2018-03-03','YYYY-MM-DD'),
             1,
             1001,
             7
        FROM dual
      UNION ALL
      SELECT TO_DATE('2018-04-05','YYYY-MM-DD'),
             3,
             1002,
             2
        FROM dual
   );

COMMIT;

SELECT *
  FROM customer;

SELECT *
  FROM order_product;

-- ----------------- Ex04 ----------------- --
-- table은 txt로 import
-- table:
--      book(book_no, book_name, book_author, book_price, book_date, book_stock, pub_no)
--      book_sale(bs_no, bs_date, bs_qty, client_no, book_no)
--      client(client_no, client_name, client_phone, client_address, client_birth, client_hobby, client_gender)
--      publisher(pub_no, pub_name)
-- 1.고객 테이블에서 고객명, 생년월일, 성별 출력
SELECT client_name,
       to_char(
          client_birth,
          'YYYY-MM-DD'
       ) AS client_birth,
       client_gender
  FROM client;

-- 2.고객 테이블에서 주소만 검색하여 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT client_address
  FROM client;

-- 3.고객 테이블에서 취미가 '축구'이거나 '등산'인 고객의 고객명, 취미 출력
SELECT client_name,
       client_hobby
  FROM client
 WHERE client_hobby IN ( '축구',
                         '등산' );

-- 4.도서 테이블에서 저자의 두 번째 위치에 '길'이 들어 있는 저자명 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT book_author
  FROM book
 WHERE book_author LIKE '_길%';

-- 5.도서 테이블에서 발행일이 2018년인 도서의 도서명, 저자, 발행일 출력
SELECT book_name,
       book_author,
       to_char(
          book_date,
          'YYYY-MM-DD'
       ) AS book_date
  FROM book
 WHERE EXTRACT(YEAR FROM book_date) = 2018;

-- 6.도서판매 테이블에서 고객번호1, 2를 제외한 모든 튜플 출력
SELECT *
  FROM book_sale
 WHERE client_no NOT IN ( 1,
                          2 );

-- 7.고객 테이블에서 취미가 NULL이 아니면서 주소가 '서울'인 고객의 고객명, 주소, 취미 출력
SELECT client_name,
       client_address,
       client_hobby
  FROM client
 WHERE client_hobby IS NOT NULL
   AND client_address = '서울';

-- 8.도서 테이블에서 가격이 25000 이상이면서 저자 이름에 '길동'이 들어가는 도서의 도서명, 저자, 가격, 재고 출력
SELECT book_name,
       book_author,
       book_price,
       book_stock
  FROM book
 WHERE book_price >= 25000
   AND book_author LIKE '%길동%';

-- 9.도서 테이블에서 가격이 20,000 ~25,000원인 모든 튜플 출력
SELECT *
  FROM book
 WHERE book_price BETWEEN 20000 AND 25000;

-- 10.도서 테이블에서 저자명에 '길동'이 들어 있지 않는 도서의 도서명, 저자 출력
SELECT book_name,
       book_author
  FROM book
 WHERE book_author NOT LIKE '%길동%';