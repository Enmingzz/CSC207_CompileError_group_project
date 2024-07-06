package data_access.in_memory.user;

import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class InMemoryUserUpdatePasswordDataAccessObject implements UserUpdatePasswordDataAccessInterface {

    @Override
    public void updateUserPassword(User user, String password) throws SQLException {

    }
}
