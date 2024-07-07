package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;

/**
 * Update specific modify_product description
 * Input is modify_product and String description
 * No return Value
 * @author CompileError group
 */

public class InMemoryProductUpdateDescriptionDataAccessObject implements ProductUpdateDescriptionDataAccessInterface {

    @Override
    public void updateProductDescription(Product product, String description) throws SQLException {

    }
}
