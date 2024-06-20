package entity;

import java.util.ArrayList;

public interface UserFactory {
    public User createUser(String name, String Password, String email, float userRating, String studentNumber);
    }
