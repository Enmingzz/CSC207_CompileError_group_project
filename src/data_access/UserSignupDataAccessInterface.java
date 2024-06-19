package data_access;

import entity.User;

import java.sql.SQLException;

public interface UserSignupDataAccessInterface {
    boolean existsByUTorID(String identifier) throws SQLException;

    void saveUser(User user) throws SQLException;
}
