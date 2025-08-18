package user;

/**
 * UserService class that implements IUserService interface.
 */
public class UserService implements IUserService {
    // UserDAO instance for database operations
    private final IUserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    @Override
    public void registerUser(String userId, String username, String password, String email) {
        UserDTO user = new UserDTO(userId, username, password, email);
        if (userDAO.createUser(user.toEntity())) {
            System.out.println("User registered successfully: " + username);
        } else {
            System.out.println("User registration failed: User already exists.");
        }
    }

    @Override
    public UserDTO loginUser(String userId, String password) {
        User user = userDAO.login(userId, password);
        if (user != null) {
            System.out.println("Login successful for user: " + userId);
            return UserDTO.fromEntity(user);
        } else {
            System.out.println("Login failed: Invalid userId or password.");
            return null;
        }
    }

    @Override
    public UserDTO getUserById(String userId) {
        if (userId == null || userId.isEmpty()) {
            System.out.println("User ID cannot be null or empty.");
            return null;
        }

        User user = userDAO.getUserById(userId);
        if (user != null) {
            System.out.println("User found: " + user.getUserId());
            return UserDTO.fromEntity(user);
        } else {
            System.out.println("User not found with ID: " + userId);
            return null;
        }
    }

    @Override
    public boolean updateUserInfo(String id, String username, String password, String email) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setUserEmail(email);
            if (userDAO.updateUser(user)) {
                System.out.println("User information updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update user information.");
                return false;
            }
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        User user = userDAO.getUserById(userId);
        if (user != null) {
            if (userDAO.deleteUser(user)) {
                System.out.println("User deleted successfully.");
                return true;
            } else {
                System.out.println("Failed to delete user.");
                return false;
            }
        } else {
            System.out.println("User not found.");
            return false;
        }
    }
}
