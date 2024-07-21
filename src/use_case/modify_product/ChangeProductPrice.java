package use_case.modify_product;

import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;

import static java.lang.Float.parseFloat;

public class ChangeProductPrice implements ChangeProductPriceInterface {
    private final ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface;

    public ChangeProductPrice(ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface) {
        this.productUpdatePriceDataAccessInterface = productUpdatePriceDataAccessInterface;
    }

    public Product execute(Product changedProduct, String price) throws SQLException {
        boolean validPrice;

        //first we will test if the price entered is a float and a positive number
        float floatPrice = 0;
        try {
            floatPrice = parseFloat(price);
            if(floatPrice >= 0 || floatPrice != changedProduct.getPrice()) {
                validPrice = true;
            }
            else{
                validPrice = false;
            }
        } catch (NumberFormatException e) {
            validPrice = false;
        }
        //Next we need to verify that the amount they entered has at most 2 decimal places
        int decimalPointIndex = price.indexOf('.');
        if(price.indexOf('.') >= 0) {
            String decimalPart = price.substring(decimalPointIndex);
            if(decimalPart.length() > 2) {
                validPrice = false;
            }
        }

        if (validPrice){
            productUpdatePriceDataAccessInterface.updateProductPrice(changedProduct, floatPrice);
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
                    changedProduct.getDescription(), changedProduct.getTitle(),
                    parseFloat(price),
                    changedProduct.getRating(),
                    changedProduct.getState(), changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(), changedProduct.getAddress(),
                    changedProduct.getListTags(), changedProduct.getProductID(),
                    changedProduct.getSchedule());
            return newProduct;
        }
        return changedProduct;


    }
}
