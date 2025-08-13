-- ex1
-- 1.호날두(고객명)가 주문한 도서의 총 구매량 출력
-- 1.1. 서브쿼리로 풀기
SELECT SUM(bs_qty) AS total_qty
  FROM book_sale
 WHERE client_no IN (
   SELECT client_no
     FROM client
    WHERE client_name = '호날두'
);

-- 1.2. join으로 풀기
SELECT SUM(bs_qty) AS total_qty
  FROM book_sale bs
 INNER JOIN client c
ON bs.client_no = c.client_no
 WHERE c.client_name = '호날두';

-- 2.‘정보출판사’에서 출간한 도서를 구매한 적이 있는 고객명 출력
-- 2.1. 서브쿼리로 풀기
SELECT DISTINCT client_name
  FROM client
 WHERE client_no IN (
   SELECT client_no
     FROM book_sale
    WHERE book_no IN (
      SELECT book_no
        FROM book
       WHERE pub_no = (
         SELECT pub_no
           FROM publisher
          WHERE pub_name = '정보출판사'
      )
   )
);

-- 2.2. join으로 풀기
SELECT DISTINCT c.client_name
  FROM client c
 INNER JOIN book_sale bs
ON c.client_no = bs.client_no
 INNER JOIN book b
ON bs.book_no = b.book_no
 INNER JOIN publisher p
ON b.pub_no = p.pub_no
 WHERE p.pub_name = '정보출판사';

-- 2.3. subquery + join
SELECT DISTINCT client_name
  FROM client c
 WHERE EXISTS (
   SELECT 1
     FROM book_sale bs
    INNER JOIN book b
   ON bs.book_no = b.book_no
    INNER JOIN publisher p
   ON b.pub_no = p.pub_no
    WHERE bs.client_no = c.client_no
      AND p.pub_name = '정보출판사'
);

-- 3.베컴이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구매한 고객명 출력
-- 3.1. 서브쿼리로 풀기
SELECT DISTINCT client_name
  FROM client
 WHERE client_no IN (
   SELECT client_no
     FROM book_sale
    WHERE bs_qty > (
      SELECT MAX(bs_qty)
        FROM book_sale
       WHERE client_no = (
         SELECT client_no
           FROM client
          WHERE client_name = '베컴'
      )
   )
);

-- 3.2. join + 서브쿼리로 풀기
SELECT DISTINCT c.client_name
  FROM client c
 INNER JOIN book_sale bs
ON c.client_no = bs.client_no
 WHERE bs.bs_qty > (
   SELECT MAX(bs_qty)
     FROM book_sale
    WHERE client_no = (
      SELECT client_no
        FROM client
       WHERE client_name = '베컴'
   )
);

-- 4.천안에 거주하는 고객에게 판매한 도서의 총 판매량 출력
-- 4.1. 서브쿼리로 풀기
SELECT SUM(bs_qty) AS total_qty
  FROM book_sale
 WHERE client_no IN (
   SELECT client_no
     FROM client
    WHERE client_address = '천안'
);

-- 4.2. join으로 풀기
SELECT SUM(bs_qty) AS total_qty
  FROM book_sale bs
 INNER JOIN client c
ON bs.client_no = c.client_no
 WHERE c.client_address = '천안';

-- ----------------------------------------------------------------
-- ex2
-- 1. 저자 중 성이 (손) 인 모든 저자 출력
-- 1.1. 빌트인 함수로 풀기
SELECT book_author
  FROM book
 WHERE substr(
   book_author,
   1,
   1
) = '손';

-- 2. 저자 중에서 같은 성을 가진 사람이 몇 몇이나 되는지 알아보기 위해 그룹지어 인원수 출력
SELECT substr(
   book_author,
   1,
   1
) AS author_last_name,
       COUNT(*) AS author_count
  FROM book
 GROUP BY substr(
   book_author,
   1,
   1
);

-- ----------------------------------------------------------------
-- ex3: sales table 생성
CREATE TABLE sales (
   prd_name     VARCHAR2(20),
   sales_date   VARCHAR2(10),
   prd_company  VARCHAR2(10),
   sales_amount NUMBER(8)
);

INSERT INTO sales
   WITH sales_data AS (
      SELECT '노트북',
             '2021.01',
             '삼성',
             10000
        FROM dual
      UNION ALL
      SELECT '노트북',
             '2021.03',
             '삼성',
             20000
        FROM dual
      UNION ALL
      SELECT '냉장고',
             '2021.01',
             'LG',
             12000
        FROM dual
      UNION ALL
      SELECT '냉장고',
             '2021.03',
             'LG',
             20000
        FROM dual
      UNION ALL
      SELECT '프린터',
             '2021.01',
             'HP',
             3000
        FROM dual
      UNION ALL
      SELECT '프린터',
             '2021.03',
             'HP',
             1000
        FROM dual
   )
   SELECT *
     FROM sales_data;
COMMIT;
-- --------------
-- 풀이
-- CUBE로 소계 및 총계 산출하기
-- CUBE는 prd_name, sales_date, prd_company 모든 조합에 대한 소계와 총계를 계산
SELECT prd_name,
       sales_date,
       prd_company,
       SUM(sales_amount) AS total_sales
  FROM sales
 GROUP BY CUBE(prd_name,
               sales_date,
               prd_company);

-- ROLLUP으로 소계 및 총계 산출하기
-- ROLLUP은 순서가 중요. 가장 먼저 지정한 열부터 차례대로 소계가 계산
-- 다음 쿼리를 기준으로 prd_name, sales_date, prd_company 순서로 소계와 총계가 계산됨
-- 이후 prd_name, sales_date 조합에 대한 소계가 계산됨
-- 이후 prd_name에 대한 소계가 계산됨
-- 마지막으로 전체 총계가 계산됨
SELECT prd_name,
       sales_date,
       prd_company,
       SUM(sales_amount) AS total_sales
  FROM sales
 GROUP BY ROLLUP(prd_name,
                 sales_date,
                 prd_company);

-- GROUPING SETS로 소계 산출하기
-- GROUPING SETS는 지정한 열 조합에 대한 소계만 계산
-- 다음 쿼리를 기준으로는 prd_name 별 소계가 계산되고, prd_name으로 order by가 진행됨.
SELECT prd_name,
       sales_date,
       prd_company,
       SUM(sales_amount) AS total_sales
  FROM sales
 GROUP BY GROUPING SETS ( ( prd_name ),( prd_name,
                                         sales_date,
                                         prd_company ) )
 ORDER BY prd_name,
          GROUPING(sales_date) DESC,
          sales_date;

-- ----------------------------------------------------------------
-- ex4
-- 주문일에 7일을 더한 날을 배송일로 계산하여 출력
-- 도서 테이블에서 도서명과 출판 연도 출력
-- 4.1. 배송 일자
SELECT to_char(
   bs_date,
   'YYYY-MM-DD'
) AS bs_date,
       to_char(
          bs_date + INTERVAL '7' DAY,
          'YYYY-MM-DD'
       ) AS delivery_date
  FROM book_sale;

-- 4.2. 도서테이블에서 도서명과 출판 연도 출력
SELECT book_name,
       EXTRACT(YEAR FROM book_date) AS pub_year
  FROM book;