package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryProductReadAllDataAccessObject implements ProductReadAllDataAccessInterface {

    @Override
    public ArrayList<Product> getAllProducts() throws SQLException, IOException {
        return null;
    }
}
