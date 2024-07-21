package use_case.modify_product;

/**
 * Represents the output data for the image upload use case.
 *
 * This class contains information about the uploaded image, including its path.
 */
public class UploadImageOutputData {

    private final String path;

    /**
     * Constructs an instance of {@code UploadImageOutputData} with the specified image path.
     *
     * @param path The path where the uploaded image is stored.
     */
    public UploadImageOutputData(String path) {
        this.path = path;
    }

    /**
     * Returns the path of the uploaded image.
     *
     * @return A {@code String} representing the path where the uploaded image is stored.
     */
    public String getPath() {
        return path;
    }
}
