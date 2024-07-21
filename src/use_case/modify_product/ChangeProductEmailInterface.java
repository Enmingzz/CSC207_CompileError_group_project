package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

public interface ChangeProductEmailInterface {
    Product execute(Product product, String email) throws SQLException;
}

