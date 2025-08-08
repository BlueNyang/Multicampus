-- ----------------- ADD IMPORTED TABLE CONSTRAINTS ----------------- --
ALTER TABLE publisher
ADD CONSTRAINT pk_publisher_pubNo PRIMARY KEY (pubNo);

ALTER TABLE book
ADD (
    CONSTRAINT pk_book_bookNo PRIMARY KEY (bookNo),
    CONSTRAINT fk_book_pubNo FOREIGN KEY (pubNo) REFERENCES publisher(pubNo)
);

ALTER TABLE client
ADD CONSTRAINT pk_client_clientNo PRIMARY KEY (clientNo);

ALTER TABLE bookSale
ADD (
    CONSTRAINT pk_bookSale_bsNo PRIMARY KEY (bsNo),
    CONSTRAINT fk_bookSale_clientNo FOREIGN KEY (clientNo) REFERENCES client(clientNo),
    CONSTRAINT fk_bookSale_bookNo FOREIGN KEY (bookNo) REFERENCES book(bookNo)
);

-- ----------------- SELECT 실습 ----------------- --

-- SELECT [ALL | DISTINCT] 열이름 리스트
-- FROM 테이블명
-- [WHERE 검색조건(들)]
-- [GROUP BY 열이름]
-- [HAVING 검색조건(들)]
-- [ORDER BY 열이름 [ASC┃DESC]

-- book table에서 모든 row 검색
SELECT * FROM book;

-- book table에서 도서명, 도서가격만 출력
SELECT bookName, bookPrice FROM book;

-- book table에서 저자명 출력
SELECT bookAuthor FROM book;

-- book table에서 저자 검색 (중복 제거)
SELECT DISTINCT bookAuthor FROM book;

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
SELECT bookName, bookAuthor
FROM book 
WHERE bookAuthor = '홍길동';

-- 도서 재고가 3권 이상 5권 이하인 도서의 도서명과 재고 수량
SELECT bookName, bookStock
FROM book
WHERE bookStock >= 3 AND bookStock <= 5;

-- 도서 재고가 3권 이상 5권 이하인 도서의 도서명과 재고 수량 (BETWEEN)
SELECT bookName, bookStock
FROM book
WHERE bookStock BETWEEN 3 AND 5;

-- 출판사명이 '서울 출판사' 또는 '도서출판 강남'인 도서의 도서명과 출판사명 
SELECT bookName, pubName
FROM book b, publisher p
WHERE b.pubNo = p.pubNo AND p.pubName IN ('서울 출판사', '도서출판 강남');

-- 취미 정보가 NULL인 클라이언트의 이름과 취미를 반환
SELECT clientName, clientHobby
FROM client
WHERE clientHobby IS NULL;

-- 취미정보가 NULL이 아닌 클라이언트의 이름과 취미를 반환
SELECT clientName, clientHobby
FROM client
WHERE clientHobby IS NOT NULL;

-- 취미에 공백 값이 저장된 클라이언트의 이름과 취미를 반환
SELECT clientName, clientHobby
FROM client
WHERE clientHobby = ' ';

--------------------------
-- 논리
-- 저자가 홍길동이면서 재고가 3권 이상인 도서
SELECT *
FROM book
WHERE bookAuthor = '홍길동' AND bookStock >=3;

-- 저자가 홍길동 이거나 성춘향인 도서의 정보
SELECT *
FROM book
WHERE bookAuthor = '홍길동' OR bookAuthor = '성춘향';

--------------------------
-- Pattern 매칭

-- 출판사명에 출판사 문자열이 포함된 출판사
SELECT *
FROM publisher
WHERE pubName LIKE '%출판사%';

-- 출생년도가 1991년인 고객의 정보
-- SELECT *
-- FROM client
-- WHERE clientBirth LIKE '%91%'; -- 출력이 DD/MM/YY이기 때문
SELECT *
FROM client
WHERE EXTRACT(YEAR FROM clientBirth) = 1991;


-- 이름이 4글자인 고객의 정보
SELECT *
FROM client
WHERE clientName LIKE '____';

-- 도서명에 안드로이드가 포함되지 않은 도서의 정보
SELECT *
FROM book
WHERE bookName NOT LIKE '%안드로이드%';