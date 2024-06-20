package data_access;

import entity.Product;

import java.awt.*;
import java.sql.SQLException;

public interface ProductUpdatePictureDataAccessInterface {
    void updateProductPicture(Product product, Image image) throws SQLException;
}
