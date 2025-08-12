-- 1. Create a table named "product" with the following columns:
CREATE TABLE product (
   prd_no      VARCHAR2(10) PRIMARY KEY,
   prd_name    VARCHAR2(30) NOT NULL,
   prd_price   NUMBER(8),
   prd_company VARCHAR2(30)
);

-- 2. PRIMARY KEY를 따로 설정
CREATE TABLE product2 (
   prd_no      VARCHAR2(10) NOT NULL,
   prd_name    VARCHAR2(30) NOT NULL,
   prd_price   NUMBER(8),
   prd_company VARCHAR2(30),
   PRIMARY KEY ( prd_no )
);

-- 3. 제약 이름과 같이 설정: 제약 변경이나 삭제시 유용
CREATE TABLE product1 (
   prd_no      VARCHAR2(10) NOT NULL
      CONSTRAINT pk_product1_prd_no PRIMARY KEY,
   prd_name    VARCHAR2(30) NOT NULL,
   prd_price   NUMBER(8),
   prd_company VARCHAR2(30)
);

--4. 따로 설정
CREATE TABLE product2 (
   prd_no      VARCHAR2(10) NOT NULL,
   prd_name    VARCHAR2(30) NOT NULL,
   prd_price   NUMBER(8),
   prd_company VARCHAR2(30),
   CONSTRAINT pk_product2_prd_no PRIMARY KEY ( prd_no )
);

-- 출판사 테이블 먼저 생성 후 도서테이블 생성 (외래키 제약조건 때문)
-- 외래키 필드에 입력되는 값은 참조테이블의 기본키로서 값과 동일해야 함
-- 외래키 필드의 도메인과 참조 테이블의 기본키 도메인은 동일해야 함
CREATE TABLE publisher (
   pub_no   VARCHAR2(10) NOT NULL,
   pub_name VARCHAR2(30) NOT NULL,
   CONSTRAINT pk_publisher_pub_no PRIMARY KEY ( pub_no )
);

CREATE TABLE book (
   book_no    VARCHAR2(10),
   book_name  VARCHAR2(30),
   book_price NUMBER(8) DEFAULT 10000,
   book_date  DATE,
   pub_no     VARCHAR2(10),
   CONSTRAINT pk_book_book_no PRIMARY KEY ( book_no ),
   CONSTRAINT fk_book_pub_no FOREIGN KEY ( pub_no )
      REFERENCES publisher ( pub_no ),
   CONSTRAINT chk_book_book_no CHECK ( book_no IS NOT NULL ),
   CONSTRAINT chk_book_book_name CHECK ( book_name IS NOT NULL ),
   CONSTRAINT chk_book_book_price CHECK ( book_price > 1000 ),
   CONSTRAINT chk_book_pub_no CHECK ( pub_no IS NOT NULL )
);