package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * ProductUpdateDescriptionDataAccessInterface provides an abstraction for updating the description of a product in the database.
 */
public interface ProductUpdateDescriptionDataAccessInterface {

    /**
     * Updates the description of the specified product in the database.
     *
     * @param product     the product whose description is to be updated
     * @param description the new description to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateProductDescription(Product product, String description) throws SQLException;
}
