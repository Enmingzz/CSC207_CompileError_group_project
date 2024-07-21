package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * The {@code ChangeProductAddressInterface} interface defines the contract for changing the address of a product.
 * Implementations of this interface handle the logic required to update a product's address and return the updated product.
 */
public interface ChangeProductAddressInterface {

    /**
     * Executes the operation to change the address of the specified product.
     *
     * <p>If the new address is the same as the current address, the original product is returned unmodified.</p>
     * <p>Otherwise, a new product instance with the updated address is created and returned.</p>
     *
     * @param product the product whose address is to be changed
     * @param address the new address to be set for the product
     * @return the updated product with the new address
     * @throws SQLException if a database access error occurs during the update
     */
    Product execute(Product product, String address) throws SQLException;
}
