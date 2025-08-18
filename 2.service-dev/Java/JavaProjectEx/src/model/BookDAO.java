package model;

import utils.DBConnect;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO implements IBookDAO {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public BookDAO() {
        // Initialize the database connection
        this.con = new DBConnect().getConnection();
    }

    @Override
    public boolean isConnected() {
        // Check if the connection is established
        return con != null;
    }

    @Override
    public boolean insertBook(Book book) {
        int result = 0;
        // INSERT query to add a new book to the DB
        String sql = "INSERT INTO book VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
        try {
            // Prepare the SQL statement
            pstmt = con.prepareStatement(sql);

            // Set the params for the pstmt
            pstmt.setString(1, book.getBookNo());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getBookAuthor());
            pstmt.setInt(4, book.getBookPrice());
            pstmt.setDate(5, new Date(book.getBookDate().getTime()));
            pstmt.setInt(6, book.getBookStock());
            pstmt.setString(7, book.getPubNo());

            // exec
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("책 정보 추가 중 오류 발생: " + e.getMessage());
        } finally {
            // Close the pstmt
            DBConnect.close(pstmt);
        }

        return result > 0;
    }

    @Override
    public ArrayList<Book> getAll() {
        // Retrieve all books from the database
        ArrayList<Book> ArrayList = new ArrayList<>();
        // SQL query to select all books
        String sql = "SELECT * FROM book ORDER BY book_no";

        try {
            // Prepare the SQL statement
            pstmt = con.prepareStatement(sql);

            // exec and get the result set
            rs = pstmt.executeQuery();

            // Process the result set and add each book to the ArrayList
            getResultAsArrayList(ArrayList);
        } catch (SQLException e) {
            System.err.println("책 정보 조회 중 오류 발생: " + e.getMessage());
        } finally {
            // Close the resources
            DBConnect.close(pstmt, rs);
        }
        return ArrayList;
    }

    @Override
    public ArrayList<Book> getByName(String searchBookName) {
        // Retrieve books by their name from the database
        ArrayList<Book> ArrayList = new ArrayList<>();
        // SQL query to select books by name using LIKE
        String sql = "SELECT * FROM book WHERE book_name LIKE ? ORDER BY book_no";

        try {
            // Prepare the SQL statement
            pstmt = con.prepareStatement(sql);
            // Set the search param
            pstmt.setString(1, "%" + searchBookName + "%");

            // exec and get the result set
            rs = pstmt.executeQuery();

            // Process the result set and add each book to the ArrayList
            getResultAsArrayList(ArrayList);
        } catch (SQLException e) {
            System.err.println("책 정보 조회 중 오류 발생: " + e.getMessage());
        } finally {
            // Close the resources
            DBConnect.close(pstmt, rs);
        }
        return ArrayList;
    }

    @Override
    public ArrayList<Book> getBookByNo(String bookNo) {
        // Retrieve a book by its ID from the database
        ArrayList<Book> ArrayList = new ArrayList<>();
        // SQL query to select a book by its bookNo
        String sql = "SELECT * FROM book WHERE book_no = ? ORDER BY book_no";

        try {
            // Prepare the SQL statement
            pstmt = con.prepareStatement(sql);
            // Set the bookNo parameter
            pstmt.setString(1, bookNo);
            // exec and get the result set
            rs = pstmt.executeQuery();

            // If a book is found, convert the ResultSet to Book
            if (rs.next()) {
                Book book = getBookFromRS(rs);
                ArrayList.add(book);
            }
        } catch (SQLException e) {
            System.err.println("책 정보 조회 중 오류 발생: " + e.getMessage());
        } finally {
            // Close the resources
            DBConnect.close(pstmt, rs);
        }

        return ArrayList;
    }

    @Override
    public boolean updateBook(Book book) {
        int result = 0;
        // Update the book information in the database
        String sql = "UPDATE book SET book_name = ?, book_author = ?, book_price = ?, book_date = TO_DATE(?, 'YYYY-MM-DD'), book_stock = ?, pub_no = ? WHERE book_no = ?";

        try {
            // Prepare the SQL statement for updating
            pstmt = con.prepareStatement(sql);

            // Set the params for the pstmt
            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getBookAuthor());
            pstmt.setInt(3, book.getBookPrice());
            pstmt.setDate(4, new Date(book.getBookDate().getTime()));
            pstmt.setInt(5, book.getBookStock());
            pstmt.setString(6, book.getPubNo());
            pstmt.setString(7, book.getBookNo());

            // exec the update
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("책 정보 업데이트 중 오류 발생: " + e.getMessage());
        } finally {
            // Close the pstmt
            DBConnect.close(pstmt);
        }

        return result > 0;
    }

    @Override
    public boolean deleteBook(String bookNo) {
        int result = 0;
        String sql = "DELETE FROM book WHERE book_no = ?";
        try {
            // Prepare the SQL statement for deletion
            pstmt = con.prepareStatement(sql);

            // Set the bookNo parameter
            pstmt.setString(1, bookNo);

            // Execute the deletion
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("책 정보 삭제 중 오류 발생: " + e.getMessage());
        } finally {
            // Close the pstmt
            DBConnect.close(pstmt);
        }
        return result > 0;
    }

    @Override
    public void closeAll() {
        // Close all database resources
        DBConnect.close(con, pstmt, rs);
        con = null;
        pstmt = null;
        rs = null;
    }

    // Helper method to process the ResultSet and populate the ArrayList
    private void getResultAsArrayList(ArrayList<Book> ArrayList) throws SQLException {
        while (rs.next()) {
            Book book = getBookFromRS(rs);
            ArrayList.add(book);
        }
    }

    // Helper method to convert ResultSet to Book
    private Book getBookFromRS(ResultSet rs) throws SQLException {
        // Extract book details from the ResultSet
        String bookNo = rs.getString("book_no");
        String bookName = rs.getString("book_name");
        String bookAuthor = rs.getString("book_author");
        int bookPrice = rs.getInt("book_price");
        Date bookDate = rs.getDate("book_date");
        int bookStock = rs.getInt("book_stock");
        String pubNo = rs.getString("pub_no");

        // Create and return a new Book object
        return new Book(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
    }
}
