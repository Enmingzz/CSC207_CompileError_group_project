package data_access.interfaces.product;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductDeleteDataAccessByIDInterface {
    void deleteProductByID(String productID) throws SQLException, IOException;
}
