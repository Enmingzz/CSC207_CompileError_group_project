package use_case.modify_product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * This class is responsible for changing the image associated with a product.
 * It uses a data access object to update the product's image in the database.
 */
public class ChangeProductImage implements ChangeProductImageInterface {
    private final ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface;

    /**
     * Constructs a ChangeProductImage with the specified data access interface.
     *
     * @param productUpdatePictureDataAccessInterface the data access interface for updating the product's image
     */
    public ChangeProductImage(ProductUpdatePictureDataAccessInterface productUpdatePictureDataAccessInterface) {
        this.productUpdatePictureDataAccessInterface = productUpdatePictureDataAccessInterface;
    }

    /**
     * Executes the image change operation for the specified product.
     * If the new image is different from the current image and not null, a new product instance is created with the updated image,
     * and the change is persisted in the database.
     *
     * @param changedProduct the product whose image is to be changed
     * @param image the new image for the product
     * @return a new product instance with the updated image if the image is changed, or the original product if the image is the same or null
     * @throws SQLException if there is an error updating the product's image in the database
     * @throws IOException if there is an error handling the image data
     */
    public Product execute(Product changedProduct, Image image) throws SQLException, IOException {
        if (Objects.equals(image, changedProduct.getImage()) || image == null) {
            return changedProduct;
        } else {
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(
                    image,
                    changedProduct.getDescription(),
                    changedProduct.getTitle(),
                    changedProduct.getPrice(),
                    changedProduct.getRating(),
                    changedProduct.getState(),
                    changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(),
                    changedProduct.getAddress(),
                    changedProduct.getListTags(),
                    changedProduct.getProductID(),
                    changedProduct.getSchedule()
            );
            productUpdatePictureDataAccessInterface.updateProductPicture(changedProduct, image);
            return newProduct;
        }
    }
}
