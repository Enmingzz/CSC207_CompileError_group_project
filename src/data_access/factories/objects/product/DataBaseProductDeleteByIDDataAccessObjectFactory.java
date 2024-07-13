package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DataBaseProductDeleteByIDDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;
import data_access.objects.product.DatabaseProductDeleteByIDDataAccessObject;

import java.sql.SQLException;

public class DataBaseProductDeleteByIDDataAccessObjectFactory implements DataBaseProductDeleteByIDDataAccessObjectFactoryInterface {
    @Override
    public ProductDeleteDataAccessByIDInterface create() throws SQLException {
        return new DatabaseProductDeleteByIDDataAccessObject();
    }
}
