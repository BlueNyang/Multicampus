-- ----------------- Ex01 ----------------- --
-- ----------------- TABLE 생성 쿼리 ----------------- --
-- ex에 맞춰 department와 student table 생성
-- declaration of department table
CREATE TABLE department (
    deptNo VARCHAR2(4),
    deptName VARCHAR2(50),
	-- primary key constraint
    CONSTRAINT pk_dept_deptNo PRIMARY KEY (deptNo),
    -- not null constraints
    CONSTRAINT chk_dept_deptNo CHECK (deptNo IS NOT NULL),
    CONSTRAINT chk_dept_deptName CHECK (deptName IS NOT NULL)
);

-- declaration of student table
CREATE TABLE student (
    stdNo VARCHAR2(10) PRIMARY KEY,
    stdName VARCHAR2(50) NOT NULL,
    stdYear NUMBER(1),
    stdBirthday DATE,
    deptNo VARCHAR2(10),
    CONSTRAINT fk_student_deptNo FOREIGN KEY (deptNo) REFERENCES DEPARTMENT(deptNo),
    CONSTRAINT chk_student_year CHECK (stdYear BETWEEN 1 AND 4)
);

-- insert sample data into department
INSERT INTO department (deptNo, deptName)
SELECT * FROM (
    SELECT 'D001', 'Computer Science' FROM dual
    UNION ALL
    SELECT 'D002', 'Electrical Engineering' FROM dual
    UNION ALL
    SELECT 'D003', 'Mechanical Engineering' FROM dual
);

-- 변경 사항 반영
COMMIT;

-- ----------------- 예제 풀이 쿼리 ----------------- --

-- INSERT EX1
-- 여러 개의 data를 dual(더미테이블)을 사용하여 삽입
INSERT INTO student
SELECT '2016001', '홍길동', 4, TO_DATE('1997-01-01', 'YYYY-MM-DD'), 'D001' FROM dual
UNION ALL
SELECT '2015002', '성춘향', 3, TO_DATE('1996-12-10', 'YYYY-MM-DD'), 'D003' FROM dual
UNION ALL
SELECT '2014004', '이몽룡', 2, TO_DATE('1996-03-03', 'YYYY-MM-DD'), 'D002' FROM dual
UNION ALL
SELECT '2016002', '변학도', 4, TO_DATE('1995-05-07', 'YYYY-MM-DD'), 'D001' FROM dual
UNION ALL
SELECT '2015003', '손흥민', 3, TO_DATE('1997-11-11', 'YYYY-MM-DD'), 'D002' FROM dual;

-- 변경 사항 반영
COMMIT;

-- 테이블 내용 조회
SELECT * FROM student;

-- 전체 데이터 삭제
DELETE FROM student;
COMMIT;

-- ----------------- Ex02 ----------------- --
INSERT INTO book
SELECT BOOK_SEQ_NO.NEXTVAL, 'JAVA 프로그래밍', 30000, TO_DATE('2021-03-10', 'YYYY-MM-DD'), '서울 출판사' FROM dual
UNION ALL
SELECT BOOK_SEQ_NO.NEXTVAL, '파이썬 데이터 과학', 24000, TO_DATE('2018-02-05', 'YYYY-MM-DD'), '도서출판 강남' FROM dual;

-- 도서명이 '데이터베이스'인 행의 가격을 22000으로 변경
UPDATE book SET bookPrice = 22000 WHERE bookName = '데이터베이스';

-- 발행일(bookDate)가 2018년도 인 tuple 삭제
DELETE FROM book WHERE EXTRACT(YEAR FROM bookDate) = 2018;

-- 변경 사항 반영
COMMIT;


-- ----------------- 종합 연습문제 (EX03) ----------------- --
-- ----------------- 사전 작업 쿼리 ----------------- --
-- SEQ
CREATE SEQUENCE product_seq
START WITH 1
INCREMENT BY 1
NOCYCLE;

CREATE SEQUENCE customer_seq
START WITH 1001
INCREMENT BY 1
NOCYCLE;

CREATE SEQUENCE orderProduct_seq
START WITH 1
INCREMENT BY 1
NOCYCLE;

-- 이전에 작성한 product
CREATE TABLE product (
    prdNo NUMBER NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    CONSTRAINT pk_product2_prdNo PRIMARY KEY (prdNo),
    CONSTRAINT chk_product_prdNo CHECK (prdNo IS NOT NULL),
    CONSTRAINT chk_product_prdName CHECK (prdName IS NOT NULL)
);

INSERT INTO product
WITH DATA AS (
    SELECT '제품이름1' prdName, 15000 prdPrice, '회사A' prdCompany FROM dual
    UNION ALL
    SELECT '제품이름2', 20000, '회사B' FROM dual
    UNION ALL
    SELECT '제품이름3', 23000, '회사C' FROM dual
    UNION ALL
    SELECT '제품이름4', 25000, '회사A' FROM dual
    UNION ALL
    SELECT '제품이름5', 34000, '회사A' FROM dual
    UNION ALL
    SELECT '제품이름6', 29000, '회사B' FROM dual
    UNION ALL
    SELECT '제품이름7', 10000, '회사C' FROM dual
) SELECT product_seq.NEXTVAL, prdName, prdPrice, prdCompany FROM data;

COMMIT;


-- ----------------- 문제 풀이 쿼리 ----------------- --
-- 1. customer 테이블 생성
CREATE TABLE customer (
    custNo NUMBER PRIMARY KEY,
    custName VARCHAR2(30) NOT NULL,
    custPhone VARCHAR2(15),
    custAddress VARCHAR2(100)
);

