package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;

public class InMemoryProductUpdateStateDataAccessObject implements ProductUpdateStateDataAccessInterface {

    @Override
    public void updateProductState(Product product, int state) throws SQLException {

    }
}
