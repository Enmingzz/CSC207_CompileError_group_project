package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

public interface ChangeProductTitleInterface {
    Product execute(Product product, String title) throws SQLException;
}

