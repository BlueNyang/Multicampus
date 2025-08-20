package model;

import java.util.ArrayList;

public interface IBookDAO {
    /**
     * Check if the database connection is established.
     *
     * @return true if connected, false otherwise.
     */
    boolean isConnected();

    /**
     * Insert a new book into the database.
     *
     * @param book BookDTO object containing book information to be inserted.
     */
    boolean insertBook(Book book);

    /**
     * Get all books in the database.
     *
     * @return ArrayList of BookDTO objects representing all books.
     */
    ArrayList<Book> getAll();

    /**
     * Get books by their name.
     *
     * @param searchBookName The name of the book to search for.
     * @return ArrayList of BookDTO objects that match the bookName.
     */
    ArrayList<Book> getByName(String searchBookName);

    /**
     * Get books by their bookNo.
     *
     * @param bookNo The unique identifier of the book to search for.
     * @return BookDTO object if found, null otherwise.
     */
    ArrayList<Book> getBookByNo(String bookNo);

    /**
     * Update the details of a book.
     *
     * @param book BookDTO object containing updated book information.
     */
    boolean updateBook(Book book);

    /**
     * Delete a book by its ID.
     *
     * @param bookNo The unique identifier of the book to be deleted.
     */
    boolean deleteBook(String bookNo);

    /**
     * Close all database connections and resources.
     */
    void closeAll();
}