-- 2. orderProduct 테이블 생성
CREATE TABLE orderProduct (
    orderNo NUMBER PRIMARY KEY,
    orderDate DATE NOT NULL,
    orderQty NUMBER(3) NOT NULL,
    custNo NUMBER NOT NULL,
    prdNo NUMBER NOT NULL,
    CONSTRAINT fk_customer_custNo FOREIGN KEY (custNo) REFERENCES customer(custNo),
    CONSTRAINT fk_customer_prdNo FOREIGN KEY (prdNo) REFERENCES product(prdNo),
    CONSTRAINT check_order_qty CHECK (orderQty > 0)
);

-- 3. customer table의 custPhone은 NOT NULL로 설정 (CONSTRAINT 추가)
ALTER TABLE customer
ADD CONSTRAINT chk_customer_custPhone CHECK (custPhone IS NOT NULL);

-- 4. customer table에 성별, 나이 추가
ALTER TABLE customer
ADD (
    custGender CHAR(4),
    custAge NUMBER(3),
    CONSTRAINT chk_cust_gender CHECK (custGender IN ('남', '여', '기타')),
    CONSTRAINT chk_cust_age CHECK (custAge >= 0)
);

-- 5. customer, order table에 data 삽입
INSERT INTO customer 
SELECT customer_seq.NEXTVAL, custName, custPhone, custAddress, custGender, custAge
FROM(
    SELECT '홍길동' custName, '010-1111-1111' custPhone, '강원도 평창' custAddress, '남' custGender, 22 custAge FROM dual
    UNION ALL
    SELECT '이몽룡', '010-2222-2222', '서울 종로구', '남', 23 FROM dual
    UNION ALL
    SELECT '성춘향', '010-3333-3333', '서울시 강남', '여', 22 FROM dual
);

INSERT INTO orderProduct
SELECT orderProduct_seq.NEXTVAL, orderDate, orderQty, custNo, prdNo
FROM (
    SELECT TO_DATE('2018-01-10', 'YYYY-MM-DD') orderDate, 3 orderQty, 1003 custNo, 3 prdNo FROM dual
    UNION ALL
    SELECT TO_DATE('2018-03-03', 'YYYY-MM-DD'), 1, 1001, 7 FROM dual
    UNION ALL
    SELECT TO_DATE('2018-04-05', 'YYYY-MM-DD'), 3, 1002, 2 FROM dual
);

COMMIT;

SELECT * FROM customer;
SELECT * FROM orderProduct;


-- ----------------- Ex04 ----------------- --
-- table은 txt로 import
-- table:
--      BOOK(BOOKNO, BOOKNAME, BOOKAUTHOR, BOOKPRICE, BOOKDATE, BOOKSTOCK, PUBNO)
--      BOOKSALE(BSNO, BSDATE, BSQTY, CLIENTNO, BOOKNO)
--      CLIENT(CLIENTNO, CLIENTNAME, CLIENTPHONE, CLIENTADDRESS, CLIENTBIRTH, CLIENTHOBBY, CLIENTGENDER)
--      PUBLISHER(PUBNO, PUBNAME)

-- 1.고객 테이블에서 고객명, 생년월일, 성별 출력
SELECT clientName, TO_CHAR(clientBirth, 'YYYY-MM-DD') AS clientBirth, clientGender
FROM client;

-- 2.고객 테이블에서 주소만 검색하여 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT clientAddress FROM client;

-- 3.고객 테이블에서 취미가 '축구'이거나 '등산'인 고객의 고객명, 취미 출력
SELECT clientName, clientHobby
FROM client 
WHERE clientHobby IN ('축구', '등산');

-- 4.도서 테이블에서 저자의 두 번째 위치에 '길'이 들어 있는 저자명 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT bookAuthor
FROM book 
WHERE bookAuthor LIKE '_길%';

-- 5.도서 테이블에서 발행일이 2018년인 도서의 도서명, 저자, 발행일 출력
SELECT bookName, bookAuthor, TO_CHAR(bookDate, 'YYYY-MM-DD') AS bookDate
FROM book
WHERE EXTRACT(YEAR FROM bookDate) = 2018;

-- 6.도서판매 테이블에서 고객번호1, 2를 제외한 모든 튜플 출력
SELECT *
FROM bookSale
WHERE clientNo NOT IN (1, 2);

-- 7.고객 테이블에서 취미가 NULL이 아니면서 주소가 '서울'인 고객의 고객명, 주소, 취미 출력
SELECT clientName, clientAddress, clientHobby
FROM client
WHERE clientHobby IS NOT NULL AND clientAddress = '서울';

-- 8.도서 테이블에서 가격이 25000 이상이면서 저자 이름에 '길동'이 들어가는 도서의 도서명, 저자, 가격, 재고 출력
SELECT bookName, bookAuthor, bookPrice, bookStock 
FROM book 
WHERE bookPrice >= 25000 AND bookAuthor LIKE '%길동%';

-- 9.도서 테이블에서 가격이 20,000 ~25,000원인 모든 튜플 출력
SELECT *
FROM book
WHERE bookPrice BETWEEN 20000 AND 25000;

-- 10.도서 테이블에서 저자명에 '길동'이 들어 있지 않는 도서의 도서명, 저자 출력
SELECT bookName, bookAuthor 
FROM book 
WHERE bookAuthor NOT LIKE '%길동%';