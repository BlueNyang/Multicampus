CREATE TABLE ex_member (
   mem_id        VARCHAR2(10) PRIMARY KEY,
   mem_pwd       VARCHAR2(100),
   mem_name      VARCHAR2(30),
   mem_email     VARCHAR2(30),
   mem_join_date DATE DEFAULT sysdate,
   mem_hp        VARCHAR2(13),
   mem_zip_code  VARCHAR2(13),
   mem_address1  VARCHAR2(30),
   mem_address2  VARCHAR2(30)
);

INSERT INTO ex_member (
   mem_id,
   mem_pwd,
   mem_name,
   mem_email,
   mem_join_date,
   mem_hp,
   mem_zip_code,
   mem_address1,
   mem_address2
)
   SELECT *
     FROM (
      SELECT 'hong' AS mem_id,
             '1234' AS mem_pwd,
             '홍길동 ' AS mem_name,
             'hkd@naver.com' AS mem_email,
             TO_DATE('2024-08-29','YYYY-MM-DD') AS mem_join_date,
             '010-1234-1234' AS mem_hp,
             '12345' AS mem_zip_code,
             '서울 강남구' AS mem_address1,
             '11번지' AS mem_address2
        FROM dual
      UNION ALL
      SELECT 'lee',
             '1234',
             '이몽룡',
             'lee@naver.com',
             TO_DATE('2024-08-29','YYYY-MM-DD'),
             '010-1111-1111',
             '12345',
             '경기 안양시',
             '100번지'
        FROM dual
      UNION ALL
      SELECT 'sch',
             '1234',
             '성춘향',
             'sch@naver.com',
             TO_DATE('2024-08-29','YYYY-MM-DD'),
             '010-2222-2222',
             '12345',
             '제주 제주시',
             '1번지'
        FROM dual
      UNION ALL
      SELECT 'cha',
             '1234',
             '차철수',
             'cha@naver.com',
             TO_DATE('2024-08-29','YYYY-MM-DD'),
             '010-3333-3333',
             '12345',
             '인천 강화군',
             '50번지'
        FROM dual
   );

COMMIT;

DROP TABLE ex_member;