package use_case.modify_product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for the output boundary of the image upload use case.
 *
 * This interface defines the methods that the output boundary must implement to handle
 * the results of the image upload operation. Implementations of this interface are
 * responsible for preparing the view based on the outcome of the upload process.
 */
public interface UploadImageOutputBoundary {

    /**
     * Prepares the view for a successful image upload operation.
     *
     * @param uploadImageOutputData An object containing the data related to the image upload operation,
     *                              including the uploaded image and any associated metadata.
     * @throws SQLException If a database access error occurs while preparing the view.
     * @throws IOException  If an I/O error occurs while preparing the view.
     */
    void prepareSuccessfulView(UploadImageOutputData uploadImageOutputData) throws SQLException, IOException;
}
