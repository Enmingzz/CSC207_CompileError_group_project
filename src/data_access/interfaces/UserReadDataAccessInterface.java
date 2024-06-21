package data_access.interfaces;

import entity.User;

import java.sql.SQLException;

public interface UserReadDataAccessInterface {
    User getUser(String studentNumber) throws SQLException;
}
