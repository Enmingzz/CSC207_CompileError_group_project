package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;
import data_access.objects.product.DatabaseProductUpdateSellerScheduleDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateSellerScheduleDataAccessObjectFactory implements DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateSellerScheduleDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateSellerScheduleDataAccessObject();
    }
}
