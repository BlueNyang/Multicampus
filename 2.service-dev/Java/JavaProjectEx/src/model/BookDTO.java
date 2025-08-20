package model;

import java.util.Date;

public class BookDTO {
    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private Date bookDate;
    private int bookStock;
    private String pubNo;

    public BookDTO(String bookNo, String bookName, String bookAuthor, int bookPrice, Date bookDate, int bookStock, String pubNo) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookDate = bookDate;
        this.bookStock = bookStock;
        this.pubNo = pubNo;
    }

    public static BookDTO from(Book book) {
        return new BookDTO(book.getBookNo(), book.getBookName(), book.getBookAuthor(),
                book.getBookPrice(), book.getBookDate(), book.getBookStock(), book.getPubNo());
    }

    public Book toEntity() {
        return new Book(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public String getPubNo() {
        return pubNo;
    }

    public void setPubNo(String pubNo) {
        this.pubNo = pubNo;
    }

    @Override
    public String toString() {
        return bookNo + "\t" + bookName + "\t" + bookAuthor + "\t" +
                bookPrice + "\t" + bookDate + "\t" + bookStock + "\t" + pubNo;
    }
}
