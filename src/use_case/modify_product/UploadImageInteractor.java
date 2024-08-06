package use_case.modify_product;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

/**
 * The UploadImageInteractor class provides functionality to upload an image file from the user's filesystem
 * and save it to a specified directory within the project. It implements the {@link UploadImageInputBoundary}
 * interface and uses a {@link UploadImageOutputBoundary} to present the result of the operation.
 */
public class UploadImageInteractor extends JFrame implements UploadImageInputBoundary {

    private final UploadImageOutputBoundary uploadImagePresenter;

    /**
     * Constructs an UploadImageInteractor instance with the specified output boundary.
     *
     * @param uploadImagePresenter the presenter for handling output data and displaying messages
     */
    public UploadImageInteractor(UploadImageOutputBoundary uploadImagePresenter) {
        this.uploadImagePresenter = uploadImagePresenter;
    }

    /**
     * Executes the process of uploading an image. Opens a file chooser for the user to select an image file,
     * uploads the selected file to a predefined directory, and informs the presenter of the success or failure
     * of the operation.
     *
     * @param uploadImageInputData the input data for uploading the image
     */
    public void execute(UploadImageInputData uploadImageInputData) throws SQLException, IOException {
        JFileChooser fileChooser = new JFileChooser();
        // Set default directory to Desktop
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"), "Desktop"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            uploadImage(selectedFile);
            Path targetDirectory = Paths.get(System.getProperty("user.dir"), "src/pic");
            Path targetFilePath = targetDirectory.resolve(selectedFile.getName());
            Path projectRoot = Paths.get(System.getProperty("user.dir"));
            Path relativePath = projectRoot.relativize(targetFilePath);
            System.out.println("File uploaded to: " + relativePath.toString());
            UploadImageOutputData uploadImageOutputData = new UploadImageOutputData(relativePath.toString());
            uploadImagePresenter.prepareSuccessfulView(uploadImageOutputData);
        }
    }

    /**
     * Uploads the specified image file to the target directory within the project. Creates the target directory
     * if it does not exist, and copies the file to that directory. Displays a message to the user indicating
     * the result of the upload operation.
     *
     * @param file the image file to upload
     */
    private void uploadImage(File file) {
        // Use relative path
        Path projectDir = Paths.get(System.getProperty("user.dir"));
        Path destDir = projectDir.resolve("src/pic");

        // Ensure target directory exists
        try {
            Files.createDirectories(destDir);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to create target directory: " + e.getMessage());
            return;
        }

        File destFile = destDir.resolve(file.getName()).toFile();

        try {
            Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(this, "Image uploaded successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Upload failed: " + ex.getMessage());
        }
    }

//    public static void main(String[] args) {
//        UploadImagePresenter uploadImagePresenter = new UploadImagePresenter();
//        UploadImageInteractor uploadImageInteractor =
//                new UploadImageInteractor(uploadImagePresenter);
//        UploadImageInputData uploadImageInputData = new UploadImageInputData();
//        uploadImageInteractor.execute(uploadImageInputData);
//    }
}
