package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductUpdateBuyerScheduleDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdateBuyerScheduleDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateBuyerScheduleDataAccessObjectFactory implements DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateBuyerScheduleDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateBuyerScheduleDataAccessObject();
    }
}
