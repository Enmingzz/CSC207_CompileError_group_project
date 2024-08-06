package use_case.shopping_cart;

import java.io.IOException;
import java.sql.SQLException;

public interface PurchaseOutputBoundary {
    void prepareSuccessView(PurchaseOutputData purchaseOutputData) throws SQLException, IOException;
    void prepareFailedView(String error) throws SQLException, IOException;
}
