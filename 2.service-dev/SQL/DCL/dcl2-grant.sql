-- DCL

-- GRANT: DB object에 권한 부여
-- REVOKE: DB object에 부여된 권한을 회수

-- 권한: execution 또는 access할 수 있는 권리
-- 권한 종류: SYSTEM 권한, OBJECT 권한

-- SYSTEM 권한: DBA account에 부여되는 권한 (최상위 권한). 사용자 생성/삭제, 모든 CREATE 권한, 모든 access 권한
-- OBJECT 권한: 특정 DB object에 대한 권한 (예: SELECT, INSERT, UPDATE, DELETE).

-- ROLE: 사용자에게 특정 DB object에 대한 권한을 부여
-- CONNECT: 데이터베이스에 접속할 수 있는 권한 (ALTER SESSION)
-- RESOURCE: 데이터베이스 자원에 대한 권한 (예: TEMPORARY TABLESPACE 사용)
-- DBA: 데이터베이스 관리에 필요한 권한 (예: 사용자 관리, 테이블스페이스 관리)

-- --------------------------------------------------------------
-- Create User account
CREATE USER newuser IDENTIFIED BY "1234"
   DEFAULT TABLESPACE users
   TEMPORARY TABLESPACE temp;

-- 일반 사용자 ROLL 부여
GRANT connect,resource TO newuser;


-- 사용자 테이블 스페이스 할당량 지정 (ALTER)
ALTER USER newuser10
   QUOTA UNLIMITED ON users; -- 테이블스페이스 무제한 활용

-- 할당량 제한(변경)
ALTER USER newuser
   QUOTA 50M ON users;

-- 사용자 계정 생성 시 할당량 부여
CREATE USER newuser2 IDENTIFIED BY "1234"
   DEFAULT TABLESPACE users
   TEMPORARY TABLESPACE temp
   QUOTA 10M ON users;

GRANT connect,resource TO newuser2;    

-- NEWUSER2에 부여된 CONNECT 롤 제거
REVOKE connect FROM newuser2; -- DB접속과 관련된 ROLL제거했으므로 접속이 제한됨

-- CONNECT 권한만 부여
GRANT connect TO newuser2;

-- NEWUSER2에 대해 새로운 비밀번호 변경
ALTER USER newuser2 IDENTIFIED BY 1111;

-- 현재 접속 사용자 조회
SHOW USER;

-- 현재 DB에 생성된 계정 (계정정보) 확인
-- DAB_USERS / ALL_USERS/ USER_USERS

-- DBA 권한으로만 사용할 수 있는 계정정보 테이블
SELECT *
  FROM dba_users;
SELECT *
  FROM all_users;
SELECT *
  FROM user_users; -- 현재 계정에 대한 정보 조회

-- 객체에 대한 정보 확인
-- DBA_XXX : DBA 권한으로 확인가능
SELECT *
  FROM dba_tables;

-- ALL_XXX : DBA권한보다 낮으면서 부여된 권한으로 조회할 수 있는 객체 확인
SELECT *
  FROM all_tables;

-- USER_XXX : 자신이 생성한 모든 객체에 대한 정보
SELECT *
  FROM user_tables;

-- 계정 삭제

DROP USER newuser;
DROP USER newuser CASCADE;

REVOKE connect,resource FROM newuser2;

-- 계정에 부여된 롤 제거
REVOKE resource FROM newuser;

SELECT *
  FROM dba_role_privs
 WHERE grantee = 'NEWUSER';

-- 모든 사용자에게 부여된 롤 조회
SELECT grantee,
       granted_role
  FROM dba_role_privs
 WHERE grantee = 'NEWUSER';
 
-- ROLE에 부여된 권한 조회
SELECT *
  FROM dba_sys_privs
 WHERE grantee = 'RESOURCE';
 
-- ROLE에 부여된 권한 조회
SELECT *
  FROM dba_sys_privs
 WHERE grantee = 'CONNECT';