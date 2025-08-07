-- declaration of department table
CREATE TABLE department (
    deptNo VARCHAR2(4),
    deptName VARCHAR2(50),
	-- primary key constraint
    CONSTRAINT pk_dept_deptNo PRIMARY KEY (deptNo),
    -- not null constraints
    CONSTRAINT chk_dept_deptNo CHECK (deptNo IS NOT NULL),
    CONSTRAINT chk_dept_deptName CHECK (deptName IS NOT NULL)
);

-- declaration of student table
CREATE TABLE student (
    sNo VARCHAR2(8),
    sName VARCHAR2(30),
    sDeptNo VARCHAR2(4),
    sYear NUMBER(4) DEFAULT 4,
    -- primary key constraint
    CONSTRAINT pk_student_sNo PRIMARY KEY (sNo),
    -- foreign key constraint
    CONSTRAINT fk_student_deptNo FOREIGN KEY (sDeptNo) REFERENCES department(deptNo),
    -- not null constraints
    CONSTRAINT chk_student_sNo CHECK (sNo IS NOT NULL),
    CONSTRAINT chk_nn_student_sName CHECK (sName IS NOT NULL),
    CONSTRAINT chk_nn_student_sDeptNo CHECK (sDeptNo IS NOT NULL),
    CONSTRAINT chk_nn_student_sYear CHECK (sYear IS NOT NULL),
    -- check constraint for year
    CONSTRAINT chk_student_sYear CHECK (sYear BETWEEN 1 AND 4)
);

-- insert sample data into department
INSERT INTO department (deptNo, deptName)
SELECT * FROM (
    SELECT '001', 'Computer Science' FROM dual
    UNION ALL
    SELECT '002', 'Electrical Engineering' FROM dual
    UNION ALL
    SELECT '003', 'Mechanical Engineering' FROM dual
);

-- insert sample data into student
INSERT INTO student (sNo, sName, sDeptNo, sYear)
SELECT 'S001', 'Alice', '001', 2 FROM dual UNION ALL
SELECT 'S002', 'Bob', '002', 3 FROM dual UNION ALL
SELECT 'S003', 'Charlie', '003', 1 FROM dual;


-- commit the changes
COMMIT;