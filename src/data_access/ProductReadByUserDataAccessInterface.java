package data_access;

import entity.Product;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductReadByUserDataAccessInterface {
    ArrayList<Product> getProductByUser(User user) throws SQLException;

}
