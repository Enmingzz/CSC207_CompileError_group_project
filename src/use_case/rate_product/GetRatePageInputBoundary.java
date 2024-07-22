package use_case.rate_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Defines the boundary for the input data required to retrieve the rating page.
 *
 * This interface is responsible for processing the input data necessary for retrieving
 * and displaying the rating page. Implementations of this interface should handle the
 * retrieval and preparation of data for the rating page view.
 */
public interface GetRatePageInputBoundary {

    /**
     * Processes the provided input data to retrieve and prepare the rating page.
     *
     * @param getRatePageInputData The input data required to retrieve the rating page.
     * @throws SQLException If an SQL error occurs during the retrieval process.
     * @throws IOException If an I/O error occurs while processing the data.
     */
    void execute(GetRatePageInputData getRatePageInputData) throws SQLException, IOException;
}
