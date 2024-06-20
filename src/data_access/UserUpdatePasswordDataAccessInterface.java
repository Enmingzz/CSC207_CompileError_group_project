package data_access;

import entity.User;

import java.sql.SQLException;

public interface UserUpdatePasswordDataAccessInterface {
    void updateUserPassword(User user, String password) throws SQLException;
}
