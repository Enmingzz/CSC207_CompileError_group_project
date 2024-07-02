package data_access.interfaces.product;

import entity.product.Product;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public interface ProductUpdatePictureDataAccessInterface {
    void updateProductPicture(Product product, Image image) throws SQLException, IOException;
}
