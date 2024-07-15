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
        users.addAll(listUser);
    }

    @Override
    public void updateUserPassword(User user, String password) throws SQLException {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getStudentNumber().equals(user.getStudentNumber())) {
                User commonUser = userFactory.createUser(user.getName(), password,
                        user.getEmail(),user.getUserRating(), user.getStudentNumber());
                users.set(i, commonUser);
            }
        }
    }

}
