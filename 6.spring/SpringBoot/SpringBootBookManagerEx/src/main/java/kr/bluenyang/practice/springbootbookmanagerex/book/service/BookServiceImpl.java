package kr.bluenyang.practice.springbootbookmanagerex.book.service;

import kr.bluenyang.practice.book.dao.BookDAO;
import kr.bluenyang.practice.book.model.Book;
import kr.bluenyang.practice.book.model.BookDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Repository
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDAO dao;

    @Override
    public List<BookDTO> listAllBooks() {
        log.info("BookServiceImpl.listAlBooks - get List of All Books");

        List<Book> books = dao.listAllBooks();
        // Convert List<Book> to List<BookDTO>
        return books.stream().map(BookDTO::new).collect(Collectors.toList());
    }

    @Override
    public BookDTO findBookByNo(String bookNo) {
        log.info("BookServiceImpl.findBookByNo - find Book by bookNo: {}", bookNo);

        try {
            Book book = dao.findBookByNo(bookNo);
            return new BookDTO(book);
        } catch (Exception e) {
            log.warn("BookServiceImpl.findBookByNo - No book found with bookNo: {}", bookNo);
            return null;
        }
    }

    @Override
    public List<BookDTO> searchBooks(HashMap<String, Object> condition) {
        log.info("BookServiceImpl.searchBooks - search by condition. searchType: {}", condition.get("searchType"));

        // SearchType을 기준으로 검색 수행
        if ("bookName".equals(condition.get("searchType"))) {
            log.info("BookServiceImpl.searchBooks - search by bookName: {}", condition.get("searchValue"));

            // BookName으로 검색
            List<Book> books = dao.findBooksByName((String) condition.get("searchValue"));
            return books.stream().map(BookDTO::new).collect(Collectors.toList());

        } else if ("pubName".equals(condition.get("searchType"))) {
            log.info("BookServiceImpl.searchBooks - search by pubName: {}", condition.get("searchValue"));

            // PubName으로 검색
            List<Book> books = dao.findBooksByPubName((String) condition.get("searchValue"));
            return books.stream().map(BookDTO::new).collect(Collectors.toList());
        }

        log.info("BookServiceImpl.searchBooks - No search condition type matched");
        return Collections.emptyList();
    }

    @Override
    public boolean insertBook(BookDTO bookDTO) {
        log.info("BookServiceImpl.insertBook - insert book no: {}", bookDTO.getBookNo());
        try {
            dao.insertBook(bookDTO.toEntity());
        } catch (Exception e) {
            log.warn("BookServiceImpl.insertBook - insert book failed: {}", e.getMessage());

            // When an exception occurs, return false
            return false;
        }
        log.info("BookServiceImpl.insertBook - insert book successful");
        return true;
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        log.info("BookServiceImpl.updateBook - update book no: {}", bookDTO.getBookNo());
        try {
            dao.updateBook(bookDTO.toEntity());
        } catch (Exception e) {
            log.warn("BookServiceImpl.updateBook - update book failed: {}", e.getMessage());
            // When an exception occurs, return false
            return false;
        }
        log.info("BookServiceImpl.updateBook - update book successful");
        return true;
    }

    @Override
    public boolean deleteBook(String bookNo) {
        log.info("BookServiceImpl.deleteBook - delete book no: {}", bookNo);
        try {
            dao.deleteBook(bookNo);
        } catch (Exception e) {
            log.warn("BookServiceImpl.deleteBook - delete book failed: {}", e.getMessage());
            // When an exception occurs, return false
            return false;
        }
        log.info("BookServiceImpl.deleteBook - delete book successful");
        return true;
    }
}
