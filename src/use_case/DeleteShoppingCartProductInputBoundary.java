package use_case;

import java.sql.SQLException;

public interface DeleteShoppingCartProductInputBoundary {
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException;
}
