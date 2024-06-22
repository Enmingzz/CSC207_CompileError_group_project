package entity.product;

import entity.schedule.CommonSchedule;

import java.awt.*;
import java.util.ArrayList;

public interface ProductFactory {
    Product createProduct(Image image, String description, String title, float price, Integer rating, int state, String eTransferEmail, String sellerStudentNumber, String address, ArrayList<String> listTags, String productID);
}
