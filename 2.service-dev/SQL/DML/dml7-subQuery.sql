-- 서브쿼리
-- 하위 질의 / 부속 질의 라고도 함
-- 하나의 SQL문 안에 다른 SQL문이 중첩
-- 하위 질의 수행 후 반환 릴레이션에 대해 다음 연산 수행
-- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보 찾기나 가공 시 사용

-- Join vs SubQuery
-- Join: 두 개 이상의 테이블을 연결하여 데이터를 조회, 카티션 곱 연산 * SELECT 연산
-- SubQuery: 필요한 데이터만 찾아서 제공. 경우에 따라 조인보다 성능이 더 좋을 수도 있지만, 대용량 데이터에서 서브쿼리 수행 성능이 나쁠 수도 있음.

-- 구성: 메인쿼리 (서브쿼리) -> 서브쿼리 먼저 수행 후 메인 쿼리 수행

-- 메시 고객이 주문한 도서의 총 수량
SELECT SUM(bs_qty)
  FROM book_sale
 WHERE client_no = (
   SELECT client_no
     FROM client
    WHERE client_name = '메시'
);

-- 서브쿼리 WHERE 절에서 사용할 경우
-- 서브쿼리 질의 결과 값이 단일 행인 경우: 단일 행 서브쿼리
-- == 연산자 사용해서 조건 확인

-- 서브쿼리 질의 결과 값이 다중 행인 경우: 다중행 서브쿼리
-- = IN, ANY, ALL, EXISTS 연산자 등 / IN, NOT IN 등등

-- 고객 호날두의 주문수량 및 주문 날짜 조회
-- 1. client table에서 '호날두'의 client_no를 찾음
-- 2. book_sale table에서 1에서 찾은 client_no를 이용하여 주문 수량과 주문 날짜를 조회
-- SELECT bs_qty,
--        bs_date
--   FROM book_sale
--  WHERE client_no = (
--    SELECT client_no
--      FROM client
--     WHERE client_name = '호날두'
-- );
SELECT SUM(bs_qty),
       bs_date
  FROM book_sale
 WHERE client_no = (
   SELECT client_no
     FROM client
    WHERE client_name = '호날두'
)
 GROUP BY bs_date;

-- 고객 호날두가 주문한 총 주문 수량
SELECT SUM(bs_qty)
  FROM book_sale
 WHERE client_no = (
   SELECT client_no
     FROM client
    WHERE client_name = '호날두'
);

-- 가장 비싼 도서의 도서명과 가격
SELECT book_name,
       book_price
  FROM book
 WHERE book_price = (
   SELECT MAX(book_price)
     FROM book
);

-- 도서의 평균 가격을 초과하는 도서의 이름과 도서 가격을 조회
SELECT book_name,
       book_price
  FROM book
 WHERE book_price > (
   SELECT AVG(book_price)
     FROM book
);

-- 도서를 구매한 적이 있는 고객의 고객명과 주소(지역)를 조회
-- 1. book_sale table의 고객정보를 조회
-- 2. client table에서 1에서 찾은 고객의 record만 추출
-- 3. 지정한 column 추출
SELECT client_name,
       client_address
  FROM client
 WHERE client_no IN (
   SELECT DISTINCT client_no
     FROM book_sale
);

-- 도서를 한 번도 구매한 적이 없는 고객의 고객명과 주소(지역)를 조회
SELECT client_name,
       client_address
  FROM client
 WHERE client_no NOT IN (
   SELECT DISTINCT client_no
     FROM book_sale
);

-- -----------------------------------------------------
-- 중첩 서브 쿼리
-- 도서명이 '안드로이드 프로그래밍'인 도서를 구매한 고객의 고객명
SELECT client_name
  FROM client
 WHERE client_no IN (
   SELECT client_no
     FROM book_sale
    WHERE book_no IN (
      SELECT book_no
        FROM book
       WHERE book_name = '안드로이드 프로그래밍'
   )
);

-- -----------------------------------------------------
-- 다중 행 서브 쿼리 연산자 (EXISTS, NOT EXISTS)
-- EXISTS: 서브 쿼리의 결과가 행을 반환하면 참이 되는 연산자
-- 도서를 구매한 적이 있는 고객
SELECT client_no,
       client_name
  FROM client c
 WHERE EXISTS (
   SELECT *
     FROM book_sale bs
    WHERE c.client_no = bs.client_no
);

-- -----------------------------------------------------
-- ALL/ANY
-- 관계 연산자와 같이 사용
-- ALL: 서브쿼리의 결과가 모두 참인 경우에만 참
-- ANY: 서브쿼리의 결과 중 하나라도 참이면 참

-- 2번 고객이 주문한 도서의 최고 주문 수량보다 더 많은 도서를 구입한 고객의 고객번호, 주문번호, 주문 수량
SELECT client_no,
       bs_no,
       bs_qty
  FROM book_sale
 WHERE bs_qty > (
   SELECT MAX(bs_qty)
     FROM book_sale
    WHERE client_no = '2'
);

-- 2번 고객이 주문한 도서의 최소 주문 수량보다 더 많은 도서를 구입한 고객의 고객번호, 주문번호, 주문 수량
SELECT client_no,
       bs_no,
       bs_qty
  FROM book_sale
 WHERE bs_qty > ANY (
   SELECT bs_qty
     FROM book_sale
    WHERE client_no = '2'
);

SELECT client_no,
       bs_no,
       bs_qty
  FROM book_sale
 WHERE bs_qty > (
   SELECT MIN(bs_qty)
     FROM book_sale
    WHERE client_no = '2'
);

-- 2번 고객이 주문한 최소 주문 수량보다 많이 주문한 고객의 주문정보
SELECT client_no,
       bs_no,
       bs_qty
  FROM book_sale
 WHERE bs_qty > ANY (
   SELECT bs_qty
     FROM book_sale
    WHERE client_no = '2'
)
   AND client_no <> '2';

-- 스칼라 서브쿼리 사용
-- 상관서브 쿼리
SELECT client_no,
       (
         -- WHERE 절에는 비교되는 client_no가 GROUP 기준이므로 반환되는 client_name은 그룹별로 반환됨
          SELECT client_name
            FROM client
           WHERE client.client_no = book_sale.client_no
       ) AS 고객명,
       SUM(bs_qty) AS "총주문수량"
  FROM book_sale
 GROUP BY client_no
 ORDER BY client_no;

/* VIEW 객체
 * 한 개의 릴레이션에 모든 정보가 저장되지는 않음
 * 필요한 정보를 얻기 위해 join이나 subquery를 사용
 * 많은 연산 수행이 동반됨
 * View는 한 번 연산 해놓은 결과를 다시 동일한 데이터를 사용하려고 할 때 빠른 연산을 위해 연산의 순서를 기록
 * 개발 중에 view가 필요한 경우 view를 생성하면 관리 문제나 성능 문제 발생 가능
 * 가상의 view, inline view 등을 사용하여 해결
 */

-- Inline View: 반환되는 데이터는 다중 행, 다중 열이어도 상관 없음
SELECT book_name,
       book_price,
       COUNT(*) AS order_count,
       SUM(bs_qty) AS total_sale_qty,
       SUM(book_price * bs_qty) AS total_sale_price
  FROM book_sale bs,
       (
          SELECT book_no,
                 book_name,
                 book_price
            FROM book
           WHERE book_price > 25000
       ) book
 WHERE book.book_no = bs.book_no
 GROUP BY book.book_no,
          book.book_name,
          book.book_price;