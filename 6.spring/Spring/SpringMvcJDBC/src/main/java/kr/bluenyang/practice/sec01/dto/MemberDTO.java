package kr.bluenyang.practice.sec01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    public String memId;
    public String memPwd;
    public String memName;
    public String memEmail;
    private Date memJoinDate;
}
