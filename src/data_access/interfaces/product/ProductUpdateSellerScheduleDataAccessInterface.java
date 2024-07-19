package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * ProductUpdateSellerScheduleDataAccessInterface provides an abstraction for updating the seller's schedule times for a product in the database.
 */
public interface ProductUpdateSellerScheduleDataAccessInterface {

    /**
     * Updates the seller's schedule times for the specified product in the database.
     *
     * @param product  the product whose seller's schedule times are to be updated
     * @param listTimes the new list of seller's schedule times to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateSellerSchedule(Product product, ArrayList<LocalDateTime> listTimes) throws SQLException;
}
