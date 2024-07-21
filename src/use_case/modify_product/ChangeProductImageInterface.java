package use_case.modify_product;

import entity.product.Product;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public interface ChangeProductImageInterface {
    Product execute(Product product, Image image) throws SQLException, IOException;
}

