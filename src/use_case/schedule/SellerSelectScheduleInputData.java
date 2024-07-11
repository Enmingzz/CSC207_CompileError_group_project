package use_case.schedule;

import entity.product.Product;
import entity.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SellerSelectScheduleInputData {
    private User seller;
    private Product product;
    private ArrayList<LocalDateTime> availableTimes;

    public SellerSelectScheduleInputData(User seller, Product product, ArrayList<LocalDateTime> availableTimes) {
        this.seller = seller;
        this.product = product;
        this.availableTimes = availableTimes;
    }

    public User getSeller() {
        return seller;
    }

    public Product getProduct () {
        return product;
    }

    public ArrayList<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }
}
