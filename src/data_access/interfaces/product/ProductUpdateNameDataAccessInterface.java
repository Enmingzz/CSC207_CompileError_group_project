package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * ProductUpdateNameDataAccessInterface provides an abstraction for updating the name of a product in the database.
 */
public interface ProductUpdateNameDataAccessInterface {

    /**
     * Updates the name of the specified product in the database.
     *
     * @param product the product whose name is to be updated
     * @param name    the new name to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateProductName(Product product, String name) throws SQLException;
}
