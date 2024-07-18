package use_case.modify_product;

import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;

public class ChangeProductPrice implements ChangeProductPriceInterface {
    private final ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface;

    public ChangeProductPrice(ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface) {
        this.productUpdatePriceDataAccessInterface = productUpdatePriceDataAccessInterface;
    }

    public boolean execute(Product product, String price) throws SQLException {
        boolean validPrice;

        //first we will test if the price entered is a float and a positive number
        float floatPrice = 0;
        try {
            floatPrice = Float.parseFloat(price);
            if(floatPrice >= 0) {
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

        if(validPrice) {
            productUpdatePriceDataAccessInterface.updateProductPrice(product, floatPrice);
            return true;
        }
        else{
            return false;
        }
    }
}
