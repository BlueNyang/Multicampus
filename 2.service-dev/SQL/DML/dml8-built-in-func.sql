-- Oracle Built-in Function

-- Mathematical Functions
-- ROUND(Value, [Decimal]): 반올림

SELECT round(
   3.862,
   1
) AS result
  FROM dual;

SELECT round(
   3.862,
   2
) AS result
  FROM dual;

-- 고객 별 평균 주문액을 계산하여 조회 (백원 단위에서 반올림한 계산 결과 조회)
SELECT client_no,
       (
          SELECT client_name
            FROM client
           WHERE client.client_no = book_sale.client_no
       ) AS client_name,
       round(
          avg(book_price * bs_qty),
          -2
       ) AS avg_order_price
  FROM book
  JOIN book_sale
ON book.book_no = book_sale.book_no
 GROUP BY client_no
 ORDER BY client_no;

-- --------------------------------------------------------------
-- Characteristic
-- REPLACE(): 문자열 치환
-- LENGTH(): 문자열 길이
-- LENGTHB(): 바이트 단위 문자열 길이
-- SUBSTR(): 문자열 추출
-- CONCAT(): 문자열 연결

SELECT replace(
   '자바프로그래밍',
   '자바',
   '파이썬'
) ex1
  FROM dual;

SELECT replace(
   'apple airplane apart',
   'ap',
   '*^'
) ex2
  FROM dual;

-- 도서명에 안드로이드가 포함된 도서의 도서명에 대해 ANDROID로 치환
SELECT replace(
   book_name,
   '안드로이드',
   'ANDROID'
) book_name,
       book_author,
       book_price
  FROM book
 WHERE book_name LIKE '%안드로이드%';

-- 각 도서의 도서명에 대한 크기 확인
-- 도서명은 문자열 크기(갯수, 바이트수)
SELECT book_name,
       length(book_name) AS name_length,
       lengthb(book_name) AS name_length_bytes
  FROM book;

-- SUBSTR(문자열, 시작위치, [길이])
SELECT book_name,
       substr(
          book_author,
          1,
          1
       ) AS author_substr
  FROM book;

SELECT substr(
   book_author,
   2
) AS author_substr
  FROM book;

-- CONCAT: 문자열 연결
-- DB에 저장은 리터럴로 저장됨 -> 저자 : 도서명 : 가격 형식의 데이터가 개발 시 필요할 때
-- CONCAT(문자열1, 문자열2)
SELECT concat(
   "Hello,",
   " World!"
)
  FROM dual;

-- || 연산자: 문자열 연결
SELECT book_author
       || ' : '
       || book_name
       || ' : '
       || book_price AS book_info
  FROM book;

-- -------------------------------------------
-- Ranking Functions

-- RANK()
-- DENSE_RANK()
-- ROW_NUMBER()

-- 순위함수() OVER (PARTITION BY ... ORDER BY ...)

SELECT book_price,
       RANK()
       OVER(
           ORDER BY book_price
       ) AS rank,
       DENSE_RANK()
       OVER(
           ORDER BY book_price DESC
       ) AS dense_rank,
       ROW_NUMBER()
       OVER(
           ORDER BY book_price DESC
       ) AS row_num
  FROM book;

-- Top N Query: ROWNUM
SELECT ROWNUM,
       book_price
  FROM book
 WHERE ROWNUM BETWEEN 1 AND 5;

-- ----------------------------------------------------------------
-- ROLLUP()
-- 그룹의 소계와 총계 산출
-- 순서가 중요, 맨 앞에 놓인 것에 대해 소계 산출

-- CUBE()
-- 각 그룹의 모든 경우의 수에 대한 소계와 총계 산출
-- 각 항목들 간의 다차원적인 소계를 산출

-- GROUPING SETS()
-- 특정 항목에 대한 소계 산출

-- ----------------------------------------------------------------
CREATE TABLE cubetbl (
   prdname VARCHAR2(10),
   color   VARCHAR2(6),
   amount  NUMBER(2)
);
INSERT ALL
     INTO cubetbl
