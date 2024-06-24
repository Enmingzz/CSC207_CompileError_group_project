package data_access.interfaces.Prouct;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductReadByUserDataAccessInterface {
    ArrayList<Product> getProductByUser(String userID) throws SQLException, IOException;

}
