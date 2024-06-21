package data_access;

import entity.Product;

import java.sql.*;

public class DatabaseProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {

    public DatabaseProductReadByIdDataAccessObject() {}

    @Override
    public Product getProductById(Product product) throws SQLException {
        return null;
    }

}
