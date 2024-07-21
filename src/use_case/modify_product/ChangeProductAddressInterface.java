package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

public interface ChangeProductAddressInterface {
    Product execute(Product product, String address) throws SQLException;
}

