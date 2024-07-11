package data_access.in_memory.user;


import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryUserUpdateNameDataAccessObject implements UserUpdateNameDataAccessInterface {

    private ArrayList<User> users;
   private UserFactory userFactory;

   public InMemoryUserUpdateNameDataAccessObject(ArrayList<User> listUser,
                                                 UserFactory userFactory) {
       users = new ArrayList<>();
       for (User user : listUser) {
           users.add(user);
       }
   }

    @Override
    public void updateUserName(User user, String name) throws SQLException {
        for(User user1 : users) {
            if(user1.getStudentNumber().equals(user.getStudentNumber())) {
                User commonUser = userFactory.createUser(name, user.getPassword(),
                        user.getEmail(),user.getUserRating(), user.getStudentNumber());
            }
        }
    }

}
