package data_access.in_memory.user;

import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * In-memory implementation of the UserUpdatePasswordDataAccessInterface.
 * This class simulates a database by storing users in memory and provides methods to update user passwords.
 */
public class InMemoryUserUpdatePasswordDataAccessObject implements UserUpdatePasswordDataAccessInterface {

    private final ArrayList<User> users;
    private final UserFactory userFactory;

    /**
     * Constructs an InMemoryUserUpdatePasswordDataAccessObject with the given list of users and user factory.
     *
     * @param listUser the initial list of users
     * @param userFactory the factory for creating user objects
     */
    public InMemoryUserUpdatePasswordDataAccessObject(ArrayList<User> listUser, UserFactory userFactory) {
        this.users = new ArrayList<>(listUser);
        this.userFactory = userFactory;
    }

    /**
     * Updates the password of the given user.
     * Creates a new user with the updated password and replaces the old user in the list.
     *
     * @param user the user whose password is to be updated
     * @param password the new password for the user
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateUserPassword(User user, String password) throws SQLException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getStudentNumber().equals(user.getStudentNumber())) {
                User commonUser = userFactory.createUser(user.getName(), password,
                        user.getEmail(), user.getUserRating(), user.getStudentNumber());
                users.set(i, commonUser);
            }
        }
    }
}
