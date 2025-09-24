package kr.bluenyang.practice.sec02.service;

import kr.bluenyang.practice.sec02.model.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> listAllBooks();

    BookDTO findBookByNo(String bookNo);

    void insertBook(BookDTO bookDTO);

    void updateBook(BookDTO bookDTO);

    void deleteBook(String bookNo);
}
