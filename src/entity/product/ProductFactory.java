package entity.product;

import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;

import java.awt.*;
import java.util.ArrayList;

/**
 *Provide the interface for CommonProductFactory
 * @author CompileError group
 */

public interface ProductFactory {
    Product createProduct(Image image, String description, String title, float price, Integer rating, int state, String eTransferEmail, String sellerStudentNumber, String address, ArrayList<String> listTags, String productID, Schedule schedule);
}
