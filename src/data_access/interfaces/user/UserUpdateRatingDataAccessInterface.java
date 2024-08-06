package data_access.interfaces.user;

import entity.product.Product;

import java.sql.SQLException;

public interface UserUpdateRatingDataAccessInterface {
    void updateUserRating(Product product) throws SQLException;
}
