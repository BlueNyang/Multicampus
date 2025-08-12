-- table 복사
CREATE TABLE new_book
   AS
      SELECT *
        FROM book
       WHERE book_date >= TO_DATE('2019-01-01','yyyy-mm-dd');

SELECT *
  FROM new_book;

ALTER TABLE new_book ADD CONSTRAINT pk_new_book PRIMARY KEY ( book_no );

-- new_book data 삭제
DELETE FROM new_book;

SELECT *
  FROM new_book;

COMMIT;