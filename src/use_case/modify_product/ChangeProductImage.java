package use_case.modify_product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ChangeProductImage implements ChangeProductImageInterface{
    private final ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface;

    public ChangeProductImage(ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface) {
        this.productUpdatePictureDataAccessInterface = productUpdatePictureDataAccessInterface;
    }

    public Product execute(Product changedProduct, Image image) throws SQLException, IOException {
        if (Objects.equals(image, changedProduct.getImage()) | image == null) {
            return changedProduct;
        }
        else {
            //System.out.println(System.identityHashCode(changedProduct));
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(image,
                    changedProduct.getDescription(), changedProduct.getTitle(),
                    changedProduct.getPrice(),
                    changedProduct.getRating(),
                    changedProduct.getState(), changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(), changedProduct.getAddress(),
                    changedProduct.getListTags(), changedProduct.getProductID(),
                    changedProduct.getSchedule());
            productUpdatePictureDataAccessInterface.updateProductPicture(changedProduct, image);
            return newProduct;
        }
    }

}
