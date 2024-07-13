package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

public interface ChangeProductDescriptionInterface {
    boolean execute(Product product, String description) throws SQLException;
}
