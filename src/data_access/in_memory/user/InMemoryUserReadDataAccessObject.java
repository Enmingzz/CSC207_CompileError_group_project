package data_access.in_memory.user;

import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;

public class InMemoryUserReadDataAccessObject implements UserReadDataAccessInterface {

    @Override
    public User getUser(String studentNumber) throws SQLException {
        return null;
    }
}
