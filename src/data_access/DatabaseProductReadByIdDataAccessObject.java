package data_access;

import entity.Product;

import java.sql.*;

public class DatabaseProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {
    @Override
    public Product getProductById(String productId) throws SQLException {
        return null;
    }
}
