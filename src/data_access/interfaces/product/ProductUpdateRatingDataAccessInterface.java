package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * ProductUpdateRatingDataAccessInterface provides an abstraction for updating the rating of a product in the database.
 */
public interface ProductUpdateRatingDataAccessInterface {

    /**
     * Updates the rating of the specified product in the database.
     *
     * @param product the product whose rating is to be updated
     * @param rating  the new rating to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateProductRating(Product product, int rating) throws SQLException;
}
