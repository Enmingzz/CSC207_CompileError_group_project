package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;

public class InMemoryProductUpdateNameDataAccessObject implements ProductUpdateNameDataAccessInterface {

    @Override
    public void updateProductName(Product product, String name) throws SQLException {

    }
}
