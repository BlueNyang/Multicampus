package kr.bluenyang.webgame.user.service;

import kr.bluenyang.webgame.user.dto.UserDTO;
import kr.bluenyang.webgame.user.model.UserServiceResult;

import java.util.List;

public interface UserService {
    /**
     * login 시도를 처리
     *
     * @param username 입력받은 username
     * @param password 입력받은 password
     * @return 로그인 성공 시 UserDTO, 실패 시 null
     */
    UserDTO login(String username, String password);

    /**
     * 회원가입 시도를 처리
     *
     * @param userDTO 회원가입에 필요한 정보가 담긴 UserDTO 객체
     * @return 회원가입 성공 여부와 메시지를 담은 UserServiceResult 객체
     */
    UserServiceResult registerUser(UserDTO userDTO);

    /**
     * 회원 정보 수정을 처리
     * 기존 비밀번호 확인 후, 새로운 정보로 업데이트
     *
     * @param userDTO 수정할 회원 정보가 담긴 UserDTO 객체
     * @return 수정 성공 여부와 메시지를 담은 UserServiceResult 객체
     */
    UserServiceResult updateUser(UserDTO userDTO, String verifyPassword);

    /**
     * 회원 탈퇴를 처리
     * 기존 비밀번호 확인 후, 회원 정보 삭제
     *
     * @param userId         탈퇴할 회원의 ID
     * @param verifyPassword 탈퇴 확인을 위한 비밀번호
     * @return 탈퇴 성공 여부와 메시지를 담은 UserServiceResult 객체
     */
    UserServiceResult removeUser(String userId, String verifyPassword);

    /**
     * 모든 회원 정보를 조회
     *
     * @return 모든 회원 정보를 담은 UserDTO 리스트
     */
    List<UserDTO> searchAllUsers();
}
