package data_access.in_memory.user;


import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class InMemoryUserUpdateNameDataAccessObject implements UserUpdateNameDataAccessInterface {

    @Override
    public void updateUserName(User user, String name) throws SQLException {

    }
}
