package entity;

import java.awt.*;
import java.util.ArrayList;

public class CommonProductFactory implements ProductFactory{
    public Product createProduct(Image image, String description, String title, float price, Integer rating, boolean isPending, String eTransferEmail, CommonUser buyer, CommonUser seller, String address, CommonSchedule schedule, ArrayList<Question> questions, ArrayList<String> listTags) {
        return new CommonProduct(image,description, title, price, rating, isPending, eTransferEmail, buyer, seller, address, schedule, questions, listTags);
    }
}
