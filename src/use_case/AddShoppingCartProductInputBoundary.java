package use_case;

import java.sql.SQLException;

public interface AddShoppingCartProductInputBoundary {
    void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) throws SQLException;
}
