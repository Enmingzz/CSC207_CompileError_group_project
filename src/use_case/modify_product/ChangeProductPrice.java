package use_case.modify_product;

import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;

import static java.lang.Float.parseFloat;

/**
 * Class responsible for changing the price of a product. It validates the new price,
 * updates it in the data access layer, and creates a new product instance with the updated price.
 */
public class ChangeProductPrice implements ChangeProductPriceInterface {
    private final ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface;

    /**
     * Constructs a ChangeProductPrice instance with the specified data access interface.
     *
     * @param productUpdatePriceDataAccessInterface the data access interface for updating the product price
     */
    public ChangeProductPrice(ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessInterface) {
        this.productUpdatePriceDataAccessInterface = productUpdatePriceDataAccessInterface;
    }

    /**
     * Executes the process of changing the price of a product. It validates the new price to ensure it is a
     * positive float and has at most two decimal places, updates the price in the data access layer, and creates
     * a new product instance with the updated price.
     *
     * @param changedProduct the product whose price is to be changed
     * @param price the new price to be set
     * @return the updated product instance if the price is valid, otherwise the original product
     * @throws SQLException if a database access error occurs
     */
    public Product execute(Product changedProduct, String price) throws SQLException {
        boolean validPrice;

        // First, we will test if the price entered is a float and a positive number
        float floatPrice = 0;
        try {
            floatPrice = parseFloat(price);
            if (floatPrice >= 0 && floatPrice != changedProduct.getPrice()) {
                validPrice = true;
            } else {
                validPrice = false;
            }
        } catch (NumberFormatException e) {
            validPrice = false;
        }

        // Next, we need to verify that the amount they entered has at most 2 decimal places
        int decimalPointIndex = price.indexOf('.');
        if (decimalPointIndex >= 0) {
            String decimalPart = price.substring(decimalPointIndex + 1);
            if (decimalPart.length() > 2) {
                validPrice = false;
            }
        }

        if (validPrice) {
            productUpdatePriceDataAccessInterface.updateProductPrice(changedProduct, floatPrice);
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
                    changedProduct.getDescription(), changedProduct.getTitle(),
                    floatPrice,
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
