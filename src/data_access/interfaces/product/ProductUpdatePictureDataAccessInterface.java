package data_access.interfaces.product;

import entity.product.Product;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ProductUpdatePictureDataAccessInterface provides an abstraction for updating the picture of a product in the database.
 */
public interface ProductUpdatePictureDataAccessInterface {

    /**
     * Updates the picture of the specified product in the database.
     *
     * @param product the product whose picture is to be updated
     * @param image   the new picture to be set for the product
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    void updateProductPicture(Product product, Image image) throws SQLException, IOException;
}
