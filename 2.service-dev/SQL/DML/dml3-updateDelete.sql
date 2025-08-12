-- update 문
-- 특정 열의 값을 변경하는 문
-- default style
-- UPDATE table_name SET attr=value WHERE condition;
UPDATE product
   SET
   prd_name = 'UHD TV'
 WHERE prd_no = '5';

-- delete
-- 테이블의 기존 행을 삭제함
-- DELETE FROM table_name [WHERE condition];
-- DELETE 문으로 모든 행을 삭제하더라도 테이블(구조)는 유지됨
DELETE FROM product
 WHERE prd_name = '그늘막 텐트';

-- DELETE문의 반화 결과는 몇개 행이 삭제 되었는지에 대한 결과가 반환됨
-- 삭제한 내용이 없으면 0개 행이 삭제되었다는 결과 반환
SELECT *
  FROM product;

COMMIT;