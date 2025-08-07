-- 1. Create a table named "product" with the following columns:
CREATE TABLE product (
    prdNo VARCHAR2(10) PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30)
);

-- 2. PRIMARY KEY를 따로 설정
CREATE TABLE product2 (
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    PRIMARY KEY (prdNo)
);

-- 3. 제약 이름과 같이 설정: 제약 변경이나 삭제시 유용
CREATE TABLE product1 (
    prdNo VARCHAR2(10) NOT NULL CONSTRAINT pk_product1_prdNo PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30)
);

--4. 따로 설정
CREATE TABLE product2 (
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    CONSTRAINT pk_product2_prdNo PRIMARY KEY (prdNo)
);