-- 상품분류테이블
CREATE TABLE ex_category (
   ctg_id   VARCHAR2(2) PRIMARY KEY,
   ctg_name VARCHAR2(30)
);

INSERT INTO ex_category
   SELECT *
     FROM (
      SELECT '1' AS ctg_id,
             '노트북' AS ctg_name
        FROM dual
      UNION ALL
      SELECT '2',
             '프린터'
        FROM dual
      UNION ALL
      SELECT '3',
             '마우스'
        FROM dual
      UNION ALL
      SELECT '4',
             '키보드'
        FROM dual
   );

COMMIT;

DROP TABLE ex_category;