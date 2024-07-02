package data_access.interfaces.Prouct;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductReadByTagDataAccessInterface {
    ArrayList<Product> getProductByTag(String tag) throws SQLException, IOException;

}
