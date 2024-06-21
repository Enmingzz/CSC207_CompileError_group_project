package data_access.interfaces;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductUpdateDescriptionDataAccessInterface {
    void updateProductDescription(Product product, String description) throws SQLException;
}
