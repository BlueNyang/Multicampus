package kr.bluenyang.webgame.user.dao;

import kr.bluenyang.webgame.user.model.DAOResult;
import kr.bluenyang.webgame.user.model.User;
import kr.bluenyang.webgame.common.util.DBConnect;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 인터페이스를 만들었으니 Implementation class를 만들어야 함
@Slf4j
public class UserDAOImpl implements UserDAO {
    private final DBConnect dbConnect;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public UserDAOImpl(DBConnect dbConnect) {
        // DBConnect 객체는 ContextListener에서 inject 해줌
        this.dbConnect = dbConnect;

        // Connection 객체를 생성자에서 초기화하여 재사용하지 않음
        // 각 메서드에서 필요할 때마다 Connection 객체를 생성하고 사용 후 닫음
        // 이렇게 하면 Connection 객체의 유효 기간 문제를 피할 수 있음
        // 또한 DataSource를 사용하는 것은 물리적은 DB 연결을 만드는 것이 아니라 미리 만들어진 connection poll에서
        // "빌려"와 사용하는 것임. 즉, close() == 연결 해제가 아니라 "반납"임
        // 따라서, Connection을 할당 및 반납이 많을 때, 효율성은 DataSource가 관리하므로, Connection 객체를 재사용할 필요가 없음
    }

    @Override
    public List<User> findAll() {
        // 모든 User 정보를 가져옴
        log.info("UserDAO.findAll - Retrieving all users");
        // ArrayList로 초기화
        List<User> users = new ArrayList<>();
        try {
            con = dbConnect.getConnection();
            String sql = "SELECT * FROM users";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // ResultSet의 각 행을 User 객체로 변환하여 리스트에 추가
            while (rs.next()) {
                String userId = rs.getString("userId");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String userEmail = rs.getString("user_email");
                users.add(new User(userId, password, username, userEmail));
            }
        } catch (SQLException e) {
            log.error("UserDAO.findAll - Error finding all users", e);
            // 문제가 있으면 비어있는 List를 반환
            return java.util.Collections.emptyList();
        } finally {
            DBConnect.close(con, ps, rs);
        }

        return users;
    }

    @Override
    public User findById(String userId) {
        // userId로 User 정보를 가져옴
        log.info("UserDAO.findById - Retrieving user {}", userId);
        User user = null;
        try {
            con = dbConnect.getConnection();
            String sql = "SELECT * FROM users WHERE user_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                String username = rs.getString("username");
                String userEmail = rs.getString("user_email");
                user = new User(userId, password, username, userEmail);
            }
        } catch (SQLException e) {
            log.error("UserDAO.findById - Error finding user by ID", e);
        } finally {
            DBConnect.close(con, ps, rs);
        }
        return user;
    }

    @Override
    public DAOResult addUser(User user) {
        // 새로운 User 정보를 추가
        log.info("UserDAO.addUser - Retrieving user {}", user);
        DAOResult result;
        try {
            con = dbConnect.getConnection();
            String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, user.userId());
            ps.setString(2, user.username());
            ps.setString(3, user.password());
            ps.setString(4, user.userEmail());

            int rowsAffected = ps.executeUpdate();
            log.info("UserDAO.addUser - rows affected: {}", rowsAffected);

            if (rowsAffected > 0) {
                result = DAOResult.SUCCESS;
            } else {
                result = DAOResult.FAILURE;
            }
        } catch (SQLException e) {
            log.error("UserDAO.addUser - Error adding user", e);
            // SQLState 23000은 SQL 표준에서 무결성 제약 조건 위반.
            // 즉, Primary Key 또는 Unique Key 값이 중복되는 경우 발생함.
            // Oracle에서는 ORA-00001이지만, "표준"을 사용하여 어떤 DBMS에서든지 동일하지 작동하도록 작성
            if ("23000".equals(e.getSQLState())) { // Duplicate entry
                result = DAOResult.DUPLICATED;
            } else {
                result = DAOResult.SQL_ERROR;
            }
        } finally {
            DBConnect.close(con, ps, null);
        }
        return result;
    }

    @Override
    public DAOResult updateUser(User user) {
        // 기존 User 정보를 수정
        log.info("UserDAO.updateUser - Retrieving user by ID: {}", user.userId());
        DAOResult result;
        try {
            con = dbConnect.getConnection();
            String sql = "UPDATE users SET password = ?, username = ?, user_email = ? WHERE user_id = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, user.password());
            ps.setString(2, user.username());
            ps.setString(3, user.userEmail());
            ps.setString(4, user.userId());

            int rowsAffected = ps.executeUpdate();
            log.info("UserDAO.updateUser - rows affected: {}", rowsAffected);

            // Update나 Delete에서는 not found가 error로 처리되지 않음
            // affected rows가 0이면, 조건에 부합하는 행이 없는 것임.
            // 족, 없는 userID 라는 뜻
            if (rowsAffected > 0) {
                result = DAOResult.SUCCESS;
            } else {
                result = DAOResult.NOT_FOUND;
            }
        } catch (SQLException e) {
            log.error("UserDAO.updateUser - Error updating user", e);
            result = DAOResult.SQL_ERROR;
        } finally {
            DBConnect.close(con, ps, null);
        }
        return result;
    }

    @Override
    public DAOResult deleteUser(String userId) {
        // userId로 User 정보를 삭제
        log.info("UserDAO.deleteUser - Deleting user by ID: {}", userId);
        DAOResult result = null;
        try {
            con = dbConnect.getConnection();
            String sql = "DELETE FROM users WHERE user_id = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, userId);

            int rowsAffected = ps.executeUpdate();
            log.info("UserDAO.deleteUser - rows affected: {}", rowsAffected);

            if (rowsAffected > 0) {
                result = DAOResult.SUCCESS;
            } else {
                result = DAOResult.NOT_FOUND;
            }
        } catch (SQLException e) {
            log.error("UserDAO.deleteUser - Error deleting user", e);
            result = DAOResult.SQL_ERROR;
        } finally {
            DBConnect.close(con, ps, null);
        }
        return result;
    }
}
