package data_access.objects;

import data_access.interfaces.ProductUpdatePictureDataAccessInterface;
import entity.product.Product;

import java.awt.*;
import java.sql.*;

public class DatabaseProductUpdatePictureDataAccessObject implements ProductUpdatePictureDataAccessInterface {
    @Override
    public void updateProductPicture(Product product, Image image) throws SQLException {

    }
}
