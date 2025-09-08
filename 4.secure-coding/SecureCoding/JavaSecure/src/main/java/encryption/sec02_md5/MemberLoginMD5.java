package encryption.sec02_md5;

import encryption.util.DBConnect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;

public class MemberLoginMD5 {
    private static String md5(String pass) {
        StringBuilder encData = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = pass.getBytes();
            md.update(bytes);

            byte[] digest = md.digest();
            System.out.println(Arrays.toString(digest));
            for (byte b : digest) {
                String hex = Integer.toHexString(b & 0xFF);
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                encData.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5 algorithm not found.");
            return null;
        }
        return encData.toString();
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
            String memPass = md5(sc.nextLine());

            String sql = "SELECT mem_pass FROM member WHERE mem_id = ? AND mem_pass = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memId);
            pstmt.setString(2, memPass);

            rs = pstmt.executeQuery();
            //회원가입 진행 시 중복 아이디 허용하지 않았다고 가정
            //위 쿼리가 진행되었다면 한명에 대한 정보가 나오거나 정보가 추출되지 않았을 것임

            if (rs.next()) {
                System.out.println("Login successful.");
                //웹에서는 로그인되었다면 자격증명을 포함해서 클라이언트에게 전달
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
