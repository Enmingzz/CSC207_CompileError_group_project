package data_access.interfaces.Prouct;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductUpdatePriceDataAccessInterface {
    void updateProductPrice(Product product, float price) throws SQLException;

}
