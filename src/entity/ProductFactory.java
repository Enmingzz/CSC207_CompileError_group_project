package entity;

import java.awt.*;
import java.util.ArrayList;

public interface ProductFactory {
    Product createProduct(Image image, String description, String title, float price, Integer rating, boolean isPending, String eTransferEmail, CommonUser buyer, CommonUser seller, String address, CommonSchedule schedule, ArrayList<Question> questions, ArrayList<String> listTags);
}
