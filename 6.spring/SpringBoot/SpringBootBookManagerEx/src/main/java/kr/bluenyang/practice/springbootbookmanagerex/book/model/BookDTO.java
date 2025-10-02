package kr.bluenyang.practice.springbootbookmanagerex.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// DTO (Data Transfer Object) for Book
public class BookDTO {
    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private Date bookDate;
    private int bookStock;
    private String pubName;

    // Constructor to create BookDTO from Book entity
    public BookDTO(Book book) {
        this.bookNo = book.getBookNo();
        this.bookName = book.getBookName();
        this.bookAuthor = book.getBookAuthor();
        this.bookPrice = book.getBookPrice();
        this.bookDate = book.getBookDate();
        this.bookStock = book.getBookStock();
        this.pubName = book.getPubName();
    }

    // Method to convert BookDTO to Book entity
    public Book toEntity() {
        return new Book(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubName);
    }
}