WITH cubetbl_data AS (
   SELECT '컴퓨터' AS prdname,
          '검정' AS color,
          11 AS amount
   UNION ALL
   SELECT '컴퓨터',
          '파랑',
          22
     FROM dual
   UNION ALL
   SELECT '모니터',
          '검정',
          33
     FROM dual
   UNION ALL
   SELECT '모니터',
          '파랑',
          44
     FROM dual
   UNION ALL
   SELECT '마우스',
          '검정',
          55
     FROM dual
   UNION ALL
   SELECT '마우스',
          '파랑',
          66
     FROM dual
)
SELECT *
  FROM cubetbl_data;

COMMIT;

SELECT *
  FROM cubetbl;
-- ----------------------------------------------------------------

-- CUBE()
SELECT prdname,
       color,
       SUM(amount) AS total_amount
  FROM cubetbl
 GROUP BY CUBE(color,
               prdname)
 ORDER BY prdname,
          color;

-- ROLLUP()
SELECT prdname,
       color,
       SUM(amount) AS total_amount
  FROM cubetbl
 GROUP BY ROLLUP(color,
                 prdname)
 ORDER BY prdname,
          color;
-- --
SELECT prdname,
       color,
       SUM(amount) AS total_amount
  FROM cubetbl
 GROUP BY ROLLUP(prdname,
                 color)
 ORDER BY prdname,
          color;

-- GROUPING SETS(): 항목 별 소계만 출력
SELECT prdname,
       color,
       SUM(amount)
  FROM cubetbl
 GROUP BY GROUPING SETS ( prdname,
                          color );

-- --
SELECT prdname,
       SUM(amount) AS total_amount
  FROM cubetbl
 GROUP BY GROUPING SETS ( prdname );

-- ----------------------------------------------------------------
CREATE TABLE pivottest (
   singer VARCHAR2(10),
   season VARCHAR2(10),
   amount NUMBER(3)
);

INSERT INTO pivottest
   WITH pivot_data AS (
      SELECT '김범수' AS singer,
             '겨울' AS season,
             10 AS amount
        FROM dual
      UNION ALL
      SELECT '윤종신',
             '여름',
             15
        FROM dual
      UNION ALL
      SELECT '김범수',
             '가을',
             25
        FROM dual
      UNION ALL
      SELECT '김범수',
             '봄',
             3
        FROM dual
      UNION ALL
      SELECT '김범수',
             '봄',
             37
        FROM dual
      UNION ALL
      SELECT '윤종신',
             '가을',
             40
        FROM dual
      UNION ALL
      SELECT '김범수',
             '여름',
             14
        FROM dual
      UNION ALL
      SELECT '김범수',
             '겨울',
             22
        FROM dual
      UNION ALL
      SELECT '윤종신',
             '여름',
             64
        FROM dual
   )
   SELECT *
     FROM pivot_data;

COMMIT;

SELECT *
  FROM pivottest;
-- ----------------------------------------------------------------
SELECT *
  FROM pivottest PIVOT (
   SUM(amount)
   FOR season
   IN ( '봄',
   '여름',
   '가을',
   '겨울' )
);
-- ----------------------------------------------------------------
-- 날짜 변환 함수
-- SYSDATE, CURRENT_DATE
SELECT sysdate
  FROM dual;

SELECT current_date
  FROM dual;

SELECT sysdate + 1
  FROM dual;

SELECT sysdate - 1
  FROM dual;

SELECT add_months(
   sysdate,
   1
)
  FROM dual;

-- 날짜 데이터에서 년, 월, 일 추출
-- EXTRACT()
SELECT EXTRACT(YEAR FROM sysdate) AS year,
       EXTRACT(MONTH FROM sysdate) AS month,
       EXTRACT(DAY FROM sysdate) AS day
  FROM dual;

-- 현재 시간
SELECT current_timestamp
  FROM dual;

-- 12시간 형식
SELECT to_char(
   sysdate,
   'HH:MI:SS'
)
  FROM dual;

-- 24시간 형식
SELECT to_char(
   sysdate,
   'HH24:MI:SS'
)
  FROM dual;

-- 24시간 형식 (시)
SELECT to_char(
   sysdate,
   'HH24'
)
  FROM dual;