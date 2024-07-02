package data_access.factories.objects.product;

import data_access.factories.interfaces.product.DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface;
import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;
import data_access.objects.product.DatabaseProductUpdateBuyerScheduleDataAccessObject;

import java.sql.SQLException;

public class DatabaseProductUpdateBuyerScheduleDataAccessObjectFactory implements DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface {
    @Override
    public ProductUpdateBuyerScheduleDataAccessInterface create() throws SQLException {
        return new DatabaseProductUpdateBuyerScheduleDataAccessObject();
    }
}
