package kr.bluenyang.webgame.user.dto;

import kr.bluenyang.webgame.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public UserDTO(User user) {
        this.userId = user.userId();
        this.password = user.password();
        this.username = user.username();
        this.userEmail = user.userEmail();
    }

    public User toEntity() {
        return new User(userId, password, username, userEmail);
    }
}
