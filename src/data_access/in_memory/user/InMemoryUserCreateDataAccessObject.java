package data_access.in_memory.user;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryUserCreateDataAccessObject implements UserCreateDataAccessInterface {

    private ArrayList<User> users;

    public InMemoryUserCreateDataAccessObject(ArrayList<User> listUsers) {
        users = new ArrayList<>();
        for (User user : listUsers) {
            users.add(user);
        }
    }

    @Override
    public void saveUser(User user) throws SQLException {
        users.add(user);
    }

    public User getUser(String studentNumber) throws SQLException {
        for(User user : users) {
            if(user.getStudentNumber().equals(studentNumber)) {
                return user;
            }
        }
        return null;
    }

}
