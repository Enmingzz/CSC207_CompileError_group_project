package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * Interface for modifying the e-transfer email.
 * <p>
 * This interface defines a contract for classes responsible for updating the e-transfer email
 * of a product in a persistent storage or data source.
 * </p>
 */
public interface ChangeProductEmailInterface {

    /**
     * Updates the e-transfer email of the specified product.
     * <p>
     * This method applies the given email to the product and persists the change to the data source.
     * </p>
     *
     * @param product the product whose e-transfer email is to be updated
     * @param email the new e-transfer email to set for the product
     * @return the updated product instance with the new e-transfer email
     * @throws SQLException if there is a database access error
     */
    Product execute(Product product, String email) throws SQLException;
}
