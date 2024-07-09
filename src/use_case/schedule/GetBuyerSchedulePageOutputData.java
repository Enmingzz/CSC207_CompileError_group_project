package use_case.schedule;

import entity.product.Product;
import entity.user.User;

public class GetBuyerSchedulePageOutputData {
    private final User buyer;
    private Product product;

    public  GetBuyerSchedulePageOutputData(User buyer, Product product) {
        this.buyer = buyer;
        this.product = product;
    }

    public User getBuyer(){
        return buyer;
    }

    public  Product getProduct() {
        return product;
    }
}
