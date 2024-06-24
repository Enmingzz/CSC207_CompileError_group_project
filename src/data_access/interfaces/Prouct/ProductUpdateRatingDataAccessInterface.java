package data_access.interfaces.Prouct;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductUpdateRatingDataAccessInterface {
    void updateProductRating(Product product, int rating) throws SQLException;
}
