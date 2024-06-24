package use_case.shopping_cart;

import java.io.IOException;
import java.sql.SQLException;

public interface ShowShoppingCartInputBoundary {

    void execute(ShowShoppingCartInputData inputData) throws SQLException, IOException;
}
