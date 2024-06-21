package data_access.interfaces;

import entity.User;

import java.sql.SQLException;

public interface UserCreateDataAccessInterface {
    //boolean existsByUserID(String identifier) throws SQLException;

    void saveUser(User user) throws SQLException;
}
