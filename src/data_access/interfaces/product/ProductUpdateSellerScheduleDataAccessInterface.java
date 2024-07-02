package data_access.interfaces.product;

import entity.product.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ProductUpdateSellerScheduleDataAccessInterface {
    void updateSellerSchedule(Product product, ArrayList<LocalDateTime> listTimes) throws SQLException;
}
