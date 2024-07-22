package use_case.view_product;

import java.sql.SQLException;

/**
 * This interface defines the output boundary for the use case of viewing a product.
 * It acts as a contract for any class that wants to implement the presentation of the result of viewing a product.
 */
public interface ViewProductOutputBoundary {

    /**
     * Prepares the success view for the view product use case.
     *
     * @param viewProductOutputData the output data containing the result of the view product use case.
     * @throws SQLException if there is an error while interacting with the database.
     */
    void prepareViewSucceed(ViewProductOutputData viewProductOutputData) throws SQLException;
}
