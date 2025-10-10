package kr.bluenyang.practice.springbootjpaex.member.model;

import java.util.Date;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String memHP;
    private String memZipcode;
    private String memAddress1;
    private String memAddress2;

    public static Member toEntity(MemberDTO dto) {
        return Member.builder()
                .memId(dto.getMemId())
                .memPwd(dto.getMemPwd())
                .memName(dto.getMemName())
                .memEmail(dto.getMemEmail())
                .memJoinDate(dto.getMemJoinDate())
                .memHP(dto.getMemHP())
                .memZipcode(dto.getMemZipcode())
                .memAddress1(dto.getMemAddress1())
                .memAddress2(dto.getMemAddress2())
                .build();
    }
}
