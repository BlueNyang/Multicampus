package jdbc.sec02;

import java.sql.Connection;

public class DBConnMain {
    public static void main(String[] args) {
        Connection conn = null;

        // DBConn 클래스의 main 메서드를 호출하여 DB 연결 테스트
        DBConnect dbconn = new DBConnect();
        conn = dbconn.getConnection();
    }
}
