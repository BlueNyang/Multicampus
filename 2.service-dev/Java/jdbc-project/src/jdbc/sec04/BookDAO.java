package jdbc.sec04;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;

// CRUD 기능 implementation class
public class BookDAO implements IBookDAO {
    private String appMode = Dotenv.configure()
            .directory("./jdbc-project").load()
            .get("APP_MODE");

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public BookDAO() {
        // DB 연결을 위한 DBConnect 객체 생성
        BookDBConnect dbConnect = new BookDBConnect();
        // DB 연결
        this.conn = dbConnect.getConnection();
        if (this.conn == null) {
            System.out.println("DB 연결 실패");
        } else {
            System.out.println("DB 연결 성공");
        }
    }

    @Override
    public void insertBook(BookDTO book) {
        String sql = "INSERT INTO book VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookNo());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getBookAuthor());
            pstmt.setInt(4, book.getBookPrice());
            // 날짜는 java.sql.Date로 변환하여 설정
            pstmt.setDate(5, new Date(book.getBookDate().getTime()));
            pstmt.setInt(6, book.getBookStock());
            pstmt.setString(7, book.getPubNo());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("책 정보가 성공적으로 추가되었습니다.");
            } else {
                System.out.println("책 정보 추가에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("책 정보 추가 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            BookDBConnect.close(pstmt);
        }
    }

    @Override
    public ArrayList<BookDTO> getAllBooks() {
        ArrayList<BookDTO> bookList = null;
        String sql = "SELECT * FROM book ORDER BY book_no";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            bookList = getListOfResult(rs);
        } catch (Exception e) {
            System.out.println("책 정보 조회 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            BookDBConnect.close(pstmt, rs);
        }
        return bookList;
    }

    @Override
    public ArrayList<BookDTO> searchBooks(String bookName) {
        ArrayList<BookDTO> bookList = null;
        String sql = "SELECT * FROM book WHERE book_name = ? ORDER BY book_no";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookName);

            rs = pstmt.executeQuery();

            bookList = getListOfResult(rs);
        } catch (Exception e) {
            System.out.println("책 정보 검색 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            BookDBConnect.close(pstmt, rs);
        }
        return bookList;
    }

    @Override
    public ArrayList<BookDTO> detailBook(String bookNo) {
        String sql = "SELECT * FROM book WHERE book_no = ?";
        ArrayList<BookDTO> bookList = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookNo);

            rs = pstmt.executeQuery();

            bookList = getListOfResult(rs);
        } catch (Exception e) {
            System.out.println("책 정보 상세 조회 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            BookDBConnect.close(pstmt, rs);
        }
        return bookList;
    }

    @Override
    public void deleteBook(String bookNo) {
        String sql = "DELETE FROM book WHERE book_no = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("책 정보가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("책 정보 삭제에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("책 정보 삭제 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            BookDBConnect.close(pstmt);
        }
    }

    @Override
    public void updateBook(BookDTO book) {
        String sql = "UPDATE book SET book_name = ?, book_author = ?, book_price = ?, book_date = TO_DATE(?, 'YYYY-MM-DD'), book_stock = ?, pub_no = ? WHERE book_no = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getBookAuthor());
            pstmt.setInt(3, book.getBookPrice());
            // 날짜는 java.sql.Date로 변환하여 설정
            pstmt.setDate(4, new Date(book.getBookDate().getTime()));
            pstmt.setInt(5, book.getBookStock());
            pstmt.setString(6, book.getPubNo());
            pstmt.setString(7, book.getBookNo());
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("책 정보가 성공적으로 수정되었습니다.");
            } else {
                System.out.println("책 정보 수정에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("책 정보 수정 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            BookDBConnect.close(pstmt);
        }
    }

    @Override
    public void close() {
        // 자원 해제
        BookDBConnect.close(conn, pstmt, rs);
        System.out.println("DB 연결이 종료되었습니다.");
    }

    private ArrayList<BookDTO> getListOfResult(ResultSet rs) throws SQLException {
        ArrayList<BookDTO> bookList = new ArrayList<>();
        while (rs.next()) {
            String bookNo = rs.getString("book_no").trim();
            String bookName = rs.getString("book_name").trim();
            String bookAuthor = rs.getString("book_author").trim();
            int bookPrice = rs.getInt("book_price");
            Date bookDate = rs.getDate("book_date");
            int bookStock = rs.getInt("book_stock");
            String pubNo = rs.getString("pub_no").trim();

            bookList.add(new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo));
        }
        return bookList;
    }
}
