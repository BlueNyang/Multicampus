package kr.bluenyang.practice.sec02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private java.sql.Date bookDate;
    private int bookStock;
    private String pubNo;
}
