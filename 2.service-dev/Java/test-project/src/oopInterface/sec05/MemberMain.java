package oopInterface.sec05;

import java.util.ArrayList;

public class MemberMain {
    public static void main(String[] ignoredArgs) {
        MemberDTO dto = new MemberDTO("abcd", "1234", "홍길동", "010-1234-5678", "서울");

        IMemberDAO idao = new MemberDAO();

        idao.insertMember(dto);
        System.out.println("회원 등록 완료: " + dto.getMemberId());

        // 회원 정보 조회
        ArrayList<MemberDTO> member = idao.getMemberList();
        System.out.println("회원 목록:");
        for (MemberDTO memberDTO : member) {
            System.out.println("ID: " + memberDTO.getMemberId() + ", Name: " + memberDTO.getMemberName() +
                    ", Phone: " + memberDTO.getMemberPhone() + ", Address: " + memberDTO.getMemberAddress());
        }
    }
}
