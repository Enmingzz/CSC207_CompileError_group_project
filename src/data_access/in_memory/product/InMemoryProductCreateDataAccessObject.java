package data_access.in_memory.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * DatabaseProductCreateDataAccessObject receives modify_product from CreateProductUseCaseInteractor
 * no return value
 */
public class InMemoryProductCreateDataAccessObject implements ProductCreateDataAccessInterface {

    @Override
    public void saveProduct(Product product) throws SQLException, IOException {

    }
}
