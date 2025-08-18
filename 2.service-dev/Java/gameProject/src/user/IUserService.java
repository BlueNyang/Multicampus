package user;

public interface IUserService {

    /**
     * Registers a new user in the system.
     *
     * @param userId   The unique identifier for the user.
     * @param username The username of the user.
     * @param password The password for the user.
     * @param email    The email address of the user.
     */
    void registerUser(String userId, String username, String password, String email);

    /**
     * Logs in a user with the provided credentials.
     *
     * @param userId   The username of the user.
     * @param password The password for the user.
     * @return An Optional containing the User if login is successful, or empty if not.
     */
    UserDTO loginUser(String userId, String password);

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param userId The unique identifier of the user.
     * @return An Optional containing the User if found, or empty if not found.
     */
    UserDTO getUserById(String userId);

    /**
     * Retrieves a user by their username.
     *
     * @param username The username of the user.
     * @return An Optional containing the User if found, or empty if not found.
     */
    boolean updateUserInfo(String id, String username, String password, String email);

    /**
     * Deletes a user from the system.
     *
     * @param userId The unique identifier of the user to be deleted.
     * @return true if the user was deleted successfully, false otherwise.
     */
    boolean deleteUser(String userId);
}
