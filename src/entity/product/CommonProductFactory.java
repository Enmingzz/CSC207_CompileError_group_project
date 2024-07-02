package entity.product;

import entity.schedule.Schedule;

import java.awt.*;
import java.util.ArrayList;

/**
 * Return an instance of CommonProduct but with upcasting to product.
 * @author CompileError group
 */

public class CommonProductFactory implements ProductFactory{
    @Override
    public Product createProduct(Image image, String description, String title, float price, Integer rating, int state, String eTransferEmail, String sellerStudentNumber, String address, ArrayList<String> listTags, String productID, Schedule schedule) {
        return new CommonProduct(image,description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address, listTags, productID, schedule);
    }
}
