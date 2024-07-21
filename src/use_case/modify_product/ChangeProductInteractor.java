package use_case.modify_product;

import data_access.interfaces.product.*;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static java.lang.Float.parseFloat;

public class ChangeProductInteractor implements ChangeProductInputBoundary{

    private final ChangeProductOutputBoundary changeProductOutputBoundary;
    private final ChangeProductDescriptionInterface changeProductDescriptionInterface;
    private final ChangeProductPriceInterface changeProductPriceInterface;
    private final ChangeProductAddressInterface changeProductAddressInterface;
    private final ChangeProductEmailInterface changeProductEmailInterface;
    private final ChangeProductImageInterface changeProductImageInterface;
    private final ChangeProductTitleInterface changeProductTitleInterface;

    public ChangeProductInteractor(ChangeProductOutputBoundary changeProductOutputBoundary,
                                   ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface,
                                   ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface,
                                   ProductUpdateAddressDataAccessInterface productUpdateAddressDataAccessInterface,
                                   ProductUpdateNameDataAccessInterface productUpdateNameDataAccessInterface,
                                   ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface,
                                   ProductUpdateTransferEmailDataAccessInterface productUpdateTransferEmailDataAccessInterface){

        this.changeProductOutputBoundary = changeProductOutputBoundary;
        this.changeProductDescriptionInterface = new ChangeProductDescription(productUpdateDescriptionDataAccessInterface);
        this.changeProductPriceInterface = new ChangeProductPrice(productUpdatePriceDataAccessInterface);
        this.changeProductAddressInterface = new ChangeProductAddress(productUpdateAddressDataAccessInterface);
        this.changeProductEmailInterface = new ChangeProductEmail(productUpdateTransferEmailDataAccessInterface);
        this.changeProductImageInterface = new ChangeProductImage(productUpdatePictureDataAccessInterface);
        this.changeProductTitleInterface = new ChangeProductTitle(productUpdateNameDataAccessInterface);
    }

