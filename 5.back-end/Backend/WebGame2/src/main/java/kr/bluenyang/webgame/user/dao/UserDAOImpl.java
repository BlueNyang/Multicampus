package kr.bluenyang.webgame.user.dao;

import kr.bluenyang.webgame.user.model.User;
import kr.bluenyang.webgame.common.util.DBConnect;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// 인터페이스를 만들었으니 Implementation class를 만들어야 함
@Slf4j
public class UserDAOImpl implements UserDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserDAOImpl(DBConnect dbConnect) {
        try {
            log.info("UserDAO constructor");
            this.con = dbConnect.getConnection();
        } catch (SQLException e) {
            log.error("UserDAO.findAll - Error getting database connection", e);
        }
    }

    @Override
    public List<User> findAll() {
        log.info("UserDAO.findAll - Retrieving all users");
        try {
            String sql = "SELECT * FROM users";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            List<User> users = new java.util.ArrayList<>();
            while (rs.next()) {
                String userId = rs.getString("userId");
                String password = rs.getString("password");
                String username = rs.getString("username");
                String userEmail = rs.getString("userEmail");
                users.add(new User(userId, password, username, userEmail));
            }
            return users;
        } catch (SQLException e) {
            log.error("UserDAO.findAll - Error finding all users", e);
            return java.util.Collections.emptyList();
        } finally {
            DBConnect.close(null, ps, rs);
        }
    }

    @Override
    public User findById(String userId) {
        log.info("UserDAO.findById - Retrieving user {}", userId);
        try {
            String sql = "SELECT * FROM users WHERE userId = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                String username = rs.getString("username");
                String userEmail = rs.getString("userEmail");
                return new User(userId, password, username, userEmail);
            } else {
                return null; // User not found
            }
        } catch (SQLException e) {
            log.error("UserDAO.findById - Error finding user by ID", e);
            return null;
        } finally {
            DBConnect.close(null, ps, rs);
        }
    }

    @Override
    public boolean addUser(User user) {
        log.info("UserDAO.addUser - Retrieving user {}", user);
        try {
            String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, user.userId());
            ps.setString(2, user.password());
            ps.setString(3, user.username());
            ps.setString(4, user.userEmail());

            int rowsAffected = ps.executeUpdate();
            log.info("UserDAO.addUser - rows affected: {}", rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            log.error("UserDAO.addUser - Error adding user", e);
            return false;
        } finally {
            DBConnect.close(null, ps, null);
        }
    }

    @Override
    public boolean updateUser(User user) {
        log.info("UserDAO.updateUser - Retrieving user by ID: {}", user.userId());
        try {
            String sql = "UPDATE users SET password = ?, username = ?, userEmail = ? WHERE userId = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, user.password());
            ps.setString(2, user.username());
            ps.setString(3, user.userEmail());
            ps.setString(4, user.userId());

            int rowsAffected = ps.executeUpdate();
            log.info("UserDAO.updateUser - rows affected: {}", rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            log.error("UserDAO.updateUser - Error updating user", e);
            return false;
        } finally {
            DBConnect.close(null, ps, null);
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        log.info("UserDAO.deleteUser - Deleting user by ID: {}", userId);
        try {
            String sql = "DELETE FROM users WHERE userId = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, userId);

            int rowsAffected = ps.executeUpdate();
            log.info("UserDAO.deleteUser - rows affected: {}", rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            log.error("UserDAO.deleteUser - Error deleting user", e);
            return false;
        } finally {
            DBConnect.close(null, ps, null);
        }
    }
}
