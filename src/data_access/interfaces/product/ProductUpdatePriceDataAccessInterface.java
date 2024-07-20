package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ProductUpdatePriceDataAccessInterface provides an abstraction for updating the price of a product in the database.
 */
public interface ProductUpdatePriceDataAccessInterface {

    /**
     * Updates the price of the specified product in the database.
     *
     * @param product the product whose price is to be updated
     * @param price   the new price to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateProductPrice(Product product, float price) throws SQLException;
}
