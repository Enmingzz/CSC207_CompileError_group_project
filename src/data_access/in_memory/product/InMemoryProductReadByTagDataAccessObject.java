package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryProductReadByTagDataAccessObject implements ProductReadByTagDataAccessInterface {

    @Override
    public ArrayList<Product> getProductByTag(String tag) throws SQLException, IOException {
        return null;
    }
}
