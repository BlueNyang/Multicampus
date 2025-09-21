package kr.bluenyang.webgame.user.dto;

import kr.bluenyang.webgame.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// User 정보를 전달하기 위한 DTO 클래스
public class UserDTO {
    private String userId;
    private String password;
    private String username;
    private String userEmail;

    public UserDTO(String userId, String password, String username, String userEmail) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.userEmail = userEmail;
    }

    // User Entity를 UserDTO로 변환하는 생성자
    public UserDTO(User user) {
        this.userId = user.userId();
        this.password = user.password();
        this.username = user.username();
        this.userEmail = user.userEmail();
    }

    // UserDTO를 User Entity로 변환하는 메서드
    public User toEntity() {
        return new User(userId, password, username, userEmail);
    }
}
