-- declaration of department table
CREATE TABLE department (
   dept_no   VARCHAR2(4),
   dept_name VARCHAR2(50),
    -- primary key constraint
   CONSTRAINT pk_dept_dept_no PRIMARY KEY ( dept_no ),
    -- not null constraints
   CONSTRAINT chk_dept_dept_no CHECK ( dept_no IS NOT NULL ),
   CONSTRAINT chk_dept_dept_name CHECK ( dept_name IS NOT NULL )
);

-- declaration of student table
CREATE TABLE student (
   s_no      VARCHAR2(8),
   s_name    VARCHAR2(30),
   s_dept_no VARCHAR2(4),
   s_year    NUMBER(4) DEFAULT 4,
    -- primary key constraint
   CONSTRAINT pk_student_s_no PRIMARY KEY ( s_no ),
    -- foreign key constraint
   CONSTRAINT fk_student_dept_no FOREIGN KEY ( s_dept_no )
      REFERENCES department ( dept_no ),
    -- not null constraints
   CONSTRAINT chk_student_s_no CHECK ( s_no IS NOT NULL ),
   CONSTRAINT chk_student_s_name CHECK ( s_name IS NOT NULL ),
   CONSTRAINT chk_student_s_dept_no CHECK ( s_dept_no IS NOT NULL ),
   CONSTRAINT chk_student_s_year CHECK ( s_year IS NOT NULL ),
    -- check constraint for year
   CONSTRAINT chk_student_s_year_range CHECK ( s_year BETWEEN 1 AND 4 )
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
   s_dept_no,
   s_year
)
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
     FROM dual;

-- commit the changes
COMMIT;