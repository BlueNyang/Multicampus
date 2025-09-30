-- 장바구니 테이블
CREATE TABLE ex_cart (
   cart_no  NUMBER
      GENERATED ALWAYS AS IDENTITY START WITH 1 INCREMENT BY 1
   PRIMARY KEY,
   mem_id   VARCHAR(10),
   prd_no   VARCHAR(10),
   cart_qty INT,
   CONSTRAINT fk_ex_cart_member FOREIGN KEY ( mem_id )
      REFERENCES ex_member ( mem_id ),
   CONSTRAINT fk_ex_cart_product FOREIGN KEY ( prd_no )
      REFERENCES ex_product ( prd_no )
);