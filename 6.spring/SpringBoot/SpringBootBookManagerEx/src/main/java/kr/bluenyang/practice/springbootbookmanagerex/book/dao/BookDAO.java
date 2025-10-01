package kr.bluenyang.practice.springbootbookmanagerex.book.dao;

import kr.bluenyang.practice.book.model.Book;

import java.util.List;

/**
 * @description : BookDAO interface for managing book record
 * @writer: bluenyang
 */
public interface BookDAO {

    /**
     * Get all book records
     *
     * @return List of Book objects
     */
    List<Book> listAllBooks();

    /**
     * Find a book by its book number.
     *
     * @param bookNo The book number to search for.
     * @return The Book object if found, otherwise null.
     */
    Book findBookByNo(String bookNo);

    /**
     * Find a book by its book name.
     *
     * @param bookName The book name to search for.
     * @return The Book object if found, otherwise null.
     */
    List<Book> findBooksByName(String bookName);

    /**
     * Find a book by its publisher name.
     *
     * @param pubName The publisher name to search for.
     * @return The Book object if found, otherwise null.
     */
    List<Book> findBooksByPubName(String pubName);

    /**
     * Insert a new book record into the database.
     *
     * @param book The Book object to be inserted.
     */
    void insertBook(Book book);

    /**
     * Update an existing book record in the database.
     *
     * @param book The Book object with updated information.
     */
    void updateBook(Book book);

    /**
     * Delete a book record from the database by its book number.
     *
     * @param bookNo The book number of the book to be deleted.
     */
    void deleteBook(String bookNo);
}
