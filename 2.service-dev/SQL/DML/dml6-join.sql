SELECT *
  FROM client
 INNER JOIN book_sale
ON client.client_no = book_sale.client_no;

SELECT client.client_no,
       client.client_name
  FROM client,
       book_sale
 WHERE client.client_no = book_sale.client_no;

-- 결과는 client_no를 제외하고는 테이블 명 포함시키지 않아도 동일함
-- 오라클 서버 입장에서는 속성의 소속을 명확히 하게 됨으로서 위치를 파악하기 쉬워짐 == 성능 향
SELECT client.client_no,
       client.client_name,
       book_sale.bs_qty
  FROM client,
       book_sale
 WHERE client.client_no = book_sale.client_no;

-- 테이블에 별칭 사용
SELECT c.client_no,
       c.client_name,
       b.bs_qty
  FROM client c,
       book_sale b
 WHERE c.client_no = b.client_no;

-- 주문한 적이 있는 고객의 모든 정보
SELECT c.client_no,
       c.client_name
  FROM client c
  JOIN book_sale b
ON c.client_no = b.client_no;

-- 소장 도서에 대한 도서명과 출판사명
SELECT book_name,
       pub_name
  FROM book b
 INNER JOIN publisher p
ON b.pub_no = p.pub_no;

-- 주문된 도서의 도서번호와 고객번호
SELECT book_no,
       client_no
  FROM book_sale;

-- 주문된 도서의 도서명과 고객명을 확인
-- 3개 테이블 조인
SELECT c.client_no,
       c.client_name
  FROM book_sale bs
 INNER JOIN client c
ON c.client_no = bs.client_no
 INNER JOIN book b
ON b.book_no = bs.book_no;

-- 고객별로 그룹 생성 시 동일한 이름의 서로 다른 고객이 있을 수 있으므로, 고객명이 필요하다고 해서 고객 이름만으로 그룹을 진행하면안됨
SELECT c.client_no,
       c.client_name,
       SUM(bs.bs_qty) AS "Total Orders"
  FROM book_sale bs
 INNER JOIN client c
ON c.client_no = bs.client_no
 GROUP BY c.client_no,
          c.client_name
 ORDER BY "Total Orders" DESC;

-- GROUP BY 다음에 없는 열 이름이 SELECT 절에 있을 수 없음
-- 주문된 도서의 주문일, 고객명, 도서명, 도서가격, 주문 수량, 주문액을 조회
-- 조인된 결과를 활용한 가공 필드 생성
SELECT bs.bs_date,
       c.client_name,
       b.book_name,
       b.book_price,
       bs.bs_qty,
       ( b.book_price * bs.bs_qty ) AS "Total Amount"
  FROM book_sale bs
 INNER JOIN client c
ON c.client_no = bs.client_no
 INNER JOIN book b
ON b.book_no = bs.book_no
 WHERE ( bs.bs_qty * b.book_price ) > 100000
 ORDER BY "Total Amount" DESC;

-- 2018년부터 현재까지 판매된 도서의 주문일, 고객명, 도서명, 도서가격, 주문수량, 주문액 계산 및 조회
SELECT bs.bs_date,
       c.client_name,
       b.book_name,
       b.book_price,
       bs.bs_qty,
       ( bs.bs_qty * b.book_price ) AS "Order Price"
  FROM book_sale bs
 INNER JOIN client c
ON c.client_no = bs.client_no
 INNER JOIN book b
ON b.book_no = bs.book_no
 WHERE bs.bs_date >= TO_DATE('2018-01-01','YYYY-MM-DD')
 ORDER BY bs.bs_date;

-- ------------------------------------------------
-- client table과 book_sale table 활용. outer join 예시
-- left 기준
SELECT *
  FROM client c
  LEFT OUTER JOIN book_sale bs
ON c.client_no = bs.client_no
 ORDER BY c.client_no;

-- Full outer join
SELECT *
  FROM client c
  FULL OUTER JOIN book_sale bs
ON c.client_no = bs.client_no
 ORDER BY c.client_no;

-- 오라클 OUTER JOIN
-- (+) 연산자
SELECT *
  FROM client c,
       book_sale bs
 WHERE c.client_no = bs.client_no (+)
 ORDER BY c.client_no;

SELECT *
  FROM client c,
       book_sale bs
 WHERE c.clientno (+) = bs.clientno
 ORDER BY c.clientno;

-- SELECT *
--   FROM client c,
--        book_sale bs
--  WHERE c.clientno (+) = bs.clientno (+) -- outer-join된 table은 1개만 지정할 수 있음.
--  ORDER BY c.clientno;