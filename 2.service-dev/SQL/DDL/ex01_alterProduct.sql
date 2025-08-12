-- 실습을 위한 product table 생성
CREATE TABLE product (
   prd_no      VARCHAR2(10) NOT NULL,
   prd_name    VARCHAR2(30) NOT NULL,
   prd_price   NUMBER(8),
   prd_company VARCHAR2(30),
   CONSTRAINT pk_product2_prd_no PRIMARY KEY ( prd_no ),
   CONSTRAINT chk_product_prd_no CHECK ( prd_no IS NOT NULL ),
   CONSTRAINT chk_product_prd_name CHECK ( prd_name IS NOT NULL )
);

-- 실습을 위한 publisher table 생성
CREATE TABLE publisher (
   pub_no   VARCHAR2(10),
   pub_name VARCHAR2(30),
   CONSTRAINT pk_publisher_pub_no PRIMARY KEY ( pub_no ),
   CONSTRAINT chk_publisher_pub_no CHECK ( pub_no IS NOT NULL ),
   CONSTRAINT chk_publisher_pub_name CHECK ( pub_name IS NOT NULL )
);

-- product table에 숫자값을 갖는 prd_stock, 날짜값을 갖는 prd_date 컬럼 추가
ALTER TABLE product ADD (
   prd_stock NUMBER(12),
   prd_date  DATE
);

-- product table의 prd_company 컬럼을 NOT NULL로 변경
ALTER TABLE product MODIFY
   prd_company NOT NULL;

-- publisher table에 pub_phone, pub_address 컬럼 추가
ALTER TABLE publisher ADD (
   pub_phone   VARCHAR2(15),
   pub_address VARCHAR2(100)
);

-- publisher table의 pub_phone 컬럼을 삭제
ALTER TABLE publisher DROP COLUMN pub_phone;