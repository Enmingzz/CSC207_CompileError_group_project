package data_access.objects;

import data_access.interfaces.ProductUpdateNameDataAccessInterface;
import entity.Product;

import java.sql.*;

public class DatabaseProductUpdateNameDataAccessObject implements ProductUpdateNameDataAccessInterface {
    @Override
    public void updateProductName(Product product, String name) throws SQLException {

    }
}
