-- ----------------- ADD IMPORTED TABLE CONSTRAINTS ----------------- --
ALTER TABLE publisher ADD CONSTRAINT pk_publisher_pub_no PRIMARY KEY ( pub_no );

ALTER TABLE book ADD (
   CONSTRAINT pk_book_book_no PRIMARY KEY ( book_no ),
   CONSTRAINT fk_book_pub_no FOREIGN KEY ( pub_no )
      REFERENCES publisher ( pub_no )
);

ALTER TABLE client ADD CONSTRAINT pk_client_client_no PRIMARY KEY ( client_no );

ALTER TABLE book_sale ADD (
   CONSTRAINT pk_book_sale_bs_no PRIMARY KEY ( bs_no ),
   CONSTRAINT fk_book_sale_client_no FOREIGN KEY ( client_no )
      REFERENCES client ( client_no ),
   CONSTRAINT fk_book_sale_book_no FOREIGN KEY ( book_no )
      REFERENCES book ( book_no )
);

-- ----------------- SELECT 실습 ----------------- --
-- SELECT [ALL | DISTINCT] 열이름 리스트
-- FROM 테이블명
-- [WHERE 검색조건(들)]
-- [GROUP BY 열이름]
-- [HAVING 검색조건(들)]
-- [ORDER BY 열이름 [ASC┃DESC]
-- book table에서 모든 row 검색
SELECT *
  FROM book;

-- book table에서 도서명, 도서가격만 출력
SELECT book_name,
       book_price
  FROM book;

-- book table에서 저자명 출력
SELECT book_author
  FROM book;

-- book table에서 저자 검색 (중복 제거)
SELECT DISTINCT book_author
  FROM book;

--------------------------
-- WHERE: 검색의 세분화
-- 조건 사용 연산자
-- 비교: <, >, <=, >=, =, <>
-- 범위: BETWEEN ... AND ...
-- 리스트에 포함: IN (...)
-- NULL: IS NULL, IS NOT NULL
-- 논리: AND, OR, NOT
-- 패턴 매칭: LIKE
--저자가 홍길동인 도서의 도서명, 저자
SELECT book_name,
       book_author
  FROM book
 WHERE book_author = '홍길동';

-- 도서 재고가 3권 이상 5권 이하인 도서의 도서명과 재고 수량
SELECT book_name,
       book_stock
  FROM book
 WHERE book_stock >= 3
   AND book_stock <= 5;

-- 도서 재고가 3권 이상 5권 이하인 도서의 도서명과 재고 수량 (BETWEEN)
SELECT book_name,
       book_stock
  FROM book
 WHERE book_stock BETWEEN 3 AND 5;

-- 출판사명이 '서울 출판사' 또는 '도서출판 강남'인 도서의 도서명과 출판사명 
SELECT book_name,
       pub_name
  FROM book b,
       publisher p
 WHERE b.pub_no = p.pub_no
   AND p.pub_name IN ( '서울 출판사',
                       '도서출판 강남' );

-- 취미 정보가 NULL인 클라이언트의 이름과 취미를 반환
SELECT client_name,
       client_hobby
  FROM client
 WHERE client_hobby IS NULL;

-- 취미정보가 NULL이 아닌 클라이언트의 이름과 취미를 반환
SELECT client_name,
       client_hobby
  FROM client
 WHERE client_hobby IS NOT NULL;

-- 취미에 공백 값이 저장된 클라이언트의 이름과 취미를 반환
SELECT client_name,
       client_hobby
  FROM client
 WHERE client_hobby = ' ';

--------------------------
-- 논리
-- 저자가 홍길동이면서 재고가 3권 이상인 도서
SELECT *
  FROM book
 WHERE book_author = '홍길동'
   AND book_stock >= 3;

-- 저자가 홍길동 이거나 성춘향인 도서의 정보
SELECT *
  FROM book
 WHERE book_author = '홍길동'
    OR book_author = '성춘향';

--------------------------
-- Pattern 매칭
-- 출판사명에 출판사 문자열이 포함된 출판사
SELECT *
  FROM publisher
 WHERE pub_name LIKE '%출판사%';

-- 출생년도가 1991년인 고객의 정보
-- SELECT *
-- FROM client
-- WHERE client_birth LIKE '%91%'; -- 출력이 DD/MM/YY이기 때문
SELECT *
  FROM client
 WHERE EXTRACT(YEAR FROM client_birth) = 1991;

-- 이름이 4글자인 고객의 정보
SELECT *
  FROM client
 WHERE client_name LIKE '____';

-- 도서명에 안드로이드가 포함되지 않은 도서의 정보
SELECT *
  FROM book
 WHERE book_name NOT LIKE '%안드로이드%';

-- 오름차순
SELECT *
  FROM book
 ORDER BY book_name ASC;

-- 내림차순
SELECT *
  FROM book
 ORDER BY book_name DESC;

-- 조건절 뒤에 ORDER BY
SELECT book_name,
       book_author,
       book_price,
       book_stock
  FROM book
 WHERE book_price > 20000
 ORDER BY book_price;

-- 정렬 조건이 2개 이상일 경우
-- 도서재고를 기준으로 내림차순, 재고가 동일하면 저자를 기준으로 오름차순 정렬한 경우
SELECT *
  FROM book
 ORDER BY book_stock DESC,
          book_author ASC;

-- -----
-- 집계 함수
-- SUM()/AVG()/COUNT()/COUNT(*)/MAX()/MIN()
-- SUM
-- 도서의 총재고 수량
SELECT SUM(book_stock)
  FROM book;

-- 모든 컬럼은 AS를 이용하여 alias를 붙일 수 있음
SELECT SUM(book_stock) AS total_stock
  FROM book;

-- 2번 고객이 주문한 총 주문 도서 수량
SELECT SUM(bs_qty) AS total_qty
  FROM book_sale
 WHERE client_no = '2';

-- 총 주문 수량은 1개의 튜플, 도서번호는 3개의 튜플을 반환
-- GROUP BY를 포함하지 않으면, SELECT에 집계함수가 포함되는 경우, 다른 column도 집계함수 필요
-- SELECT SUM(bs_qty) AS total_qty, book_no
-- FROM book_sale
-- WHERE client_no='2';
SELECT SUM(bs_qty) AS total_qty,
       AVG(bs_qty) AS avg_qty
  FROM book_sale
 WHERE client_no = '2';

SELECT SUM(bs_qty),
       book_no
  FROM book_sale
 GROUP BY book_no
 ORDER BY book_no;

SELECT SUM(bs_qty),
       book_no
  FROM book_sale
 GROUP BY book_no
 ORDER BY 2;

-- SELECT된 첫번째 COLUMN을 기준으로 정렬
-- 각 지역별 고객의 수
SELECT client_address AS "Area",
       COUNT(*) AS "Number of Clients"
  FROM client
 GROUP BY client_address;

-- 성별에 따른 고객 수
SELECT client_gender AS "Gender",
       COUNT(*) AS "Number of Clients"
  FROM client
 GROUP BY client_gender;

-- GROUP BY의 기준으로 사용하지 않은 필드는 SELECT에 단독 사용 불가
-- SELECT client_gender AS "Gender", COUNT(*) AS "Number of Clients", client_address
-- FROM client
-- GROUP BY client_gender;
SELECT client_gender AS "Gender",
       COUNT(*) AS "Number of Clients",
       client_address AS "Local Area"
  FROM client
 GROUP BY client_gender,
          client_address;