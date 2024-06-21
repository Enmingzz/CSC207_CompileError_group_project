package data_access.interfaces;

import entity.user.User;

import java.sql.SQLException;

public interface UserUpdatePasswordDataAccessInterface {
    void updateUserPassword(User user, String password) throws SQLException;
}
