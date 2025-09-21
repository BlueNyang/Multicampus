package kr.bluenyang.webgame.service.user;

import kr.bluenyang.webgame.dao.user.UserDAOImpl;
import kr.bluenyang.webgame.dto.user.UserDTO;

public class UserService {
    private final UserDAOImpl userDAO;

    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(UserDTO userDto) {

    }
}
