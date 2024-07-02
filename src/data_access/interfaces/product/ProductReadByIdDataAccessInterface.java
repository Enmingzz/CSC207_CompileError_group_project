package data_access.interfaces.product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductReadByIdDataAccessInterface {
    Product getProductById(String productID) throws SQLException, IOException;
}
