package use_case.schedule;

import entity.product.Product;
import entity.user.User;

public class GetSellerSchedulePageOutputData {
    private final User seller;
    private Product product;

    public  GetSellerSchedulePageOutputData(User seller, Product product) {
        this.seller = seller;
        this.product = product;
    }

    public User getSeller(){
        return seller;
    }

    public  Product getProduct() {
        return product;
    }
}
