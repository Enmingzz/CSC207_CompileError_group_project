package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * ProductUpdateTransferEmailDataAccessInterface provides an abstraction for updating the transfer email of a product in the database.
 */
public interface ProductUpdateTransferEmailDataAccessInterface {

    /**
     * Updates the transfer email of the specified product in the database.
     *
     * @param product the product whose transfer email is to be updated
     * @param eMail   the new transfer email to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateProductEmail(Product product, String eMail) throws SQLException;
}
