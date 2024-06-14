package data_access;

import entity.User;

public class DatabaseUserSignupSaveDataAccessObject implements UserSignupDataAccessInterface {
    @Override
    public boolean existsByUTorID(String identifier) {
        return false;
    }

    @Override
    public void saveUser(User user) {

    }
}
