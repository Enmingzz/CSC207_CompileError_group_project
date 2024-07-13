package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;
import java.util.Objects;

public class ChangeProductDescription implements ChangeProductDescriptionInterface{
    private final ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface;

    public ChangeProductDescription(ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface) {
        this.productUpdateDescriptionDataAccessInterface = productUpdateDescriptionDataAccessInterface;
    }

    public boolean execute(Product product, String description) throws SQLException {
        if (Objects.equals(description, "")) {
            return false;
        }
        else {
            productUpdateDescriptionDataAccessInterface.updateProductDescription(product, description);
            return true;
        }
    }

}
