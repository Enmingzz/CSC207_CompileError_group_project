package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * ProductUpdateStateDataAccessInterface provides an abstraction for updating the state of a product in the database.
 */
public interface ProductUpdateStateDataAccessInterface {

    /**
     * Updates the state of the specified product in the database.
     *
     * @param product the product whose state is to be updated
     * @param state   the new state to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateProductState(Product product, int state) throws SQLException;
}
