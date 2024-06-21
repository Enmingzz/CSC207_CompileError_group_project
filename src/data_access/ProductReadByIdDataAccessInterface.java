package data_access;

import entity.Product;

import java.sql.SQLException;

public interface ProductReadByIdDataAccessInterface {
    Product getProductById(Product product) throws SQLException;
}
