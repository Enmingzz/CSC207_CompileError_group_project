package data_access.in_memory.user;

import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * In-memory implementation of the UserUpdateNameDataAccessInterface.
 * This class simulates a database by storing users in memory and provides methods to update user names.
 */

public class InMemoryUserUpdateNameDataAccessObject implements UserUpdateNameDataAccessInterface {

    private final ArrayList<User> users;
    private final UserFactory userFactory;

    /**
     * Constructs an InMemoryUserUpdateNameDataAccessObject with the given list of users and user factory.
     *
     * @param listUser the initial list of users
     * @param userFactory the factory for creating user objects
     */
    public InMemoryUserUpdateNameDataAccessObject(ArrayList<User> listUser, UserFactory userFactory) {
        this.userFactory = userFactory;
        users = listUser;
    }

    /**
     * Updates the name of the given user.
     * Creates a new user with the updated name and replaces the old user in the list.
     *
     * @param user the user whose name is to be updated
     * @param name the new name for the user
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateUserName(User user, String name) throws SQLException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getStudentNumber().equals(user.getStudentNumber())) {
                User commonUser = userFactory.createUser(name, user.getPassword(),
                        user.getEmail(), user.getUserRating(), user.getStudentNumber());
                users.set(i, commonUser);
            }
        }
    }
}
