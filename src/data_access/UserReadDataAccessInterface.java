package data_access;

import entity.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserReadDataAccessInterface {
    User getUser(String studentNumber) throws SQLException;
}
