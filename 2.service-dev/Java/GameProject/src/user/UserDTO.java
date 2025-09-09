package user;

/**
 * User Data Transfer Object (DTO) class for transferring user data.
 */
public class UserDTO {
    private String userId;
    private String username;
    private String password;
    private String email;

    public UserDTO(String userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getUserEmail());
    }

    public User toEntity() {
        return new User(userId, username, password, email);
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }
}
