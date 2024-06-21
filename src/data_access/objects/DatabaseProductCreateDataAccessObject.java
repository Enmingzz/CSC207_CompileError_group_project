package data_access.objects;

import data_access.interfaces.ProductCreateDataAccessInterface;
import entity.product.Product;
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
