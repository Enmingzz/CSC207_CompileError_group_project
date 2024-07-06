package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;

public class InMemoryProductUpdateAddressDataAccessObject implements ProductUpdateAddressDataAccessInterface {

    @Override
    public void updateProductAddress(Product product, String address) throws SQLException {

    }
}
