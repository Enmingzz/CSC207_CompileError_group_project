package data_access;

import entity.Product;

import java.sql.SQLException;

public interface ProductUpdateNameDataAccessInterface {
    void updateProductName(Product product, String name) throws SQLException;
}
