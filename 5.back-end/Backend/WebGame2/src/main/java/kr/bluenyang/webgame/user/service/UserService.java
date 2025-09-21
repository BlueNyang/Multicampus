package kr.bluenyang.webgame.user.service;

import kr.bluenyang.webgame.user.dto.UserDTO;
import kr.bluenyang.webgame.user.model.UserServiceResult;

import java.util.List;

public interface UserService {
    UserDTO login(String username, String password);

    UserServiceResult registerUser(UserDTO userDTO);

    UserServiceResult updateUser(UserDTO userDTO);

    UserServiceResult removeUser(String userId, String verifyPassword);

    List<UserDTO> searchAllUsers();
}
