package data_access;

import entity.Product;
import java.sql.*;

/**
 * DatabaseProductCreateDataAccessObject receives product from CreateProductUseCaseInteractor
 * no return value
 */
public class DatabaseProductCreateDataAccessObject implements ProductCreateDataAccessInterface {
    @Override
    public void saveProduct(Product product) throws SQLException {
        
    }
}
