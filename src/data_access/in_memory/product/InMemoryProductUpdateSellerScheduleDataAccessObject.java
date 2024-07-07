package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class InMemoryProductUpdateSellerScheduleDataAccessObject implements ProductUpdateSellerScheduleDataAccessInterface {

    @Override
    public void updateSellerSchedule(Product product, ArrayList<LocalDateTime> listTimes) throws SQLException {

    }
}
