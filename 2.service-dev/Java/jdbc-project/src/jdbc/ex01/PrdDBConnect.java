package jdbc.ex01;

import java.sql.*; // database 관련 class
import io.github.cdimascio.dotenv.Dotenv; // .env 사용을 위함

public class PrdDBConnect {
    // DB 연결을 위한 URL, 사용자명, 비밀번호
    private String url;
    // DB 연결을 위한 사용자명
    private String username;
    // DB 연결을 위한 비밀번호
    private String password;

    public PrdDBConnect() {
        // .env 파일에서 DB 연결 정보를 읽어오기 위해 Dotenv 라이브러리 사용
        final Dotenv dotenv = Dotenv.configure()
                .directory("./jdbc-project/.env")
                .load(); // .env configure

        // .env 파일에서 DB 연결 정보 가져오기
        this.url = dotenv.get("DB_URL");
        this.username = dotenv.get("DB_USERNAME");
        this.password = dotenv.get("DB_PASSWORD");
    }

    public Connection getConnection() {
        try {
            // DB 연결
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
            return null;
        }
    }
}

