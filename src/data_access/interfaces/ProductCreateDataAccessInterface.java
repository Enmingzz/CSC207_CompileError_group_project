package data_access.interfaces;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductCreateDataAccessInterface {
    void saveProduct(Product product) throws SQLException, IOException;
}
