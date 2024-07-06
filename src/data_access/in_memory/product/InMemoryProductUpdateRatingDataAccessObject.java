package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;


public class InMemoryProductUpdateRatingDataAccessObject implements ProductUpdateRatingDataAccessInterface {

    @Override
    public void updateProductRating(Product product, int rating) throws SQLException {

    }
}
