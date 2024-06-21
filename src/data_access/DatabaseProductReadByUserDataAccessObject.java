package data_access;

import entity.Product;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseProductReadByUserDataAccessObject implements ProductReadByUserDataAccessInterface{

    public DatabaseProductReadByUserDataAccessObject() {}

    @Override
    public ArrayList<Product> getProductByUser(User user) throws SQLException {
        return null;
    }
}
