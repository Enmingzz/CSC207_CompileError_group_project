package use_case.modify_product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.Product;
import interface_adapter.modify_product.ModifyProductPresenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ChangeProductInteractor implements ChangeProductInputBoundary{

    private final ChangeProductOutputBoundary changeProductOutputBoundary;
    private final ChangeProductDescriptionInterface changeProductDescriptionInterface;
    private final ChangeProductPriceInterface changeProductPriceInterface;

    public ChangeProductInteractor(ChangeProductOutputBoundary changeProductOutputBoundary,
                                   ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface,
                                   ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface){
        this.changeProductOutputBoundary = changeProductOutputBoundary;
        this.changeProductDescriptionInterface = new ChangeProductDescription(productUpdateDescriptionDataAccessInterface);
        this.changeProductPriceInterface = new ChangeProductPrice(productUpdatePriceDataAccessInterface);
    }

    public void execute(ChangeProductInputData changeProductInputData) throws SQLException, IOException {
        Product changedProduct = changeProductInputData.getProduct();
        changeProductDescriptionInterface.execute(changedProduct, changeProductInputData.getChangedDescription());
        changeProductPriceInterface.execute(changedProduct, changeProductInputData.getChangedPrice());

        boolean descriptionFlag = changeProductDescriptionInterface.execute(changedProduct, changeProductInputData.getChangedDescription());
        boolean priceFlag = changeProductPriceInterface.execute(changedProduct, changeProductInputData.getChangedPrice());

        if (descriptionFlag & priceFlag) {
            //If the new description and price they inputted are both valid

            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
                    "Successfully modified product", changeProductInputData.getUser());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
        else if(descriptionFlag) {
            //If only the description was successfully modified
            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
                    "Only the price failed to update", changeProductInputData.getUser());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
        else if(priceFlag) {
            //If only the description was successfully modified
            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
                    "Only the description failed to update", changeProductInputData.getUser());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
        else {
            //If both of the description and price failed to upload, then don't make the update.
            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
                    "Both the description and price failed to update", changeProductInputData.getUser());
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        }
    }
}
