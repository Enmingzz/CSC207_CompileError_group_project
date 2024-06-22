package use_case;

import java.io.IOException;
import java.sql.SQLException;

public interface DeleteShoppingCartProductInputBoundary {
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException, IOException;
}
