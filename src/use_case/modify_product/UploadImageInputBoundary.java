package use_case.modify_product;

import java.io.IOException;

/**
 * Interface for the use case of uploading an image for a product.
 * Defines the contract for handling image upload operations.
 */
public interface UploadImageInputBoundary {

    /**
     * Executes the image upload process.
     *
     * @param imageInputData the data needed for uploading the image, including the product and image details
     * @throws IOException if an I/O error occurs during the image upload process
     */
    void execute(UploadImageInputData imageInputData) throws IOException;
}
