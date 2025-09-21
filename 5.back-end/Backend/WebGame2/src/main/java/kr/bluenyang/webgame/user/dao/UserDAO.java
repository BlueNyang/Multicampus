package kr.bluenyang.webgame.user.dao;

import kr.bluenyang.webgame.user.model.User;

import java.util.List;

// interface로 선언하는 이유
// - DIP(Dependency Inversion Principle, 의존 역전 원칙) 준수
// - 유연성 증가: 구현체 변경이 용이
// - 테스트 용이성: Mock 객체 사용 가능
// - 유지보수성 향상: 코드 변경 최소화
public interface UserDAO {
    /**
     * Retrieve all users from the database.
     *
     * @return a list of User objects
     */
    List<User> findAll();

    /**
     * Find a user by their ID.
     *
     * @param userId the ID of the user to find
     * @return the User object if found, otherwise null
     */
    User findById(String userId);

    /**
     * Add a new user to the database.
     *
     * @param user the User object to add
     * @return true if the user was added successfully, otherwise false
     */
    boolean addUser(User user);

    /**
     * Update an existing user's information.
     *
     * @param user the User object with updated information
     * @return true if the user was updated successfully, otherwise false
     */
    boolean updateUser(User user);

    /**
     * Delete a user by their ID.
     *
     * @param userId the ID of the user to delete
     * @return true if the user was deleted successfully, otherwise false
     */
    boolean deleteUser(String userId);
}
