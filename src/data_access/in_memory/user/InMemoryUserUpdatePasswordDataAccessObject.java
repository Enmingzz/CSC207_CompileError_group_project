package data_access.in_memory.user;

import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryUserUpdatePasswordDataAccessObject implements UserUpdatePasswordDataAccessInterface {

    private ArrayList<User> users;
    private UserFactory userFactory;

    public InMemoryUserUpdatePasswordDataAccessObject(ArrayList<User> listUser, UserFactory userFactory) {
        users = new ArrayList<>();
        this.userFactory = userFactory;
        for (User user : listUser) {
            users.add(user);
        }
    }

    @Override
    public void updateUserPassword(User user, String password) throws SQLException {
        for(User user1 : users) {
            if(user1.getStudentNumber().equals(user.getStudentNumber())) {
                User commonUser = userFactory.createUser(user.getName(), password,
                        user.getEmail(),user.getUserRating(), user.getStudentNumber());
            }
        }
    }

}
