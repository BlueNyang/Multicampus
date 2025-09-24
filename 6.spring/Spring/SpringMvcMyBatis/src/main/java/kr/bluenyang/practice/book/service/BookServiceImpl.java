package kr.bluenyang.practice.book.service;

import kr.bluenyang.practice.book.dao.BookDAO;
import kr.bluenyang.practice.book.model.Book;
import kr.bluenyang.practice.book.model.BookDTO;
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
    public boolean insertBook(BookDTO bookDTO) {
        try {
            dao.insertBook(bookDTO.toEntity());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        try {
            dao.updateBook(bookDTO.toEntity());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteBook(String bookNo) {
        try {
            dao.deleteBook(bookNo);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
