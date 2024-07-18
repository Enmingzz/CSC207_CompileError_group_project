package data_access.in_memory.user;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * In-memory implementation of the UserCreateDataAccessInterface.
 * This class simulates a database by storing users in memory and provides methods to save users.
 */
public class InMemoryUserCreateDataAccessObject implements UserCreateDataAccessInterface {

    private ArrayList<User> users;

    /**
     * Constructs an InMemoryUserCreateDataAccessObject with the given list of users.
     *
     * @param listUsers the initial list of users
     */
    public InMemoryUserCreateDataAccessObject(ArrayList<User> listUsers) {
        users = listUsers;
    }

    /**
     * Saves a user to the in-memory list.
     *
     * @param user the user to save
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void saveUser(User user) throws SQLException {
        users.add(user);
    }
}
