package encryption.sec04_sha256;

import encryption.util.DBConnect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberJoinSHA256 {
    private static String sha256(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pass.getBytes());
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-256 algorithm not found.");
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred during hashing.");
            return null;
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) {
        DBConnect dbcon = new DBConnect();
        Connection conn = dbcon.getConnection();
        PreparedStatement pstmt = null;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the ID: ");
            String memId = sc.nextLine();
            System.out.print("Enter the Password: ");
            String memPass = sc.nextLine();

            for (int i = 0; i < 10000; i++) {
                memPass = sha256(memPass);
                // Stretching => 해시함수를 여러번 적용해서 보안성을 높이는 기법
            }

            System.out.print("Enter the Name: ");
            String memName = sc.nextLine();
            System.out.print("Enter the email: ");
            String memMail = sc.nextLine();

            LocalDate ld = LocalDate.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String memJoinDate = ld.format(dtf);

            String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            pstmt.setString(2, memPass); // binding 되는 password == plain text;
            pstmt.setString(3, memName);
            pstmt.setString(4, memMail);
            pstmt.setString(5, memJoinDate);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("Member registration successful.");
            } else {
                System.out.println("Member registration failed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnect.close(conn, pstmt, null);
        }
    }
}
