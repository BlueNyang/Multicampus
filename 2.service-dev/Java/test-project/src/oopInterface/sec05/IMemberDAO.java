package oopInterface.sec05;

import java.util.ArrayList;

// Data Access Object for managing member data on the online shopping mall.
// Features include:
// 1. Register: Add a new member to the DB with received member information and close the connection. There's no return value. And If the member ID already exists, an exception should be thrown.
// 2. Withdraw: Receive a member ID and search the DB for the member. If found, delete the member information and close the connection. There's no return value.
// 3. Search: Receive a member ID and search the DB for the member. If found, return the member information as a MemberDTO object. If not found, return null.
// 4. Update: Receive a MemberDTO object and update the member information in the DB. There's no return value. But if the member ID does not exist, an exception should be thrown.
// Manager Features:
// 5. Get Member List: Return a list of all members without parameters. The list is returned as an ArrayList of MemberDTO objects.
// 6. Get Member width Name: Receive a member name and search the DB for members with that name. If found, return an ArrayList of MemberDTO objects. If not found, return an empty list.

public interface IMemberDAO {
    void insertMember(MemberDTO member);

    void deleteMember(String memberId);

    MemberDTO selectMember(String memberId);

    void updateMember(MemberDTO member);

    ArrayList<MemberDTO> getMemberList();

    ArrayList<MemberDTO> getMemberList(String memberName);
}
