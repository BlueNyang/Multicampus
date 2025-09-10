CREATE TABLE member2 (
   mem_id        VARCHAR2(10) PRIMARY KEY,
   mem_pwd       VARCHAR2(10) NOT NULL,
   mem_name      VARCHAR2(30),
   mem_email     VARCHAR2(50),
   mem_join_date DATE DEFAULT ( current_date )
);

INSERT INTO member2 (
   mem_id,
   mem_pwd,
   mem_name,
   mem_email
)
   SELECT *
     FROM (
      SELECT 'kim',
             '1234',
             '김철수',
             'kim@example.com'
        FROM dual
      UNION ALL
      SELECT 'lee',
             '1111',
             '이영희',
             'lee@example.com'
        FROM dual
      UNION ALL
      SELECT 'park',
             '2222',
             '박민수',
             'park@example.com'
        FROM dual
   );

COMMIT;