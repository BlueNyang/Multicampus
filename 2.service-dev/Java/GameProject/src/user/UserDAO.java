package user;

import utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO is responsible for managing user data operations.
 */
public class UserDAO implements IUserDAO {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // Constructor initializes the database
    public UserDAO() {
        con = new DBConnect().getConnection();
    }

    @Override
    public boolean createUser(User user) {
        int result = 0;
        String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getUserEmail());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("User creation failed: " + e.getMessage());
            return false;
        } finally {
            DBConnect.close(pstmt);
        }
        return (result > 0);
    }

    @Override
    public User getUserById(String userId) {
        String sql = "SELECT * FROM users WHERE user_id = ? ORDER BY user_id";
        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("user_email"));
            }
            return null;

        } catch (SQLException e) {
            System.out.println("User retrieval failed: " + e.getMessage());
            return null;
        } finally {
            DBConnect.close(pstmt, rs);
        }
    }

    @Override
    public List<User> getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ? ORDER BY user_id";
        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, username);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return getListFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            System.out.println("User retrieval by username failed: " + e.getMessage());
            return null;
        } finally {
            DBConnect.close(pstmt, rs);
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users ORDER BY user_id";
        try {
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return getListFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            System.out.println("User retrieval failed: " + e.getMessage());
            return null;
        } finally {
            DBConnect.close(pstmt, rs);
        }
    }

    @Override
    public boolean updateUser(User user) {
        int result = 0;
        String sql = "UPDATE users SET username = ?, password = ?, user_email = ? WHERE user_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setString(4, user.getUserId());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("User update failed: " + e.getMessage());
            return false;
        } finally {
            DBConnect.close(pstmt);
        }
        return (result > 0);
    }

    @Override
    public boolean deleteUser(User user) {
        int result = 0;
        String sql = "DELETE FROM users WHERE user_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("User deletion failed: " + e.getMessage());
            return false;
        } finally {
            DBConnect.close(pstmt);
        }
        return (result > 0);
    }

    @Override
    public User login(String userId, String password) {
        User user = getUserById(userId);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void commitTransaction() {
        try {
            if (con != null) {
                con.commit();
            }
        } catch (SQLException e) {
            System.out.println("Transaction commit failed: " + e.getMessage());
        }
    }

    private List<User> getListFromResultSet(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(
                    rs.getString("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("user_email")));
        }
        return users;
    }
}
