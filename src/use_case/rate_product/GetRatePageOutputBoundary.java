package use_case.rate_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Defines the output boundary for the process of retrieving a rating page.
 *
 * This interface is responsible for presenting the result of the rating page retrieval
 * process. Implementations of this interface will handle the successful presentation of
 * the rating page data.
 */
public interface GetRatePageOutputBoundary {

    /**
     * Prepares the view for a successful rating page retrieval.
     *
     * This method is called when the rating page data is successfully retrieved. It allows
     * the implementation to present or process the retrieved data.
     *
     * @param getRatePageOutputData The data to be presented, including user and product information.
     * @throws SQLException If a database access error occurs.
     * @throws IOException If an I/O error occurs.
     */
    void prepareSuccessfulView(GetRatePageOutputData getRatePageOutputData) throws SQLException, IOException;
}
