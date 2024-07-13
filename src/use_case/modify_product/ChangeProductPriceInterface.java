package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

public interface ChangeProductPriceInterface {
    boolean execute(Product product, String price) throws SQLException;
}

