package data_access.interfaces;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductReadByIdDataAccessInterface {
    Product getProductById(Product product) throws SQLException;
}
