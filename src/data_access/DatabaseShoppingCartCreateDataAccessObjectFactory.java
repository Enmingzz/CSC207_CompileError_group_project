package data_access;

import java.sql.SQLException;

public class DatabaseShoppingCartCreateDataAccessObjectFactory implements DatabaseShoppingCartCreateDataAccessObjectFactoryInterface{
    @Override
    public ShoppingCartCreateDataAccessInterface create() throws SQLException {
        return new DatabaseShoppingCartCreateDataAccessObject();
    }
}
