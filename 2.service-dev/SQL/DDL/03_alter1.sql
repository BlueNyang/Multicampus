CREATE TABLE product1 (
    prdNo VARCHAR2(10),
    prdName VARCHAR2(30),
    prdPrice NUMBER(8),
    prdCompany VARCHAR2(30),
    CONSTRAINT pk_product1_prdNo PRIMARY KEY (prdNo),
    CONSTRAINT chk_product1_prdNo CHECK (prdNo IS NOT NULL),
    CONSTRAINT chk_product1_prdName CHECK (prdName IS NOT NULL)
);

-- ALTER TABLE ADD
ALTER TABLE product1 ADD (prdUitPrice NUMBER(8), prdStock NUMBER(12));

-- Alter data type of column: ALTER TABLE table_name MODIFY column_name new_data_type;
ALTER TABLE product1 MODIFY prdUitPrice NUMBER(4);

-- Alter constraint(NOT NULL -> CAN NULL): ALTER TABLE p01_product1 MODIFY prdUnitPrice NULL;
ALTER TABLE product1 MODIFY prdName VARCHAR2(30) NULL;

-- Alter column name: ALTER TABLE table_name RENAME COLUMN old_column_name TO new_column_name;
ALTER TABLE product1 RENAME COLUMN prdUitPrice TO prdUnitPrice;

-- Delete column: ALTER TABLE table_name DROP COLUMN column_name;
ALTER TABLE product1 DROP COLUMN prdStock;

-- Delete multiple columns: ALTER TABLE table_name DROP (column_name1, column_name2);
ALTER TABLE product1 DROP (prdCompany, prdPrice);