package kr.bluenyang.practice.book.service;

import kr.bluenyang.practice.book.model.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> listAllBooks();

    BookDTO findBookByNo(String bookNo);

    boolean insertBook(BookDTO bookDTO);

    boolean updateBook(BookDTO bookDTO);

    boolean deleteBook(String bookNo);
}
