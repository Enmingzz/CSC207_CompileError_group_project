package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

public class InMemoryProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {


    @Override
    public Product getProductById(String productID) throws SQLException, IOException {
        return null;
    }
}
