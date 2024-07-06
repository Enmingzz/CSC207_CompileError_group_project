package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryProductReadByNameDataAccessObject implements ProductReadByNameDataAccessInterface {

    @Override
    public ArrayList<Product> getProductByName(String name) throws SQLException, IOException {
        return null;
    }
}
