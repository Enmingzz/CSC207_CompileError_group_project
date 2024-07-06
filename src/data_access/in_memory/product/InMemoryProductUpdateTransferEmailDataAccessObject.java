package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;

public class InMemoryProductUpdateTransferEmailDataAccessObject implements ProductUpdateTransferEmailDataAccessInterface {

    @Override
    public void updateProductEmail(Product product, String eMail) throws SQLException {

    }
}
