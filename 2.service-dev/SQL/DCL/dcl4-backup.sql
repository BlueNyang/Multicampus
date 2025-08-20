-- 백업 및 복구
-- CONNECT, RESOURCE 권한 필요
-- sql developer > tools > export 이후 pivottest drop 및 복구
COMMIT;
DROP TABLE pivottest;

-- console에서 백업 및 복구
-- 백업(덤프, 익스포트)
-- 사용자단위
-- exp userid=계정명/비밀번호 file='PATH/fulldb.dmp' full=y
-- 백업 후 복구
-- imp userid=계정명/비밀번호 file='PATH/fulldb.dmp'