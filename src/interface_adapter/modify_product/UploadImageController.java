package interface_adapter.modify_product;

import use_case.modify_product.UploadImageInputBoundary;
import use_case.modify_product.UploadImageInputData;

public class UploadImageController {

    private final UploadImageInputBoundary uploadImageInteractor;

    public UploadImageController(UploadImageInputBoundary uploadImageInteractor) {
        this.uploadImageInteractor = uploadImageInteractor;
    }

    public void execute(){
        UploadImageInputData uploadImageInputData = new UploadImageInputData();
        uploadImageInteractor.execute(uploadImageInputData);
    }
}
