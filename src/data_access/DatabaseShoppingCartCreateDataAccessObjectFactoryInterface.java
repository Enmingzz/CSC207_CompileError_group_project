package data_access;

import java.sql.SQLException;

public interface DatabaseShoppingCartCreateDataAccessObjectFactoryInterface {

    ShoppingCartCreateDataAccessInterface create() throws SQLException;
}
