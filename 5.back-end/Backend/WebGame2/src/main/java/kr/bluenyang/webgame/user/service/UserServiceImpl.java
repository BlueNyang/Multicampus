package kr.bluenyang.webgame.user.service;

import kr.bluenyang.webgame.user.dao.UserDAO;
import kr.bluenyang.webgame.user.dto.UserDTO;
import kr.bluenyang.webgame.user.model.DAOResult;
import kr.bluenyang.webgame.user.model.UserServiceResult;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public record UserServiceImpl(UserDAO dao) implements UserService {

    @Override
    public UserDTO login(String username, String password) {
        log.info("UserServiceImple.login - login for user: {}", username);
        var user = dao.findById(username);
        if (user == null) {
            log.info("UserServiceImpl.login - User not found: {}", username);
            return null;
        }
        if (!user.password().equals(password)) {
            log.info("UserServiceImpl.login - Invalid password for user: {}", username);
            return null;
        }

        log.info("UserServiceImpl.login - login for user: {}", username);
        return new UserDTO(user);
    }

    @Override
    public UserServiceResult registerUser(UserDTO userDTO) {
        log.info("UserServiceImpl.registerUser - userId: {}", userDTO.getUserId());
        var result = dao.addUser(userDTO.toEntity());

        if (result == DAOResult.SUCCESS) {
            log.info("UserServiceImpl.registerUser - user successfully added: {}", userDTO.getUserId());
            return UserServiceResult.SUCCESS;
        } else if (result == DAOResult.DUPLICATED) {
            log.info("UserServiceImpl.registerUser - duplicated userId: {}", userDTO.getUserId());
            return UserServiceResult.DUPLICATED;
        } else {
            log.info("UserServiceImpl.registerUser - failed to add user: {}", userDTO.getUserId());
            return UserServiceResult.FAIL;
        }
    }

    @Override
    public UserServiceResult updateUser(UserDTO userDTO, String verifyPassword) {
        // First, verify the existing password
        var existingUser = dao.findById(userDTO.getUserId());

        // User 검색
        if (existingUser == null) {
            log.info("UserServiceImpl.updateUser - user not found: {}", userDTO.getUserId());
            return UserServiceResult.NOT_FOUND;
        }
        // Password 검증
        if (!existingUser.password().equals(verifyPassword)) {
            log.info("UserServiceImpl.updateUser - invalid password for user: {}", userDTO.getUserId());
            return UserServiceResult.INVALID_ID_OR_PASSWORD;
        }

        // Proceed to update user information
        log.info("UserServiceImpl.updateUser - userId: {}", userDTO.getUserId());
        var result = dao.updateUser(userDTO.toEntity());

        if (result == DAOResult.SUCCESS) {
            log.info("UserServiceImpl.updateUser - user successfully updated: {}", userDTO.getUserId());
            return UserServiceResult.SUCCESS;
        } else if (result == DAOResult.NOT_FOUND) {
            log.info("UserServiceImpl.updateUser - user not found: {}", userDTO.getUserId());
            return UserServiceResult.NOT_FOUND;
        } else {
            log.info("UserServiceImpl.updateUser - failed to update user: {}", userDTO.getUserId());
            return UserServiceResult.FAIL;
        }
    }

    @Override
    public UserServiceResult removeUser(String userId, String verifyPassword) {
        // First, verify the existing password
        log.info("UserServiceImpl.removeUser - userId: {}", userId);
        // User 검색
        var user = dao.findById(userId);
        if (user == null) {
            log.info("UserServiceImpl.removeUser - user not found: {}", userId);
            return UserServiceResult.NOT_FOUND;
        }
        // Password 검증
        if (!user.password().equals(verifyPassword)) {
            log.info("UserServiceImpl.removeUser - invalid password for user: {}", userId);
            return UserServiceResult.INVALID_ID_OR_PASSWORD;
        }

        // Proceed to delete user
        var result = dao.deleteUser(userId);
        if (result == DAOResult.SUCCESS) {
            log.info("UserServiceImpl.removeUser - user successfully removed: {}", userId);
            return UserServiceResult.SUCCESS;
        } else {
            log.info("UserServiceImpl.removeUser - failed to remove user: {}", userId);
            return UserServiceResult.FAIL;
        }
    }

    @Override
    public List<UserDTO> searchAllUsers() {
        log.info("UserServiceImpl.searchAllUsers - fetching all users");
        var users = dao.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
}
