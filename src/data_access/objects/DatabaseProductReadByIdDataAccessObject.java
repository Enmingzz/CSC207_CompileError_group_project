package data_access.objects;

import data_access.interfaces.ProductReadByIdDataAccessInterface;
import entity.product.Product;

import java.sql.*;

public class DatabaseProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {

    public DatabaseProductReadByIdDataAccessObject() {}

    @Override
    public Product getProductById(Product product) throws SQLException {
        return null;
    }

}
