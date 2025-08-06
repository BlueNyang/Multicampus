package game_project.user;

import game_project.database.HashMapDB;
import game_project.database.IHashMapDB;
import game_project.database.UserDuplicatedException;
import game_project.database.UserNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * UserDAO is responsible for managing user data operations.
 */
public class UserDAO implements IUserDAO {
    // Simple db implementation using HashMap
    IHashMapDB db;

    // Constructor initializes the database
    public UserDAO() {
        this.db = new HashMapDB();
    }

    @Override
    public boolean createUser(UserDTO user) {
        try {
            String userId = db.createUser(user);
            return isUserDuplicate(userId, user.getUsername());
        } catch (UserDuplicatedException e) {
            return false;
        }
    }

    @Override
    public Optional<UserDTO> getUserById(String userId) {
        try {
            return Optional.of(db.findUserById(userId));
        } catch (UserNotFoundException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserDTO> getUserByUsername(String username) {
        try {
            return Optional.of(db.findUserByUsername(username));
        } catch (UserNotFoundException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        try{
            return db.findAll();
        } catch (UserNotFoundException e) {
            return List.of();
        }
    }

    @Override
    public boolean updateUser(UserDTO user) {
        try {
            Optional<UserDTO> existingUserOpt = getUserById(user.getUserId());
            if (existingUserOpt.isEmpty()) {
                return false;
            }
        } catch (UserNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(UserDTO user) {
        try {
            Optional<UserDTO> existingUserOpt = getUserById(user.getUserId());
            if (existingUserOpt.isEmpty()) {
                System.out.println("User deletion failed: User does not exist.");
                return false;
            }
        } catch (UserNotFoundException e) {
            System.out.println("User deletion failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Optional<UserDTO> login(String userId, String password) {
        Optional<UserDTO> userOpt = getUserById(userId);

        if (userOpt.isPresent()) {
            UserDTO user = userOpt.get();
            if (user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean isUserDuplicate(String userId, String username) {
        // Search for users who use a combination of userId and username
        Optional<UserDTO> userById = getUserById(userId);
        Optional<UserDTO> userByUsername = getUserByUsername(username);

        if (userById.isPresent() && userByUsername.isPresent()) {
            return !userById.get().getUserId().equals(userByUsername.get().getUserId());
        }

        return false;
    }
}
