package data_access.interfaces.Prouct;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductUpdateNameDataAccessInterface {
    void updateProductName(Product product, String name) throws SQLException;
}
