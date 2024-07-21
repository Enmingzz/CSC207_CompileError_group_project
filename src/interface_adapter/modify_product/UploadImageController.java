package interface_adapter.modify_product;

import use_case.modify_product.UploadImageInputBoundary;
import use_case.modify_product.UploadImageInputData;

import java.io.IOException;

/**
 * Controller for handling image upload operations.
 *
 * This class facilitates the interaction between the view and the use case for uploading images.
 */
public class UploadImageController {

    private final UploadImageInputBoundary uploadImageInteractor;

    /**
     * Constructs an UploadImageController with the specified upload image input boundary.
     *
     * @param uploadImageInteractor The use case boundary for handling image upload operations.
     */
    public UploadImageController(UploadImageInputBoundary uploadImageInteractor) {
        this.uploadImageInteractor = uploadImageInteractor;
    }

    /**
     * Executes the image upload use case.
     *
     * Creates an instance of {@link UploadImageInputData} and invokes the {@link UploadImageInputBoundary}
     * to perform the image upload operation.
     */
    public void execute() throws IOException {
        UploadImageInputData uploadImageInputData = new UploadImageInputData();
        uploadImageInteractor.execute(uploadImageInputData);
    }
}
