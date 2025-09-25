package kr.bluenyang.practice.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    // Fields
    // 도서 번호, 도서명, 저자, 가격, 출판일, 재고, 출판사번호
    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private java.sql.Date bookDate;
    private int bookStock;
    private String pubNo;
}
