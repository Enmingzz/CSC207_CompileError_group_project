package use_case.modify_product;

import use_case.profile.modify_profile.ModifyProfileOutputData;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for the output boundary of the use case that changes product details.
 * <p>
 * This interface defines methods for preparing the views that will be displayed to the user based on the outcome
 * of the product modification process. Implementations are responsible for handling both successful and failed
 * outcomes and presenting the appropriate information to the user.
 * </p>
 */
public interface ChangeProductOutputBoundary {

    /**
     * Prepares the view for a successful product modification.
     * <p>
     * This method is called when the product modification operation is successful. It allows for preparing and
     * presenting the output data that reflects the changes made to the product.
     * </p>
     *
     * @param changeProductOutputData the output data containing the details of the modified product
     * @throws SQLException if an error occurs while accessing or processing data
     * @throws IOException if an error occurs while handling input/output operations
     */
    void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException;

    /**
     * Prepares the view for a failed product modification.
     * <p>
     * This method is called when the product modification operation fails. It allows for preparing and presenting
     * the output data that indicates the failure and provides relevant error messages or information.
     * </p>
     *
     * @param changeProductOutputData the output data containing information about the failure
     */
    void prepareFailView(ChangeProductOutputData changeProductOutputData);
}
