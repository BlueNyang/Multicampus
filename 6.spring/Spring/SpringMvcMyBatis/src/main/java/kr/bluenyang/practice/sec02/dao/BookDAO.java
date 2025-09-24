package kr.bluenyang.practice.sec02.dao;

import kr.bluenyang.practice.sec02.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> listAllBooks();

    Book findBookByNo(String bookNo);

    void insertBook(Book book);

    void updateBook(Book book);

    void deleteBook(String bookNo);
}