    public void execute(ChangeProductInputData changeProductInputData) throws SQLException, IOException {

        Product changedProduct = changeProductInputData.getProduct();
        Product orignProduct = changeProductInputData.getProduct();
//        boolean noChangeFlag;

//        boolean descriptionFlag;
//        boolean priceFlag;
//        boolean addressFlag;
//        boolean titleFlag;
//        boolean emailFlag;
//        boolean imageFlag;
//        System.out.println(descriptionFlag);
//        System.out.println(priceFlag);;
//
//        imageFlag = changeProductInputData.getImage() != null;
//
//        addressFlag = !Objects.equals(changeProductInputData.getAddress(), "");
//
//        titleFlag = !Objects.equals(changeProductInputData.getTitle(), "");
//
//        emailFlag = !Objects.equals(changeProductInputData.getEmail(), "");
//
//        descriptionFlag = !Objects.equals(changeProductInputData.getChangedDescription(), "");
//
//        /** Next we will check if the new price they enetered is valid. There will be two
//         * conditions to check.*/
//        String price = changeProductInputData.getChangedPrice();
//        //first we will test if the price entered is a float and a positive number
//        float floatPrice = 0;
//        try {
//            floatPrice = parseFloat(price);
//            if(floatPrice >= 0) {
//                priceFlag = true;
//            }
//            else{
//                priceFlag = false;
//            }
//        } catch (NumberFormatException e) {
//            priceFlag = false;
//        }
//        //Next we need to verify that the amount they entered has at most 2 decimal places
//        if(priceFlag) {
//            int decimalPointIndex = price.indexOf('.');
//            if(price.indexOf('.') >= 0) {
//                String decimalPart = price.substring(decimalPointIndex);
//                if(decimalPart.length() > 2) {
//                    priceFlag = false;
//                }
//            }
//        }

        changedProduct = changeProductDescriptionInterface.execute(changedProduct,
                    changeProductInputData.getChangedDescription());
        changedProduct = changeProductPriceInterface.execute(changedProduct,
                changeProductInputData.getChangedPrice());
        changedProduct = changeProductAddressInterface.execute(changedProduct,
                changeProductInputData.getAddress());
        changedProduct = changeProductEmailInterface.execute(changedProduct,
                changeProductInputData.getEmail());
        changedProduct = changeProductImageInterface.execute(changedProduct,
                changeProductInputData.getImage());
        changedProduct = changeProductTitleInterface.execute(changedProduct,
                changeProductInputData.getTitle());

        ChangeProductOutputData changeProductOutputData = (!Objects.equals(changedProduct.geteTransferEmail(),
                orignProduct.geteTransferEmail()) |
                !Objects.equals(changedProduct.getDescription(), orignProduct.getDescription()) |
                !Objects.equals(changedProduct.getTitle(), orignProduct.getTitle()) |
                !Objects.equals(changedProduct.getImage(), orignProduct.getImage()) |
                !Objects.equals(changedProduct.getAddress(), orignProduct.getAddress()) |
                !Objects.equals(changedProduct.getPrice(), orignProduct.getPrice()))?

                new ChangeProductOutputData(changedProduct,
                "Successfully modified product", changeProductInputData.getUser()):
                new ChangeProductOutputData(changedProduct,
                "You didn't Change any thing!", changeProductInputData.getUser());
        if (Objects.equals(changeProductOutputData.getMessage(), "Successfully modified product")){
            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
        } else {
            changeProductOutputBoundary.prepareFailView(changeProductOutputData);
        }
// =======
//         if (!Objects.equals(changeProductInputData.getChangedDescription(), "") & changeProductInputData.getChangedDescription() != null) {
//             descriptionFlag = true;
//         }
//         else {
//             descriptionFlag = false;
//         }
//         /** Next we will check if the new price they enetered is valid. There will be two
//          * conditions to check.*/
//         String price = changeProductInputData.getChangedPrice();
//         //first we will test if the price entered is a float and a positive number
//         float floatPrice;
//         try {
//             floatPrice = parseFloat(price);
//             if(floatPrice >= 0) {
//                 priceFlag = true;
//             }
//             else{
//                 priceFlag = false;
//             }
//         } catch (NumberFormatException e) {
//             priceFlag = false;
//         }
//         //Next we need to verify that the amount they entered has at most 2 decimal places
//         if(priceFlag) {
//             int decimalPointIndex = price.indexOf('.');
//             if(price.indexOf('.') >= 0) {
//                 String decimalPart = price.substring(decimalPointIndex);
//                 if(decimalPart.length() > 2) {
//                     priceFlag = false;
//                 }
//             }
//         }

//         if (descriptionFlag & priceFlag) {
//             //If the new description and price they inputted are both valid
//             ProductFactory commonProductFactory = new CommonProductFactory();
// //            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
// //                    changeProductInputData.getChangedDescription(), changedProduct.getTitle(),
// //                    parseFloat(changeProductInputData.getChangedPrice()),
// //                    changedProduct.getRating(),
// //                    changedProduct.getState(), changedProduct.geteTransferEmail(),
// //                    changedProduct.getSellerStudentNumber(), changedProduct.getAddress(),
// //                    changedProduct.getListTags(), changedProduct.getProductID(),
// //                    changedProduct.getSchedule());

//             changedProduct = changeProductPriceInterface.execute(changedProduct,
//                     changeProductInputData.getChangedPrice());
//             changedProduct = changeProductDescriptionInterface.execute(changedProduct,
//                     changeProductInputData.getChangedDescription());
//             ChangeProductOutputData changeProductOutputData =
//                     new ChangeProductOutputData(changedProduct,
//                     "Successfully modified product", changeProductInputData.getUser());
//             changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
//         }
//         else if(descriptionFlag) {
//             changedProduct = changeProductDescriptionInterface.execute(changedProduct,
//                     changeProductInputData.getChangedDescription());
//             //If only the description was successfully modified
//             ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
//                     "Only the price failed to update", changeProductInputData.getUser());
//             changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
//         }
//         else if(priceFlag) {
//             //If only the description was successfully modified
//             changedProduct = changeProductPriceInterface.execute(changedProduct,
//                     changeProductInputData.getChangedPrice());
//             ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
//                     "Only the description failed to update", changeProductInputData.getUser());
//             changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
//         }
//         else {
//             //If both of the description and price failed to upload, then don't make the update.
//             ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changeProductInputData.getProduct(),
//                     "Both the description and price failed to update", changeProductInputData.getUser());
// >>>>>>> main




//        if (emailFlag & priceFlag) {
//            //If the new description and price they inputted are both valid
//            ProductFactory commonProductFactory = new CommonProductFactory();
////            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
////                    changeProductInputData.getChangedDescription(), changedProduct.getTitle(),
////                    parseFloat(changeProductInputData.getChangedPrice()),
////                    changedProduct.getRating(),
////                    changedProduct.getState(), changedProduct.geteTransferEmail(),
////                    changedProduct.getSellerStudentNumber(), changedProduct.getAddress(),
////                    changedProduct.getListTags(), changedProduct.getProductID(),
////                    changedProduct.getSchedule());
//
//            changedProduct = changeProductPriceInterface.execute(changedProduct,
//                    changeProductInputData.getChangedPrice());
//            changedProduct = changeProductDescriptionInterface.execute(changedProduct,
//                    changeProductInputData.getChangedDescription());
//            ChangeProductOutputData changeProductOutputData =
//                    new ChangeProductOutputData(changedProduct,
//                    "Successfully modified product", changeProductInputData.getUser());
//            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
//        }
//        else if(emailFlag) {
//            changedProduct = changeProductDescriptionInterface.execute(changedProduct,
//                    changeProductInputData.getChangedDescription());
//            //If only the description was successfully modified
//            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
//                    "Only the price failed to update", changeProductInputData.getUser());
//            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
//        }
//        else if(priceFlag) {
//            //If only the description was successfully modified
//            changedProduct = changeProductPriceInterface.execute(changedProduct,
//                    changeProductInputData.getChangedPrice());
//            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changedProduct,
//                    "Only the description failed to update", changeProductInputData.getUser());
//            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
//        }
//        else {
//            //If both of the description and price failed to upload, then don't make the update.
//            ChangeProductOutputData changeProductOutputData = new ChangeProductOutputData(changeProductInputData.getProduct(),
//                    "Both the description and price failed to update", changeProductInputData.getUser());
//            changeProductOutputBoundary.prepareSuccessfulView(changeProductOutputData);
//        }
    }
}
