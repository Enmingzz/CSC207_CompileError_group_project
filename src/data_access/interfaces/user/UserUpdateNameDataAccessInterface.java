package data_access.interfaces.user;

import entity.user.User;

import java.sql.SQLException;

public interface UserUpdateNameDataAccessInterface {
    void updateUserName(User user, String name) throws SQLException;
}
