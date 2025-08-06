package game_project.user;

import java.util.Optional;

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
        UserDTO user = new UserDTO(new User(userId, username, password, email));
        if (userDAO.createUser(user)) {
            System.out.println("User registered successfully: " + username);
        } else {
            System.out.println("User registration failed: User already exists.");
        }
    }

    @Override
    public Optional<User> loginUser(String userId, String password) {
        Optional<UserDTO> user = userDAO.login(userId, password);
        if (user.isPresent()) {
            System.out.println("Login successful for user: " + userId);
            return Optional.of(user.get().toEntity());
        } else {
            System.out.println("Login failed: Invalid userId or password.");
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> getUserById(String userId) {
        if (userId == null || userId.isEmpty()) {
            System.out.println("User ID cannot be null or empty.");
            return Optional.empty();
        }

        Optional<UserDTO> userDTO = userDAO.getUserById(userId);
        if (userDTO.isPresent()) {
            System.out.println("User found: " + userDTO.get());
            return Optional.of(userDTO.get().toEntity());
        } else {
            System.out.println("User not found with ID: " + userId);
            return Optional.empty();
        }
    }

    @Override
    public boolean updateUserInfo(String id, String username, String password, String email) {
        Optional<UserDTO> userOpt = userDAO.getUserById(id);
        if (userOpt.isPresent()) {
            UserDTO user = userOpt.get();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
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
        Optional<UserDTO> userOpt = userDAO.getUserById(userId);
        if (userOpt.isPresent()) {
            UserDTO user = userOpt.get();
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
