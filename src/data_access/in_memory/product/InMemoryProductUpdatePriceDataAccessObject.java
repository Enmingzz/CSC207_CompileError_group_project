package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;

public class InMemoryProductUpdatePriceDataAccessObject implements ProductUpdatePriceDataAccessInterface {

    @Override
    public void updateProductPrice(Product product, float price) throws SQLException {

    }
}
