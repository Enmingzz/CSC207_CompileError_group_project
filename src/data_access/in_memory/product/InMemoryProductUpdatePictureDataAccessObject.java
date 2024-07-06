package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import entity.product.Product;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class InMemoryProductUpdatePictureDataAccessObject implements ProductUpdatePictureDataAccessInterface {

    @Override
    public void updateProductPicture(Product product, Image image) throws SQLException, IOException {

    }
}
