package kr.bluenyang.practice.springbootbookmanagerex.book.service;

import kr.bluenyang.practice.springbootbookmanagerex.book.model.BookDTO;

import java.util.HashMap;
import java.util.List;

/**
 * Service interface for managing books.
 */
public interface BookService {

    /**
     * Retrieve a list of all books.
     *
     * @return List of BookDTO objects.
     */
    List<BookDTO> listAllBooks();

    /**
     * Find a book by its unique identifier.
     *
     * @param bookNo The unique identifier of the book.
     * @return The BookDTO object if found, otherwise null.
     */
    BookDTO findBookByNo(String bookNo);

    /**
     * Find books by their name.
     *
     * @param condition A HashMap containing search conditions, including "searchType" and "searchValue".
     * @return List of BookDTO objects matching the book name.
     */
    List<BookDTO> searchBooks(HashMap<String, Object> condition);

    /**
     * Insert a new book into the system.
     *
     * @param bookDTO The BookDTO object containing book details.
     * @return true if the insertion was successful, false otherwise.
     */
    boolean insertBook(BookDTO bookDTO);

    /**
     * Update an existing book's details.
     *
     * @param bookDTO The BookDTO object containing updated book details.
     * @return true if the update was successful, false otherwise.
     */
    boolean updateBook(BookDTO bookDTO);

    /**
     * Delete a book by its unique identifier.
     *
     * @param bookNo The unique identifier of the book to be deleted.
     * @return true if the deletion was successful, false otherwise.ㄴ
     */
    boolean deleteBook(String bookNo);
}
