package encryption.sec05_keysalt;

import encryption.util.DBConnect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberJoinKeySalt {
    private static final int SALT_SIZE = 16; // 16 bytes = 128 bits

    private static String getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] temp = new byte[SALT_SIZE];

        random.nextBytes(temp);

        return bytesToString(temp);
    }

    private static String bytesToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = String.format("%02x", b);
            sb.append(hex);
        }
        return sb.toString();
    }

    private static String hasing(byte[] password, String Salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            for (int i = 0; i < 10000; i++) {
                String temp = bytesToString(password) + Salt;
                md.update(temp.getBytes());

                password = md.digest();
            }

            return bytesToString(password);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-256 algorithm not found.");
        } catch (Exception e) {
            System.out.println("An error occurred during hashing.");
        }
        return null;
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

            String memSalt = getSalt();
            memPass = hasing(memPass.getBytes(), memSalt);
            System.out.println(memPass);

            System.out.print("Enter the Name: ");
            String memName = sc.nextLine();
            System.out.print("Enter the email: ");
            String memMail = sc.nextLine();

            LocalDate ld = LocalDate.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String memJoinDate = ld.format(dtf);

            String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            pstmt.setString(2, memPass); // binding 되는 password == plain text;
            pstmt.setString(3, memName);
            pstmt.setString(4, memMail);
            pstmt.setString(5, memJoinDate);
            pstmt.setString(6, memSalt); // salt 컬럼 추가 필요

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
