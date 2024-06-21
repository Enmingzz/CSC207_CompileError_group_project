package data_access.interfaces;

import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductReadByUserDataAccessInterface {
    ArrayList<Product> getProductByUser(User user) throws SQLException;

}
