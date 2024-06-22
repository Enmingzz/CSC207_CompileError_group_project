package use_case.shopping_cart;

import java.io.IOException;
import java.sql.SQLException;

public interface PurchaseInputBoundary {
    void purchaseProduct(PurchaseInputData purchaseInputData) throws SQLException, IOException;
}
