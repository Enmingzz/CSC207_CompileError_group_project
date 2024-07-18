package data_access.in_memory.user;

import data_access.interfaces.user.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * In-memory implementation of the UserReadDataAccessInterface.
 * This class simulates a database by storing users in memory and provides methods to retrieve users.
 */
public class InMemoryUserDataReadAccessObject implements UserReadDataAccessInterface {

    private final ArrayList<User> users;
    private final UserFactory userFactory;

    /**
     * Constructs an InMemoryUserDataReadAccessObject with the given list of users and user factory.
     *
     * @param listUser the initial list of users
     * @param userFactory the factory for creating user objects
     */
    public InMemoryUserDataReadAccessObject(ArrayList<User> listUser, UserFactory userFactory) {
        users = new ArrayList<>(listUser);
        this.userFactory = userFactory;
    }

    /**
     * Retrieves a user by their student number.
     *
     * @param studentNumber the student number of the user to retrieve
     * @return the user with the given student number, or null if no such user exists
     * @throws SQLException if a database access error occurs
     */
    @Override
    public User getUser(String studentNumber) throws SQLException {
        for (User user : users) {
            if (user.getStudentNumber().equals(studentNumber)) {
                return user;
            }
        }
        return null;
    }
}
