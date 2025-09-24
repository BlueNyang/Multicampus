package kr.bluenyang.practice.book.dao;

import kr.bluenyang.practice.book.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> listAllBooks();

    Book findBookByNo(String bookNo);

    void insertBook(Book book);

    void updateBook(Book book);

    void deleteBook(String bookNo);
}
