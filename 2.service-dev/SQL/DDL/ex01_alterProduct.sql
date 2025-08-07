-- 실습을 위한 product table 생성
CREATE TABLE product (
    prdNo VARCHAR2(10) NOT NULL ,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    CONSTRAINT pk_product2_prdNo PRIMARY KEY (prdNo),
    CONSTRAINT chk_product_prdNo CHECK (prdNo IS NOT NULL),
    CONSTRAINT chk_product_prdName CHECK (prdName IS NOT NULL)
);

-- 실습을 위한 publisher table 생성
CREATE TABLE publisher (
    pubNo VARCHAR2(10),
    pubName VARCHAR2(30),
    CONSTRAINT pk_publisher_pubNo PRIMARY KEY (pubNo),
    CONSTRAINT chk_publisher_pubNo CHECK (pubNo IS NOT NULL),
    CONSTRAINT chk_publisher_pubName CHECK (pubName IS NOT NULL)
);

-- product table에 숫자값을 갖는 prdStock, 날짜값을 갖는 prdDate 컬럼 추가
ALTER TABLE product ADD (prdStock NUMBER(12), prdDate DATE);
-- product table의 prdCompany 컬럼을 NOT NULL로 변경
ALTER TABLE product MODIFY prdCompany NOT NULL;
-- publisher table에 pubPhone, pubAddress 컬럼 추가
ALTER TABLE publisher ADD (pubPhone VARCHAR2(15), pubAddress VARCHAR2(100));
-- publisher table의 pubPhone 컬럼을 삭제
ALTER TABLE publisher DROP COLUMN pubPhone;