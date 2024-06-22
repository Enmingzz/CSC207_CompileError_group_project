package data_access.interfaces;

import entity.product.Product;

import java.sql.SQLException;

public interface ProductUpdateAddressDataAccessInterface {
    void updateProductAddress(Product product, String address) throws SQLException;
}
