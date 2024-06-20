package entity;

import java.awt.*;
import java.util.ArrayList;

public interface ProductFactory {
    Product createProduct(Image image, String description, String title, float price, Integer rating, boolean isPending, String eTransferEmail, String buyerStudentNumber, String sellerStudentNumber, String address, CommonSchedule schedule, ArrayList<String> listTags);
}
