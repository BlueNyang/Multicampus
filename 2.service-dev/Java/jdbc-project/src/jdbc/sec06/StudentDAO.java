package jdbc.sec06;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// CRUD 기능 implementation class
public class StudentDAO implements IStudentDAO {
    private String appMode = Dotenv.configure()
            .directory("./jdbc-project").load()
            .get("APP_MODE");

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public StudentDAO() {
        // DB 연결을 위한 DBConnect 객체 생성
        DBConnect dbConnect = new DBConnect();
        // DB 연결
        this.conn = dbConnect.getConnection();
        if (this.conn == null) {
            System.out.println("DB 연결 실패");
        } else {
            System.out.println("DB 연결 성공");
        }
    }

    @Override
    public void insertStudent(StudentDTO student) {
        String sql = "INSERT INTO student VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getStdNo());
            pstmt.setString(2, student.getStdName());
            pstmt.setInt(3, student.getStdYear());
            pstmt.setString(4, student.getStdAddress());
            // 날짜는 java.sql.Date로 변환하여 설정
            pstmt.setDate(5, new Date(student.getStdBirth().getTime()));
            pstmt.setString(6, student.getDeptNo());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("학생 정보가 성공적으로 추가되었습니다.");
            } else {
                System.out.println("학생 정보 추가에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("학생 정보 추가 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY std_no";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String stdNo = rs.getString("std_no").trim();
                String stdName = rs.getString("std_name").trim();
                System.out.println("stdNo = " + stdNo);
                int stdYear = rs.getInt("std_year");
                String stdAddress = rs.getString("std_address").trim();
                Date stdBirth = rs.getDate("std_birth");
                String deptNo = rs.getString("dept_no").trim();

                studentList.add(new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, deptNo));
            }
        } catch (Exception e) {
            System.out.println("학생 정보 조회 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return studentList;
    }

    @Override
    public ArrayList<StudentDTO> searchStudent(String deptName) {
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE dept_no = (SELECT dept_no FROM department WHERE dept_name = ?) ORDER BY std_no";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, deptName);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String stdNo = rs.getString("std_no").trim();
                String stdName = rs.getString("std_name").trim();
                int stdYear = rs.getInt("std_year");
                String stdAddress = rs.getString("std_address").trim();
                Date stdBirth = rs.getDate("std_birth");
                String deptNo = rs.getString("dept_no").trim();

                studentList.add(new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, deptNo));
            }
        } catch (Exception e) {
            System.out.println("학생 정보 검색 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return studentList;
    }

    @Override
    public ArrayList<StudentDTO> detailStudent(String stdNo) {
        String sql = "SELECT * FROM student WHERE std_no = ?";
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stdNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String stdName = rs.getString("std_name").trim();
                int stdYear = rs.getInt("std_year");
                String stdAddress = rs.getString("std_address").trim();
                Date stdBirth = rs.getDate("std_birth");
                String deptNo = rs.getString("dept_no").trim();

                studentList.add(new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, deptNo));
            }
        } catch (Exception e) {
            System.out.println("학생 정보 상세 조회 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, rs);
        }
        return studentList;
    }

    @Override
    public void deleteStudent(String stdNo) {
        String sql = "DELETE FROM student WHERE std_no = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stdNo);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("학생 정보가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("학생 정보 삭제에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("학생 정보 삭제 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public void updateStudent(StudentDTO student) {
        String sql = "UPDATE student SET std_name = ?, std_year = ?, std_address = ?, std_birth = TO_DATE(?, 'YYYY-MM-DD'), dept_no = ? WHERE std_no = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getStdName());
            pstmt.setInt(2, student.getStdYear());
            pstmt.setString(3, student.getStdAddress());
            pstmt.setDate(4, new Date(student.getStdBirth().getTime()));
            pstmt.setString(5, student.getDeptNo());
            pstmt.setString(6, student.getStdNo());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("학생 정보가 성공적으로 수정되었습니다.");
            } else {
                System.out.println("학생 정보 수정에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("학생 정보 수정 중 오류 발생: " + e.getMessage());
            if (appMode.equals("development")) e.printStackTrace();
        } finally {
            DBConnect.close(pstmt);
        }
    }

    @Override
    public void close() {
        // 자원 해제
        DBConnect.close(conn, pstmt, rs);
        System.out.println("DB 연결이 종료되었습니다.");
    }
}
