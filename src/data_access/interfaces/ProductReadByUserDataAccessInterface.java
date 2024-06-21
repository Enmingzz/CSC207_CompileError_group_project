package data_access.interfaces;

import entity.product.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductReadByUserDataAccessInterface {
    ArrayList<Product> getProductByUser(String userId) throws SQLException;

}
