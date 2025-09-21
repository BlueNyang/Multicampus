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
        log.info("UserServiceImple.registerUser - userId: {}", userDTO.getUserId());
        var result = dao.addUser(userDTO.toEntity());

        if (result == DAOResult.SUCCESS) {
            log.info("UserServiceImple.registerUser - user successfully added: {}", userDTO.getUserId());
            return UserServiceResult.SUCCESS;
        } else if (result == DAOResult.DUPLICATED) {
            log.info("UserServiceImple.registerUser - duplicated userId: {}", userDTO.getUserId());
            return UserServiceResult.DUPLICATED;
        } else {
            log.info("UserServiceImple.registerUser - failed to add user: {}", userDTO.getUserId());
            return UserServiceResult.FAIL;
        }
    }

    @Override
    public UserServiceResult updateUser(UserDTO userDTO) {
        log.info("UserServiceImple.updateUser - userId: {}", userDTO.getUserId());
        var result = dao.updateUser(userDTO.toEntity());
        if (result == DAOResult.SUCCESS) {
            log.info("UserServiceImple.updateUser - user successfully updated: {}", userDTO.getUserId());
            return UserServiceResult.SUCCESS;
        } else if (result == DAOResult.NOT_FOUND) {
            log.info("UserServiceImple.updateUser - user not found: {}", userDTO.getUserId());
            return UserServiceResult.NOT_FOUND;
        } else {
            log.info("UserServiceImple.updateUser - failed to update user: {}", userDTO.getUserId());
            return UserServiceResult.FAIL;
        }
    }

    @Override
    public UserServiceResult removeUser(String userId, String verifyPassword) {
        log.info("UserServiceImple.removeUser - userId: {}", userId);
        var user = dao.findById(userId);
        if (user == null) {
            log.info("UserServiceImple.removeUser - user not found: {}", userId);
            return UserServiceResult.NOT_FOUND;
        }
        if (!user.password().equals(verifyPassword)) {
            log.info("UserServiceImple.removeUser - invalid password for user: {}", userId);
            return UserServiceResult.INVALID_ID_OR_PASSWORD;
        }

        var result = dao.deleteUser(userId);
        if (result == DAOResult.SUCCESS) {
            log.info("UserServiceImple.removeUser - user successfully removed: {}", userId);
            return UserServiceResult.SUCCESS;
        } else {
            log.info("UserServiceImple.removeUser - failed to remove user: {}", userId);
            return UserServiceResult.FAIL;
        }
    }

    @Override
    public List<UserDTO> searchAllUsers() {
        log.info("UserServiceImple.searchAllUsers - fetching all users");
        var users = dao.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
}
