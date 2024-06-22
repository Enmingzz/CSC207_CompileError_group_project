package use_case;

import java.io.IOException;
import java.sql.SQLException;

public interface AddShoppingCartProductInputBoundary {
    void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) throws SQLException, IOException;
}
