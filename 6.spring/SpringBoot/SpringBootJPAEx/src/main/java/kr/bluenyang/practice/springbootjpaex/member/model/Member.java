package kr.bluenyang.practice.springbootjpaex.member.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member2")
public class Member {
    @Id
    private String memId;
    private String memPwd;
    private String memName;
    private String memEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memJoinDate;
    private String memHP;
    private String memZipcode;
    private String memAddress1;
    private String memAddress2;

    public void changePwdForEncode(String encodedPwd) {
        memPwd = encodedPwd;
    }

    public static MemberDTO toDTO(Member member) {
        return MemberDTO.builder()
                .memId(member.getMemId())
                .memPwd(member.getMemPwd())
                .memName(member.getMemName())
                .memEmail(member.getMemEmail())
                .memJoinDate(member.getMemJoinDate())
                .memHP(member.getMemHP())
                .memZipcode(member.getMemZipcode())
                .memAddress1(member.getMemAddress1())
                .memAddress2(member.getMemAddress2())
                .build();
    }
}








