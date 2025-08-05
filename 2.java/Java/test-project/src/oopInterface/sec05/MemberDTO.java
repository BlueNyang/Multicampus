package oopInterface.sec05;

public class MemberDTO {
    private String memberId;
    private String memberPass;
    private String memberName;
    private String memberPhone;
    private String memberAddress;

    public MemberDTO(String memberId, String memberPass, String memberName, String memberPhone, String memberAddress) {
        this.memberId = memberId;
        this.memberPass = memberPass;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }
}
