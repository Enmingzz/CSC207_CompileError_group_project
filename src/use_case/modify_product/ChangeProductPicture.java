package use_case.modify_product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import entity.product.Product;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeProductPicture implements ChangeProductPictureInterface {
    private final ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface;

    public ChangeProductPicture(ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface) {
        this.productUpdatePictureDataAccessInterface = productUpdatePictureDataAccessInterface;
    }

    public void execute(Product product, Image image) throws SQLException, IOException {
        productUpdatePictureDataAccessInterface.updateProductPicture(product, image);
    }

}
