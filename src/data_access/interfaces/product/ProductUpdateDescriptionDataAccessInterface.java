package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductUpdateDescriptionDataAccessInterface {
    void updateProductDescription(Product product, String description) throws SQLException;
}
