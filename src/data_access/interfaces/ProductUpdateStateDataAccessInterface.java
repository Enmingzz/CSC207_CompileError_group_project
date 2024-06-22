package data_access.interfaces;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductUpdateStateDataAccessInterface {
    void updateProductState(Product product, int state) throws SQLException;
}
