CREATE TABLE product2 (
   prd_no      VARCHAR(10) NOT NULL PRIMARY KEY,
   prd_name    VARCHAR(30) NOT NULL,
   prd_price   INT,
   prd_company VARCHAR(30),
   prd_stock   INT,
   prd_date    DATE
);

INSERT INTO product2 VALUES ( '1001',
                              '노트북',
                              1000000,
                              '삼성',
                              10,
                              TO_DATE('2024/01/10','YYYY/MM/DD') );
INSERT INTO product2 VALUES ( '1002',
                              '모니터',
                              300000,
                              'LG',
                              5,
                              TO_DATE('2024/01/10','YYYY/MM/DD') );

COMMIT;

DROP TABLE product2;