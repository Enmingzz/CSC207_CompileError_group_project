package data_access.interfaces.User;

import entity.user.User;

import java.sql.SQLException;

public interface UserReadDataAccessInterface {
    User getUser(String studentNumber) throws SQLException;
}
