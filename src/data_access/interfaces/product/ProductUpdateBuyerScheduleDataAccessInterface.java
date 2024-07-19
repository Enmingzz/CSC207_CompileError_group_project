package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * ProductUpdateBuyerScheduleDataAccessInterface provides an abstraction for updating the buyer's schedule time for a product in the database.
 */
public interface ProductUpdateBuyerScheduleDataAccessInterface {

    /**
     * Updates the buyer's schedule time for the specified product in the database.
     *
     * @param product           the product whose buyer's schedule time is to be updated
     * @param buyerScheduleTime the new buyer's schedule time to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateBuyerScheduleByProductID(Product product, LocalDateTime buyerScheduleTime) throws SQLException;
}
