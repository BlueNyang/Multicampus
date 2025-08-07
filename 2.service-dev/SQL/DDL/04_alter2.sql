-- declaration of department table
CREATE TABLE department (
    deptNo VARCHAR2(4),
    deptName VARCHAR2(50) NOT NULL,
    -- primary key constraint
    CONSTRAINT pk_department_deptNo PRIMARY KEY (deptNo)
);

-- declaration of student table
CREATE TABLE student (
    sNo VARCHAR2(8),
    sName VARCHAR2(30) NOT NULL,
    deptNo VARCHAR2(4) NOT NULL,
    sYear NUMBER(4) DEFAULT 4 NOT NULL,
    -- primary key constraint
    CONSTRAINT pk_student_sNo PRIMARY KEY (sNo),
    -- foreign key constraint
    CONSTRAINT fk_student_deptNo FOREIGN KEY (deptNo) REFERENCES department(deptNo),
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
INSERT INTO student (sNo, sName, deptNo, sYear)
SELECT * FROM (
    SELECT 'S001', 'Alice', '001', 2 FROM dual
    UNION ALL
    SELECT 'S002', 'Bob', '002', 3 FROM dual
    UNION ALL
    SELECT 'S003', 'Charlie', '003', 1 FROM dual
);

-- commit the changes
COMMIT;

-- 교수 테이블
CREATE TABLE professor (
	profNo VARCHAR2(10),
    profName VARCHAR2(30) NOT NULL,
    profPosition VARCHAR2(30),
    profTel VARCHAR2(13),
    deptNo VARCHAR2(4) NOT NULL,
    CONSTRAINT pk_professor_profNo PRIMARY KEY (profNo),
    CONSTRAINT fk_professor_deptNo FOREIGN KEY (deptNo) REFERENCES department(deptNo)
);

-- 과목 테이블
CREATE TABLE course (
	courseId VARCHAR2(10),
    courseName VARCHAR2(30) NOT NULL,
    courseCredit NUMBER(3),
    profNo VARCHAR2(10) NOT NULL,
    CONSTRAINT pk_course_courseId PRIMARY KEY (courseId),
    CONSTRAINT fk_course_profNo FOREIGN KEY (profNo) REFERENCES professor(profNo)
);

CREATE TABLE scores (
    sNo VARCHAR2(8),
    courseId VARCHAR2(10) NOT NULL,
    score NUMBER(3),
    grade VARCHAR2(2),
    CONSTRAINT pk_scores PRIMARY KEY (sNo, courseId),
    CONSTRAINT fk_scores_student FOREIGN KEY (sNo) REFERENCES student(sNo),
    CONSTRAINT fk_scores_course FOREIGN KEY (courseId) REFERENCES course(courseId),
    CONSTRAINT chk_scores_score CHECK (score BETWEEN 0 AND 100)
);

-- 기본키 삭제: 기본키는 반드시 있어야 하는 건 아님.
-- 단, 릴레이션 논리적 특징을 유지하기 위해 기본키는 설정해야 함.
-- 학생 테이블 교수테이블이 참조하고 있음 - 외부테이블 참조 기본키는 참조 오류로 기본키 제약 조건 삭제 불가
ALTER TABLE department
DROP PRIMARY KEY;

-- 제약조건(참조제약) 무시 무조건 기본키 삭제 - CASCADE
-- 참조하는 외래키 제약조건이 같이 삭제됨
ALTER TABLE department
DROP PRIMARY KEY CASCADE;

-- 기본 제약조건 추가
ALTER TABLE department
ADD CONSTRAINT pk_dept_deptNo
PRIMARY KEY (deptNo);

ALTER TABLE student 
ADD CONSTRAINT fk_student_deptNo
FOREIGN KEY (deptNo) REFERENCES department(deptNo);

ALTER TABLE professor
ADD CONSTRAINT fk_professor_deptNo
FOREIGN KEY (deptNo) REFERENCES department(deptNo);

-- 외래키 제약조건 삭제: DROP CONSTRAINT 제약조건명
ALTER TABLE student
DROP CONSTRAINT fk_student_deptNo;

ALTER TABLE professor
DROP CONSTRAINT fk_professor_deptNo;

-- 기본키 삭제 - 참조하고 있는 다른 테이블이 없으면 삭제됨
ALTER TABLE department
DROP PRIMARY KEY;

-- CONSTRAINTS 확인
SELECT *
FROM USER_CONSTRAINTS;

SELECT * 
FROM USER_CONSTRAINTS
WHERE TABLE_NAME='STUDENT';

-- 제약조건 타입
-- C: Check on a table, Check, Not Null
-- P: Primary Key
-- F: Foreign Key

--------------
ALTER TABLE department
ADD CONSTRAINT pk_dept_deptNo
PRIMARY KEY (deptNo);

-- data가 삭제되는 경우 삭제되는 records가 다른 table에서 referenced 되고 있는 경우, data 삭제에 제약을 받음
ALTER TABLE student 
ADD CONSTRAINT fk_student_deptNo
FOREIGN KEY (deptNo) REFERENCES department(deptNo)
ON DELETE CASCADE;
