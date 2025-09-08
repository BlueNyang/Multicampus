CREATE TABLE member (
   mem_id       VARCHAR2(20) PRIMARY KEY,
   mem_pwd      VARCHAR2(50) NOT NULL,
   mem_name     VARCHAR2(50) NOT NULL,
   mem_email    VARCHAR2(100) UNIQUE NOT NULL,
   mem_joindate DATE DEFAULT sysdate,
   mem_salt     VARCHAR2(50)
);

DROP TABLE member;

INSERT INTO member
   SELECT *
     FROM (
      SELECT 'user1' AS mem_id,
             'pass1' AS mem_pwd,
             'Alice' AS mem_name,
             'alice@example.com' AS mem_email,
             sysdate AS mem_joindate,
             NULL AS mem_salt
        FROM dual
      UNION ALL
      SELECT 'user2',
             'pass2',
             'Bob',
             'bob@example.com',
             sysdate,
             NULL
        FROM dual
   );

COMMIT;