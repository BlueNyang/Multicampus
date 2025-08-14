package jdbc.sec04;

import java.util.ArrayList;

// 책 정보를 관리하기 위한 DAO(Data Access Object) 인터페이스
public interface IBookDAO {
    void insertBook(BookDTO book); // 책 정보 추가

    ArrayList<BookDTO> getAllBooks(); // 모든 책 정보 조회

    ArrayList<BookDTO> searchBooks(String bookName); //

    ArrayList<BookDTO> detailBook(String bookNo); // 특정 학생 정보 조회

    void deleteBook(String bookNo); // 학생 정보 삭제

    void updateBook(BookDTO book); // 학생 정보 수정

    void close();
}
