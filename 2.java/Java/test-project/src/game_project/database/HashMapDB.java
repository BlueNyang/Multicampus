package game_project.database;

import game_project.user.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMapDB is a simple in-memory database implementation for managing UserDTO objects.
 */
public class HashMapDB implements IHashMapDB {
    // A simple in-memory database implementation using HashMaps
    private final Map<String, UserDTO> userById = new ConcurrentHashMap<>();
    // Indexes for quick lookup by username
    private final Map<String, String> usernameIndex = new ConcurrentHashMap<>();

    @Override
    public String createUser(UserDTO user) throws UserDuplicatedException {
        if (userById.containsKey(user.getUserId())) {
            throw new UserDuplicatedException(user.getUserId());
        }

        String id = user.getUserId();

        userById.put(id, user);
        usernameIndex.put(user.getUsername(), id);

        return id;
    }

    @Override
    public UserDTO findUserById(String userId) throws UserNotFoundException {
        UserDTO user = userById.get(userId);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
        return user;
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        String userId = usernameIndex.get(username);
        if (userId == null) {
            throw new UserNotFoundException("User with name " + username + " not found.");
        }
        return userById.get(userId);
    }

    @Override
    public List<UserDTO> findAll() throws UserNotFoundException {
        return new ArrayList<>(userById.values());
    }

    @Override
    public boolean updateUser(UserDTO user) throws UserNotFoundException {
        String id = user.getUserId();
        if (!userById.containsKey(id)) {
            return false; // User does not exist
        }

        UserDTO existingUser = userById.get(id);

        if (existingUser == null) {
            return false; // User not found
        }

        if (!existingUser.getUsername().equals(user.getUsername())) {
            // Update username index
            usernameIndex.remove(existingUser.getUsername());
            usernameIndex.put(user.getUsername(), id);
        }

        userById.put(id, user);
        return true;
    }

    @Override
    public boolean deleteUser(String userId) throws UserNotFoundException {
        UserDTO user = userById.remove(userId);
        if (user == null) {
            return false; // User not found
        }

        usernameIndex.remove(user.getUsername());
        return true;
    }
}
