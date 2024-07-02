package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductUpdateSellerScheduleDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdateSellerScheduleDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateSellerScheduleDataAccessObjectFactory implements DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateSellerScheduleDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateSellerScheduleDataAccessObject();
    }
}
