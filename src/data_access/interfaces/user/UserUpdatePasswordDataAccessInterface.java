package data_access.interfaces.user;

import entity.user.User;

import java.sql.SQLException;

public interface UserUpdatePasswordDataAccessInterface {
    void updateUserPassword(User user, String password) throws SQLException;
}
