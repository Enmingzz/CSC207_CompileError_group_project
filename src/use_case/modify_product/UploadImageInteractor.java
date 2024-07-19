package use_case.modify_product;

import interface_adapter.modify_product.UploadImagePresenter;
import pic.ImageUploader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadImageInteractor extends JFrame implements UploadImageInputBoundary {

    private final UploadImageOutputBoundary uploadImagePresenter;

    public UploadImageInteractor(UploadImageOutputBoundary uploadImagePresenter) {
        this.uploadImagePresenter = uploadImagePresenter;
    }

    public void execute(UploadImageInputData uploadImageInputData) {

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
