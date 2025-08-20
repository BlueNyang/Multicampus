-- 1.도서 테이블에서 가격 순으로 내림차순 정렬하여, 도서명, 저자, 가격 출력 (가격이 같으면 저자 순으로 오름차순 정렬)
SELECT book_name,
       book_author,
       book_price
  FROM book
 ORDER BY book_price DESC,
          book_author ASC;

-- 2.도서 테이블에서 저자에 '길동'이 들어가는 도서의 총 재고 수량 계산하여 출력
SELECT SUM(book_stock) AS "Total Stock Quantity"
  FROM book
 WHERE book_author LIKE '%길동%';

-- 3.도서 테이블에서 ‘서울 출판사' 도서 중 최고가와 최저가 출력
SELECT MAX(book.book_price) AS "Highest Price",
       MIN(book.book_price) AS "Lowest Price"
  FROM book,
       publisher
 WHERE book.pub_no = publisher.pub_no
   AND pub_name = '서울 출판사';

-- 4.도서 테이블에서 출판사별로 총 재고수량과 평균 재고 수량 계산하여 출력 (‘총 재고 수량’으로 내림차순 정렬)
SELECT publisher.pub_name AS "Publisher",
       SUM(book.book_stock) AS "Total Stock",
       round(
          avg(book.book_stock),
          2
       ) AS "Average Stock"
  FROM book,
       publisher
 WHERE book.pub_no = publisher.pub_no
 GROUP BY publisher.pub_name
 ORDER BY "Total Stock" DESC;

-- 5.도서판매 테이블에서 고객별로 ‘총 주문 수량’과 ‘총 주문 건수’ 출력. 단 주문 건수가 2이상인 고객만 해당
SELECT client_no,
       SUM(bs_qty) AS "Total Order Quantity",
       COUNT(*) AS "Total Orders"
  FROM book_sale
 GROUP BY client_no
HAVING COUNT(*) >= 2;

-- 1.모든 도서에 대하여 도서의 도서번호, 도서명, 출판사명 출력
SELECT b.book_no,
       b.book_name,
       p.pub_name
  FROM book b,
       publisher p
 WHERE b.pub_no = p.pub_no;

-- 2.'서울 출판사'에서 출간한 도서의 도서명, 저자명, 출판사명 출력 (출판사명 사용)
SELECT book_name,
       book_author,
       pub_name
  FROM book b,
       publisher p
 WHERE b.pub_no = p.pub_no
   AND p.pub_name = '서울 출판사';

-- 3.'정보출판사'에서 출간한 도서 중 판매된 도서의 도서명 출력 (중복된 경우 한 번만 출력) (출판사명 사용)
SELECT DISTINCT book_name
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 INNER JOIN publisher p
ON b.pub_no = p.pub_no
 WHERE p.pub_name = '정보출판사'
   AND bs.bs_date IS NOT NULL;

-- 4.도서가격이 30,000원 이상인 도서를 주문한 고객의 고객명, 도서명, 도서가격, 주문수량 출력
SELECT c.client_name,
       b.book_name,
       b.book_price,
       bs.bs_qty
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 INNER JOIN client c
ON bs.client_no = c.client_no
 WHERE b.book_price >= 30000;

-- 5.'안드로이드 프로그래밍' 도서를 구매한 고객에 대하여 도서명, 고객명, 성별, 주소 출력 (고객명으로 오름차순 정렬)
SELECT b.book_name,
       c.client_name,
       c.client_gender,
       c.client_address
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 INNER JOIN client c
ON bs.client_no = c.client_no
 WHERE b.book_name = '안드로이드 프로그래밍'
 ORDER BY c.client_name ASC;

-- 6.'도서출판 강남'에서 출간된 도서 중 판매된 도서에 대하여 '총 매출액' 출력
SELECT SUM(b.book_price * bs.bs_qty) AS "Total_Sales"
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 INNER JOIN publisher p
ON b.pub_no = p.pub_no
 WHERE p.pub_name = '도서출판 강남';

-- 7.'서울 출판사'에서 출간된 도서에 대하여 판매일, 출판사명, 도서명, 도서가격, 주문수량, 주문액 출력
SELECT bs.bs_date AS "Sale Date",
       p.pub_name AS "Publisher",
       b.book_name AS "Book Name",
       b.book_price AS "Book Price",
       bs.bs_qty AS "Order Quantity",
       ( b.book_price * bs.bs_qty ) AS "Order Amount"
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 INNER JOIN publisher p
ON b.pub_no = p.pub_no
 WHERE p.pub_name = '서울 출판사';

-- 8.판매된 도서에 대하여 도서별로 도서번호, 도서명, 총 주문 수량 출력
SELECT b.book_no,
       b.book_name,
       SUM(bs.bs_qty) AS "Total_Order_Quantity"
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 GROUP BY b.book_no,
          b.book_name
 ORDER BY b.book_no;

-- 9.판매된 도서에 대하여 고객별로 고객명, 총구매액 출력 ( 총구매액이 100,000원 이상인 경우만 해당)
SELECT c.client_name,
       SUM(b.book_price * bs.bs_qty) AS "Total_Purchase_Amount"
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 INNER JOIN client c
ON bs.client_no = c.client_no
 GROUP BY c.client_name
HAVING SUM(b.book_price * bs.bs_qty) >= 100000;

-- 10.판매된 도서 중 '도서출판 강남'에서 출간한 도서에 대하여 고객명, 주문일, 도서명, 주문수량, 출판사명 출력 (고객명으로 오름차순 정렬)
SELECT c.client_name AS "Customer Name",
       bs.bs_date AS "Order Date",
       b.book_name AS "Book Name",
       bs.bs_qty AS "Order Quantity",
       p.pub_name AS "Publisher"
  FROM book b
 INNER JOIN book_sale bs
ON b.book_no = bs.book_no
 INNER JOIN client c
ON bs.client_no = c.client_no
 INNER JOIN publisher p
ON b.pub_no = p.pub_no
 WHERE p.pub_name = '도서출판 강남'
 ORDER BY c.client_name ASC;