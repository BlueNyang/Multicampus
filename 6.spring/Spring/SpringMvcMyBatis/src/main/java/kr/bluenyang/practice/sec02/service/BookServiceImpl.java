package kr.bluenyang.practice.sec02.service;

import kr.bluenyang.practice.sec02.dao.BookDAO;
import kr.bluenyang.practice.sec02.model.Book;
import kr.bluenyang.practice.sec02.model.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Repository
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDAO dao;

    @Override
    public List<BookDTO> listAllBooks() {
        List<Book> books = dao.listAllBooks();
        return books.stream().map(BookDTO::new).collect(Collectors.toList());
    }

    @Override
    public BookDTO findBookByNo(String bookNo) {
        Book book = dao.findBookByNo(bookNo);
        return new BookDTO(book);
    }

    @Override
    public void insertBook(BookDTO bookDTO) {
        dao.insertBook(bookDTO.toEntity());
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        dao.updateBook(bookDTO.toEntity());
    }

    @Override
    public void deleteBook(String bookNo) {
        dao.deleteBook(bookNo);
    }
}
