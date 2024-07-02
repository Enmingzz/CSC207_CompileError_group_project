package data_access.interfaces.Prouct;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductReadByNameDataAccessInterface {
    ArrayList<Product> getProductByName(String name) throws SQLException, IOException;
}
