package use_case.view_product;

import java.sql.SQLException;

/**
 * This interface defines the input boundary for the use case of viewing a product.
 * It acts as a contract for any class that wants to implement the functionality of viewing a product.
 */
public interface ViewProductInputBoundary {

    /**
     * Executes the use case of viewing a product.
     *
     * @param viewProductInputData the input data required to view a product.
     * @throws SQLException if there is an error while interacting with the database.
     */
    void execute(ViewProductInputData viewProductInputData) throws SQLException;
}
