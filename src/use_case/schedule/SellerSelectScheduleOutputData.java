package use_case.schedule;

import entity.product.Product;
import entity.user.User;


public class SellerSelectScheduleOutputData {
    private User seller;
    private Product product;

    public SellerSelectScheduleOutputData(User seller, Product product) {
        this.seller = seller;
        this.product = product;
    }

    public User getSeller() {
        return seller;
    }

    public Product getProduct() {
        return product;
    }
}
