-- 주문 테이블
CREATE TABLE ex_order_info (
   ord_no          VARCHAR(20) PRIMARY KEY,
   ord_date        TIMESTAMP DEFAULT sysdate,
   mem_id          VARCHAR(10),
   ord_receiver    VARCHAR(30),
   ord_rcvzipcode  VARCHAR(6),
   ord_rcvaddress1 VARCHAR(50),
   ord_rcvaddress2 VARCHAR(50),
   ord_rcvphone    VARCHAR(14),
   ord_rcvmsg      VARCHAR(30),
   ord_pay         VARCHAR(30),
   CONSTRAINT fk_ex_order_member FOREIGN KEY ( mem_id )
      REFERENCES ex_member ( mem_id )
);

-- 주문 상품 및 수량
CREATE TABLE ex_order_product (
   ord_no  VARCHAR2(20),
   prd_no  VARCHAR2(10),
   ord_qty INT,
   CONSTRAINT fk_ex_order_product FOREIGN KEY ( prd_no )
      REFERENCES ex_product ( prd_no ),
   CONSTRAINT fk_ex_order_prd_info FOREIGN KEY ( ord_no )
      REFERENCES ex_order_info ( ord_no )
);

-- DROP TABLE ex_order_product;
-- DROP TABLE ex_order_info;