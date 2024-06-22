package use_case.shopping_cart;

import java.io.IOException;
import java.sql.SQLException;

public interface AddShoppingCartProductInputBoundary {
    void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) throws SQLException, IOException;
}
