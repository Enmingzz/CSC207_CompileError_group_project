package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

public interface ChangeProductDescriptionInterface {
    Product execute(Product product, String description) throws SQLException;
}
