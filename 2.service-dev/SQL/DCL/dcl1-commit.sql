-- commit/rollback

-- commit
-- 트랜잭션 처리가 정상적으로 종료되었음을 알리는 명령어
-- 트랜잭션이 수행한 변경 내용을 DB에 반영
-- 트랜잭션이 commit에 의해 완료되면 db는 영구적으로 변경.
-- 오류가 발생해도 영구 반영 됨

-- rollback
-- 트랜잭션 처리가 비정상적으로 종료되었음을 알리는 명령어
-- 트랜잭션이 수행한 변경 내용을 DB에 반영하지 않음
-- DB의 일관성이 깨진 경우 rollback을 수행하여 이전 상태로 복구.

INSERT INTO book VALUES ( '12345678',
                          'booktest',
                          'test',
                          33000,
                          TO_DATE('2020-01-01','YYYY-MM-DD'),
                          5,
                          '1' );

SELECT *
  FROM book;

ROLLBACK;

SELECT *
  FROM book;

INSERT INTO book VALUES ( '12345678',
                          'booktest1',
                          'test2',
                          33000,
                          TO_DATE('2020-01-01','YYYY-MM-DD'),
                          5,
                          '1' );

COMMIT;

INSERT INTO book VALUES ( '22345678',
                          'booktest2',
                          'test2',
                          33000,
                          TO_DATE('2020-01-01','YYYY-MM-DD'),
                          5,
                          '1' );

ROLLBACK; -- rollback to last commit

SELECT *
  FROM book;

DELETE FROM book
 WHERE book_no = '12345678';

COMMIT;

SELECT *
  FROM book;