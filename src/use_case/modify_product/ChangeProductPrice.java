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

        if(validPrice) {
            productUpdatePriceDataAccessInterface.updateProductPrice(product, floatPrice);
            return true;
        }
        else{
            return false;
        }
    }
}
