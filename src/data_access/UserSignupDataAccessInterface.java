package data_access;

import entity.User;

public interface UserSignupDataAccessInterface {
    boolean existsByUTorID(String identifier);

    void save(User user);
}
