package use_case.modify_product;

import entity.product.Product;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for updating the image associated with a Product.
 * <p>
 * Implementations of this interface are responsible for changing the image of a product in a data source.
 * </p>
 */
public interface ChangeProductImageInterface {

    /**
     * Updates the image of the specified product.
     * <p>
     * This method takes a product and applies the new image to it, saving the changes to the data source.
     * </p>
     *
     * @param product the Product whose image is to be updated
     * @param image the new Image to set for the product
     * @return the updated Product with the new image
     * @throws SQLException if an error occurs while accessing the database
     * @throws IOException if an error occurs while processing the image
     */
    Product execute(Product product, Image image) throws SQLException, IOException;
}
