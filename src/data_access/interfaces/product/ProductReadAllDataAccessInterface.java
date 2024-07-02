package data_access.interfaces.product;

import entity.product.Product;
import java.util.ArrayList;

import java.sql.SQLException;
import java.io.IOException;

public interface ProductReadAllDataAccessInterface {
    ArrayList<Product> getAllProducts() throws SQLException, IOException;
}
