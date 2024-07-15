package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import entity.product.Product;
import interface_adapter.modify_product.ModifyProductPresenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class ChangeProductInteractor implements ChangeProductInputBoundary{

    private final ChangeProductOutputBoundary changeProductOutputBoundary;
    private final ChangeProductDescriptionInterface changeProductDescriptionInterface;
    private final ChangeProductPriceInterface changeProductPriceInterface;
    private final ChangeProductPictureInterface changeProductPictureInterface;


    public ChangeProductInteractor(ChangeProductOutputBoundary changeProductOutputBoundary,
                                   ChangeProductDescriptionInterface changeProductDescriptionInterface, ChangeProductPriceInterface changeProductPriceInterface,
                                   ChangeProductPictureInterface changeProductPictureInterface) {
        this.changeProductOutputBoundary = changeProductOutputBoundary;
        this.changeProductDescriptionInterface = changeProductDescriptionInterface;
        this.changeProductPriceInterface = changeProductPriceInterface;
        this.changeProductPictureInterface = changeProductPictureInterface;
    }

    public void execute(ChangeProductInputData changeProductInputData) throws SQLException, IOException {
        boolean descriptionFlag = changeProductDescriptionInterface.execute(changeProductInputData.getProduct(), changeProductInputData.getChangedDescription());
        boolean priceFlag = changeProductPriceInterface.execute(changeProductInputData.getProduct(), changeProductInputData.getChangedPrice());

        if (descriptionFlag & priceFlag) {
            //If the new description and price they inputted are both valid, then update the image and pass on the information
            //that the change has been successfully made.
            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changeProductInputData.getProduct(),
                    "Successfully modified product", changeProductInputData.getUser());
            changeProductPictureInterface.execute(changeProductInputData.getProduct(), changeProductInputData.getChangedImage());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
        else if(descriptionFlag) {
            //If only the description was successfully modified
            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changeProductInputData.getProduct(),
                    "Only the price failed to update", changeProductInputData.getUser());
            changeProductPictureInterface.execute(changeProductInputData.getProduct(), changeProductInputData.getChangedImage());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
        else if(priceFlag) {
            //If only the description was successfully modified
            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changeProductInputData.getProduct(),
                    "Only the description failed to update", changeProductInputData.getUser());
            changeProductPictureInterface.execute(changeProductInputData.getProduct(), changeProductInputData.getChangedImage());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
        else {
            //If both of the description and price failed to upload, then don't make the update.
            changeProductPictureInterface.execute(changeProductInputData.getProduct(), changeProductInputData.getChangedImage());
            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changeProductInputData.getProduct(),
                    "Both the description and price failed to update", changeProductInputData.getUser());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
    }
}
