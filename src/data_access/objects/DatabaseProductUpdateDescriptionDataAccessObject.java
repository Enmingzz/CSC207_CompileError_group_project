package data_access.objects;

import data_access.interfaces.ProductUpdateDescriptionDataAccessInterface;
import entity.product.Product;

import java.sql.*;

public class DatabaseProductUpdateDescriptionDataAccessObject implements ProductUpdateDescriptionDataAccessInterface {
    @Override
    public void updateProductDescription(Product product, String description) throws SQLException {

    }
}
