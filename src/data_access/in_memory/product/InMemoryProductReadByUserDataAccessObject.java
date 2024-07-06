package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryProductReadByUserDataAccessObject implements ProductReadByUserDataAccessInterface {

    @Override
    public ArrayList<Product> getProductByUser(String userID) throws SQLException, IOException {
        return null;
    }
}
