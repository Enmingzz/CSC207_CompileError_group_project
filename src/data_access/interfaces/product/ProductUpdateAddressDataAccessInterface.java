package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * ProductUpdateAddressDataAccessInterface provides an abstraction for updating the address of a product in the database.
 */
public interface ProductUpdateAddressDataAccessInterface {

    /**
     * Updates the address of the specified product in the database.
     *
     * @param product the product whose address is to be updated
     * @param address the new address to be set for the product
     * @throws SQLException if a database access error occurs
     */
    void updateProductAddress(Product product, String address) throws SQLException;
}
