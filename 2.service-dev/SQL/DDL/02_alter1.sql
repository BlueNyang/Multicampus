CREATE TABLE product1 (
   prd_no      VARCHAR2(10),
   prd_name    VARCHAR2(30),
   prd_price   NUMBER(8),
   prd_company VARCHAR2(30),
   CONSTRAINT pk_product1_prd_no PRIMARY KEY ( prd_no ),
   CONSTRAINT chk_product1_prd_no CHECK ( prd_no IS NOT NULL ),
   CONSTRAINT chk_product1_prd_name CHECK ( prd_name IS NOT NULL )
);

-- ALTER TABLE ADD
ALTER TABLE product1 ADD (
   prd_unit_price NUMBER(8),
   prd_stock      NUMBER(12)
);

-- Alter data type of column: ALTER TABLE table_name MODIFY column_name new_data_type;
ALTER TABLE product1 MODIFY
   prd_unit_price NUMBER(4);

-- Alter constraint(NOT NULL -> CAN NULL): ALTER TABLE p01_product1 MODIFY prd_unit_price NULL;
ALTER TABLE product1 MODIFY
   prd_name VARCHAR2(30) NULL;

-- Alter column name: ALTER TABLE table_name RENAME COLUMN old_column_name TO new_column_name;
ALTER TABLE product1 RENAME COLUMN prd_unit_price TO prd_unit_price;

ALTER TABLE product1 RENAME COLUMN prd_unit_price TO prd_unit_price;

-- Delete column: ALTER TABLE table_name DROP COLUMN column_name;
ALTER TABLE product1 DROP COLUMN prd_stock;

-- Delete multiple columns: ALTER TABLE table_name DROP (column_name1, column_name2);
ALTER TABLE product1 DROP ( prd_company,
                            prd_price );

-- declaration of department table
CREATE TABLE department (
   dept_no   VARCHAR2(4),
   dept_name VARCHAR2(50) NOT NULL,
    -- primary key constraint
   CONSTRAINT pk_department_dept_no PRIMARY KEY ( dept_no )
);

-- declaration of student table
CREATE TABLE student (
   s_no    VARCHAR2(8),
   s_name  VARCHAR2(30) NOT NULL,
   dept_no VARCHAR2(4) NOT NULL,
   s_year  NUMBER(4) DEFAULT 4 NOT NULL,
    -- primary key constraint
   CONSTRAINT pk_student_s_no PRIMARY KEY ( s_no ),
    -- foreign key constraint
   CONSTRAINT fk_student_dept_no FOREIGN KEY ( dept_no )
      REFERENCES department ( dept_no ),
    -- check constraint for year
   CONSTRAINT chk_student_s_year CHECK ( s_year BETWEEN 1 AND 4 )
);

-- insert sample data into department
INSERT INTO department (
   dept_no,
   dept_name
)
   SELECT *
     FROM (
      SELECT '001',
             'Computer Science'
        FROM dual
      UNION ALL
      SELECT '002',
             'Electrical Engineering'
        FROM dual
      UNION ALL
      SELECT '003',
             'Mechanical Engineering'
        FROM dual
   );

-- insert sample data into student
INSERT INTO student (
   s_no,
   s_name,
   dept_no,
   s_year
)
   SELECT *
     FROM (
      SELECT 'S001',
             'Alice',
             '001',
             2
        FROM dual
      UNION ALL
      SELECT 'S002',
             'Bob',
             '002',
             3
        FROM dual
      UNION ALL
      SELECT 'S003',
             'Charlie',
             '003',
             1
        FROM dual
   );

-- commit the changes
COMMIT;

-- 교수 테이블
CREATE TABLE professor (
   prof_no       VARCHAR2(10),
   prof_name     VARCHAR2(30) NOT NULL,
   prof_position VARCHAR2(30),
   prof_tel      VARCHAR2(13),
   dept_no       VARCHAR2(4) NOT NULL,
   CONSTRAINT pk_professor_prof_no PRIMARY KEY ( prof_no ),
   CONSTRAINT fk_professor_dept_no FOREIGN KEY ( dept_no )
      REFERENCES department ( dept_no )
);

-- 과목 테이블
CREATE TABLE course (
   course_id     VARCHAR2(10),
   course_name   VARCHAR2(30) NOT NULL,
   course_credit NUMBER(3),
   prof_no       VARCHAR2(10) NOT NULL,
   CONSTRAINT pk_course_course_id PRIMARY KEY ( course_id ),
   CONSTRAINT fk_course_prof_no FOREIGN KEY ( prof_no )
      REFERENCES professor ( prof_no )
);

CREATE TABLE scores (
   s_no      VARCHAR2(8),
   course_id VARCHAR2(10) NOT NULL,
   score     NUMBER(3),
   grade     VARCHAR2(2),
   CONSTRAINT pk_scores PRIMARY KEY ( s_no,
                                      course_id ),
   CONSTRAINT fk_scores_student FOREIGN KEY ( s_no )
      REFERENCES student ( s_no ),
   CONSTRAINT fk_scores_course FOREIGN KEY ( course_id )
      REFERENCES course ( course_id ),
   CONSTRAINT chk_scores_score CHECK ( score BETWEEN 0 AND 100 )
);

-- 기본키 삭제: 기본키는 반드시 있어야 하는 건 아님.
-- 단, 릴레이션 논리적 특징을 유지하기 위해 기본키는 설정해야 함.
-- 학생 테이블 교수테이블이 참조하고 있음 - 외부테이블 참조 기본키는 참조 오류로 기본키 제약 조건 삭제 불가
ALTER TABLE department DROP PRIMARY KEY;

-- 제약조건(참조제약) 무시 무조건 기본키 삭제 - CASCADE
-- 참조하는 외래키 제약조건이 같이 삭제됨
ALTER TABLE department DROP PRIMARY KEY CASCADE;

-- 기본 제약조건 추가
ALTER TABLE department ADD CONSTRAINT pk_dept_dept_no PRIMARY KEY ( dept_no );

ALTER TABLE student
   ADD CONSTRAINT fk_student_dept_no FOREIGN KEY ( dept_no )
      REFERENCES department ( dept_no );

ALTER TABLE professor
   ADD CONSTRAINT fk_professor_dept_no FOREIGN KEY ( dept_no )
      REFERENCES department ( dept_no );

-- 외래키 제약조건 삭제: DROP CONSTRAINT 제약조건명
ALTER TABLE student DROP CONSTRAINT fk_student_dept_no;

ALTER TABLE professor DROP CONSTRAINT fk_professor_dept_no;

-- 기본키 삭제 - 참조하고 있는 다른 테이블이 없으면 삭제됨
ALTER TABLE department DROP PRIMARY KEY;

-- CONSTRAINTS 확인
SELECT *
  FROM user_constraints;

SELECT *
  FROM user_constraints
 WHERE table_name = 'STUDENT';

-- 제약조건 타입
-- C: Check on a table, Check, Not Null
-- P: Primary Key
-- F: Foreign Key
--------------
ALTER TABLE department ADD CONSTRAINT pk_dept_dept_no PRIMARY KEY ( dept_no );

-- data가 삭제되는 경우 삭제되는 records가 다른 table에서 referenced 되고 있는 경우, data 삭제에 제약을 받음
ALTER TABLE student
   ADD CONSTRAINT fk_student_dept_no
      FOREIGN KEY ( dept_no )
         REFERENCES department ( dept_no )
            ON DELETE CASCADE;