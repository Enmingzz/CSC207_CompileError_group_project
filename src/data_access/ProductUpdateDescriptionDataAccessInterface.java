package data_access;

import entity.Product;

import java.sql.SQLException;

public interface ProductUpdateDescriptionDataAccessInterface {
    void updateProductDescription(Product product, String description) throws SQLException;
}
