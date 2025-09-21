package kr.bluenyang.webgame.user.service;

import kr.bluenyang.webgame.user.dao.UserDAOImpl;
import kr.bluenyang.webgame.user.dto.UserDTO;

public class UserService {
    private final UserDAOImpl userDAO;

    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(UserDTO userDto) {

    }
}
