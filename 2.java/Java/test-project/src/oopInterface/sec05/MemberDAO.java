package oopInterface.sec05;

import java.util.ArrayList;

public class MemberDAO implements IMemberDAO {
    @Override
    public void insertMember(MemberDTO member) {
        String id = member.getMemberId();
        System.out.println("Member registered successfully: " + id);
    }

    @Override
    public void deleteMember(String memberId) {
        System.out.println("Member deleted successfully: " + memberId);
    }

    @Override
    public MemberDTO selectMember(String memberId) {
        System.out.println("Searching for member with ID: " + memberId);
        return new MemberDTO(memberId, "dummyPass", "Dummy Name", "000-0000-0000", "Dummy Address");
    }

    @Override
    public void updateMember(MemberDTO member) {
        String id = member.getMemberId();

        System.out.println("Member updated successfully: " + id);
    }

    @Override
    public ArrayList<MemberDTO> getMemberList() {
        System.out.println("Retrieving all members from the database.");
        ArrayList<MemberDTO> members = new ArrayList<>();
        members.add(new MemberDTO("abcd", "1234", "홍길동", "010-1234-5678", "서울"));
        members.add(new MemberDTO("efgh", "5678", "김철수", "010-8765-4321", "부산"));
        return members; // Return a sample list of members
    }

    @Override
    public ArrayList<MemberDTO> getMemberList(String memberName) {
        System.out.println("Retrieving members with name: " + memberName);
        return new ArrayList<>(); // Return an empty list for now
    }
}
