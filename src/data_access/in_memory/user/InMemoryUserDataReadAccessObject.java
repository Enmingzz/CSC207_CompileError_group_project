package data_access.in_memory.user;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * mocked DAO for User table
 */

public class InMemoryUserDataReadAccessObject implements UserReadDataAccessInterface{

    private ArrayList<User> users;
    private UserFactory userFactory;

    public InMemoryUserDataReadAccessObject(ArrayList<User> listUser, UserFactory userFactory) {
        users = new ArrayList<>();
        users.addAll(listUser);
        this.userFactory = userFactory;
    }

    @Override
    public User getUser(String studentNumber) throws SQLException {
        for(User user : users) {
            if(user.getStudentNumber().equals(studentNumber)) {
                return user;
            }
        }
        return null;
    }

}
