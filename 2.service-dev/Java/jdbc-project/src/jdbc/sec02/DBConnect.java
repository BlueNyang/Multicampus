package jdbc.sec02;

import java.sql.*; // database 관련 class
import io.github.cdimascio.dotenv.Dotenv; // .env 사용을 위함

public class DBConnect {
    private String url;
    private String username;
    private String password;

    public DBConnect() {
        final Dotenv dotenv = Dotenv.configure()
                .directory("./jdbc-project/.env")
                .load(); // .env configure

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
