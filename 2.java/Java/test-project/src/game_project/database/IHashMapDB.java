package game_project.database;

import game_project.user.UserDTO;

import java.util.List;

public interface IHashMapDB {
    /**
     * Creates a new user in the database.
     * If the user already exists, it returns null.
     *
     * @param user The UserDTO object containing user details.
     * @return The user ID if created successfully, or null if the user already exists.
     */
    String createUser(UserDTO user) throws UserDuplicatedException;

    /**
     * Finds a user by their ID.
     * If the user does not exist, it returns null.
     * @param userId The ID of the user to find.
     * @return The UserDTO object if found, or null if not found.
     */
    UserDTO findUserById(String userId) throws UserNotFoundException;

    /**
     * Finds a user by their username.
     * If the user does not exist, it returns null.
     * @param username The username of the user to find.
     * @return The UserDTO object if found, or null if not found.
     */
    UserDTO findUserByUsername(String username) throws UserNotFoundException;

    /**
     * Retrieves all users in the database.
     * @return A list of all UserDTO objects.
     */
    List<UserDTO> findAll() throws UserNotFoundException;

    /**
     * Updates an existing user in the database.
     * If the user does not exist, it returns false.
     * @param user The UserDTO object containing updated user details.
     * @return true if the user was updated successfully, false if the user does not exist.
     */
    boolean updateUser(UserDTO user) throws UserNotFoundException;

    /**
     * Deletes a user from the database.
     * If the user does not exist, it returns false.
     * @param userId The ID of the user to delete.
     * @return true if the user was deleted successfully, false if the user does not exist.
     */
    boolean deleteUser(String userId) throws UserNotFoundException;
}
