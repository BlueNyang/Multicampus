package kr.bluenyang.practice.springbootjpaex.member.model;

import java.util.Date;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memId;
    @Setter
    private String memPwd;
    private String memName;
    private String memEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memJoinDate;
    @Setter
    private String memHp;
    private String memZipCode;
    private String memAddress1;
    private String memAddress2;

    public static Member toEntity(MemberDTO dto) {
        return Member.builder()
                .memId(dto.getMemId())
                .memPwd(dto.getMemPwd())
                .memName(dto.getMemName())
                .memEmail(dto.getMemEmail())
                .memJoinDate(dto.getMemJoinDate())
                .memHp(dto.getMemHp())
                .memZipCode(dto.getMemZipCode())
                .memAddress1(dto.getMemAddress1())
                .memAddress2(dto.getMemAddress2())
                .build();
    }

    public String getMemHp1() {
        if (this.memHp != null && this.memHp.length() == 13) {
            return this.memHp.substring(0, 3);
        }
        return "";
    }

    public String getMemHp2() {
        if (this.memHp != null && this.memHp.length() == 13) {
            return this.memHp.substring(4, 8);
        }
        return "";
    }

    public String getMemHp3() {
        if (this.memHp != null && this.memHp.length() == 13) {
            return this.memHp.substring(9);
        }
        return "";
    }
}
