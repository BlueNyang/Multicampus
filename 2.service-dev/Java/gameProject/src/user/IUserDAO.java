package user;

import java.util.List;

/**
 * IUserDAO interface defines the methods for user data access operations.
 */
public interface IUserDAO {
    /**
     * Creates a new user in the system.
     *
     * @param user The user data transfer object containing user information.
     * @return true if the user was created successfully, false otherwise.
     */
    boolean createUser(User user);

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param userId The unique identifier of the user.
     * @return An Optional containing the UserDTO if found, or empty if not found.
     */
    User getUserById(String userId);

    /**
     * Retrieves a user by their username.
     *
     * @param username The username of the user.
     * @return An Optional containing the UserDTO if found, or empty if not found.
     */
    List<User> getUserByUsername(String username);

    /**
     * Retrieves all users in the system.
     *
     * @return A list of UserDTOs representing all users.
     */
    List<User> getAllUsers();

    /**
     * Updates an existing user in the system.
     *
     * @param user The user data transfer object containing updated user information.
     * @return true if the user was updated successfully, false otherwise.
     */
    boolean updateUser(User user);

    /**
     * Deletes a user from the system.
     *
     * @param user The user data transfer object representing the user to be deleted.
     * @return true if the user was deleted successfully, false otherwise.
     */
    boolean deleteUser(User user);

    /**
     * Logs in a user with the provided username and password.
     *
     * @param userId   The username of the user.
     * @param password The password of the user.
     * @return An Optional containing the UserDTO if login is successful, or empty if login fails.
     */
    User login(String userId, String password);
}
