package use_case.shopping_cart;

import java.sql.SQLException;
import java.io.IOException;

public interface ConfirmInputBoundary {
    void confirm(ConfirmInputData confirmInputData) throws SQLException, IOException;
}
