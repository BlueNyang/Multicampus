package kr.bluenyang.practice.sec02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private Date bookDate;
    private int bookStock;
    private String pubNo;

    public BookDTO(Book book) {
        this.bookNo = book.getBookNo();
        this.bookName = book.getBookName();
        this.bookAuthor = book.getBookAuthor();
        this.bookPrice = book.getBookPrice();
        this.bookDate = book.getBookDate();
        this.bookStock = book.getBookStock();
        this.pubNo = book.getPubNo();
    }

    public Book toEntity() {
        return new Book(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
    }
}
