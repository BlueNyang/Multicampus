package game_project.user;

/**
 * Entity class representing a user in the system.
 */
public class User {
    // Unique identifier for the user
    private String userId;
    private String username;
    private String password;
    private String email;

    // Constructor to initialize a User object
    public User(String userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters for userId, username, password, and email
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Override equals and hashCode methods for proper comparison and hashing
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return userId.equals(user.userId) &&
               username.equals(user.username) &&
               password.equals(user.password) &&
               email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + userId.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }

    // Override toString method for easy representation of User object
    @Override
    public String toString() {
        return "User{" +
               "userId='" + userId + '\'' +
               ", username='" + username + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
