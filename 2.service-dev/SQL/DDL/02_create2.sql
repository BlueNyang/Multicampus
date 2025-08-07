-- 출판사 테이블 먼저 생성 후 도서테이블 생성 (외래키 제약조건 때문)
-- 외래키 필드에 입력되는 값은 참조테이블의 기본키로서 값과 동일해야 함
-- 외래키 필드의 도메인과 참조 테이블의 기본키 도메인은 동일해야 함
CREATE TABLE publisher (
    pubNo VARCHAR2(10) NOT NULL,
    pubName VARCHAR2(30) NOT NULL,
    CONSTRAINT pk_publisher_pubNo PRIMARY KEY (pubNo)
);

CREATE TABLE book (
    bookNo VARCHAR2(10),
    bookName VARCHAR2(30),
    bookPrice NUMBER(8) DEFAULT 10000,
    bookDate DATE,
    pubNo VARCHAR2(10),
    CONSTRAINT pk_book_bookNo PRIMARY KEY (bookNo),
    CONSTRAINT fk_book_pubNo FOREIGN KEY (pubNo) REFERENCES publisher(pubNo),
    CONSTRAINT chk_book_bookNo CHECK (bookNo IS NOT NULL),
    CONSTRAINT chk_book_bookName CHECK (bookName IS NOT NULL),
    CONSTRAINT chk_book_bookPrice CHECK (bookPrice > 1000),
    CONSTRAINT chk_book_pubNo CHECK (pubNo IS NOT NULL)
);