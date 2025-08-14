package jdbc.sec06;

import java.util.ArrayList;

// 학생 정보를 관리하기 위한 DAO(Data Access Object) 인터페이스
public interface IStudentDAO {
    void insertStudent(StudentDTO student); // 학생 정보 추가

    ArrayList<StudentDTO> getAllStudents(); // 모든 학생 정보 조회

    ArrayList<StudentDTO> searchStudent(String deptName);

    ArrayList<StudentDTO> detailStudent(String stdNo); // 특정 학생 정보 조회

    void deleteStudent(String stdNo); // 학생 정보 삭제

    void updateStudent(StudentDTO student); // 학생 정보 수정

    void close();
}
