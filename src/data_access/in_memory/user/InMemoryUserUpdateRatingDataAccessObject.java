package data_access.in_memory.user;

import data_access.interfaces.user.UserUpdateRatingDataAccessInterface;
import entity.product.Product;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryUserUpdateRatingDataAccessObject implements UserUpdateRatingDataAccessInterface {
    public boolean isCalled;

    public InMemoryUserUpdateRatingDataAccessObject() {
        this.isCalled = false;
    }

    @Override
    public void updateUserRating(Product product) throws SQLException {
        isCalled = true;
    }
}
