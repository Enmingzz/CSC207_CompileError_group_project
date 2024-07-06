package data_access.in_memory.user;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class InMemoryUserCreateDataAccessObject implements UserCreateDataAccessInterface {

    @Override
    public void saveUser(User user) throws SQLException {

    }
}
