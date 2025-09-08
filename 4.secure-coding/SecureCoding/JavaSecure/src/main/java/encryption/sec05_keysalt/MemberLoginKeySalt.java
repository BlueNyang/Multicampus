package encryption.sec05_keysalt;

import encryption.util.DBConnect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberLoginKeySalt {
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

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) {
        // DB에 저장된 비밀번호가 plain text기 때문에 사용자 입력값과 db에서 조회한 값을 바로 비교
        // sql 쿼리를 문자열을 결합해서 동적으로 생성하고 있음 : sql 삽입공격에 노출됨
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null; //select 구문

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the ID: ");
            String memId = sc.nextLine();
            System.out.print("Enter the Password: ");
            String memPass = sc.nextLine();
            //사용자가 입력한 비밀번호를 바로 비교하지 않고
            //DB에서 조회한 Salt값을 이용해서 해싱처리한 후 비교

            String sql = "SELECT memPass FROM member WHERE memId = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memId);

            rs = pstmt.executeQuery();
            //회원가입 진행 시 중복 아이디 허용하지 않았다고 가정
            //위 쿼리가 진행되었다면 한명에 대한 정보가 나오거나 정보가 추출되지 않았을 것임

            if (rs.next()) {
                String dbPwd = rs.getString("memPass");
                String dbSalt = rs.getString("memSalt");

                String hashPass = hasing(memPass.getBytes(), dbSalt);

                if (dbPwd.equals(hashPass)) {
                    System.out.println("Login successful.");
                } else {
                    System.out.println("Login failed.");
                }
            } else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBConnect.close(con, pstmt, rs);
        }
    }
}
