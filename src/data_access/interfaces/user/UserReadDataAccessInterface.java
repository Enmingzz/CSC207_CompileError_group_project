package data_access.interfaces.user;

import entity.user.User;

import java.sql.SQLException;

public interface UserReadDataAccessInterface {
    User getUser(String studentNumber) throws SQLException;
}
