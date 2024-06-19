package data_access;

import entity.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserLoginDataReadAccessInterface {
    User getUser(String userEmail) throws SQLException, IOException;
}
