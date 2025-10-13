package kr.bluenyang.practice.springbootjpaex.member.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Slf4j
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ex_member")
public class Member {
    @Id
    private String memId;
    private String memPwd;
    private String memName;
    private String memEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memJoinDate;
    private String memHp;
    private String memZipCode;
    private String memAddress1;
    private String memAddress2;

    public void changePwd(String encodedPwd) {
        memPwd = encodedPwd;
    }

    public void changeMemberInfo(Member updatedMember) {
        log.info("Updating member info: {}", updatedMember);
        if (updatedMember.memName != null) {
            this.memName = updatedMember.memName;
        }

        if (updatedMember.memEmail != null) {
            this.memEmail = updatedMember.memEmail;
        }

        if (updatedMember.memHp != null) {
            this.memHp = updatedMember.memHp;
        }

        if (updatedMember.memZipCode != null) {
            this.memZipCode = updatedMember.memZipCode;
        }

        if (updatedMember.memAddress1 != null) {
            this.memAddress1 = updatedMember.memAddress1;
        }

        if (updatedMember.memAddress2 != null) {
            this.memAddress2 = updatedMember.memAddress2;
        }
    }

    public static MemberDTO toDTO(Member member) {
        return MemberDTO.builder()
                .memId(member.getMemId())
                .memPwd(member.getMemPwd())
                .memName(member.getMemName())
                .memEmail(member.getMemEmail())
                .memJoinDate(member.getMemJoinDate())
                .memHp(member.getMemHp())
                .memZipCode(member.getMemZipCode())
                .memAddress1(member.getMemAddress1())
                .memAddress2(member.getMemAddress2())
                .build();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memId='" + memId + '\'' +
                ", memPwd='" + memPwd + '\'' +
                ", memName='" + memName + '\'' +
                ", memEmail='" + memEmail + '\'' +
                ", memJoinDate=" + memJoinDate +
                ", memHp='" + memHp + '\'' +
                ", memZipCode='" + memZipCode + '\'' +
                ", memAddress1='" + memAddress1 + '\'' +
                ", memAddress2='" + memAddress2 + '\'' +
                '}';
    }
}








