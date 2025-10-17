CREATE TABLE prj_banners (
   id          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   image_title VARCHAR2(100) NOT NULL,
   image_alt   VARCHAR2(150),
   image_url   VARCHAR2(255) NOT NULL,
   link_url    VARCHAR2(255) NOT NULL,
   is_active   NUMBER(1) DEFAULT 1 CHECK ( is_active IN ( 0,
                                                        1 ) ),
   sort_order  NUMBER,
   created_at  TIMESTAMP DEFAULT current_timestamp,
   updated_at  TIMESTAMP DEFAULT current_timestamp
)

CREATE OR REPLACE TRIGGER trg_prj_banners_updated_at BEFORE
   UPDATE ON prj_banners
   FOR EACH ROW
BEGIN
   :new.updated_at := current_timestamp;
END;


CREATE INDEX idx_prj_banners_is_active ON
   prj_banners (
      is_active
   );
CREATE INDEX idx_prj_banners_sort_order ON
   prj_banners (
      sort_order
   );

   SET DEFINE OFF;

INSERT INTO prj_banners (
   image_title,
   image_alt,
   image_url,
   link_url,
   is_active,
   sort_order
)
   SELECT *
     FROM (
      SELECT 'KEYWORD SHOP' AS image_title,
             '#COFFEE & TEA, ~20% + EXTRA 10% OFF' AS image_alt,
             '/images/banners/176051531709868ef54f51d5b049b61ed099d.jpg' AS image_url,
             '/event/1' AS link_url,
             1 AS is_active,
             1 AS sort_order
        FROM dual
      UNION ALL
      SELECT 'BRAND WEEK',
             '#플러스 마이너스 제로, 오직 여기에서만 ~72%',
             '/images/banners/176051253504968ef4a17d960c3807e86b00f.jpg',
             '/event/2',
             1,
             2
        FROM dual
      UNION ALL
      SELECT '네거티브 쓰리',
             '단독 슬라우치 미들 부츠',
             '/images/banners/176051257908168ef4a436fd6e7a4e6b87c5d.jpg',
             '/event/3',
             1,
             3
        FROM dual
   );

COMMIT;

DROP TRIGGER trg_prj_banners_updated_at;
DROP TABLE prj_banners;