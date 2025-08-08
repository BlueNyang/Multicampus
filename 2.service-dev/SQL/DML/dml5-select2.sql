-- 오름차순
SELECT * FROM book
ORDER BY bookName ASC;

-- 내림차순
SELECT * FROM book 
ORDER BY bookName DESC;

-- 조건절 뒤에 ORDER BY
SELECT  bookName, BookAuthor, BookPrice, BookStock 
FROM book
WHERE bookPrice > 20000 
ORDER BY BookPrice;

-- 정렬 조건이 2개 이상일 경우
-- 도서재고를 기준으로 내림차순, 재고가 동일하면 저자를 기준으로 오름차순 정렬한 경우
SELECT * FROM book 
ORDER BY bookStock DESC, bookAuthor ASC;

-- -----
-- 집계 함수
-- SUM()/AVG()/COUNT()/COUNT(*)/MAX()/MIN()

-- SUM
-- 도서의 총재고 수량
SELECT SUM(bookStock) FROM book;

-- 모든 컬럼은 AS를 이용하여 alias를 붙일 수 있음
SELECT SUM(bookStock) AS totalStock FROM book;

-- 2번 고객이 주문한 총 주문 도서 수량
SELECT SUM(bsQty) AS totalQty
FROM bookSale
WHERE ClientNo='2';

-- 총 주문 수량은 1개의 튜플, 도서번호는 3개의 튜플을 반환
-- GROUP BY를 포함하지 않으면, SELECT에 집계함수가 포함되는 경우, 다른 column도 집계함수 필요
-- SELECT SUM(bsQty) AS totalQty, bookNo
-- FROM bookSale
-- WHERE ClientNo='2';

SELECT SUM(bsQty) AS totalQty, AVG(bsQty) AS avgQty
FROM bookSale
WHERE ClientNo='2';
